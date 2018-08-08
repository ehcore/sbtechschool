package hibernate1.dao;


import hibernate1.model.Ingredient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class IngredientDaoImpl implements IngredientDao{
    private SessionFactory sessionFactory;

    public IngredientDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Ingredient getIngredientsById(Integer id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Query<Ingredient> query = session.createQuery("FROM Ingredient WHERE id =:id",Ingredient.class)
                .setParameter("id", id);

        Ingredient ingredient = query.getSingleResult();

        transaction.commit();
        session.close();
        return ingredient;
    }

    @Override
    public Ingredient getIngredientByName(String name) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Query<Ingredient> query = session.createQuery("FROM Ingredient WHERE name =:name",Ingredient.class)
                .setParameter("name", name);

        //**будет ошибка, если в результате больше одного рецепта
        Ingredient ingredient = query.getSingleResult();

        transaction.commit();
        session.close();
        return ingredient;
    }

    @Override
    public List<Ingredient> getIngredientsByName(String name) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Query<Ingredient> query = session.createQuery("FROM Ingredient WHERE name =:name",Ingredient.class)
                .setParameter("name", name);


        List<Ingredient> ingredients = query.list();

        transaction.commit();
        session.close();

        return ingredients;
    }

    @Override
    public List<Ingredient> getAllIngredients() {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Query<Ingredient> query = session.createQuery("FROM Ingredient",Ingredient.class);

        List<Ingredient> ingredients = query.list();

        transaction.commit();
        session.close();

        return ingredients;
    }

    @Override
    public void addIngredient(String name) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();

        Ingredient ingredient = new Ingredient();
        ingredient.setName(name);
        session.save(ingredient);

        transaction.commit();
        session.close();
    }

    @Override
    public void deleteIngredientByName(String name) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();

        Ingredient ingredient = new Ingredient();
        ingredient.setName(name);
        session.delete(ingredient);

        transaction.commit();
        session.close();
    }
}
