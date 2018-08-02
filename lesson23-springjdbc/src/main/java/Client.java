import java.util.*;

import dao.IngredientsRecipeDao;
import dao.IngredientsRecipeDaoImpl;
import dao.RecipeDao;
import dao.RecipeDaoImpl;
import exceptions.*;
import model.Ingredient;
import model.IngredientsRecipeView;
import model.Recipe;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class Client {
    private JdbcTemplate jdbcTemplate;


    public void start() throws NoSuchOperationException{
        init();
        work();
    }

    private void init(){
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        ctx.refresh();

        jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
    }

    private void work()  throws NoSuchOperationException {

        while (true) {
            int numOper = getMenuOperation();
            switch (numOper) {
                case 1:
                    findRecipe();
                    break;
                case 2:

                    findRecipes();
                    break;
                case 3:
                    addRecipe();
                    break;
                case 4:
                    deleteRecipe();
                    break;
                case 5:
                    showListRecipes();
                    break;
                case 6:
                    getMenuPreferences();
                    break;
                case 7:
                    return;
            }
        }
    }



    private void findRecipe(){
        String str = getStringLine("рецепта");
        if(str==null){
            System.out.println("введено пустое наименование, повторите");
            return;
        }
        RecipeDao recipeDao = new RecipeDaoImpl(jdbcTemplate);
        Recipe recipe = recipeDao.getRecipeByName(str);
        System.out.println(recipe);
        IngredientsRecipeDao ingredientsRecipeDao = new IngredientsRecipeDaoImpl(jdbcTemplate);

        List<IngredientsRecipeView> listView = ingredientsRecipeDao.getIngredientsRecipeViewByNameRecipe(recipe.getName());
        for(IngredientsRecipeView view : listView){
            System.out.println(view.getIngredient() + " " + view.getAmount() + " " + view.getUnit());
        }

/*
        List<Ingredient> listIngredients = ingredientsRecipeDao.getIngredientsByNameRecipe(recipe.getName());
        for(Ingredient ingredient : listIngredients){
            System.out.println(ingredient);
        }
*/
    }

    private void findRecipes() {
        String str = getStringLine("рецепта");
        if(str==null){
            System.out.println("введено пустое наименование, повторите");
            return;
        }
        RecipeDao recipeDao = new RecipeDaoImpl(jdbcTemplate);
        List<Recipe> listRecipe = recipeDao.getRecipesByName(str);
        for(Recipe recipe: listRecipe){
            System.out.println(recipe);
        }

    }


    private void addRecipe() throws NoSuchOperationException {
        throw new NoSuchOperationException();
    }

    private void deleteRecipe(){
        String str = getStringLine("рецепта");
        if(str==null){
            System.out.println("введено пустое наименование, повторите");
            return;
        }
        RecipeDao recipeDao = new RecipeDaoImpl(jdbcTemplate);
        recipeDao.deleteRecipeByName(str);
    }

    private void showListRecipes() {
        RecipeDao recipeDao = new RecipeDaoImpl(jdbcTemplate);
        List<Recipe> listRecipe = recipeDao.getAllRecipes();
        for(Recipe recipe: listRecipe){
            System.out.println(recipe);
        }
    }

    private void getMenuPreferences() throws NoSuchOperationException {
        throw new NoSuchOperationException();
    }


    private String getStringLine(String type) {
        String str = null;
        while (true) {
            System.out.println("Введите название " + type + ":");
            Scanner scanner = new Scanner(System.in);
            str = scanner.nextLine().trim();
            break;
/*
            try {
                checkCorrectPin(pin);
                break;
            } catch (NullPinException | IncorrectPinException exc) {
                System.out.println(exc.getMessage());
            }
*/
        }
        return str;
    }


/*
    1.Поиск рецепта по имени или части имени блюда
    2.Добавление рецепта - рецепт состоит из множества ингредиентов и их количественного состава
    3.Удаление блюда
*/

    private int getMenuOperation() {
        while (true) {
            try {
                System.out.println("Меню:");
                System.out.println("1.Поиск рецепта");
                System.out.println("2.Поиск рецептов по части имени");
                System.out.println("3.Добавление рецепта");
                System.out.println("4.Удаление рецепта");
                System.out.println("5.Вывести список рецептов");
                System.out.println("6.Настройки");
                System.out.println("7.Выход");
                System.out.println("Введите номер пункта меню:");
                Scanner scanner = new Scanner(System.in);
                int numOper = 0;
                try {
                    numOper = scanner.nextInt();
                }catch (InputMismatchException exc){
                    throw new NoSuchOperationException();
                }
                if ((numOper < 1) || (numOper > 7)) {
                    throw new NoSuchOperationException();
                }
                return numOper;
            } catch (NoSuchOperationException exc) {
                System.out.println(exc.getMessage());
            }
        }
    }
}
