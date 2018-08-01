package dao;

import model.Recipe;

import java.util.List;

public interface RecipeDao {
    Recipe getRecipeByName(String name);

    List<Recipe> getAllRecipes();

    boolean addRecipe(String name);

    boolean deleteRecipeByName(String name);
}
