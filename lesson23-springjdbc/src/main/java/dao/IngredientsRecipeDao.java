package dao;


import model.Ingredient;

import java.util.List;

public interface IngredientsRecipeDao {
    List<Ingredient> getIngredientsByNameRecipe(String name);

    boolean addIngredientsToRecipe(String recipeName, String ingredientName,
                                   Double amount, String unitName);
}
