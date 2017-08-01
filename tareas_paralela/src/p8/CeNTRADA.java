/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p8;

import java.awt.Label;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import static p8.Appconsumidor.p;


/**
 *
 * @author warren
 */
public class CeNTRADA extends Thread {

    buffer buf;
    String dato;
    JLabel l;
    
    public CeNTRADA(buffer buf,String dato) {
        this.buf=buf;
        this.dato=dato;
        this.l= new JLabel(new ImageIcon(getClass().getResource("gg.png")));
        l.setBounds(0,100,50,50);
        l.setVisible(true);
        p.add(l);
    }

    public void run() {
        node n=new  node(l);
        dato d=new dato();
        d.setL(l);
        try {
            n.movimientoa();
            buf.insertar(d); //--tratar de pasar el puente
            n.movimientob(d.getPos());
            d.setB(true);
            sleep(200);
        } catch (InterruptedException e) {
        }
    }

    @Override
    public String toString() {
        return dato;
    }
    
}
