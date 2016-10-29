import dao.EmployeeDao;
import entity.Employee;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("ui/sample.fxml"));
        primaryStage.setTitle("Filter");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

    public static void main(final String[] args) throws Exception {
        Employee employeeOne = new Employee();
        employeeOne.setName("Kalpa");
        employeeOne.setAddress("Gampaha");

        Employee employeeTwo = new Employee();
        employeeTwo.setName("Madushan");
        employeeTwo.setAddress("Naiwala");

        EmployeeDao dao = new EmployeeDao();
        dao.save(employeeOne);
        dao.save(employeeTwo);

        launch(args);
    }
}
