import java.util.HashMap;

import org.hibernate.criterion.Restrictions;

public class EmployeesFilter extends QueryFilter {

    public  EmployeesFilter(HashMap<String, String> filters) {
        super(filters);

        this.criterias = this.session.createCriteria(Employee.class);
    }

    public void name(String name) {
        this.criterias.add(Restrictions.like("name", "%" + name + "%"));
    }

    public void address(String address) {
        this.criterias.add(Restrictions.like("address", "%" + address + "%"));
    }
}
