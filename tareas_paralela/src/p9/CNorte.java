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
public class CNorte extends Thread {

    puente puente;
    JLabel l;
    public CNorte(puente puente,JLabel l) {
        this.l=l;
        this.puente = puente;
    }


    public void run() {
        node n=new node(l);
        try {
            n.movimientoa();
            puente.entrarNorte(); //--tratar de pasar el puente
            System.out.println("ENTROn " + this);
            n.movimientob();

            sleep(200);
            puente.salirNorte();
            n.movimientoc();
            System.out.println("SALIOn " + this);
        } catch (InterruptedException e) {
        }
    }

    @Override
    public String toString() {
        return l.getText();
    }
    
}
