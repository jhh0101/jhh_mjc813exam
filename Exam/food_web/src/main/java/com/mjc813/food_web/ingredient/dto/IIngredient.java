package com.mjc813.food_web.ingredient.dto;

import com.mjc813.food_web.food.dto.FoodDto;
import com.mjc813.food_web.ingredient_category.dto.IIngredientCategory;

public interface IIngredient {
    public Long getId();
    public String getName();
    public Long getIngredientCategoryId();
    public IIngredientCategory getIngredientCategory();
    public void setId(Long id);
    public void setName(String name);
    public void setIngredientCategoryId(Long categoryId);
    public void setIngredientCategory(IIngredientCategory iIngredientCategory);

    default void copyIngredient(IIngredient iIngredient){
        if(iIngredient == null){
            return;
        }
        if (iIngredient.getId() != null){
            setId(iIngredient.getId());
        }
        if (iIngredient.getName() != null){
            setName(iIngredient.getName());
        }
        if(iIngredient.getIngredientCategoryId() != null){
            setIngredientCategoryId(iIngredient.getIngredientCategoryId());
        }
    }
}
