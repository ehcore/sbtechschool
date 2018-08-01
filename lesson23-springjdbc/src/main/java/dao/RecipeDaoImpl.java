package dao;


import model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RecipeDaoImpl implements RecipeDao{
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public RecipeDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Recipe getRecipeByName(String name){
        Recipe recipe = null;
        try {
            recipe = jdbcTemplate.queryForObject(
                    "SELECT * FROM recipes.recipes WHERE name =?",
                    new RecipeRowMapper(),
                    name);
            return recipe;
        }catch (EmptyResultDataAccessException exc){
            return recipe;
        }
    }

    @Override
    public List<Recipe> getAllRecipes(){
        List<Recipe> list =
                jdbcTemplate.query(
                        "SELECT * FROM recipes.recipes",
                        new RecipeRowMapper());
        return list;
    }

    @Override
    public boolean addRecipe(String name){
        Recipe recipe = getRecipeByName(name);
        if(recipe != null){
            return false;
        }
        int i = jdbcTemplate.update(
                "INSERT INTO recipes.recipes(name) VALUES(?)",
                name);
        if(i>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteRecipeByName(String name){
        Recipe recipe = getRecipeByName(name);
        if(recipe == null){
            return false;
        }
        int i = jdbcTemplate.update(
                "DELETE FROM recipes.recipes WHERE name=?",
                name);
        if(i>0){
            return true;
        }
        return false;
    }

    private class RecipeRowMapper implements RowMapper<Recipe> {
        @Override
        public Recipe mapRow(ResultSet resultSet, int i) throws SQLException {
            Recipe recipe = new Recipe(resultSet.getInt("id"),resultSet.getString("name"));
            return recipe;
        }
    }
}
