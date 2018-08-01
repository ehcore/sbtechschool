package dao;

import model.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class IngredientDaoImpl implements IngredientDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public IngredientDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Ingredient getIngredientsById(Integer id) {

        Ingredient ingredient = jdbcTemplate.queryForObject(
                "SELECT * FROM recipes.ingredients WHERE id=?",
                new IngredientRowMapper(),
                id);
        return ingredient;
    }

    @Override
    public Ingredient getIngredientByName(String name){
        Ingredient ingredient = null;
        try {
             ingredient = jdbcTemplate.queryForObject(
                    "SELECT * FROM recipes.ingredients WHERE name =?",
                    new IngredientRowMapper(),
                    name);
            return ingredient;
        }catch (EmptyResultDataAccessException exc){
            return ingredient;
        }
    }

    @Override
    public List<Ingredient> getIngredientsByName(String name){
        List<Ingredient> list =
                jdbcTemplate.query(
                "SELECT * FROM recipes.ingredients WHERE name LIKE ?",
                new IngredientRowMapper(),
                name + "%");
        return list;
    }

    @Override
    public List<Ingredient> getAllIngredients(){
        List<Ingredient> list =
                jdbcTemplate.query(
                        "SELECT * FROM recipes.ingredients",
                        new IngredientRowMapper());
        return list;
    }

    @Override
    public boolean addIngredient(String name){
        Ingredient ingredient = getIngredientByName(name);
        if(ingredient != null){
            return false;
        }
        int i = jdbcTemplate.update(
                "INSERT INTO recipes.ingredients(name) VALUES(?)",
                name);
        if(i>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteIngredientByName(String name){
        Ingredient ingredient = getIngredientByName(name);
        if(ingredient == null){
            return false;
        }
        int i = jdbcTemplate.update(
                "DELETE FROM recipes.ingredients WHERE name=?",
                name);
        if(i>0){
            return true;
        }
        return false;
    }

    private class IngredientRowMapper implements RowMapper<Ingredient> {
        public Ingredient mapRow(ResultSet resultSet, int i) throws SQLException {
            Ingredient ingredient = new Ingredient(resultSet.getInt("id"),resultSet.getString("name"));
            return ingredient;
        }
    }
}
