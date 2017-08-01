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

public class Main {

    public static void main(String[] args) {
        Semaphore hayEspMar = new Semaphore(4);
        Semaphore hayMarco = new Semaphore(0);
        Semaphore hayEspRuedas = new Semaphore(10);
        Semaphore hayRueda = new Semaphore(0);
        Semaphore hayEspMani = new Semaphore(10);
        Semaphore hayManillar = new Semaphore(0);
        COperario1 op1 = new COperario1(hayEspRuedas, hayRueda);
        COperario2 op2 = new COperario2(hayEspMar, hayMarco);
        COperario3 op3 = new COperario3(hayEspMani, hayManillar);
        CMontador mon = new CMontador(hayEspRuedas, hayRueda,
                hayEspMar, hayMarco,
                hayEspMani, hayManillar);
//--iniciar los hilos
        op1.start();
        op2.start();
        op3.start();
        mon.start();
    }
}
