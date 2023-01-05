package com.study.repository;

import javax.persistence.EntityManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.study.domain.Shop;

public class ShopRepositoryTest {
    private static EntityManager mockEntityManager;
    private static ShopRepository shopRepository;

    @BeforeAll
    public static void setUp() {
        mockEntityManager = mock(EntityManager.class);
        shopRepository = new Repository(mockEntityManager);
    }

    @Test
    public void testSave() {
        Shop shop = new Shop();
        shop.setName("Rei Do Pastel");
        shop.setDescription("Loja que vende pastel.");
        shop.setColor("Loja que vende pastel.");
        shop.setImgUrl("Loja que vende pastel.");
        shopRepository.save(shop);

        // Verificar se o EntityManager.persist foi chamado com o objeto shop
        verify(mockEntityManager).persist(shop);
    }

    @Test
    public void testFindById() {
        // Configurar o mock EntityManager para retornar um objeto shop quando o método find é chamado
        shop shop = new shop();
        when(mockEntityManager.find(shop.class, 1L)).thenReturn(shop);

        // Verificar se o repository retorna o objeto shop correto
        assertEquals(shop, shopRepository.findById(1L));
    }

    @Test
    public void testUpdate() {
        // Criar um objeto shop e atualizar no repository
        shop shop = new shop();
        lojaRepository.update(loja);

        // Verificar se o EntityManager.merge
