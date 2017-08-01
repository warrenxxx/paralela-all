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
import p5.*;
import java.util.concurrent.Semaphore;
import static p6.animacion.hola.hilos;

public class RCC {

    Semaphore v; //--cola de hilos que quieren entrar por primera vez
    Semaphore s; //--cola de hilos suspendidos
    Semaphore mutex;
    private static int suspendidos_s; //--num. de hilos suspendidos
//--constructor

    public RCC() {
        v = new Semaphore(1);
        s = new Semaphore(0);
        mutex = new Semaphore(1);
        suspendidos_s = 0;
    }
//--region crítica condicional
    
    
    public void espera_a_que(base x,int pos,int mont) {
        try {
            mutex.acquire(); //region montacargas
            System.out.println("-->intentando entrar a la RCC "+pos+" "+mont+" - "+x);
            v.acquire(); //--intenta entrar por primera vez
            System.out.println("-->entro a la RCC"+pos+" "+mont+" - "+x);
            while (!x.isB()) //--espera_a_que B(x)
            { //--B(x)=falso
                suspendidos_s++;
                mutex.release();
                v.release(); //--salida momentanea de la RCC
                System.out.println(
                "entraalacoladesuspendidos" +suspendidos_s+" "+pos+" "+mont+" - "+x);
               

                System.out.println("intentando reentrar a la RCC "+pos+" "+mont+" - "+x);
                v.acquire(); //--intento de reentrada a la RCC
            }
            if(pos!=650)
                hilos[mont][pos].autPermiso();
            System.out.println("paso "+pos+" "+mont+" - "+x);
            /*--en este punto un hilo ha completado la RCC por lo que deben
            pasarse los hilos suspendidos de la cola Qv --*/
            while (suspendidos_s > 0) {
                suspendidos_s--;
            }

            v.release();
            mutex.release(); //fin region montacargas
        } catch (InterruptedException e) {
        }
    } //--fin de la RCC(){}
}
