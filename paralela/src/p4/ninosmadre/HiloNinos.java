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

public class HiloNinos extends Thread {

    Semaphore mutex, esperar, dormir;
    int num;
    Contador nroRaciones;

    public HiloNinos(Semaphore pmutex, Contador raciones,
            Semaphore pesperar, Semaphore pdormir) {
        mutex = pmutex;
        nroRaciones = raciones;
        esperar = pesperar;
        dormir = pdormir;
    }

    public void run() {
        while (true) {
            try {
//--niños jugando
                Thread.sleep(100);
//--niño tiene hambre
                mutex.acquire();
                while (nroRaciones.getNumero() <= 0) //--no hay raciones
                {
                    mutex.release();
                    System.out.println("NIÑO ESPERANDO POR RACIONES");
                    esperar.acquire();
                    System.out.println("NIÑO DESPIERTA LUEGO DE ESPERAR");
                    mutex.acquire();
                }
//--si hay raciones
                System.out.println("niño comió una ración");
                num = nroRaciones.getNumero();
                num--;

nroRaciones.setNumero(num);
                System.out.println("Nro Raciones: " + nroRaciones.getNumero());
                mutex.release();
//--niño se va a dormir
                System.out.println("NIÑO SE VA A DORMIR");
                dormir.acquire();
            } catch (InterruptedException e) {
            }
        }
    }
}
