package com.civiletti;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;
import javafx.animation.FillTransition;
import javafx.animation.Timeline;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;

public class JavaFXCerchioAnimato extends Application {

    public void start(Stage stage) {

        Circle cerchio = new Circle(250, 50, 50);
//        Circle cerchio = new Circle(50, 150, 50);
        cerchio.setFill(Color.GREEN);
        AnchorPane root = new AnchorPane();
        root.getChildren().add(cerchio);
        FillTransition coloreDiRiempimento = new
                FillTransition(Duration.millis(1500));

        coloreDiRiempimento.setToValue(Color.BLUE);  // Passa al Blu
        TranslateTransition traslazione = new
                TranslateTransition(Duration.millis(1500));

//        traslazione.setToX(400);  // Si sposta a y=200
        traslazione.setToY(200);  // Si sposta a y=200

        // Effettua le transizioni di riempimento e traslazione in parallelo
        ParallelTransition transizione = new
                ParallelTransition(cerchio, coloreDiRiempimento, traslazione);
        transizione.setCycleCount(Timeline.INDEFINITE);
        transizione.setAutoReverse(true);
        transizione.play();

        Scene scene = new Scene(root, 500, 300, Color.BLACK);

        stage.setTitle("JavaFX Cerchio Animato");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
