import java.sql.*;

import dao.*;
import model.Recipe;
import org.springframework.context.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class MainApp {
    public static void main(String[] args) throws SQLException {
/*
        Connection conn = DriverManager.
                getConnection("jdbc:h2:./recipes", "sa", "");
        Statement st = conn.createStatement();

        ResultSet rs = st.executeQuery("SELECT * FROM RECIPES.INGREDIENTS ");

        while (rs.next()){
            System.out.println(rs.getString("name"));
        }

        rs.close();
        st.close();
        conn.close();

*/

        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        ctx.refresh();

        JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");

        IngredientDao ingredientDao = new IngredientDaoImpl(jdbcTemplate);

        System.out.println(ingredientDao.getAllIngredients());

        RecipeDao recipeDao = new RecipeDaoImpl(jdbcTemplate);

        recipeDao.addRecipe("Салат Оливье");
        recipeDao.addRecipe("Куриный суп");

        System.out.println(recipeDao.getAllRecipes());

        IngredientsRecipeDao ingredientsRecipeDao = new IngredientsRecipeDaoImpl(jdbcTemplate);
        ingredientsRecipeDao.addIngredientsToRecipe("Салат Оливье",
                "Картофель",200d,"гр");
        ingredientsRecipeDao.addIngredientsToRecipe("Салат Оливье",
                "Яйцо куриное",3d,"шт");
        ingredientsRecipeDao.addIngredientsToRecipe("Салат Оливье",
                "Горошек зеленый. Консервы",200d,"гр");
        ingredientsRecipeDao.addIngredientsToRecipe("Салат Оливье",
                "Колбаса",300d,"гр");
        ingredientsRecipeDao.addIngredientsToRecipe("Салат Оливье",
                "Майонез",100d,"гр");
        ingredientsRecipeDao.addIngredientsToRecipe("Салат Оливье",
                "Морковь",50d,"гр");
        ingredientsRecipeDao.addIngredientsToRecipe("Салат Оливье",
                "Огурец",100d,"гр");

        System.out.println(ingredientsRecipeDao.getIngredientsByNameRecipe("Салат Оливье"));;

    }
}
