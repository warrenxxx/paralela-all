/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p4.appbicicletas;

import java.util.concurrent.Semaphore;

public class COperario3 extends Thread { //--fabrica marcos para bicicletas

    Semaphore hayEspMani;
    Semaphore hayManillar;

    public COperario3(Semaphore p_hayEspMani, Semaphore p_hayManillar) {
        hayEspMani = p_hayEspMani;
        hayManillar = p_hayManillar;
    }

    public void run() {
        while (true) {
            try {
                hayEspMani.acquire();
//---fabricar manillar
                sleep(400);
                System.out.println("Se fabricó un manillar");
                hayManillar.release();
            } catch (InterruptedException e) {
            }
        }
    }
}
