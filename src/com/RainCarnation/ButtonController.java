package com.RainCarnation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class ButtonController {
    @FXML
    private Button button;
    private int counter = 0;
    
    @FXML
    private void click(ActionEvent action) {
        button.setText(Integer.toString(counter));
        counter++;
    }
}
