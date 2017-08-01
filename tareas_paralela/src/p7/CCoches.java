/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p7;

/**
 *
 * @author warren
 */
public class CCoches extends Thread {

    CPuenteLevadizo puenteLevadizo;

    public CCoches(CPuenteLevadizo p_puenteLevadizo) {
        puenteLevadizo = p_puenteLevadizo;
    }

    public void run() {
        try {
            puenteLevadizo.entrarCoche(); //--tratar de pasar el puente
            System.out.println("ENTRO " + getName());
//---PASAR EL PUENTE
            sleep(100);
            puenteLevadizo.salirCoche();
            System.out.println("SALIO " + getName());
        } catch (InterruptedException e) {
        }
    }
}
