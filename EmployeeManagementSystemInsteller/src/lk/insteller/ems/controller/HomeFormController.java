package lk.insteller.ems.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.insteller.ems.business.BOFactory;
import lk.insteller.ems.business.BOTypes;
import lk.insteller.ems.business.custom.EmployeeBO;
import lk.insteller.ems.business.exception.AlreadyExistsInEmployeeException;
import lk.insteller.ems.dto.EmployeeDTO;
import lk.insteller.ems.util.EmployeeTM;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HomeFormController implements Initializable {
    public AnchorPane root;
    public ComboBox<String> cmbPosition;
    public TextField txtNic;
    public ComboBox<String> cmbDepNo;
    public TextField txtName;
    public TextField txtSalary;
    public ComboBox<String> cmbDepName;
    public TextField txtDate;
    public Button btnSave;
    public Button btnUpdate;
    public Button btnDelete;
    public Button btnAdd;
    public TableView<EmployeeTM> tblEmployee;
    public Label lblDate;


    private EmployeeBO employeeBO = BOFactory.getInstance().getBO(BOTypes.EMPLOYEE);

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // Set Local Date
        lblDate.setText(LocalDate.now() + "");

        // Lord to data in to the combobox manually
        cmbDepName.getItems().removeAll(cmbDepName.getItems());
        cmbDepName.getItems().addAll("Marketing Management", "HR Management", "Software Engineering", "QA");
        cmbDepName.getSelectionModel().select("Software Engineering");

        cmbPosition.getItems().removeAll(cmbPosition.getItems());
        cmbPosition.getItems().addAll("Software Engineer", "QA", "HR Manager", "Marketing Manager");
        cmbPosition.getSelectionModel().select("Software Engineer");

        cmbDepNo.getItems().removeAll(cmbDepNo.getItems());
        cmbDepNo.getItems().addAll("DP001-MM", "DP002-HM", "DP003-SE", "DP004-QA");
        cmbDepNo.getSelectionModel().select("DP003-SE");


        // Match table columns according to the database columns
        tblEmployee.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("empId"));
        tblEmployee.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("emp_Name"));
        tblEmployee.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("dep_Name"));
        tblEmployee.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("position"));
        tblEmployee.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("salary"));
        tblEmployee.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("joined_Date"));
        tblEmployee.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("depId"));

        txtNic.setDisable(true);
        txtName.setDisable(true);
        cmbDepName.setDisable(true);
        cmbDepNo.setDisable(true);
        cmbPosition.setDisable(true);
        txtSalary.setDisable(true);
        txtDate.setDisable(true);
        btnSave.setDisable(false);
        btnDelete.setDisable(true);

        // When home form is loard, All employee table data is loding to the initialize statement.
        loadAllEmployees();

        tblEmployee.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<EmployeeTM>() {
            @Override
            public void changed(ObservableValue<? extends EmployeeTM> observable, EmployeeTM oldValue, EmployeeTM newValue) {

                EmployeeTM selectedItem = tblEmployee.getSelectionModel().getSelectedItem();

                if (selectedItem == null) {
                    btnSave.setText("Save");
                    btnDelete.setDisable(true);
                    return;
                }
                btnSave.setDisable(false);
                btnDelete.setDisable(false);
                txtName.setDisable(false);
                cmbDepName.setDisable(false);
                cmbPosition.setDisable(false);
                txtSalary.setDisable(false);
                txtDate.setDisable(false);
                cmbDepNo.setDisable(false);

                txtNic.setText(selectedItem.getEmpId());
                txtName.setText(selectedItem.getEmp_Name());
                cmbDepName.getSelectionModel().select(selectedItem.getDep_Name());
                cmbPosition.getSelectionModel().select(selectedItem.getPosition());
                txtSalary.setText(String.valueOf(selectedItem.getSalary()));
                txtDate.setText(selectedItem.getJoined_Date());
                cmbDepNo.getSelectionModel().select(selectedItem.getDepId());
            }
        });
    }


    public void navigateToHome(MouseEvent mouseEvent) throws IOException {

        URL resource = this.getClass().getResource("/lk/insteller/ems/view/MainForm.fxml");
        Parent root = FXMLLoader.load(resource);
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) (this.root.getScene().getWindow());
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
    }

    public void btnAddOnAction(ActionEvent actionEvent) {

        txtNic.clear();
        txtName.clear();
        cmbDepName.getSelectionModel().clearSelection();
        cmbDepNo.getSelectionModel().clearSelection();
        cmbPosition.getSelectionModel().clearSelection();
        txtSalary.clear();
        txtDate.clear();
        tblEmployee.getSelectionModel().clearSelection();

        txtName.setDisable(false);
        cmbDepName.setDisable(false);
        cmbDepNo.setDisable(false);
        cmbPosition.setDisable(false);
        txtSalary.setDisable(false);
        txtDate.setDisable(false);
        txtNic.requestFocus();

        btnUpdate.setDisable(false);
        btnSave.setDisable(false);

        // Generate a new Employee ID:
        int maxId = 0;

        try {
            String lastEmployeeId = employeeBO.getLastEmployeeId();

            if (lastEmployeeId == null) {
                maxId = 0;
            } else {
                maxId = Integer.parseInt(lastEmployeeId.replace("E", ""));
            }

            maxId = maxId + 1;
            String id = "";
            if (maxId < 10) {
                id = "E00" + maxId;
            } else if (maxId < 100) {
                id = "E0" + maxId;
            } else {
                id = "E" + maxId;
            }
            txtNic.setText(id);

        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Something went wrong, please contact Dilini Wellage").show();
            Logger.getLogger("lk.insteller.ems.controller").log(Level.SEVERE, null, e);
        }

    }

    public void btSave_OnAction(ActionEvent actionEvent) {

        // Using Regex
        if (!txtName.getText().matches("[A-Za-z][A-Za-z. ]+")) {
            new Alert(Alert.AlertType.ERROR, "Invalid Name").show();
            return;
        }

        if (btnSave.getText().equals("Save")) {
            ObservableList<EmployeeTM> employee = tblEmployee.getItems();
            EmployeeDTO newEmployee = new EmployeeDTO(
                    txtNic.getText(),
                    txtName.getText(),
                    cmbDepName.getValue(),
                    cmbPosition.getValue(),
                    Double.parseDouble(String.valueOf(txtSalary.getText())),
                    txtDate.getText(),
                    cmbDepNo.getValue());

            try {
                employeeBO.saveEmployee(newEmployee);
                employee.add(new EmployeeTM(newEmployee.getEmpId(), newEmployee.getEmp_Name(), newEmployee.getDep_Name(),
                        newEmployee.getPosition(), Double.parseDouble(String.valueOf(newEmployee.getSalary())), newEmployee.getJoined_Date(),
                        newEmployee.getDepId()));

                btnAddOnAction(actionEvent);
                new Alert(Alert.AlertType.CONFIRMATION, "New employee saved successfully").show();
            } catch (Exception e) {
                new Alert(Alert.AlertType.ERROR, "Something went wrong, please contact Dilini Wellage").show();
                Logger.getLogger("lk.insteller.ems.controller").log(Level.SEVERE, null, e);
            }

        } else {
            EmployeeTM selectedEmployee = tblEmployee.getSelectionModel().getSelectedItem();
            try {
                employeeBO.updateEmployee(new EmployeeDTO(selectedEmployee.getEmpId(),
                        txtName.getText(),
                        cmbDepName.getValue(),
                        cmbPosition.getValue(),
                        Double.parseDouble(txtSalary.getText()),
                        txtDate.getText(),
                        cmbDepNo.getValue()));

                selectedEmployee.setEmp_Name(txtName.getText());
                selectedEmployee.setDep_Name(String.valueOf(cmbDepName.getSelectionModel()));
                selectedEmployee.setPosition(String.valueOf(cmbPosition.getSelectionModel()));
                selectedEmployee.setSalary(Double.parseDouble(txtSalary.getText()));
                selectedEmployee.setEmp_Name(txtDate.getText());
                selectedEmployee.setDepId(String.valueOf(cmbDepNo.getSelectionModel()));
                tblEmployee.refresh();
                btnAddOnAction(actionEvent);
            } catch (Exception e) {
                new Alert(Alert.AlertType.ERROR, "Something went wrong, please contact Dilini Wellage").show();
                Logger.getLogger("lk.insteller.ems.controller").log(Level.SEVERE, null, e);
            }
        }
    }


    public void btnUpdate_OnAction(ActionEvent actionEvent) throws Exception {

        boolean b = employeeBO.updateEmployee(new EmployeeDTO( txtNic.getText(), txtName.getText(), cmbDepName.getValue(), cmbPosition.getValue(),
                Double.parseDouble(txtSalary.getText()), txtDate.getText(), cmbDepNo.getValue()));

        if (b){
            new Alert(Alert.AlertType.CONFIRMATION,"Employee updated successfully").show();
            loadAllEmployees();
        }else{
            new Alert(Alert.AlertType.ERROR,"Something went wrong, please contact Dilini Wellage").show();
        }
        tblEmployee.refresh();
    }


    private void loadAllEmployees() {
        try {
            List<EmployeeDTO> allEmployees = employeeBO.findAllEmployee();
            ObservableList<EmployeeTM> employees = tblEmployee.getItems();
            tblEmployee.getItems().clear();
            for (EmployeeDTO e : allEmployees) {
                employees.add(new EmployeeTM(e.getEmpId(), e.getEmp_Name(),e.getDep_Name(), e.getPosition(), e.getSalary(),
                        e.getJoined_Date(), e.getDepId()));
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR,"Something went wrong, please contact Dilini Wellage").show();
            Logger.getLogger("lk.insteller.ems.controller").log(Level.SEVERE, null,e);
        }
    }


        public void btnDelete_OnAction(ActionEvent actionEvent) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                "Are you sure whether you want to delete this employee?",
                ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> buttonType = alert.showAndWait();
        if (buttonType.get() == ButtonType.YES) {
            EmployeeTM selectedItem = tblEmployee.getSelectionModel().getSelectedItem();
            try {
                employeeBO.deleteEmployee(selectedItem.getEmpId());
                tblEmployee.getItems().remove(selectedItem);
            }catch (AlreadyExistsInEmployeeException e){
                new Alert(Alert.AlertType.INFORMATION,e.getMessage()).show();
            } catch (Exception e) {
                new Alert(Alert.AlertType.ERROR,"Something went wrong, please contact Dilini Wellage").show();
                Logger.getLogger("lk.insteller.ems.controller").log(Level.SEVERE, null,e);
            }
        }
    }
}
