/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea2;

import java.awt.Point;
import static java.lang.Math.random;
import static java.lang.Math.sqrt;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author warren
 */
public class hilocenicienta2 extends Thread {

    private final JLabel l;
    private final JPanel jf;
    private final Point pos_mesa = new Point(750, 300);
    private final Point pos_espera = new Point(850, 350);
    private final Point pos_platos = new Point(950, 360);
    private final Point pos;
    private Semaforo silla, quierocomer, seervircomida, terminecomida, mutex;
    private mesa mesa;
    JLabel platos[];
    private int nplato;
    private buelta b;
    public hilocenicienta2(JLabel l, Point pos, Semaforo silla, Semaforo quierocomer, Semaforo seervircomida, Semaforo terminecomida, JPanel jf, Semaforo mutex, mesa mesa, JLabel[] platos,buelta b) {
        this.b=b;
        this.platos = platos;
        this.mesa = mesa;
        this.mutex = mutex;
        this.jf = jf;
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
        for (int i = 0; i < 4; i++) {
            platos[i].setLocation(mesa.get_posPlato(i));
        }

        while (true) {
            try {

                mutex.P();
                if(b.p>=4){
                    vuelta_sensual();
                }
                mutex.V();
                quierocomer.P();
                
                servir_comida();
                seervircomida.V();
                //esperar();
                terminecomida.P();
                recoger_plato();

            } catch (InterruptedException ex) {
                System.out.println("error");
                Logger.getLogger(hilocenicienta.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("fin erro");
            }

        }
    }

    private void servir_comida() {
        try {
            mutex.P();
                nplato = mesa.buscar_plato();
                moverPosicion(l.getLocation(), mesa.get_possilla(nplato));
//                platos[nplato].setVisible(true);
                mesa.poner_plato(nplato);
            mutex.V();
        } catch (InterruptedException ex) {
            Logger.getLogger(hilocenicienta2.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void esperar() {
        moverPosicion(l.getLocation(), pos_espera);

    }

    private void recoger_plato() {
        try {
            mutex.P();
              //              mesa.sacar_plato(nplato);
                nplato = mesa.buscar_plato();
                moverPosicion(l.getLocation(), mesa.get_possilla(nplato));
//                platos[nplato].setVisible(false);

            mutex.V();
            moverPosicion(l.getLocation(), pos_platos);
        } catch (InterruptedException ex) {
            Logger.getLogger(hilocenicienta2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void vuelta_sensual() {
            moverPosicion(l.getLocation(), new Point(50,50));

    }

    public void moverPosicion(Point a, Point b) {
        double vx = b.x - a.x;
        double vy = b.y - a.y;
        double ax = vx / sqrt(vx * vx + vy * vy);
        double ay = vy / sqrt(vx * vx + vy * vy);

        double x = a.x;
        double y = a.y;
        for (int i = 0; i < vx / ax; i++) {
            x = x + ax;
            y = y + ay;
            try {
                Thread.sleep(2);
            } catch (InterruptedException ex) {
                Logger.getLogger(hilocenicienta2.class.getName()).log(Level.SEVERE, null, ex);
            }
            l.setLocation((int) x, (int) y);
        }
    }
}
