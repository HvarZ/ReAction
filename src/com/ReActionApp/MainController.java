package com.ReActionApp;

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
import java.util.List;
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
    private final List<Long> times = new ArrayList<>();
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
            case Start -> start();
            case Yellow -> yellow();
            case Result -> result();
        }
    }

    private void start() {
        mainButton.setText("Wait a green color");
        mainButton.setStyle("-fx-background-color: #fbff05");

        status = ButtonStatus.Yellow;
        time = ButtonStatus.Yellow;

        banDuration.setCycleCount(Timeline.INDEFINITE);
        banDuration.playFromStart();
    }

    private void yellow() {
        banDuration.stop();
        if (time == ButtonStatus.Yellow) {
            status = ButtonStatus.Start;
            mainButton.setText("Too early... Try again!");
            mainButton.setStyle("-fx-background-color: #ff4a12");
        } else {
            long singleResult = System.currentTimeMillis() - startTime;
            mainButton.setText("Your result: " + singleResult + "ms" + " (" + (times.size() + 1) + "/5)");
            status = ButtonStatus.Result;
            times.add(singleResult);
            averageResult.setText("Average: " + average(times) + "ms");
            bestResult.setText("Best: " + Collections.min(times) + "ms");
            if (times.size() == 5) {
                times.clear();
            }
        }
    }

    private void result() {
        if (times.size() == 0) {
            averageResult.setText("Average: ~");
            bestResult.setText("Best: ~");
        }
        mainButton.setText("Click to start...");
        status = ButtonStatus.Start;
        mainButton.setStyle("-fx-background-color: silver");
    }

    private static long average(List<Long> results) {
        return results.stream().reduce(Long::sum).get() / results.size();
    }
}