package hibernate1;

import hibernate1.dao.IngredientDaoImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import hibernate1.model.*;
import java.util.List;

public class MainApp {
    private static SessionFactory sessionFactory;

    public static void main(String[] args) {

//        sessionFactory = new Configuration().configure().buildSessionFactory();

/*
        List<Recipe> recipes = new MainApp().listRecipes();
        for(Recipe recipe : recipes){
            System.out.println(recipe);
        }
*/

        sessionFactory = HibernateUtil.getSessionFactory();

        IngredientDaoImpl ingredientDao = new IngredientDaoImpl(sessionFactory);
        System.out.println(ingredientDao.getIngredientByName("Слива"));

        //new MainApp().addIngredient("Мармелад");

/*        List<Ingredient> ingredients = new MainApp().listIngredients();
        for(Ingredient ingredient : ingredients){
            System.out.println(ingredient);
        }*/



    }

    public List<Recipe> listRecipes() {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        List<Recipe> recipes = session.createQuery("FROM Recipe").list();

        transaction.commit();
        session.close();
        return recipes;
    }

    public List<Ingredient> listIngredients() {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        List<Ingredient> ingredients = session.createQuery("FROM Ingredient").list();

        transaction.commit();
        session.close();
        return ingredients;
    }

    public void addIngredient(String name){
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();

        Ingredient ingredient = new Ingredient();
        ingredient.setName(name);
        session.save(ingredient);

        transaction.commit();
        session.close();

    }
}
