package dao;


import model.Ingredient;
import model.IngredientsRecipeView;

import java.util.List;

public interface IngredientsRecipeDao {
    List<Ingredient> getIngredientsByNameRecipe(String name);

    List<IngredientsRecipeView> getIngredientsRecipeViewByNameRecipe(String name);

    boolean addIngredientsToRecipe(String recipeName, String ingredientName,
                                   Double amount, String unitName);
}
