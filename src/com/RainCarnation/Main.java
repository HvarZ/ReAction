package com.RainCarnation;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.Parent;

import java.util.Objects;


public class Main extends Application {

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Main.fxml")));
        root.setLayoutX(230);
        root.setLayoutY(270);
        Scene scene = new Scene(root);
        scene.setFill(Color.BLACK);

        stage.setScene(scene);
        stage.setTitle("ReActionApp");
        stage.setWidth(460);
        stage.setHeight(540);

        stage.show();
    }
}