package ui;

import dao.EmployeeDao;
import dao.RoleDao;
import entity.Employee;
import entity.Role;
import filters.EmployeesFilter;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.HashMap;

public class EmployeesController {

    @FXML
    protected TextField name;

    @FXML
    protected TextField address;

    @FXML
    protected TextField age;

    @FXML
    protected TableView<Employee> tableEmployees;

    @FXML
    protected TableColumn colName;

    @FXML
    protected TableColumn colAddress;

    @FXML
    protected ComboBox<Role> comboBoxRoles;

    protected EmployeeDao employeeDao;

    protected RoleDao roleDao;

    public EmployeesController() {
        this.employeeDao = new EmployeeDao();
        this.roleDao = new RoleDao();
    }

    @FXML
    public void initialize() {
        populateEmployeesTable(new HashMap());
        populateRolesComboBox();
    }

    @FXML
    protected void search() {

        HashMap<String, Object> filters = new HashMap<>();
        filters.put("name", name.getText().trim());
        filters.put("address", address.getText().trim());

        if (! comboBoxRoles.getSelectionModel().isEmpty())
            filters.put("role", comboBoxRoles.getSelectionModel().getSelectedItem());

        populateEmployeesTable(filters);
    }

    protected void populateEmployeesTable(HashMap filters) {
        colName.setCellValueFactory(new PropertyValueFactory<Employee, String>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<Employee, String>("address"));

        tableEmployees.setItems(FXCollections.observableList(
                this.employeeDao.filter(new EmployeesFilter(filters))
        ));
    }

    protected void populateRolesComboBox() {
        comboBoxRoles.setItems(FXCollections.observableList(this.roleDao.all()));
    }
}
