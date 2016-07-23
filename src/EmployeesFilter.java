import java.util.HashMap;

import org.hibernate.type.IntegerType;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

public class EmployeesFilter extends QueryFilter {

    public  EmployeesFilter(HashMap<String, Object> filters) {
        super(filters);

        this.criteria = this.session.createCriteria(Employee.class);
    }

    public void name(String name) {
        this.criteria.add(Restrictions.like("name", name, MatchMode.START));
    }

    public void address(String address) {
        this.criteria.add(Restrictions.like("address", address, MatchMode.ANYWHERE));
    }

    public void age(Integer age) {
        this.criteria.add(
                Restrictions.sqlRestriction("(YEAR(NOW()) - YEAR(birth_date)) = ?", age, IntegerType.INSTANCE)
        );
    }

    public void role(Role role) {
        this.criteria.createAlias("roles", "role");
        this.criteria.add(Restrictions.eq("role.id", role.getId()));
    }
}
