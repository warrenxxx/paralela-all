/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p4.appbicicletas;

import java.util.concurrent.Semaphore;

public class COperario2 extends Thread { //--fabrica marcos para bicicletas

    Semaphore hayEspMar;
    Semaphore hayMarco;

    public COperario2(Semaphore p_hayEspMar, Semaphore p_hayMarco) {
        hayEspMar = p_hayEspMar;
        hayMarco = p_hayMarco;
    }

    public void run() {
        while (true) {
            try {
                hayEspMar.acquire();

                sleep(500);
                System.out.println("Se fabricó un marco...");
                hayMarco.release();
            } catch (InterruptedException e) {
            }
        }
    }
}
