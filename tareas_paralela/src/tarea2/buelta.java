/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea2;

/**
 *
 * @author warren
 */
public class buelta {
    public int p;

    public buelta() {
        p=0;
    }
    public void pedircomida( ){
        p--;
               if(p<0)p=0;
    }
    public void retirarcomida(){
        p++;
 
    }
}
