/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paralela;

/**
 *
 * @author warren
 */
public class hilotren extends Thread{
    private Semaforo ta,tb,pa,pb,mutex;
    private ayuda sos;

    public hilotren(Semaforo ta, Semaforo tb, Semaforo pa, Semaforo pb, Semaforo mutex, ayuda sos) {
        this.ta = ta;
        this.tb = tb;
        this.pa = pa;
        this.pb = pb;
        this.mutex = new Semaforo(1);
        this.sos = sos;
    }

    
    @Override
    public void run() {
        try{
        while(true){    
            if(sos.a>0){
                mutex.P();
                    ta.V();
                    sos.menosa();
                    pa.P();
                mutex.V();
                
            }
            if(sos.b>0){
                mutex.P();
                    tb.V();
                    sos.menosb();
                    pb.P();
                mutex.V();
            }
            Thread.sleep(15);
        }
        }catch(Exception e ){
        
        }
    }
    
}
