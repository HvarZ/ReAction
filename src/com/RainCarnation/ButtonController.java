package com.RainCarnation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class ButtonController {
    @FXML
    private Button button;

    @FXML
    private void click(ActionEvent action) {
        button.setText("Clicked");
    }
}
