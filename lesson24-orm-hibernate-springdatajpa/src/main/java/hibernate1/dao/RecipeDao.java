package hibernate1.dao;

import hibernate1.model.Recipe;

import java.util.List;

public interface RecipeDao {
    Recipe getRecipeByName(String name);

    List<Recipe> getRecipesByName(String name);

    List<Recipe> getAllRecipes();

    void addRecipe(String name);

    void deleteRecipeByName(String name);
}
