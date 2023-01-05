package com.study.repository;

import com.study.domain.Category;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

    @Query(value = "SELECT C.* FROM CATEGORY C JOIN SHOP_CATEGORY SC ON C.ID = SC.CATEGORY_ID WHERE SC.SHOP_ID = :shopId GROUP BY C.ID;", nativeQuery = true)
    public Iterable<Category> findByShop(Long shopId);
    
    @Query("SELECT C FROM Category C WHERE :enabled = C.enable;")
    public Iterable<Category> findEnabled(boolean enabled);
    
}
