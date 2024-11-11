package org.example.assignment1_20104720;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TheatreApplication extends Application {
    public static DisplayShowList showList = new DisplayShowList();

    public static DisplayCustomerList customerList = new DisplayCustomerList();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try{
            Parent root = FXMLLoader.load(getClass().getResource("mainpage.fxml"));
            primaryStage.setTitle("Theatre Booking System");
            Scene scene1 = new Scene(root);
            primaryStage.setScene(scene1);
            primaryStage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
