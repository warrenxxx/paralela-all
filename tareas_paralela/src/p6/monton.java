/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p6;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author warren
 */
public class monton extends Thread{
    private CGrapa a_montacargas;    
    int n;
    public monton(CGrapa a_montacargas,int n) {
        this.a_montacargas = a_montacargas;
        this.n=n;
    }
    
    @Override
    public void run() {
            try {
                a_montacargas.p(n);        
            } catch (InterruptedException ex) {
                Logger.getLogger(monton.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
}
