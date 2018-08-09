package hibernate1.dao;


import hibernate1.model.Recipe;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class RecipeDaoImpl implements RecipeDao{
    private SessionFactory sessionFactory;

    public RecipeDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Recipe getRecipeByName(String name) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        Query<Recipe> query = session.createQuery("FROM Recipe WHERE name =:name",Recipe.class)
                .setParameter("name", name);

        Recipe recipe = query.getSingleResult();

        transaction.commit();
        session.close();

        return recipe;
    }

    @Override
    public List<Recipe> getRecipesByName(String name) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();

        Query<Recipe> query = session.createNamedQuery("Recipe.findSuggection",Recipe.class);
        query.setParameter("name",name + "%");

        List<Recipe> recipes = query.list();

        transaction.commit();
        session.close();

        return recipes;
    }

    @Override
    public List<Recipe> getAllRecipes() {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();

        Query<Recipe> query = session.createNamedQuery("Recipe.findAll",Recipe.class);

        List<Recipe> recipes = query.list();

        transaction.commit();
        session.close();

        return recipes;
    }

    @Override
    public void addRecipe(String name) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();

        Recipe recipe = new Recipe();
        recipe.setName(name);
        session.save(recipe);

        transaction.commit();
        session.close();
    }

    @Override
    public void deleteRecipeByName(String name) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();

        Recipe recipe = new Recipe();
        recipe.setName(name);
        session.delete(recipe);

        transaction.commit();
        session.close();

    }
}
