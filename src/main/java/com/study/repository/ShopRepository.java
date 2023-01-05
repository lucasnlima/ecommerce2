package com.study.repository;

import com.study.domain.Shop;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository 
public interface ShopRepository extends CrudRepository<Shop, Long> {

    @Query(value = "SELECT * FROM SHOP S JOIN SHOP_CATEGORY SC ON S.ID = SC.SHOP_ID JOIN CATEGORY C ON C.ID = SC.CATEGORY_ID WHERE C.NAME = :category GROUP BY S.ID;", nativeQuery = true)
    Iterable<Shop> findByCategoryName(String category);

    @Query("SELECT S FROM Shop S WHERE :enabled = S.enable;")
    public Iterable<Shop> findEnabled(boolean enabled);
}