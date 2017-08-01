/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p6b;

/**
 *
 * @author warren
 */
public class Engrapar implements Runnable {

    Mesa L;

    public Engrapar(Mesa mesa) {
        L = mesa;
    }

    public void run() {
        L.engrapar();
    }
}
