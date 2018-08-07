package hibernate1.dao;


import hibernate1.model.Ingredient;

import java.util.List;

public interface IngredientDao {
    Ingredient getIngredientsById(Integer id);
    Ingredient getIngredientByName(String name);
    List<Ingredient> getIngredientsByName(String name);
    List<Ingredient> getAllIngredients();
    boolean addIngredient(String name);
    boolean deleteIngredientByName(String name);
}
