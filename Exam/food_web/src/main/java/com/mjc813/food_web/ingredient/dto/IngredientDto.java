package com.mjc813.food_web.ingredient.dto;

import com.mjc813.food_web.ingredient_category.dto.IIngredientCategory;
import com.mjc813.food_web.ingredient_category.dto.IngredientCategoryDto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IngredientDto implements IIngredient{
    private Long id;
    private String name;
    private Long ingredientCategoryId;
    private IngredientCategoryDto ingredientCategoryDto;

    @Override
    public IIngredientCategory getIngredientCategory() {
        return this.ingredientCategoryDto;
    }

    @Override
    public void setIngredientCategory(IIngredientCategory ingredientCategory) {
        if( this.ingredientCategoryDto == null ) {
            this.ingredientCategoryDto = new IngredientCategoryDto();
        }
        this.ingredientCategoryDto.copyIngredientCategory(ingredientCategory);
    }

    @Override
    public Long getIngredientCategoryId() {
        if (this.ingredientCategoryDto == null) {
            return this.ingredientCategoryId;
        }
        if (this.ingredientCategoryDto.getId() == null) {
            return this.ingredientCategoryId;
        }
        if (!this.ingredientCategoryDto.getId().equals(this.ingredientCategoryId)) {
            this.ingredientCategoryId = this.ingredientCategoryDto.getId();
        }
        return this.ingredientCategoryId;
    }

    @Override
    public void setIngredientCategoryId(Long ingredientCategoryId) {
        if (this.ingredientCategoryDto == null) {
            this.ingredientCategoryDto = new IngredientCategoryDto();
        }
        this.ingredientCategoryDto.setId(ingredientCategoryId);
        this.ingredientCategoryId = ingredientCategoryId;
    }
}
