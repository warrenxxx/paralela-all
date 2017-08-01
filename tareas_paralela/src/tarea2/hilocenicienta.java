/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea2;

import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author warren
 */
public class hilocenicienta extends Thread {

    private final JLabel l;
    private Dimension pos;
    private Semaforo silla,quierocomer,seervircomida,terminecomida;

    public hilocenicienta(JLabel l, Dimension pos, Semaforo silla, Semaforo quierocomer, Semaforo seervircomida, Semaforo terminecomida) {
        this.l = l;
        this.pos = pos;
        this.silla = silla;
        this.quierocomer = quierocomer;
        this.seervircomida = seervircomida;
        this.terminecomida = terminecomida;
    }

    
    

    @Override
    public void run() {
        while (true) {
            try {
                quierocomer.P();
                servir_comida();
                seervircomida.V();
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
    }

    private void recoger_plato() {

    }

    private void vuelta_sensual() {

    }


}
