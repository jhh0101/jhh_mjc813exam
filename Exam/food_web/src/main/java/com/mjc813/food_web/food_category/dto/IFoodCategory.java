package com.mjc813.food_web.food_category.dto;

import com.mjc813.food_web.food.dto.FoodDto;

public interface IFoodCategory {

    public Long getId();
    public String getName();
    public void setId(Long id);
    public void setName(String name);

    default void copyFoodCategory(IFoodCategory iFood){
        if(iFood == null){
            return;
        }
        if (iFood.getId() != null){
            setId(iFood.getId());
        }
        if (iFood.getName() != null){
            setName(iFood.getName());
        }
    }
}
