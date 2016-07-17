import java.util.HashMap;

import org.hibernate.criterion.Restrictions;
import org.hibernate.type.IntegerType;

public class EmployeesFilter extends QueryFilter {

    public  EmployeesFilter(HashMap<String, Object> filters) {
        super(filters);

        this.criteria = this.session.createCriteria(Employee.class);
    }

    public void name(String name) {
        this.criteria.add(Restrictions.like("name", "%" + name + "%"));
    }

    public void address(String address) {
        this.criteria.add(Restrictions.like("address", "%" + address + "%"));
    }

    public void age(Integer age) {
        this.criteria.add(
                Restrictions.sqlRestriction("(YEAR(NOW()) - YEAR(birth_date)) = ?", age, IntegerType.INSTANCE)
        );
    }
}
