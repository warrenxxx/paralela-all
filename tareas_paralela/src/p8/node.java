/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p8;

import static java.lang.Math.cos;
import static java.lang.Math.sin;
import p6.animacion.*;
import static java.lang.Math.sqrt;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author warren
 */
public class node {
    private JLabel l;
    double x;
    double y;

    private double cx=300,cy=200;
    public node(JLabel l) {
        this.l = l;
        this.x = l.getX();
        this.y = l.getY();
    }
    public void premov(){
        mover(new Point(x,y),new Point(x,y+150));        
    }
    public void movimientoa(){
        mover(new Point(x,y),new Point(x+150,y+150));
    }
    public void movimientob(int n){ 
        double xx=cx+70*cos((n*3.14/4));
        double yy=cx-70*sin((n*3.14/4));
//        mover(new Point(x,y),new Point(x+100,n*50+150));
        mover(new Point(x,y),new Point(xx,yy));
    }
    public void movimientoc(){
        mover(new Point(x,y),new Point(x+100,150));
    }
    public void posmob (){
        mover(new Point(x, y),new Point(x, y+100));    
    }
    private void mover(Point a,Point b){
        double vx=b.x-a.x;
        double vy=b.y-a.y;
        double ux=vx/(sqrt(vx*vx+vy*vy));
        double uy=vy/(sqrt(vx*vx+vy*vy));
        
        while(true){
            if((int)x==b.x&&(int)y==b.y)break;
            if(distancia(new Point(x, y), b)<=2)break;
            x+=ux;
            y+=uy;
            l.setLocation((int)x, (int)y);
            try {
                Thread.sleep(7);
            } catch (InterruptedException ex) {
                Logger.getLogger(node.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public double distancia(Point a,Point b){
        double x=a.x-b.x;
        double y=a.y-b.y;
        return sqrt(x*x+y*y);
    }
    
}
