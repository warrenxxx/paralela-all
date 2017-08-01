/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p6;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author warren
 */
public class wIntero implements base{
    private AtomicInteger b;
    private AtomicBoolean estado;
    
    public wIntero() {
        this.b =new AtomicInteger(0);
        estado=new AtomicBoolean(false);
    }
    public void clear(){
        this.estado.set(false);
    }
    public synchronized int numHojas(){
        return b.get();
    }
    public boolean isB() {
        return estado.get();
    }

    public void add() {
        b.addAndGet(1);
        if(b.get()>0&&b.get()%4==0)
            estado.set(true);
    }
    public void add(int k){
        b.addAndGet(k);    
        if(b.get()>0&&b.get()%4==0)
            estado.set(true);
    }    

    @Override
    public String toString() {
        return "wIntero{" + "b=" + b + ", estado=" + estado + '}';
    }
    
}
