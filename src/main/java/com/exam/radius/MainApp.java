package com.exam.radius;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/calculator.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root, 720, 480);
        scene.getStylesheets().add(getClass().getResource("/styles/calculator.css").toExternalForm());

        primaryStage.setTitle("Radius Calculator of any given Circle");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
