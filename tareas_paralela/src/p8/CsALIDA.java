/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p8;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


/**
 *
 * @author warren
 */
public class CsALIDA extends Thread {

    buffer buf;
    dato dato;    
    
     public CsALIDA(buffer buf) {
        this.buf=buf;        
    }

    public void run() {

        try {
            dato=buf.sacar(); //--tratar de pasar el puente
            System.out.println("salio " + this);
            node n=new node(dato.getL());
            n.movimientoc();
            dato.getL().setVisible(false);
            sleep(200);
        } catch (InterruptedException e) {
        }
    }

    @Override
    public String toString() {
        return dato.toString();
    }
    
}
