/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p6a;

/**
 *
 * @author warren
 */
class mesa extends MyObject {

    CountingSemaphore CH;
    BinarySemaphore G;

    public mesa(CountingSemaphore C, BinarySemaphore BG) {
        this.CH = C;
        this.G = BG;
    }

    public void amontona(int i) {
        P(CH);
        System.out.println("Se pone la hoja " + i + " en la mesa");
        if (CH.value == 0) {
            V(G);
        }
    }

    public void grapa() {
        P(G);
        if (G.value == 0) {
            System.out.println("Se graparon 4 hojas");
            for (int y = 0; y < 4; y++) {
                V(CH);
            }
        }
    }
}
