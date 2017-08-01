/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p9;

/**
 *
 * @author warren
 */
import java.util.concurrent.locks.*;

public class puente {

    final ReentrantLock cerrojo = new ReentrantLock();
    final Condition okSur = cerrojo.newCondition();
    final Condition okNorte = cerrojo.newCondition();
    int n, s;

    public puente() {
        s = 0;
        n = 0;
    }

    public void entrarNorte() throws InterruptedException {
        cerrojo.lock();
        try {
            while ((s > 0) || (awaited(okSur) > 0)){
                    System.out.println("norte esperando..puente ocupado"+s+" "+(awaited(okSur)));
                    okNorte.await(); //el coche espera
            }
            System.out.println("entro un norte");
            n++; //--incrementa el número de coches pasando
            okNorte.signal(); //--despierta si hay otro coche esperando
        //BAJAR PUENTE
        } finally {
            cerrojo.unlock();
        }
    }

    public void salirNorte() throws InterruptedException {
        cerrojo.lock();
        try {
            System.out.println("norte saliendo..puente libre");
            n--;
            if (n == 0) {
                okSur.signal(); 
            }
        } finally {
            cerrojo.unlock();
        }
    }

    public void entrarSur() throws InterruptedException {
        cerrojo.lock();
        try {
            while ((n > 0)||awaited(okNorte)>0)            {
                System.out.println("sur esperando..puente ocupado"+n+" "+(awaited(okSur)));
                okSur.await();
            }
            System.out.println("entro un sur");
            s++;
            okSur.signal();
        } finally {
            cerrojo.unlock();
        }

    }

    public void salirSur() throws InterruptedException {
        cerrojo.lock();
        try {
            System.out.println("sur saliendo..puente libre");
            s--; 
            if (s == 0) {
                okNorte.signal(); 
            }
        } finally {
            cerrojo.unlock();
        }
    }

    private int awaited(Condition condicion) { //--devuelve el número de hilos que esperan sobre la variable condicion
        return cerrojo.getWaitQueueLength(condicion);
    }
}
