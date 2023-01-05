package com.study.controller;

import java.util.Optional;
import com.study.domain.Category;
import com.study.domain.Shop;
import com.study.repository.CategoryRepository;
import com.study.repository.ShopRepository;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import io.micronaut.validation.Validated;

@Controller("/shops")
@Validated
public class ShopController {

    private final ShopRepository shopRepository;
    private final CategoryRepository categoryRepository;

    ShopController(ShopRepository shopRepository, CategoryRepository categoryRepository){
        this.shopRepository = shopRepository;
        this.categoryRepository = categoryRepository;
    }

    @Get
    public HttpResponse<Iterable<Shop>> getShops(@QueryValue Optional<String> category, @QueryValue Optional<Boolean> enabled){
        if(category.isPresent()){
            return HttpResponse.ok(shopRepository.findByCategoryName(category.get()));
        } else if(enabled.isPresent()) {
            return HttpResponse.ok(shopRepository.findEnabled(enabled.get()));
        } else {
            return HttpResponse.ok(shopRepository.findAll());
        }
    }

    @Get("/{id}")
    public HttpResponse<Shop> getShopById(@QueryValue long id){
        Optional<Shop> shop = shopRepository.findById(id);
        if (shop.isPresent()) {
            return HttpResponse.ok(shop.get());
        } else {
            return HttpResponse.notFound();
        }
    }

    @Delete("/{id}")
    public HttpResponse<Shop> removeShopById(@QueryValue long id){
        try {
            shopRepository.deleteById(id);
        } catch (Exception e) {
            return HttpResponse.notFound();
        }
        return HttpResponse.accepted();
    }

    @Post
    public HttpResponse<Shop> createShop(@Body Shop shop){
        return HttpResponse.created(shopRepository.save(new Shop(shop.getName(), shop.getDescription(), shop.getColor(),shop.getImgUrl())));
    }

    @Put("/{id}")
    public HttpResponse<Shop> updateShop(@QueryValue long id, @Body Shop shopInput){
        Optional<Shop> shop = shopRepository.findById(id);
        if (shop.isPresent()) {
            shop.get().setName(shopInput.getName());
            shop.get().setDescription(shopInput.getDescription());
            shop.get().setColor(shopInput.getColor());
            shop.get().setImgUrl(shopInput.getImgUrl());
            return HttpResponse.ok(shopRepository.update(shop.get()));
        }else {
            return HttpResponse.notFound();
        }

    }

    @Patch("/{id}")
    public Shop addCategoryToShop(@QueryValue long id, @Body Long categoryId){
        Shop shop = shopRepository.findById(id).orElseThrow();
        Category category = categoryRepository.findById(categoryId).orElseThrow();

        shop.addCategory(category);

        return shopRepository.update(shop);
    }

    @Patch("/{id}/removeCategory")
    public Shop removeCategoryFromShop(@QueryValue long id, @Body Long categoryId){
        Shop shop = shopRepository.findById(id).orElseThrow();
        Category category = categoryRepository.findById(categoryId).orElseThrow();
        shop.removeCategory(category);


        return shopRepository.update(shop);
    }
}
