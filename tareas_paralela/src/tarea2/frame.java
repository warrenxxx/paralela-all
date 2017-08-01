/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea2;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author warren
 */
public class frame extends JFrame{
    JPanel p;
    JLabel lmesa,lmina,platos[];
    
    public static  hiloenano g[]=new hiloenano[7];
    public static hilocenicienta2 c; 

    public frame() {
        this.setBounds(0,0,1800,800);
        this.setLocation(0,0);
        this.setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        p=new JPanel(); 
        setContentPane(p);        
        p.setBounds(0,0,1800,800);
        this.setLocation(0,0);
        p.setPreferredSize(new Dimension(1800, 800));
                this.load();
                pack();
            hilos();
        activar_kye();
    }
    public void load(){     
        lmina=new JLabel(new ImageIcon(getClass().getResource("mina.png")));
        lmina.setLocation(0,0);
        lmina.setVisible(true);
        p.add(lmina);
 
        lmesa=new JLabel(new ImageIcon(getClass().getResource("mesa.png")));
        lmesa.setLocation(700, 0);
        lmesa.setVisible(true);

        platos=new JLabel[4];
        for(int i=0;i<4;i++){
            platos[i]=new JLabel(new ImageIcon(getClass().getResource("platob.png")));
            platos[i].setVisible(false);
            platos[i].setLocation(0,0);
            p.add(platos[i]);
        }
        p.add(lmesa);
        p.revalidate();

        JButton b=new JButton("WARREN");
        b.setLocation(0,0);
        b.addActionListener(e->{
            lmina.setLocation(0,0);
            lmesa.setLocation(800,200);
            for(int i=0;i<7;i++)g[i].start();
            c.start();
        });
        p.add(b);
    }

    public void hilos(){
             Dimension mina=new Dimension(0,200);
        Semaforo silla=new Semaforo(4),
                 quiercocomer=new Semaforo(0),
                 seervircomida=new Semaforo(0),
                 terminecomida=new Semaforo(0),
                 mutex=new Semaforo(1);
        mesa r=new mesa();
        buelta x=new buelta();
        g[0]=new hiloenano(new JLabel(new ImageIcon(getClass().getResource("ee1.png"))), new Point(0,420), silla, quiercocomer, seervircomida, terminecomida,p,mutex,r,x);
        g[1]=new hiloenano(new JLabel(new ImageIcon(getClass().getResource("ee2.png"))), new Point(50,420), silla, quiercocomer, seervircomida, terminecomida,p,mutex,r,x);
        g[2]=new hiloenano(new JLabel(new ImageIcon(getClass().getResource("ee3.png"))), new Point(100,420), silla, quiercocomer, seervircomida, terminecomida,p,mutex,r,x);
        g[3]=new hiloenano(new JLabel(new ImageIcon(getClass().getResource("ee4.png"))), new Point(150,420), silla, quiercocomer, seervircomida, terminecomida,p,mutex,r,x);
        g[4]=new hiloenano(new JLabel(new ImageIcon(getClass().getResource("ee5.png"))), new Point(200,420), silla, quiercocomer, seervircomida, terminecomida,p,mutex,r,x);
        g[5]=new hiloenano(new JLabel(new ImageIcon(getClass().getResource("ee6.png"))), new Point(250,420), silla, quiercocomer, seervircomida, terminecomida,p,mutex,r,x);
        g[6]=new hiloenano(new JLabel(new ImageIcon(getClass().getResource("ee7.png"))), new Point(300,420), silla, quiercocomer, seervircomida, terminecomida,p,mutex,r,x);        
        c=new hilocenicienta2(new JLabel(new ImageIcon(getClass().getResource("ee8.png"))), new Point(500,420), silla, quiercocomer, seervircomida, terminecomida,p,mutex,r,platos,x);        

 
    }
    
    public void activar_kye(){
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(e.getX()+" "+e.getY());
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
    }
}
