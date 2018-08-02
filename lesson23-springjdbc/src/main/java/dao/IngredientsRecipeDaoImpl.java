package dao;


import model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class IngredientsRecipeDaoImpl implements IngredientsRecipeDao{
    private JdbcTemplate jdbcTemplate;

   // @Autowired
    public IngredientsRecipeDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Ingredient> getIngredientsByNameRecipe(String name){
        RecipeDao recipeDao = new RecipeDaoImpl(jdbcTemplate);
        Recipe recipe = recipeDao.getRecipeByName(name);

        List<Ingredient> list =
                jdbcTemplate.query(
                        "SELECT recipes.ingredients_recipes.id_ingredients AS id , recipes.ingredients.name" +
                                " FROM recipes.ingredients_recipes JOIN recipes.ingredients " +
                                " ON recipes.ingredients_recipes.id_ingredients = recipes.ingredients.id " +
                                " WHERE recipes.ingredients_recipes.id_recipes=?",
                        new IngredientRowMapper(),recipe.getId());
        return list;

    }

    @Override
    public List<IngredientsRecipeView> getIngredientsRecipeViewByNameRecipe(String name){
        RecipeDao recipeDao = new RecipeDaoImpl(jdbcTemplate);
        Recipe recipe = recipeDao.getRecipeByName(name);
// id_recipes int(10) NOT NULL, id_ingredients int(10) NOT NULL, amount decimal(8,3) NOT NULL, id_unit int(10)
        List<IngredientsRecipeView> list =
                jdbcTemplate.query(
                        "SELECT temp.name AS name_ingredient, temp.amount, temp.id_unit,  recipes.units.name AS name_unit FROM " +
                                "(SELECT recipes.ingredients_recipes.id_unit , recipes.ingredients.name, recipes.ingredients_recipes.amount " +
                                "FROM recipes.ingredients_recipes JOIN recipes.ingredients ON recipes.ingredients_recipes.id_ingredients = recipes.ingredients.id " +
                                "WHERE recipes.ingredients_recipes.id_recipes=?) temp JOIN recipes.units ON temp.id_unit = recipes.units.id",

/*                        "SELECT temp.name AS name_ingredient, temp.amount, temp.id_unit,  recipes.units.name AS name_unit FROM (SELECT recipes.ingredients_recipes.id_unit , recipes.ingredients.name, recipes.ingredients_recipes.amount" +
                                " FROM recipes.ingredients_recipes JOIN recipes.ingredients " +
                                " ON recipes.ingredients_recipes.id_ingredients = recipes.ingredients.id " +
                                " WHERE recipes.ingredients_recipes.id_recipes=?) temp JOIN recipes.units ON temp.id_unit = recipes.units.id",*/
                        new IngredientsRecipeViewRowMapper(),recipe.getId());
        return list;

    }


    @Override
    public boolean addIngredientsToRecipe(String recipeName, String ingredientName,
                                          Double amount, String unitName){
        RecipeDao recipeDao = new RecipeDaoImpl(jdbcTemplate);
        Recipe recipe = recipeDao.getRecipeByName(recipeName);
        IngredientDao ingredientDao = new IngredientDaoImpl(jdbcTemplate);
        Ingredient ingredient = ingredientDao.getIngredientByName(ingredientName);
        UnitDao unitDao = new UnitDaoImpl(jdbcTemplate);
        Unit unit = unitDao.getUnitByName(unitName);
//id_recipes int(10), id_ingredients int(10), amount decimal(8,3), id_unit int(10)
        int i = jdbcTemplate.update(
                "INSERT INTO recipes.ingredients_recipes(id_recipes,id_ingredients,amount,id_unit) VALUES(?,?,?,?)",
                recipe.getId(),ingredient.getId(),amount,unit.getId());
        if(i>0){
            return true;
        }
        return false;
    }

    private class IngredientsRecipeRowMapper implements RowMapper<IngredientsRecipe> {
        @Override
        public IngredientsRecipe mapRow(ResultSet resultSet, int i) throws SQLException {
            IngredientsRecipe ingredientsRecipe =
                    new IngredientsRecipe(resultSet.getInt("id_recipes"),
                            resultSet.getInt("id_ingredients"),
                            resultSet.getDouble("amount"),
                            resultSet.getInt("id_unit"));
            return ingredientsRecipe;
        }
    }

    private class IngredientRowMapper implements RowMapper<Ingredient> {
        public Ingredient mapRow(ResultSet resultSet, int i) throws SQLException {
            Ingredient ingredient = new Ingredient(resultSet.getInt("id"),resultSet.getString("name"));
            return ingredient;
        }
    }

    private class IngredientsRecipeViewRowMapper implements RowMapper<IngredientsRecipeView> {
        @Override
        public IngredientsRecipeView mapRow(ResultSet resultSet, int i) throws SQLException {
            IngredientsRecipeView ingredientsRecipeView =
                    new IngredientsRecipeView(resultSet.getString("name_ingredient"),
                            resultSet.getDouble("amount"),
                            resultSet.getString("name_unit"));
            return ingredientsRecipeView;
        }
    }


}
