/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */ 
package paralela;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author warren
 */
public class hola extends JFrame{
    JPanel p;
    Semaforo ta,tb,pa,pb,mutex;
    ayuda sos;
    hilotren ht;
    public hola(){
  //  JLabel l=new JLabel("erea");
    sos=new ayuda();
        p=new JPanel();
        ta=new Semaforo(0);
        tb=new Semaforo(0);
        pa=new Semaforo(0);
        pb=new Semaforo(0);
        ht=new hilotren(ta, tb, pa, pb, mutex, sos);
        ht.start();
        mutex=new Semaforo(1);
        this.setResizable(false);
        
        p.setBounds(0,100,500,500);
        this.setResizable(true);
        JButton b1=new JButton("trenes a");
        b1.setBounds(0,0, 250, 100);
        JButton b2=new JButton("trenes b");
        b2.setBounds(250,0, 250, 100);
        this.add(b1);
        this.add(b2);
        this.add(p);
        this.setLocationRelativeTo(null);
        this.setBounds(0,0,500,600);
        p.setLayout(null);
        p.requestFocus();
        p.revalidate();p.repaint();
        b1.addActionListener(e->{
                    JLabel l=new JLabel(new ImageIcon(getClass().getResource("tren.png")));
                    p.add(l);
                    l.setBounds(10,100,50,120);
                    ht k=new ht(l,true,mutex,   ta,tb,pa,pb,sos);
                    p.revalidate();
                    p.repaint();;
                    k.start();
        });



        b2.addActionListener(e->{
                    JLabel l=new JLabel(new ImageIcon(getClass().getResource("trencb.png")));
                    p.add(l);
                    l.setBounds(400,100,50,120);
                    ht k=new ht(l,false,mutex,   ta,tb,pa,pb,sos);
                    k.start();
                    p.revalidate();
                    p.repaint();
        });
    }
}
