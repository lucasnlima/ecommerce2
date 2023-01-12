// package com.study.controller;

// import io.micronaut.http.client.annotation.Client;

// import static org.junit.jupiter.api.Assertions.assertAll;
// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.mockito.Mockito.mock;
// import static org.mockito.Mockito.when;

// import java.security.PublicKey;
// import java.util.ArrayList;
// import java.util.HashSet;

// import org.junit.jupiter.api.Test;

// import com.fasterxml.jackson.databind.util.ArrayIterator;
// import com.study.domain.Shop;
// import com.study.repository.ShopRepository;
// import io.micronaut.http.HttpRequest;
// import io.micronaut.http.HttpResponse;
// import io.micronaut.http.client.HttpClient;
// import io.micronaut.test.annotation.MockBean;
// import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
// import jakarta.inject.Inject;

// @MicronautTest
// public class ShopControllerTest {

    
//     @Inject
//     @Client("/")
//     HttpClient client;
    
//     @MockBean(ShopRepository.class)
//     public ShopRepository mockRepository(){
//         return mock(ShopRepository.class);
//     };
    
//     @Inject
//     ShopRepository shopRepository;
    
//     @Test
//     public void testeTest(){
//         when(shopRepository.findAll()).thenReturn(new ArrayList<Shop>());
//         String response = client.toBlocking().retrieve(HttpRequest.GET("/shops"));
        
//         assertEquals("[]", response);
        
//     }

// }
