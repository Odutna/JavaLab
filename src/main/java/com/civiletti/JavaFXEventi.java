package com.civiletti;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class JavaFXEventi extends Application implements EventHandler<ActionEvent> {

    private TextField campoTesto;
    private Label etichetta;
    private Button bottone;

    public void start(Stage primaryStage) {

        campoTesto = new TextField();
        campoTesto.setText("Digita un numero");
        campoTesto.setFont(new Font(20));
        etichetta = new Label();
        etichetta.setFont(new Font(25));
        bottone = new Button();
        bottone.setFont(new Font(20));
        bottone.setText("Click per aggiungere 1");
        bottone.setOnAction(this);

// Layout verticale

        VBox root = new VBox();

        root.getChildren().add(campoTesto);
        root.getChildren().add(bottone);
        root.getChildren().add(etichetta);

        Scene scene = new Scene(root, 350, 200);

        primaryStage.setTitle("JavaFX Gestione Eventi Demo");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

    public void handle(ActionEvent event) {

        int val = Integer.parseInt(campoTesto.getText());
        val++;
        //campoTesto.setText(Integer.toString(val));  // <-- Aggiorna anche il TextField
        etichetta.setText("" + val);        // <-- Mostra il valore anche nella Label
    }
}
