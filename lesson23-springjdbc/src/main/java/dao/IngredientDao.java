package dao;


import model.Ingredient;

interface IngredientDao {
    Ingredient getIngredientsById(Integer id);
}
