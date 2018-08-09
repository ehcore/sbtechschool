package hibernate1.dao;


import hibernate1.model.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;

import java.util.List;

public class IngredientsRecipeDaoImpl implements IngredientsRecipeDao{
    private SessionFactory sessionFactory;

    public IngredientsRecipeDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<IngredientsRecipeView> getIngredientsRecipeViewByNameRecipe(String name) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();

        RecipeDao recipeDao = new RecipeDaoImpl(sessionFactory);
        Recipe recipe = recipeDao.getRecipeByName(name);

        Query<IngredientsRecipeView> query = session
                .createNativeQuery("SELECT temp.name AS \"ingredient\", temp.amount AS \"amount\" , temp.id_unit,  recipes.units.name AS \"unit\" FROM " +
                                "(SELECT recipes.ingredients_recipes.id_unit , recipes.ingredients.name, recipes.ingredients_recipes.amount " +
                                "FROM recipes.ingredients_recipes JOIN recipes.ingredients ON recipes.ingredients_recipes.id_ingredients = recipes.ingredients.id " +
                                "WHERE recipes.ingredients_recipes.id_recipes=:id) temp JOIN recipes.units ON temp.id_unit = recipes.units.id"
                        ,IngredientsRecipeView.class);
        query.setParameter("id",recipe.getId());

        List<IngredientsRecipeView> views = query
                .setResultTransformer( Transformers.aliasToBean( IngredientsRecipeView.class ))
                .list();//.getResultList();//list();

        transaction.commit();
        session.close();

        return views;
    }

    @Override
    public void addIngredientsToRecipe(String recipeName, String ingredientName, Double amount, String unitName) {
        RecipeDao recipeDao = new RecipeDaoImpl(sessionFactory);
        Recipe recipe = recipeDao.getRecipeByName(recipeName);
        IngredientDao ingredientDao = new IngredientDaoImpl(sessionFactory);
        Ingredient ingredient = ingredientDao.getIngredientByName(ingredientName);
        UnitDao unitDao = new UnitDaoImpl(sessionFactory);
        Unit unit = unitDao.getUnitByName(unitName);

        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();

        IngredientsRecipe ingredientsRecipe =
                new IngredientsRecipe(recipe,ingredient,amount,unit);

        session.save(ingredientsRecipe);

        transaction.commit();
        session.close();

//id_recipes int(10), id_ingredients int(10), amount decimal(8,3), id_unit int(10)

    }
}
