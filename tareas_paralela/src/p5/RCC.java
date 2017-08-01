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
import java.util.concurrent.Semaphore;

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

    public void espera_a_que(boolean x) {
        try {
            mutex.acquire(); //region montacargas
            System.out.println("-->intentando entrar a la RCC ");
            v.acquire(); //--intenta entrar por primera vez
            System.out.println("-->entro a la RCC");
            while (!x) //--espera_a_que B(x)
            { //--B(x)=falso
                suspendidos_s++;
                mutex.release();
                v.release(); //--salida momentanea de la RCC
                System.out.println(
                "entraalacoladesuspendidos" +suspendidos_s);
                s.acquire();
                System.out.println("intentando reentrar a la RCC ");
                v.acquire(); //--intento de reentrada a la RCC
            }          
            System.out.println("paso....................");
            /*--en este punto un hilo ha completado la RCC por lo que deben
pasarse los hilos suspendidos de la cola Qv --*/
            while (suspendidos_s > 0) {
                suspendidos_s--;
                s.release();
            }
            v.release();
            mutex.release(); //fin region montacargas
        } catch (InterruptedException e) {
        }
    } //--fin de la RCC
}
