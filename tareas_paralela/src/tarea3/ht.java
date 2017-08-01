/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea3;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Circle;

/**
 *
 * @author warren
 */
public class ht extends Thread{
    private GraphicsContext g;
    private double x,y,ancho,alto,limitex,limitey;
    private Circle c;

    public ht(GraphicsContext g, double x, double y, double ancho, double alto, double limitex, double limitey, Circle c) {
        this.g = g;
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        this.limitex = limitex;
        this.limitey = limitey;
        this.c = c;
    }
    
  
   
    
    @Override
    public void run() {
        while (true){
            x=x+1;
            y=y+1;
            this.c.setTranslateX(x);
            this.c.setTranslateY(y);
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(ht.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
}
