package lk.insteller.ems.controller;

import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.insteller.ems.business.BOFactory;
import lk.insteller.ems.business.BOTypes;
import lk.insteller.ems.business.custom.DepartmentBO;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class DepartmentFormController implements Initializable {

    public AnchorPane root;
    public Label lblDate;
    public ImageView imgMM;
    public ImageView imgHR;
    public ImageView imgSE;
    public ImageView imgQA;
    public Label lblMenu;
    public Label lblDescription;
    private DepartmentBO departmentBO = BOFactory.getInstance().getBO(BOTypes.DEPARTMENT);

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        lblDate.setText(LocalDate.now() + "");

    }

    public void navigate(MouseEvent mouseEvent) throws IOException {

        if (mouseEvent.getSource() instanceof ImageView) {
            ImageView icon = (ImageView) mouseEvent.getSource();
            Parent root = null;
            FXMLLoader fxmlLoader = null;
            switch (icon.getId()) {
                case "imgLogin":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/insteller/ems/view/HomeForm.fxml"));
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
                case "imgMM":
                    lblMenu.setText("Marketing Management Department");
                    break;
                case "imgHR":
                    lblMenu.setText("HR Management Department");
                    break;
                case "imgSE":
                    lblMenu.setText("Software Engineering Department");
                    break;
                case "imgQA":
                    lblMenu.setText("QA Department");
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
            lblMenu.setText("WELCOME");
            lblDescription.setText("PLEASE SELECT ONE OF ABOVE DEPARTMENT TO PROCEED MAIN OPERATIONS");
        }

        // Under the construction..
    }
}
