package com.civiletti;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Arrays;

public class Testo extends Application {

    @Override
    public void start(Stage primaryStage) {

        Text t1 = new Text(50, 50, "Orange");
        t1.setFont(Font.font("Verdana", FontWeight.BOLD, 60));
        t1.setFill(Color.YELLOW);
        t1.setStroke(Color.RED);
        t1.setStrokeWidth(4);

        Text t2 = new Text(100, 100, "Apple");
        t2.setFont(Font.font("Arial", FontPosture.ITALIC, 40));

        Text t3 = new Text(20, 150, "Lemon");
        t3.setFont(Font.font("Courier New", 30));
        t3.setStrikethrough(true);

        Group g = new Group();
        g.getChildren().addAll(Arrays.asList(t1, t2, t3));

        Scene scene = new Scene(g, 600, 300);
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

//    public static void main(String[] args) {}
}
