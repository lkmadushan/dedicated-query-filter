import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {

    public static void main(final String[] args) throws Exception {

        HashMap<String, Object> filters = new HashMap<>();
        filters.put("name", "s");
        filters.put("age", 25);
        //filters.put("address", "ga");

        EmployeeDao employeeDao = new EmployeeDao();
        List<Employee> employees = employeeDao.filter(new EmployeesFilter(filters));

        for (Employee e : employees) {
            System.out.println(e.getName());
        }
    }

    protected static List<Employee> createEmployees() {
        List<Employee> employees = new ArrayList<>();

        try {
            employees.add(new Employee("Ashini", "Ampara", new SimpleDateFormat("yyyy-MM-dd").parse("1994-02-25")));
            employees.add(new Employee("Aloka", "Minuwangoda", new SimpleDateFormat("yyyy-MM-dd").parse("1990-06-28")));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return employees;
    }
}
