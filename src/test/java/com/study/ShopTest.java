package com.study;

import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import com.study.domain.Category;
import com.study.domain.Shop;

import org.junit.jupiter.api.Assertions;
import jakarta.inject.Inject;

@MicronautTest
class ShopTest {

    @Inject
    EmbeddedApplication<?> application;

    @Test
    void testeAddCategory() {
        //Arrange
        Category categoryA = new Category("Sorveteria","SORVETE.jpg");
        Shop shopA = new Shop("LuluGelado", "Loja de sorvertes", "#HPTS35", "LULU.jpg");
        
        //Act
        shopA.addCategory(categoryA);

        //Assert
        Assertions.assertTrue(shopA.getCategories().contains(categoryA));
    }

}
