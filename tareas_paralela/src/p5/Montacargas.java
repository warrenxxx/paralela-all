/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p5;

/**
 *
 * @author warren
 */
public class Montacargas extends Thread {

    CMontacargas a_montacargas;

    public Montacargas(CMontacargas p_montacargas) {
        a_montacargas = p_montacargas;
    }

    public void run() {
        try {
            while (true) {
                if ((a_montacargas.numVP() == 2) && (a_montacargas.numVG() == 1)
                        || (a_montacargas.numVP() == 4) && (a_montacargas.numVG() == 0)) {
                    System.out.println("EL MONTACARGAS ESTA LLENO. SE TRASLADA LOSVEHICULOS");  
                    sleep(0);
                    a_montacargas.inicia();
                }
            }
        } catch (InterruptedException e) {
        }
    }
}
