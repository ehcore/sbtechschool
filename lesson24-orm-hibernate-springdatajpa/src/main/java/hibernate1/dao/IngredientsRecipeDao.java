package hibernate1.dao;


import hibernate1.model.Ingredient;
import hibernate1.model.IngredientsRecipeView;

import java.util.List;

public interface IngredientsRecipeDao {
   // List<Ingredient> getIngredientsByNameRecipe(String name);

    List<IngredientsRecipeView> getIngredientsRecipeViewByNameRecipe(String name);

    void addIngredientsToRecipe(String recipeName, String ingredientName,
                                   Double amount, String unitName);
}
