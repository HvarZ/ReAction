package com.RainCarnation;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.scene.control.Button;


public class Main extends Application {

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Button button = new Button();
        button.setText("Click");
        button.setMinSize(180, 90);
        button.setLayoutX(160 - button.getMinWidth() / 2);
        button.setLayoutY(280 - button.getMinHeight() / 2);


        button.setOnAction(e ->
                button.setText("Clicked"));

        Group group = new Group(button);
        Scene scene = new Scene(group);

        scene.setFill(Color.BLACK);

        stage.setScene(scene);
        stage.setWidth(320);
        stage.setHeight(560);
        stage.setTitle("ReActionApp");

        stage.show();
    }
}