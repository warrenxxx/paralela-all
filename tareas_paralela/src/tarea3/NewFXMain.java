/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author warren
 */
public class NewFXMain extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        Canvas c=new Canvas(500, 500);
        StackPane root = new StackPane();
       
        root.setOnMousePressed(e->{
            Circle cir=new Circle(40,10,10);
            root.getChildren().add(cir);
            ht t=new ht(c.getGraphicsContext2D(), 10, 10,40, 40, 500,500, cir);
            t.start();
        });
        root.getChildren().addAll(c);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
