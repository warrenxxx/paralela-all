/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p6.animacion;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author warren
 */
public class ht extends Thread {

    JLabel l;
    boolean a;

    public ht(JLabel l, boolean a) {
        this.l = l;
        this.a = a;
    }
    
    public void autPermiso(){
        this.a=true;
    }
    @Override
    public void run() {
        node n = new node(l);
        while(!a){
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(ht.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        l.setVisible(true);
        n.movimientoa();         
        l.setVisible(false);
    }

}
