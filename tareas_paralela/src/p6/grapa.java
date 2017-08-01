/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p6;
/**
 *
 * @author warren
 */
public class grapa extends Thread {

    CGrapa a_montacargas;

    public grapa(CGrapa p_montacargas) {
        a_montacargas = p_montacargas;
    }

    public void run() {
        try {
            while (true) {
                a_montacargas.Grapar();
                a_montacargas.inicia();
                System.out.println("se engrampo" + a_montacargas.numHojas());
            }
        } catch (InterruptedException e) {
        }
    }
}
