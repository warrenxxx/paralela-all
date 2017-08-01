/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p6;


/**
 *
 * @author warren
 */

public class Programagrapar {

    public static void main(String arg[]) {
        CGrapa RCmontacargas; //--recurso compartido

        RCmontacargas = new CGrapa(8); //--inicia el montacargas
        for(int i=0;i<4;i++){
            monton m=new monton(RCmontacargas,i);
            m.start();
        }
//--crear hilos de vehiculos grandes
        grapa v=new grapa(RCmontacargas); //--hilos de vehiculos grandes
//--crear hilos de vehiculos pequeños
//--ejecutar hilos
        v.start();
    }
}
