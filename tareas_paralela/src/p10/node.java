/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p10;

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

    public node(JLabel l) {
        this.l = l;
        this.x = l.getX();
        this.y = l.getY();
    }
    public void premov(){
        mover(new Point(x,y),new Point(x,y+150));        
    }
    public void movimientoa(){
        mover(new Point(x,y),new Point(x,y-50));
    }
    public void movimientob(){
        mover(new Point(x,y),new Point(x+50,y-50));
        mover(new Point(x,y),new Point(x+200,y));
        mover(new Point(x,y),new Point(x+50,y-50));
    }
    public void movimientoc(){
        mover(new Point(x,y),new Point(x,y-50));
    }
    public void movimientoaa(){
        mover(new Point(x,y),new Point(x,y-50));
    }
    public void movimientobb(){
        mover(new Point(x,y),new Point(x-50,y-50));
        mover(new Point(x,y),new Point(x-200,y));
        mover(new Point(x,y),new Point(x-50,y-50));
    }
    public void movimientocc(){
        mover(new Point(x,y),new Point(x,y-50));
    }
    public void posmob (){
        mover(new Point(x, y),new Point(x, y+50));    
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
