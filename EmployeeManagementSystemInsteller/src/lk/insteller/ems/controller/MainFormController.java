package lk.insteller.ems.controller;

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainFormController {
    public AnchorPane root;
    public Label lblMenu;
    public Label lblDescription;
    public ImageView imgLogin;
    public ImageView imgRegister;

    /**
     * Initializes the lk.insteller.ems.controller class.
     */

    public void navigate(MouseEvent mouseEvent) throws IOException {
        if (mouseEvent.getSource() instanceof ImageView) {
            ImageView icon = (ImageView) mouseEvent.getSource();
            Parent root = null;
            FXMLLoader fxmlLoader = null;
            switch (icon.getId()) {
                case "imgLogin":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/insteller/ems/view/LoginForm.fxml"));
                    break;
                case "imgRegister":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/insteller/ems/view/RegisterForm.fxml"));
                    break;
            }

            if (root != null) {
                Scene subScene = new Scene(root);
                Stage primaryStage = (Stage) this.root.getScene().getWindow();

                primaryStage.setScene(subScene);
                primaryStage.centerOnScreen();

                TranslateTransition tt = new TranslateTransition(Duration.millis(350), subScene.getRoot());
                tt.setFromX(-subScene.getWidth());
                tt.setToX(0);
                tt.play();

            }
        }
    }

    public void playMouseEnterAnimation(MouseEvent mouseEvent) {
        if (mouseEvent.getSource() instanceof ImageView) {
            ImageView icon = (ImageView) mouseEvent.getSource();

            switch (icon.getId()) {
                case "imgLogin":
                    lblMenu.setText("MANAGE LOGIN");
                    lblDescription.setText("CLICK TO LOGIN TO THE SYSTEM");
                    break;
                case "imgRegister":
                    lblMenu.setText("MANAGE REGISTRATION");
                    lblDescription.setText("CLICK TO REGISTER TO THE SYSTEM");
                    break;
            }

            ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1.2);
            scaleT.setToY(1.2);
            scaleT.play();

            DropShadow glow = new DropShadow();
            glow.setColor(Color.DARKGREEN);
            glow.setWidth(20);
            glow.setHeight(20);
            glow.setRadius(20);
            icon.setEffect(glow);
        }
    }

    public void playMouseExitAnimation(MouseEvent mouseEvent) {
        if (mouseEvent.getSource() instanceof ImageView) {
            ImageView icon = (ImageView) mouseEvent.getSource();
            ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1);
            scaleT.setToY(1);
            scaleT.play();

            icon.setEffect(null);
            lblMenu.setText("EELCOME");
            lblDescription.setText("PLEASE SELECT ONE OF ABOVE MAIN OPERATIONS TO PROCEED ");
        }
    }

}


