/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p8;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 *
 * @author warren
 */
public class Appconsumidor extends JFrame{
   public static     JPanel p;

    public Appconsumidor(){
            //  JLabel l=new JLabel("erea");
        this.setResizable(false);
        p=new JPanel();
  
        p.setBounds(0, 100, 500, 500);
        this.setResizable(true);
        JButton b1 = new JButton("comensar a");
        b1.setBounds(0, 0, 250, 100);
        JButton b2 = new JButton("Comnesar b");
        b2.setBounds(250, 0, 250, 100);
        this.add(b1);
        this.add(b2);
        this.add(p);
        this.setLocationRelativeTo(null);
        this.setBounds(0, 0, 500, 600);
        p.setLayout(null);
        p.requestFocus();
        p.revalidate();
        p.repaint();
        buffer b=new buffer(8);
        
        
        b1.addActionListener(e->{
            CeNTRADA x=new CeNTRADA(b,"dato");
            x.start();
        });
        b2.addActionListener(e->{
            CsALIDA y=new CsALIDA(b);
            y.start();
        });

    }
    
    
    public static void main(String arg[]) {
        Appconsumidor app= new Appconsumidor();
        app.setVisible(true);
        /*
//--CREAR EL MONITOR
        buffer buf=new buffer(6);
//--CREAR LOS HILOS A LOS QUE SE PASA COMO PARAMETRO EL MONITOR A UTILIZAR
        CsALIDA s1[]=new CsALIDA[15];
        CeNTRADA en[]=new CeNTRADA[15];
//--PONER NOMBRE A LOS HILOS
        
        for(int i=0;i<15;i++){
            s1[i]=new CsALIDA(buf);
            en[i]=new CeNTRADA(buf, "was"+i);
        }
        
        for(int i=0;i<15;i++){
            en[i].start();
            s1[i].start();
        }*/
    }
}
