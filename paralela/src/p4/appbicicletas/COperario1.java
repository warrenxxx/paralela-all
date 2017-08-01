package p4.appbicicletas;

import java.util.concurrent.Semaphore;

public class COperario1 extends Thread {

    Semaphore hayEspRuedas;
    Semaphore hayRueda;

    public COperario1(Semaphore p_hayEspRuedas, Semaphore p_hayRueda) {
        hayEspRuedas = p_hayEspRuedas;
        hayRueda = p_hayRueda;
    }

    public void run() {
        while (true) {
            try {
                hayEspRuedas.acquire();
//--Hacer Rueda
                sleep(100);
                System.out.println("Se fabricó una rueda");
                hayRueda.release();
            } catch (InterruptedException e) {
            }
        }
    }
}
