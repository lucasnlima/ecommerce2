package com.study.controller;

import java.util.Optional;
import com.study.domain.Category;
import com.study.repository.CategoryRepository;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.validation.Validated;
import jakarta.inject.Inject;

@Controller("/categories")
@Validated
public class CategoryController {
    
    // Uso do Inject nessa classe e não uso na outra para fim de estudo da diferença entre DI usando esse anotation e da maneira tradicional.
    @Inject
    CategoryRepository categoryRepository;

    @Get
    public HttpResponse<Iterable<Category>> getCategory(@QueryValue Optional<Long> shopId, @QueryValue Optional<Boolean> enabled){
        if(shopId.isPresent()){
            return HttpResponse.ok(categoryRepository.findByShop(shopId.get()));
        }else if(enabled.isPresent()){
            return HttpResponse.ok(categoryRepository.findEnabled(enabled.get()));
        }else {
            return HttpResponse.ok(categoryRepository.findAll());
        }
    }


    @Post
    public Category createCategory( Category category){
        return categoryRepository.save(new Category(category.getName(),category.getImgUrl()));
    }

    @Delete("/{id}")
    public HttpResponse<Category> deleteCategory(Long id){
        try {
            categoryRepository.deleteById(id);
        } catch (Exception e) {
            return HttpResponse.notFound();
        }
        return HttpResponse.accepted();

    }

    @Put("/{id}")
    public HttpResponse<Category> updateCategory(@QueryValue Long id, @Body Category category) {
        Optional<Category> existingCategory = categoryRepository.findById(id);
        if (existingCategory.isPresent()) {
            category.setId(id);
            Category updatedCategory = categoryRepository.update(category);
            return HttpResponse.ok(updatedCategory);
        } else {
            return HttpResponse.notFound();
        }
    }
        
}
