/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paralela;

import javax.swing.JLabel;

/**
 *
 * @author warren
 */
public class ht extends Thread {

    JLabel l;
    boolean a;
    Semaforo mutex, ta, tb, pa, pb;
    ayuda sos;

    public ht(JLabel l, boolean a, Semaforo mutex, Semaforo ta, Semaforo tb, Semaforo pa, Semaforo pb, ayuda sos) {
        this.l = l;
        this.a = a;
        this.mutex = mutex;
        this.ta = ta;
        this.tb = tb;
        this.pa = pa;
        this.pb = pb;
        this.sos = sos;
    }

    @Override
    public void run() {
        node n = new node(l);
        try {
            if (a) {
                mutex.P();
                sos.masa();
                mutex.V();
                n.premov();
                ta.P();
                n.movimientoa();
                pa.V();
                n.posmob();
            } else {
                mutex.P();
                sos.masb();
                mutex.V();
                n.premov();
                tb.P();
                n.movimientob();
                n.posmob();
                pb.V();
            }
        } catch (InterruptedException ex) {
        }

    }

}
