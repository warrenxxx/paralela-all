/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p10;

/**
 *
 * @author warren
 */
import java.util.concurrent.locks.*;

public class torre {

    final ReentrantLock cerrojo = new ReentrantLock();
    final Condition despegar    = cerrojo.newCondition();
    final Condition aterrizar   = cerrojo.newCondition();
    final Condition alerta      = cerrojo.newCondition();
    
    boolean ocu;
    public torre() {
        ocu=false;
    }

    public void pedirAterrisaje() throws InterruptedException {
        cerrojo.lock();
        try {
            while (ocu ) //hay barco pasando o esperando
            { //--tiene prioridad los barcos
                aterrizar.await();
            }
            ocu=true;
        } finally {
            cerrojo.unlock();
        }
    }

    public void alertaRoja() throws InterruptedException {
        cerrojo.lock();
        try {
            if (ocu) {
                aterrizar.await();
            }
            ocu=true;
        } finally {
            cerrojo.unlock();
        }
    }

    public void confirmar() throws InterruptedException {
        cerrojo.lock();
        try {
            if (awaited(alerta)>0){
                alerta.signal();
            }else{
                if(awaited(despegar)>0){
                    despegar.signal();
                }else{
                    if(awaited(aterrizar)>0){
                        aterrizar.signal();
                    }else{
                        ocu=false;
                    }
                }
            }
        } finally {
            cerrojo.unlock();
        }
    }

    private int awaited(Condition condicion) { //--devuelve el número de hilos que esperan sobre la variable condicion
        return cerrojo.getWaitQueueLength(condicion);
    }
}
