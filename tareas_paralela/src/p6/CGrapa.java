package p6;
/**
 *
 * @author warren
 */

public class CGrapa extends RCC { //--atributos

    private wIntero numHojas;
    private wboolean []turno;
    int n;

    public CGrapa(int n) {
        super();
        numHojas=new wIntero();
        turno=new wboolean[4];
        for(int i=0;i<4;i++)
            turno[i]=new wboolean(false);
        turno[0].setB(true);
        this.n=n;
    }

    public void p(int pos )throws  InterruptedException{
        for(int i=0;i<n;i++){            
            espera_a_que(turno[pos],i,pos);
            turno[pos].setB(false);
            RegionNumeroDehojas();
            RegionTurnosalida((pos+1)%4);

        }
        System.out.println("fin n");
    }
    public  void Grapar()throws InterruptedException{        
        espera_a_que(numHojas,650,650);
        numHojas.add(-4 ); 
    }

    

    public  void  RegionTurno(int n)throws  InterruptedException{

    }
    public void  RegionTurnosalida(int n)throws  InterruptedException{
            turno[n].setB(true);        
    }
    public void  RegionNumeroDehojas()throws  InterruptedException{
            numHojas.add();
    }
    public synchronized  int numHojas(){
        return numHojas.numHojas();
    }

    public synchronized void inicia() {
        for(int i=0;i<4;i++){
            turno[i].setB(false);
        }
        turno[0].setB(true);
        numHojas.clear();

    }


}
