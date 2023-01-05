package com.study.domain;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

@MicronautTest
public class CategoryTest {

    private static Category category;

    @BeforeAll
    public static void setUp(){
        category = new Category();
        category.setName("Banco");
        category.setImgUrl("http://images.com/banco.png");
    }

    @Test
        void testGetNome() {
            Assertions.assertEquals(category.getName(), "Banco");

        }
    @Test
        void testGetImgUrl() {
            Assertions.assertEquals(category.getImgUrl(), "http://images.com/banco.png");
    }

    @Test
        void testSetName() {
            category.setName("SuperApp");
            Assertions.assertEquals(category.getName(), "SuperApp");
    }
    @Test
        void testSetImgUrl() {
            category.setImgUrl("http://images.com/app.png");
            Assertions.assertEquals(category.getImgUrl(), "http://images.com/app.png");
    }

}
