package com.civiletti;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class JavaFXCiaoMondo extends Application {

    public void start(Stage stagePrimario) {

        Label etichetta1 = new Label();
        Label etichetta2 = new Label();

        etichetta1.setText("Ciao");
        etichetta2.setText(" Mondo");

        HBox root = new HBox();

        root.getChildren().add(etichetta1);
        root.getChildren().add(etichetta2);

        Scene scene = new Scene(root, 300, 50);

        stagePrimario.setTitle("Esempio JavaFX");
        stagePrimario.setScene(scene);
        stagePrimario.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
