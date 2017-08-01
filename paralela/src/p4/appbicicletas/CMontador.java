/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p4.appbicicletas;

/**
 *
 * @author warren
 */
import java.util.concurrent.Semaphore;

public class CMontador extends Thread { //--ensambla bicicletas utilizando ruedas, marcos y manillasres

    Semaphore hayEspMar;
    Semaphore hayMarco;
    Semaphore hayEspRuedas;
    Semaphore hayRueda;
    Semaphore hayEspMani;
    Semaphore hayManillar;
    
public CMontador(Semaphore p_hayEspRuedas, Semaphore p_hayRueda,
            Semaphore p_hayEspMar, Semaphore p_hayMarco,
            Semaphore p_hayEspMani, Semaphore p_hayManillar) {
        hayEspRuedas = p_hayEspRuedas;
        hayRueda = p_hayRueda;
        hayEspMar = p_hayEspMar;
        hayMarco = p_hayMarco;
        hayEspMani = p_hayEspMani;
        hayManillar = p_hayManillar;
    }

    public void run() {
        while (true) {
            try {
                hayRueda.acquire();
//--coger rueda
                System.out.println("Se tomó una rueda");
                sleep(50);
                hayEspRuedas.release(); //--libera un espacio para una rueda
                hayRueda.acquire();
//--coger rueda
                System.out.println("Se tomó una rueda");
                sleep(50);
                hayEspRuedas.release(); //--libera un espacio para otra rueda
                hayMarco.acquire();
//--coge un marco
                sleep(100);
                System.out.println("Se tomó un marco");
                hayEspMar.release(); //--libera un espacio para un marco
                hayManillar.acquire();
//--coge un manillar
                System.out.println("Se tomó un manillar");
                sleep(60);
                hayEspMani.release(); //--libera un espacio para un manillar
//--MONTAR LA BICICLETA
                sleep(200);
                System.out.println("SE ARMO UNA BICICLETA...");
            } catch (InterruptedException e) {
            }
        }
    }
}
