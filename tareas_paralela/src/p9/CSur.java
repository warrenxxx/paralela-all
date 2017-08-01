/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p9;

import javax.swing.JLabel;


/**
 *
 * @author warren
 */
public class CSur extends Thread {

    puente puente;
     JLabel l;
   
    public CSur(puente puente,JLabel l) {
        this.puente = puente;
        this.l=l;
    }


    public void run() {
        try {
            node n=new node(l);
            n.movimientoaa();
            puente.entrarSur();//--tratar de pasar el puente
            System.out.println("ENTROs " + this);
            n.movimientobb();
            sleep(200);
            puente.salirSur();
            n.movimientocc();
            System.out.println("SALIOs " + this);
        } catch (InterruptedException e) {
        }
    }

    @Override
    public String toString() {
        return l.getText();
    }    
}
