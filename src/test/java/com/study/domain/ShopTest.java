package com.study.domain;

import org.junit.jupiter.api.Test;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.HashSet;
import org.junit.jupiter.api.BeforeAll;

@MicronautTest
public class ShopTest {
    private static Shop shop;
    private static Category categoryA = new Category("Eletronicos","http://eletronicos.com/imagem.jpg");

    @BeforeAll
    public static void setUp() {
        shop = new Shop();
        shop.setName("Araujo");
        shop.setDescription("Loja que se multiplica em cada esquina de BH");
        shop.setColor("#AABBCC");
        shop.setImgUrl("http://araujo.com/imagem.jpg");
        shop.setCategories(new HashSet<Category>());
        shop.addCategory(categoryA);
    }

    @Test
    public void testGetNome() {
        assertEquals("Araujo", shop.getName());
    }

    @Test
    public void testSetNome() {
        shop.setName("DrogaLucas");
        assertEquals("DrogaLucas", shop.getName());
    }

    @Test
    public void testGetDescricao() {
        assertEquals("Loja que se multiplica em cada esquina de BH", shop.getDescription());
    }

    @Test
    public void testSetDescricao() {
        shop.setDescription("Melhor Farmacia de BH");
        assertEquals("Melhor Farmacia de BH", shop.getDescription());
    }

    @Test
    public void testGetCor() {
        assertEquals("#AABBCC", shop.getColor());
    }

    @Test
    public void testSetCor() {
        shop.setColor("#00FF00");
        assertEquals("#00FF00", shop.getColor());
    }

    @Test
    public void testGetImagemUrl() {
        assertEquals("http://araujo.com/imagem.jpg", shop.getImgUrl());
    }

    @Test
    public void testSetImagemUrl() {
        shop.setImgUrl("http://drogalucas.com/imagem.jpg");
        assertEquals("http://drogalucas.com/imagem.jpg", shop.getImgUrl());
    }

    @Test
    public void testeAddCategory() {
        Category category = new Category("Famarcia","http://images.com/famacia.jpg");
        shop.addCategory(category);

        assertTrue(shop.getCategories().contains(category));
    }

    @Test
    public void testeRemoveCategory() {
        shop.removeCategory(categoryA);
        assertFalse(shop.getCategories().contains(categoryA));
    }
}