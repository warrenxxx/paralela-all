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
public class SemaforoBinario {

    private int contador;

    public SemaforoBinario(int n) {
        this.contador = n;
    }

    public synchronized void WAIT() {
        while (contador == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        contador--;
    }

    public synchronized void SIGNAL() {
        contador++;
        notify();
    }
}
