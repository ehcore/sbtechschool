package dao;

import model.Ingredient;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by user1 on 31.07.2018.
 */
public class IngredientDaoImpl extends JdbcDaoSupport implements IngredientDao {
    @Override
    public Ingredient getIngredientsById(Integer id) {
        List<Ingredient> ingredientList = getJdbcTemplate()
                .query("SELECT * FROM RECIPES.INGREDIENTS ",new IngredientRowMapper());
        System.out.println(ingredientList);
        return null;
    }


    private class IngredientRowMapper implements RowMapper<Ingredient> {
        public Ingredient mapRow(ResultSet resultSet, int i) throws SQLException {
            Ingredient ingredient = new Ingredient(resultSet.getInt("id"),resultSet.getString("name"));
            return ingredient;
        }
    }

}
