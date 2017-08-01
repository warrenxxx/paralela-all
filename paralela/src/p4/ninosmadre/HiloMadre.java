/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p4.ninosmadre;

/**
 *
 * @author warren
 */

import java.util.concurrent.Semaphore;



public class HiloMadre extends Thread {

    Semaphore mutex, espera, dormir;
    Contador nroRaciones;

    public HiloMadre(Semaphore pmutex, Contador raciones,
            Semaphore pespera, Semaphore pdormir) {
        mutex = pmutex;
        nroRaciones = raciones;
        espera = pespera;
        dormir = pdormir;
    }

    public void run() {
        while (true) {
            System.out.println("MADRE VERIFICANDO SI HAY RACIONES");
            try {
                Thread.sleep(150);
                mutex.acquire();
                while (nroRaciones.getNumero() <= 0) {
                    System.out.println("REPONIENDO RACIONES");
                    nroRaciones.setNumero(4);
                    espera.release();
                }
                mutex.release();
//--depierta si hay niños durmiendo
                dormir.release();
            } catch (InterruptedException e) {
            }
        }
    }
}
