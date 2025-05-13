/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package com.civiletti.javafxdemo03;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author S.Civiletti
 */
public class App extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
       
        try{
            Parent root = FXMLLoader.load(getClass().getResource("FXML_demo03.fxml"));

            Scene scena = new Scene(root);

            scena.getStylesheets().add(getClass().getResource("app.css").toExternalForm()); //

            primaryStage.setTitle("JavaFX Demo 03");
            primaryStage.setScene(scena);
            primaryStage.show();
        } catch(Exception e){
            System.out.println("Errore durante l'apertura del file: " + e);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
