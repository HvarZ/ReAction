package com.RainCarnation;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.util.Duration;

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
    private ButtonStatus time = ButtonStatus.Yellow;
    private final ArrayList<Long> times = new ArrayList<>();
    private final Random randomEngine = new Random();
    private long startTime;
    private final Timeline banDuration = new Timeline(new KeyFrame(
            Duration.millis(randomEngine.nextInt(2000) + 1000),
            new EventHandler<>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    mainButton.setText("Click it fast!!!");
                    mainButton.setStyle("-fx-background-color: #19f749");
                    startTime = System.currentTimeMillis();
                    time = ButtonStatus.Green;
                }
            }));

    @FXML
    public void click(ActionEvent event) throws Exception {
        switch (status) {
            case Start -> {
                mainButton.setText("Wait a green color");
                mainButton.setStyle("-fx-background-color: #fbff05");
                status = ButtonStatus.Yellow;
                time = ButtonStatus.Yellow;
                banDuration.setCycleCount(Timeline.INDEFINITE);
                banDuration.playFromStart();
            }

            case Yellow -> {
                if (time == ButtonStatus.Yellow) {
                    banDuration.stop();
                    status = ButtonStatus.Start;
                    mainButton.setText("Too early... Try again!");
                    mainButton.setStyle("-fx-background-color: #ff4a12");
                } else {
                    long singleResult = System.currentTimeMillis() - startTime;
                    banDuration.stop();
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
                }
            }

            case Result -> {
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
}