/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p6a;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author warren
 */
public class c1 extends c0{

    cc b1;
    public c1() {
        b1=new cc(false);
        h();
        this.gg(b1);
    }

    public void h(){
        Thread hh=new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    if(!b1.isB())b1.setB(true);
                    else b1.setB(false);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(c1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        System.out.println("gg");
        hh.start();
                System.out.println("gg");

    }
        
}
