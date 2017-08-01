/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p8;

/**
 *
 * @author warren
 */
import java.util.concurrent.locks.*;

public class buffer {

    final ReentrantLock cerrojo = new ReentrantLock();
    final Condition noLleno = cerrojo.newCondition();
    final Condition noVacio = cerrojo.newCondition();
    int pe,ps,num;
    int max;    
    public static dato []almacen;
    public buffer(int n) {
        pe = 0;
        ps = 0;
        max=n;
        num=0;
        almacen=new dato[n];
    }
    public void insertar(dato muajajja)throws InterruptedException{
        cerrojo.lock();
        try{
            while(num>=max){
                noLleno.await();
            }
            almacen[pe]=muajajja;
            muajajja.setPos(pe);
            pe=(pe+1)%max;
            num++;
  //          node n=new node(muajajja.getL());
//            n.movimientob(muajajja.getPos());
            noVacio.signal();
        }finally{
            cerrojo.unlock();
        }
    }
    public dato sacar(){
        cerrojo.lock();              
        dato res=null;
        try{
            while(num<=0){
                noVacio.await();
            }

            res=almacen[ps];
            ps=(ps+1)%max;
            num--;
            while(!res.isB()){
                System.out.println(res.isB());
            }
            noLleno.signal();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally{
            cerrojo.unlock();
        }
        return res;
    }


    private int awaited(Condition condicion) { //--devuelve el número de hilos que esperan sobre la variable condicion
        return cerrojo.getWaitQueueLength(condicion);
    }
}
