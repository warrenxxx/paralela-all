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

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        HiloNinos n1, n2, n3, n4;
        HiloMadre m1;
        Semaphore mutex, esperar, dormir;
        mutex = new Semaphore(1);
        esperar = new Semaphore(0);
        dormir = new Semaphore(0);
        Contador nroRaciones;
        nroRaciones = new Contador(4);
        n1 = new HiloNinos(mutex, nroRaciones, esperar, dormir);
        n2 = new HiloNinos(mutex, nroRaciones, esperar, dormir);
        n3 = new HiloNinos(mutex, nroRaciones, esperar, dormir);
        n4 = new HiloNinos(mutex, nroRaciones, esperar, dormir);
        m1 = new HiloMadre(mutex, nroRaciones, esperar, dormir);
//--EJECUTAR 4 NIÑOS
        n1.start();
        n2.start();
        n3.start();
        n4.start();
//--EJECUTAR LA MADRE
        m1.start();
    }
}
