package com.civiletti.javafxdemo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage primaryStage) {

        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();

        var label = new Label("Versione JavaFX " + javafxVersion + ", eseguito su Java " + javaVersion + ".");
        
        //var scene = new Scene(new StackPane(label), 640, 480);
        
        try {
            Parent root = FXMLLoader.load(getClass().getResource("FXML.fxml"));
//            Parent root = FXMLLoader.load(getClass().getResource("/org/javafx/demo/FXML.fxml"));
                
            Scene scena = new Scene(root);

            primaryStage.setTitle("JavaFX Demo 04");
            primaryStage.setScene(scena);
            primaryStage.show();
            
        } catch (IOException e) {
            System.out.println("Errore durante il caricamento del file FXML: " + e.getMessage());
            e.printStackTrace();
        } 
    }

    public static void main(String[] args) {
        launch();
    }

}