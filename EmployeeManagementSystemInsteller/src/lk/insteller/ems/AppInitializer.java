package lk.insteller.ems;

import lk.insteller.ems.db.DBConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.net.URL;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)  {
        try {

            // Let's setup the root logger
            Logger rootLogger = Logger.getLogger("");
            FileHandler fileHandler = new FileHandler("error.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            fileHandler.setLevel(Level.INFO);
            rootLogger.addHandler(fileHandler);

            DBConnection.getInstance().getConnection();
            //Parent root = FXMLLoader.load(this.getClass().getResource("lk.insteller.ems.view.LoginForm.fxml"));
            URL resource = this.getClass().getResource("/lk/insteller/ems/view/MainForm.fxml");
            Parent root = FXMLLoader.load(resource);
            Scene mainScene = new Scene(root);
            primaryStage.setScene(mainScene);
            primaryStage.setTitle("EMPLOYEE MANAGEMENT SYSTEM - 2021");
            primaryStage.centerOnScreen();
            primaryStage.setResizable(false);
            primaryStage.show();

        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR,"Something went wrong, please contact Dilini Wellage").show();
            Logger.getLogger("lk.insteller.ems").log(Level.SEVERE, null,e);
        }
    }
}
