package dao;

import entity.Employee;
import filters.QueryFilter;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateManager;

import java.util.List;

public class Dao<T> {

    protected final SessionFactory sessionFactory;

    public Dao() {
        this.sessionFactory = HibernateManager.getSessionFactory();
    }

    public Session getSession() {
        return this.sessionFactory.openSession();
    }

    public List<T> filter(QueryFilter filter) {
        return (List<T>) filter.apply();
    }

    public List<T> all(Class<T> cls) {
        final Session session = this.getSession();
        Criteria criteria = session.createCriteria(cls);

        return (List<T>) criteria.list();
    }

    public T find(Class<T> cls, Integer id) {
        final Session session = this.getSession();

        T object = (T) this.getSession().get(cls, id);

        session.flush();
        session.close();

        return object;
    }

    public void save(T object) {
        final Session session = this.getSession();
        final Transaction transaction = session.beginTransaction();

        session.persist(object);

        session.flush();
        transaction.commit();
        session.close();
    }

    public void saveMany(List<Employee> employees) {
        final Session session = this.getSession();
        final Transaction transaction = session.beginTransaction();

        try {
            employees.forEach(employee -> session.persist(employee));

            session.flush();
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
        }

        session.close();
    }

    public void delete(T object) {
        final Session session = this.getSession();

        session.delete(object);

        session.close();
    }
}
