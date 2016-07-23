import java.util.List;
import java.util.HashMap;

public class Main {

    public static void main(final String[] args) throws Exception {

        EmployeeDao employeeDao = new EmployeeDao();
        RoleDao roleDao = new RoleDao();

        Role role = roleDao.find(1);

        HashMap<String, Object> filters = new HashMap<>();
        //filters.put("name", "kuma");
        //filters.put("age", 25);
        filters.put("role", role);
        //filters.put("address", "ga");

        List<Employee> employees = employeeDao.filter(new EmployeesFilter(filters));

        for (Employee e : employees) {
            System.out.println(e.getName());
        }
    }
}
