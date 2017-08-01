/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea2;

import java.awt.Dimension;
import java.awt.Point;
import static java.lang.Math.random;
import static java.lang.Math.sqrt;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author warren
 */
public class hiloenano extends Thread {

    private final JLabel l;
    private final JPanel jf;
    private final Point pos_cola=new Point(500,300);   
    private final Point pos_trabajo=new Point(0,300);   
    private final Point pos_mesa=new Point(700,300);
    private final Point pos;
    private Semaforo silla,quierocomer,seervircomida,terminecomida,mutex;
    private mesa mesa;
    private buelta b;
    private int nsilla;
    
    public hiloenano(JLabel l, Point pos, Semaforo silla, Semaforo quierocomer, Semaforo seervircomida, Semaforo terminecomida,JPanel jf,Semaforo mutex,mesa mesa,buelta b) {
        this.b=b;
        this.mutex=mutex;
        this.mesa=mesa;
        this.jf=jf;
        this.l = l;
        this.pos = pos;
        this.silla = silla;
        this.quierocomer = quierocomer;
        this.seervircomida = seervircomida;
        this.terminecomida = terminecomida;
        l.setLocation(pos);
        this.jf.add(l);
        this.jf.revalidate();
    }

       
    @Override
    public void run() {        
        l.setLocation(pos);
        while (true) {
            try {
                System.out.println(b.p);
                ir_cola();
                silla.P();
                ir_mesa();
                quierocomer.V();
                seervircomida.P();
                comer();
                terminecomida.V();
                ir_trabajar();
                //silla.V();
            } catch (InterruptedException ex) {
                System.out.println("error");
                Logger.getLogger(hiloenano.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("fin erro");
            }

        }
    }

    private void ir_trabajar() {
        try {
        mutex.V();
                b.retirarcomida();
        mutex.P();
            moverPosicion(new Point(l.getLocation()), pos_trabajo);                
            Thread.sleep((int)(random()*50000));
        } catch (InterruptedException ex) {
            Logger.getLogger(hiloenano.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void ir_cola() throws InterruptedException {
        mutex.V();
                b.pedircomida();
        mutex.P();
        moverPosicion(new Point(l.getLocation()), pos_cola);
    }

    private void ir_mesa() {
        try {
            mutex.P();
                nsilla=mesa.buscar();
                mesa.entrar(nsilla);
            mutex.V();
             moverPosicion(new Point(l.getLocation()), mesa.get_possilla(nsilla));
        } catch (InterruptedException ex) {
            Logger.getLogger(hiloenano.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void comer() {
        try {

            Thread.sleep((int)(random()*5000));
            mutex.P();
                mesa.salir(nsilla);
                mesa.sacar_plato(nsilla);
            mutex.V();
            silla.V();
        } catch (InterruptedException ex) {
            Logger.getLogger(hiloenano.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void moverPosicion(Point a,Point b){
        double vx=b.x-a.x;
        double vy=b.y-a.y;
        double ax=vx/sqrt(vx*vx+vy*vy);
        double ay=vy/sqrt(vx*vx+vy*vy);
        
                
        
        double x=a.x;
        double y=a.y;
        for(int i=0;i<vx/ax;i++){
            x=x+ax;
            y=y+ay;
            try {
                Thread.sleep(2);
            } catch (InterruptedException ex) {
                Logger.getLogger(hiloenano.class.getName()).log(Level.SEVERE, null, ex);
            }
            l.setLocation((int)x, (int)y);
        }
    }
}
