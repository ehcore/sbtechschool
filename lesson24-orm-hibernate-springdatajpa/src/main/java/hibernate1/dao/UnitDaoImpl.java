package hibernate1.dao;


import hibernate1.model.Unit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class UnitDaoImpl implements UnitDao{
    private SessionFactory sessionFactory;

    public UnitDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Unit getUnitByName(String name) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Unit> query = builder.createQuery(Unit.class);
        Root<Unit> root = query.from(Unit.class);
        Unit unit = query
                .select(root)
                .where(builder.equal(root.get(Unit_.name),name));

        transaction.commit();
        session.close();


        return unit;
    }

    @Override
    public List<Unit> getAllUnits() {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Unit> query = builder.createQuery(Unit.class);
        Root<Unit> root = query.from(Unit.class);
        query.select(root);
        List<Unit> units = session.createQuery(query).list();

        transaction.commit();
        session.close();

        return units;
    }

    @Override
    public void addUnit(String name) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();

        Unit unit = new Unit();
        unit.setName(name);
        session.save(unit);

        transaction.commit();
        session.close();
    }

    @Override
    public void deleteUnitByName(String name) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();

        Unit unit = new Unit();
        unit.setName(name);
        session.delete(unit);

        transaction.commit();
        session.close();
    }
}
