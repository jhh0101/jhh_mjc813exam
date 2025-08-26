package com.mjc813.food_web.food.service;

import com.mjc813.food_web.food.dto.FoodEntity;
import com.mjc813.food_web.food.dto.IFood;
import com.mjc813.food_web.food_category.dto.FoodCategoryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<FoodEntity, Long> {
    List<FoodEntity> findAllByOrderByIdDesc();
    Page<FoodEntity> findByNameContains(String name, Pageable pageable);
}
