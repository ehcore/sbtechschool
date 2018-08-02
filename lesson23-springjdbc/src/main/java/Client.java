import java.util.*;

import dao.*;
import exceptions.*;
import model.Ingredient;
import model.IngredientsRecipeView;
import model.Recipe;
import model.Unit;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;


public class Client {
    private JdbcTemplate jdbcTemplate;

    public void start(){
        init();
        work();
    }

    private void init(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
       // ctx.refresh();
        jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
    }

    private void work(){

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
                    makeSettings();
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

    private void addRecipe(){
        String str = getStringLine("рецепта");
        if(str==null){
            System.out.println("введено пустое наименование, повторите");
            return;
        }
        RecipeDao recipeDao = new RecipeDaoImpl(jdbcTemplate);
        recipeDao.addRecipe(str);
        addIngredientToRecipe(str);
    }

    private void addIngredientToRecipe(String nameRecipe){
        IngredientsRecipeDao ingredientsRecipeDao = new IngredientsRecipeDaoImpl(jdbcTemplate);

        while (true) {
            System.out.println("Введите ингредиент (для окончания процесса ввода ингредиента введите ВЫХОД)");
            Scanner scanner = new Scanner(System.in);
            String nameIngredient = scanner.nextLine().trim();
            if("ВЫХОД".equals(nameIngredient.trim().toUpperCase())){
                break;
            }
            System.out.println("Введите количество:");
            scanner = new Scanner(System.in);
            Double amount = 0d;
            try {
                amount = scanner.nextDouble();
            }catch (InputMismatchException exc){
            }
            System.out.println("Введите единицу измерения:");
            scanner = new Scanner(System.in);
            String nameUnit = scanner.nextLine().trim();
            ingredientsRecipeDao.addIngredientsToRecipe(nameRecipe,nameIngredient,amount,nameUnit);
        }
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


    private void makeSettings(){
        while (true) {
            int numOper = getMenuPreferences();
            switch (numOper) {
                case 1:
                    showListIngredients();
                    break;
                case 2:
                    addIngredient();
                    break;
                case 3:
                    showListUnits();
                    break;
                case 4:
                    addUnit();
                    break;
                case 5:
                    return;
            }
        }
    }

    private void showListIngredients() {
        IngredientDao ingredientDao = new IngredientDaoImpl(jdbcTemplate);
        List<Ingredient> listIngredients = ingredientDao.getAllIngredients();
        for(Ingredient ingredient : listIngredients){
            System.out.println(ingredient.getName());
        }
    }

    private void addIngredient() {
        String str = getStringLine("ингредиента");
        if(str==null){
            System.out.println("введено пустое наименование, повторите");
            return;
        }
        IngredientDao ingredientDao = new IngredientDaoImpl(jdbcTemplate);
        ingredientDao.addIngredient(str);
    }

    private void showListUnits() {
        UnitDao unitDao = new UnitDaoImpl(jdbcTemplate);
        List<Unit> listUnits = unitDao.getAllUnits();
        for(Unit unit : listUnits){
            System.out.println(unit.getName());
        }
    }

    private void addUnit() {
        String str = getStringLine("единицы измерения");
        if(str==null){
            System.out.println("введено пустое наименование, повторите");
            return;
        }
        UnitDao unitDao = new UnitDaoImpl(jdbcTemplate);
        unitDao.addUnit(str);
    }


    private int getMenuPreferences()  {

        while (true) {
            try {
                System.out.println();
                System.out.println("Настройки справочников:");
                System.out.println("1.Вывести список ингредиентов");
                System.out.println("2.Добавление ингредиента");
                System.out.println("3.Вывести список единиц измерений");
                System.out.println("4.Добавление единицы измерения");
                System.out.println("5.Выход");
                System.out.println("Введите номер пункта меню:");
                Scanner scanner = new Scanner(System.in);
                int numOper = 0;
                try {
                    numOper = scanner.nextInt();
                }catch (InputMismatchException exc){
                    throw new NoSuchOperationException();
                }
                if ((numOper < 1) || (numOper > 5)) {
                    throw new NoSuchOperationException();
                }
                return numOper;
            } catch (NoSuchOperationException exc) {
                System.out.println(exc.getMessage());
            }
        }


    }


    private String getStringLine(String type) {
        String str = null;
        while (true) {
            System.out.println("Введите название " + type + ":");
            Scanner scanner = new Scanner(System.in);
            str = scanner.nextLine().trim();
            break;
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
                System.out.println();
                System.out.println("Меню:");
                System.out.println("1.Поиск рецепта");
                System.out.println("2.Поиск рецептов по части имени");
                System.out.println("3.Добавление рецепта");
                System.out.println("4.Удаление рецепта");
                System.out.println("5.Вывести список рецептов");
                System.out.println("6.Настройки справочников");
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
