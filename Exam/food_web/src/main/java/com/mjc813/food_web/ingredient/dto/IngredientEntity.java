package com.mjc813.food_web.ingredient.dto;

import com.mjc813.food_web.ingredient_category.dto.IIngredientCategory;
import com.mjc813.food_web.ingredient_category.dto.IngredientCategoryDto;
import com.mjc813.food_web.ingredient_category.dto.IngredientCategoryEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ingredient_tbl")
public class IngredientEntity implements IIngredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "ingredient_category_id")
    private IngredientCategoryEntity ingredientCategory;

    @Override
    public Long getIngredientCategoryId() {
        return 0L;
    }

    @Override
    public IIngredientCategory getIngredientCategory() {
        return this.ingredientCategory;
    }

    @Override
    public void setIngredientCategoryId(Long categoryId) {

    }

    @Override
    public void setIngredientCategory(IIngredientCategory ingredientCategory) {
        if( this.ingredientCategory == null ) {
            this.ingredientCategory = new IngredientCategoryEntity();
        }
        this.ingredientCategory.copyIngredientCategory(ingredientCategory);
    }
    
}
