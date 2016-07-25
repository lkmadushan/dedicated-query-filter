package filters;

import java.util.List;
import java.util.HashMap;

import org.hibernate.Session;
import org.hibernate.Criteria;
import util.HibernateManager;

import java.lang.reflect.InvocationTargetException;

public class QueryFilter {

    protected final Session session;

    protected Criteria criteria;

    protected HashMap<String, Object> filters;

    public QueryFilter(HashMap filters) {
        this.filters = filters;
        this.session = HibernateManager.getSessionFactory().openSession();
    }

    public List apply() {

        this.filters.keySet().forEach((key) -> {
            try {
                this.getClass().getMethod(
                        key.toString(), this.filters.get(key).getClass()
                ).invoke(this, this.filters.get(key));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                System.out.println(e.getCause());
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        });

        List results = this.criteria.list();

        this.session.flush();
        this.session.close();

        return results;
    }
}
