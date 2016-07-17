import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

public class Main {

    public static void main(final String[] args) throws Exception {

        HashMap<String, String> filters = new HashMap<>();
        filters.put("name", "k");
        filters.put("address", "ga");

        EmployeeDao employeeDao = new EmployeeDao();
        List<Employee> employees = employeeDao.filter(new EmployeesFilter(filters));

        for (Employee e : employees) {
            System.out.println(e.getName());
        }
    }

    protected static List<Employee> createEmployees() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Supun", "Ampara"));
        employees.add(new Employee("Sandun", "Minuwangoda"));

        return employees;
    }
}
