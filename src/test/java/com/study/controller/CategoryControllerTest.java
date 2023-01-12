// package com.study.controller;

// import com.study.repository.CategoryRepository;
// import io.micronaut.context.annotation.Requires;
// import io.micronaut.http.HttpRequest;
// import io.micronaut.http.client.HttpClient;
// import io.micronaut.http.client.annotation.Client;
// import io.micronaut.test.annotation.MockBean;
// import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
// import jakarta.inject.Inject;
// import org.junit.jupiter.api.Test;
// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.mockito.Mockito.*;


// @MicronautTest
// @Requires
// public class CategoryControllerTest {

    
//     @Inject
//     @Client("/")
//     HttpClient client;

//     @Inject
//     private CategoryRepository mockCategoryRepository;
    
//     @Test
//     public void testeTest(){
//         String response = client.toBlocking().retrieve(HttpRequest.GET("/categories"));
//         assertEquals("[]", response);
//     }
    
    
//     @MockBean(CategoryRepository.class)
//     CategoryRepository mockCategoryRepository() {
//         return mock(CategoryRepository.class);
//     }
    
// }

