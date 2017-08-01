/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p5;

/**
 *
 * @author warren
 */

public class AppVehiculos {

    public static void main(String arg[]) {
        int a=0;
        System.out.println((a+1)%4);
        CMontacargas RCmontacargas; //--recurso compartido
        Montacargas montacargas;
        VehiculoGrande vG1, vG2, vG3, vG4; //--hilos de vehiculos grandes
        VehiculoPeque vP1, vP2, vP3, vP4, vP5, vP6, vP7, vP8; //--hilos de vehiculos pequeños
        RCmontacargas = new CMontacargas(); //--inicia el montacargas
        montacargas = new Montacargas(RCmontacargas);
        montacargas.start();
//--crear hilos de vehiculos grandes
        vG1 = new VehiculoGrande(RCmontacargas);
        vG2 = new VehiculoGrande(RCmontacargas);
        vG3 = new VehiculoGrande(RCmontacargas);
        vG4 = new VehiculoGrande(RCmontacargas);
//--crear hilos de vehiculos pequeños
        vP1 = new VehiculoPeque(RCmontacargas);
        vP2 = new VehiculoPeque(RCmontacargas);
        vP3 = new VehiculoPeque(RCmontacargas);
        vP4 = new VehiculoPeque(RCmontacargas);
        vP5 = new VehiculoPeque(RCmontacargas);
        vP6 = new VehiculoPeque(RCmontacargas);
        vP7 = new VehiculoPeque(RCmontacargas);
        vP8 = new VehiculoPeque(RCmontacargas);
//--ejecutar hilos
        vG1.start();
        vP3.start();
        vP1.start();
        vG4.start();
        vG2.start();
        vG3.start();
        vP2.start();
        vP4.start();
        vP5.start();
        vP6.start();
        vP7.start();
        vP8.start();
    }
}
