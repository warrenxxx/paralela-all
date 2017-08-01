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
public class CBarcos extends Thread {

    CPuenteLevadizo puenteLevadizo;

    public CBarcos(CPuenteLevadizo p_puenteLevadizo) {
        puenteLevadizo = p_puenteLevadizo;
    }

    public void run() {
        try {
            puenteLevadizo.entrarBarco(); //--tratar de pasar el puente
            System.out.println("ENTRO " + getName());
//---PASAR EL PUENTE
            sleep(200);
            puenteLevadizo.salirBarco();
            System.out.println("SALIO " + getName());
        } catch (InterruptedException e) {
        }
    }
}
