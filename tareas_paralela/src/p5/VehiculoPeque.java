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
public class VehiculoPeque extends Thread {
CMontacargas a_montacargas;

    public VehiculoPeque(CMontacargas p_montacargas) {
        a_montacargas = p_montacargas;
    }

    public void run() {
        try {
            sleep(30);
            System.out.println("NUM.VEHICULOS:" + a_montacargas.numVP() + " " + a_montacargas.numVG());
            a_montacargas.entraVp();
            System.out.println("ENTRO VEHICULO PEQUEÑO No. P:" + a_montacargas.numVP() + " No. G:" + a_montacargas.numVG());
        } catch (InterruptedException e) {
        }
    }
}
