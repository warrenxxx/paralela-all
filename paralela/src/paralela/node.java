/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paralela;

import static java.lang.Math.sqrt;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
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
        mover(new Point(x,y),new Point(x,y+150));
        mover(new Point(x, y),new Point(x+400, y));
        mover(new Point(x, y),new Point(x, y+100));
    }
    public void movimientob(){
        mover(new Point(x,y),new Point(x,y+150));
        mover(new Point(x, y),new Point(x-400, y));
    }
    public void posmob (){
        mover(new Point(x, y),new Point(x, y+100));    
    }
    private void mover(Point a,Point b){
        double vx=b.x-a.x;
        double vy=b.y-a.y;
        double ux=vx/(sqrt(vx*vx+vy*vy));
        double uy=vy/(sqrt(vx*vx+vy*vy));
        
        System.out.println("");
        while(true){
            if((int)x==b.x&&(int)y==b.y)break;
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
    
}
