/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea1;

import java.awt.Label;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import static java.lang.Math.random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

/**
 *
 * @author warren
 */
public class pantalla {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame x=new JFrame();
        x.setBounds(0,0,500,500);
        x.setVisible(true);
        JPanel p=new JPanel();
        p.setBounds(0, 0,500, 500);
        x.setContentPane(p);

        x.addMouseListener(new MouseInputListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int k=(int)(random()*6);
                while(k==0)k=(int)(random()*6);
                

                JLabel l=new JLabel(new ImageIcon( getClass().getResource(String.valueOf(k)+".png")));
                p.add(l);
                l.setLocation((int)(random()*50),(int)(random()*50));
                l.setVisible(true);
//                hbola h=new hbola(random()*300, random()*300, p.getWidth(), p.getHeight(), l,l.getIcon().getIconWidth(), l.getIcon().getIconHeight(), random()*30-15, random()*30-15);
                //hbola h=new hbola(l, x.getHeight(), x.getWidth(), random()*50, random()*50,(int)(random()*150));

                hbola h=new hbola(l, p.getWidth(), p.getHeight(), random()*50-25, random()*50-25,(int)(random()*1000));
                h.start();
                x.revalidate();            
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

            @Override
            public void mouseDragged(MouseEvent e) {
            }

            @Override
            public void mouseMoved(MouseEvent e) {
            }
        });
    }
    
}
