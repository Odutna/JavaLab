package com.civiletti;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;

public class RectangleCircle extends Application{

    @Override
    public void start(Stage primaryStage) {
        Rectangle r1 = new Rectangle(200, 50);
        r1.setFill(Color.RED);
        r1.setStroke(Color.web("0x00FF00"));
        r1.setStrokeWidth(10);

        Circle c1 = new Circle(50);
        c1.setFill(Color.rgb(0, 0, 255));
        c1.setCenterX(50);
        c1.setCenterY(100);

        Group g = new Group();

        g.getChildren().add(r1);
        g.getChildren().add(c1);

        Scene scene = new Scene(g, 600, 300);
        primaryStage.setTitle("Rettamgolo e Cerchio");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
