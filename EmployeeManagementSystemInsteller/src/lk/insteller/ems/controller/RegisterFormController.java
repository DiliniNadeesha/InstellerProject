package lk.insteller.ems.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.insteller.ems.business.BOFactory;
import lk.insteller.ems.business.BOTypes;
import lk.insteller.ems.business.custom.LoginBO;
import lk.insteller.ems.business.custom.UserBO;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class RegisterFormController implements Initializable {
    public AnchorPane root;
    public ComboBox<String> cmbUserType;
    public TextField txtUsername;
    public TextField txtEmail;
    public PasswordField txtPassword;
    public Button btnRegister;

    private UserBO userBO = BOFactory.getInstance().getBO(BOTypes.USER);

    public void initialize(URL location, ResourceBundle resources) {

        ObservableList<String> userTypes = cmbUserType.getItems();
        try {
            List<String> userTypes2 = userBO.getUserTypes();
            ObservableList<String> utypes = FXCollections.observableArrayList(userTypes2);
            cmbUserType.setItems(utypes);
            System.out.println(utypes);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void navigateToHome(MouseEvent mouseEvent) throws IOException {

        URL resource = this.getClass().getResource("/lk/insteller/ems/view/MainForm.fxml");
        Parent root = FXMLLoader.load(resource);
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) (this.root.getScene().getWindow());
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
    }

    public void btnRegister_OnAction(ActionEvent actionEvent) {

        String selectedUserType = (String) cmbUserType.getSelectionModel().getSelectedItem();
        String username = txtUsername.getText();
        String email = txtEmail.getText();
        String password = txtPassword.getText();

        try {
            boolean result = userBO.isUser(selectedUserType, username, email, password);
            if(result){
                URL resource = this.getClass().getResource("/lk/insteller/ems/view/HomeForm.fxml");
                Parent root = FXMLLoader.load(resource);
                Scene scene = new Scene(root);
                Stage primaryStage = (Stage) (this.root.getScene().getWindow());
                primaryStage.setScene(scene);
                primaryStage.centerOnScreen();

            }else{
                new Alert(Alert.AlertType.ERROR,"Please Check your login credentials", ButtonType.OK).show();
                cmbUserType.getSelectionModel().clearSelection();
                txtUsername.clear();
                txtEmail.clear();
                txtPassword.clear();
                cmbUserType.requestFocus();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
