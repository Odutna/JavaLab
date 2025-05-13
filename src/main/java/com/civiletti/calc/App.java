package com.civiletti.calc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author S. Civiletti
 */
public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        try {
//            Parent root = FXMLLoader.load(getClass().getResource("FXML_calc.fxml"));
            Parent root = FXMLLoader.load(getClass().getResource("/com/civiletti/calc/FXML_calc.fxml"));

            Scene scena = new Scene(root);
            scena.getStylesheets().add(getClass().getResource("app_calc.css").toExternalForm());

            primaryStage.setTitle("Calcolatrice");
            primaryStage.setScene(scena);
            primaryStage.show();
            
        } catch (Exception e) {
            System.out.println("Errore nell'apertura del file: " + e);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
