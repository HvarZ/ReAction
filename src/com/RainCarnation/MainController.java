package com.RainCarnation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class MainController implements Initializable {
    @FXML
    private Label averageResult;

    @FXML
    private Label bestResult;

    @FXML
    private Button mainButton;

    private ButtonStatus status = ButtonStatus.Start;
    private double singleResult;
    private ArrayList<Double> times;

    @FXML
    private ImageView expectationImage;

    @FXML
    void click(ActionEvent event) {
        if (status == ButtonStatus.Start) {
            mainButton.setText("Wait a green color");
            status = ButtonStatus.Middle;
            mainButton.setStyle("-fx-background-color: #fbff05");
        } else if (status == ButtonStatus.Middle) {
            mainButton.setText("Very good job");
            status = ButtonStatus.DoubleClick;
            mainButton.setStyle("-fx-background-color: #19f749");
        } else if (status == ButtonStatus.DoubleClick) {
            mainButton.setText("Your result: " + singleResult);
            status = ButtonStatus.Result;
        } else {
            mainButton.setText("Click to start...");
            status = ButtonStatus.Start;
            mainButton.setStyle("-fx-background-color: silver");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        expectationImage = new ImageView(new Image("com/RainCarnation/assets/img_1.png"));
    }
}
