/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paralela;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import static java.lang.Math.random;
import javax.swing.ImageIcon;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Warren
 */
public class Paralela {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        JFrame f=new JFrame("tarea pelotitas rebotando");
        JPanel p=new JPanel();
        
        f.pack();
        p.setBounds(0, 0, 400,400);
        f.setBounds(0,0,500,500);
 //       f.setVisible(true);
        f.setContentPane(p);
        p.setVisible(true);
        
        f.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
                int k=(int)(random()*6);
                while(k==0)k=(int)(random()*6);
                

                JLabel l=new JLabel(new ImageIcon( getClass().getResource("images/"+String.valueOf(k)+".png")));
                p.add(l);
              
                l.setVisible(true);
                hilos h=new hilos(random()*300, random()*300, p.getWidth(), p.getHeight(), l,l.getIcon().getIconWidth(), l.getIcon().getIconHeight(), random()*30-15, random()*30-15);
                h.start();
                p.revalidate();
                System.out.println("ww");
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
       java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               f.setVisible(true);
            }
        });
    }    
}
