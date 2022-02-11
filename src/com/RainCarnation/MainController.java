package com.RainCarnation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MainController {
    @FXML
    private Label averageResult;

    @FXML
    private Label bestResult;

    @FXML
    private Button mainButton;

    private ButtonStatus status = ButtonStatus.Start;
    private ArrayList<Long> times = new ArrayList<>();
    private final Random randomEngine = new Random();
    private long startTime;

    @FXML
    public void click(ActionEvent event) throws Exception {
        if (status == ButtonStatus.Start) {
            mainButton.setText("Wait a green color");
            status = ButtonStatus.Middle;
            mainButton.setStyle("-fx-background-color: #fbff05");
        } else if (status == ButtonStatus.Middle) {
            Thread.sleep(randomEngine.nextInt(2000) + 1000);
            mainButton.setText("Click it fast!!!");
            status = ButtonStatus.DoubleClick;
            mainButton.setStyle("-fx-background-color: #19f749");
            startTime = System.currentTimeMillis();
        } else if (status == ButtonStatus.DoubleClick) {
            long singleResult = System.currentTimeMillis() - startTime;
            mainButton.setText("Your result: " + singleResult + "ms" + " (" + (times.size() + 1) + "/5)");
            status = ButtonStatus.Result;
            times.add(singleResult);
            long sum = 0;
            for (long time : times) {
                sum += time;
            }
            averageResult.setText("Average: " + sum / times.size() + "ms");
            bestResult.setText("Best: " + Collections.min(times) + "ms");
            if (times.size() == 5) {
                times.clear();
            }
        } else {
            if (times.size() == 0) {
                averageResult.setText("Average: ~");
                bestResult.setText("Best: ~");
            }
            mainButton.setText("Click to start...");
            status = ButtonStatus.Start;
            mainButton.setStyle("-fx-background-color: silver");
        }
    }
}

// problems with multiclick and second stage