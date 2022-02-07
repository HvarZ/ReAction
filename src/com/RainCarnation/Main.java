package com.RainCarnation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.Parent;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage stage) {
        try  {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Main.fxml")));

            Scene scene = new Scene(root);

            scene.setFill(Color.BLACK);

            stage.setScene(scene);
            stage.setWidth(320);
            stage.setHeight(560);
            stage.setTitle("ReActionApp");

            stage.show();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}