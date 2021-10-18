package lk.insteller.ems.controller;

import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.insteller.ems.business.BOFactory;
import lk.insteller.ems.business.BOTypes;
import lk.insteller.ems.business.custom.LoginBO;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class LoginFormController implements Initializable {
    public AnchorPane root;
    public ComboBox<String> cmbUserType;
    public TextField txtEmail;
    public PasswordField txtPassword;
    public Button btnLogin;

    private LoginBO loginBO = BOFactory.getInstance().getBO(BOTypes.LOGIN);

    public void initialize(URL location, ResourceBundle resources) {

        ObservableList<String> userTypes = cmbUserType.getItems();
        try {
            List<String> userTypes1 = loginBO.getUserTypes();
            ObservableList<String> utypes = FXCollections.observableArrayList(userTypes1);
            cmbUserType.setItems(utypes);
            System.out.println(utypes);
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    public void btnLogin_OnAction(ActionEvent actionEvent) {

        String selectedUserType = (String) cmbUserType.getSelectionModel().getSelectedItem();
        String email = txtEmail.getText();
        String password = txtPassword.getText();

        try {
            boolean result = loginBO.isUser(selectedUserType, email, password);
            
            if(result){
                URL resource = this.getClass().getResource("/lk/insteller/ems/view/HomeForm.fxml");
                //URL resource = this.getClass().getResource("/lk/insteller/ems/view/DepartmentForm.fxml");
                Parent root = FXMLLoader.load(resource);
                Scene scene = new Scene(root);
                Stage primaryStage = (Stage) (this.root.getScene().getWindow());
                primaryStage.setScene(scene);
                primaryStage.centerOnScreen();

            }else{
                new Alert(Alert.AlertType.ERROR,"Please Check your login credentials", ButtonType.OK).show();
                cmbUserType.getSelectionModel().clearSelection();
                txtEmail.clear();
                txtPassword.clear();
                cmbUserType.requestFocus();
            }
        } catch (Exception e) {
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
}
