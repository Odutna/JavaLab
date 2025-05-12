package com.civiletti;

import javafx.application.Application;
import javafx.scene.Scene;

import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;


public class ShapeMoverApp extends Application {

    private Circle circle;
    private Pane drawingArea;

    @Override
    public void start(Stage primaryStage) {
        // 1. Area di disegno principale
        drawingArea = new Pane();
        drawingArea.setPrefSize(500, 300);
        drawingArea.setStyle("-fx-background-color: white; -fx-border-color: black;");

        // 2. Creazione degli oggetti grafici
        Rectangle rectangle = new Rectangle(300, 50, Color.LIGHTGRAY);
        rectangle.setX(100);  // Posizione X
        rectangle.setY(50);   // Posizione Y

        circle = new Circle(25, Color.BLUE);
        circle.setCenterX(250);
        circle.setCenterY(150);

        drawingArea.getChildren().addAll(rectangle, circle);

        // 3. Creazione dei pulsanti (molto grandi per essere visibili)
        Button btnLeft = new Button("SINISTRA");
        Button btnRight = new Button("DESTRA");
        Button btnUp = new Button("SU");
        Button btnDown = new Button("GIÙ");

        // Dimensioni minime per i pulsanti
        btnLeft.setMinSize(100, 50);
        btnRight.setMinSize(100, 50);
        btnUp.setMinSize(100, 50);
        btnDown.setMinSize(100, 50);

        // 4. Azioni dei pulsanti
        btnLeft.setOnAction(e -> circle.setCenterX(circle.getCenterX() - 10));
        btnRight.setOnAction(e -> circle.setCenterX(circle.getCenterX() + 10));
        btnUp.setOnAction(e -> circle.setCenterY(circle.getCenterY() - 10));
        btnDown.setOnAction(e -> circle.setCenterY(circle.getCenterY() + 10));

        // 5. Layout dei pulsanti (orizzontale)
        HBox buttonsBox = new HBox(10, btnLeft, btnRight, btnUp, btnDown);
        buttonsBox.setAlignment(Pos.CENTER);
        buttonsBox.setPadding(new Insets(15));
        buttonsBox.setStyle("-fx-background-color: lightgray;");

        // 6. Layout principale (verticale)
        VBox mainLayout = new VBox(drawingArea, buttonsBox);
        mainLayout.setSpacing(10);
        mainLayout.setPadding(new Insets(10));

        // 7. Creazione della scena
        Scene scene = new Scene(mainLayout, 520, 420);  // Dimensioni leggermente maggiori

        // 8. Configurazione della finestra
        primaryStage.setTitle("Shape Mover - Versione Semplice");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}