package com.RainCarnation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;


public class MainController {
    @FXML
    private Label averageResult;

    @FXML
    private Label bestResult;

    @FXML
    private Button mainButton;

    private ButtonStatus status = ButtonStatus.Start;

    @FXML
    void click(ActionEvent event) {
        if (status == ButtonStatus.Start) {
            mainButton.setText("Good job");
            status = ButtonStatus.Middle;
        } else if (status == ButtonStatus.Middle) {
            mainButton.setText("Very good job");
            status = ButtonStatus.Finish;
        } else {
            mainButton.setText("Click to start...");
            status = ButtonStatus.Start;
        }
    }
}
