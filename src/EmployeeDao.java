import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.Transaction;

import java.util.List;

public class EmployeeDao {

    public List<Employee> filter(QueryFilter filter) {
        return (List<Employee>) filter.apply();
    }

    public List<Employee> all() {
        final Session session = HibernateManager.getSession();

        Criteria cr = session.createCriteria(Employee.class);
        List list = cr.list();
        
        return (List<Employee>) list;
    }

    public void saveMany(List<Employee> employees) {
        final Session session = HibernateManager.getSession();
        final Transaction transaction = session.beginTransaction();

        try {
            int i = 0;
            for (Employee employee : employees) {
                session.save(employee);
                if ( i % 20 == 0 ) {
                    session.flush();
                    session.clear();
                }
                i++;
            }
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
        }

        session.close();
    }

}
