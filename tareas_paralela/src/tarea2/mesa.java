/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea2;

import java.awt.Point;

/**
 *
 * @author warren
 */
public class mesa {
    public boolean []sillas;
    public boolean []comiendo;
   
    public Point [] pos;
    public Point [] platos;
    
    public mesa() {
        sillas=new boolean[4];
        comiendo=new boolean[4];
        for(int i=0;i<4;i++){
            sillas[i]=false;
            comiendo[i]=false;
        }
        pos=new Point[4];
        pos[0]=new Point(955,158);
        pos[1]=new Point(751,346);
        pos[2]=new Point(955,468);
        pos[3]=new Point(1129,328);

        platos=new Point[4];
        platos[0]=new Point(949,258);
        platos[1]=new Point(843,298);
        platos[2]=new Point(598,313);
        platos[3]=new Point(1059,285);
		

    }
    public int buscar(){
        for(int i=0;i<4;i++)
            if(!sillas[i])return i;        
        return -1;
    }
    public void entrar(int a){
        sillas[a]=true;
    }
    public void salir(int a){
        sillas[a]=false;
    }
    
    public Point get_posPlato(int a){
        return platos[a];
    }
    public Point get_possilla(int a){
        return pos[a];
    }
    
    public void poner_plato(int a){
        comiendo[a]=true;
    }
    public void sacar_plato(int a){
        comiendo[a]=false;
    }
    public int buscar_plato(){
        for(int i=0;i<4;i++)
            if(!comiendo[i])return i;
        return -1;
    }
}
