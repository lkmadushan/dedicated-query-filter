import java.util.HashMap;

import org.hibernate.criterion.Restrictions;

public class EmployeesFilter extends QueryFilter {

    public  EmployeesFilter(HashMap<String, String> filters) {
        super(filters);

        this.criteria = this.session.createCriteria(Employee.class);
    }

    public void name(String name) {
        this.criteria.add(Restrictions.like("name", "%" + name + "%"));
    }

    public void address(String address) {
        this.criteria.add(Restrictions.like("address", "%" + address + "%"));
    }
}
