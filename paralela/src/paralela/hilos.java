    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paralela;

import static java.lang.Math.random;
import static java.lang.Math.sqrt;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author Warren
 */
public class hilos  extends Thread{
    private double x,y,fx,fy;
    private JLabel l;
    private double lx,ly; 
    private int mov=15;
    private double ax,ay;
    public hilos(double x, double y, double fx, double fy, JLabel l, double lx, double ly,double vx,double  vy) {
        this.x = x;
        this.y = y;
        this.fx = fx;
        this.fy = fy;
        this.l = l;
        this.lx = lx;
        this.ly = ly;
        ax=vx/(sqrt(vx*vx+vy*vy));
        ay=vy/(sqrt(vx*vx+vy*vy));        
        this.mov=(int) (random()*50)+1;
    }

    @Override
    public void run() {
        while(true){
            if(x<=0||x>=fx-lx)ax=ax*-1;
            if(y<=0||y>=fy-ly)ay=ay*-1;
            x=x+ax;
            y=y+ay;
            l.setLocation((int)x,(int)y);
            
            try {
                Thread.sleep(mov);
            } catch (InterruptedException ex) {
                Logger.getLogger(hilos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
}
