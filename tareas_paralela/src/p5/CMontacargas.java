package p5;
/**
 *
 * @author warren
 */
import java.util.concurrent.atomic.*;

public class CMontacargas extends RCC { //--atributos

    AtomicInteger a_numVg; //--num. de vehiculos grandes
    AtomicInteger a_numVp; //--num. de vehiculos pequeños

    public CMontacargas() {
        super();
        a_numVg = new AtomicInteger();
        a_numVp = new AtomicInteger();
    }

    public void entraVg() throws InterruptedException {//--incrementa nº de vehiculos pequeños
        espera_a_que((numVG() == 0) && (numVP() <= 2));
        System.out.println(a_numVg.addAndGet(1));
    }

    public synchronized int numVG() {//-- devuelve el nº de vehiculos grandes que existen en el montacargas
        return a_numVg.get();
    }

    public void entraVp() throws InterruptedException {//--incrementa nº de vehiculos pequeños
        espera_a_que(((numVP() < 4) && (numVG() == 0))
                || ((numVP() < 2) && (numVG() == 1)));
        System.out.println(a_numVp.addAndGet(1));
    }

    public synchronized int numVP() {//-- devuelve el nº de vehiculos pequeños que existen en el montacargas
        return a_numVp.get();
    }

    public synchronized void inicia() {
        a_numVp.set(0);
        a_numVg.set(0);
    }
}
