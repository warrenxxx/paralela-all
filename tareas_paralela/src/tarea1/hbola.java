/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea1;

import static java.lang.Math.sqrt;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author warren
 */
public class hbola extends Thread{
    private final JLabel l;
    private final int lx,ly,vel;
    private final int labelx,labely;
    private  double vx,vy,px,py;
    public boolean enFuncionamiento;
    public hbola(JLabel l, int lx, int ly, double vx, double vy,int vel) {
        this.vel=vel;
        this.l = l;
        this.lx = lx;
        this.ly = ly;
        this.vx =  vx/sqrt(vx*vx+vy*vy);
        this.vy = vy/sqrt(vx*vx+vy*vy);
        this.px = l.getX();
        this.py = l.getY();
        this.labelx=this.l.getWidth();
        this.labely=this.l.getHeight();
        enFuncionamiento=true;
    }
       
    @Override
    public void run() {
        final int NS_POR_SEGUNDO=1000000000;
        final int aps_objetivo=vel;
        final double NS_POR_ACTUALIZACION=NS_POR_SEGUNDO/aps_objetivo;
        long referenciaActulizaion=System.nanoTime();
        long referenciaContador=System.nanoTime();
        double tiempoTranscurrido;
        double delta=0;
        
        while(true){
          


            final long inicioBucle=System.nanoTime();
            tiempoTranscurrido=inicioBucle-referenciaActulizaion;
            referenciaActulizaion=inicioBucle;
            delta+=tiempoTranscurrido/NS_POR_ACTUALIZACION;
            
            while(delta>=1){
                if(px<=0||px>=lx-l.getWidth()) vx=vx*-1;
                if(py<=0||py>=ly-l.getHeight())vy=vy*-1;
                px=px+vx;
                py=py+vy;
                delta--;                
            }
            System.out.println("warren");
            l.setLocation((int)px,(int)py);
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(hbola.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
