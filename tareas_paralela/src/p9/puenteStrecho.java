/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p9;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 *
 * @author warren
 */
public class puenteStrecho extends JFrame{
   public static     JPanel p;
    public puenteStrecho(){
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
        puente b=new puente();
        b1.addActionListener(e->{
            JLabel l=new JLabel(new ImageIcon(getClass().getResource("trena.png")));
            l.setBounds(10,400,50,50);
            l.setVisible(true);
            p.add(l);
            CNorte x=new CNorte(b,l);
            x.start();
        });
        b2.addActionListener(e->{
            JLabel l=new JLabel(new ImageIcon(getClass().getResource("tren.png")));
            l.setBounds(400,400,50,50);
            l.setVisible(true);
            p.add(l);
            CSur y=new CSur(b,l);
            y.start();
        });

    }
    
    public static void main(String arg[]) {
        puenteStrecho p=new puenteStrecho();
        p.setVisible(true);
        /*
//--CREAR EL MONITOR
    
        puente puenteps = new puente();
//--CREAR LOS HILOS A LOS QUE SE PASA COMO PARAMETRO EL MONITOR A UTILIZAR
        CNorte c1 = new CNorte(puenteps);
        CSur b1 = new CSur(puenteps);
        CNorte c2 = new CNorte(puenteps);
        CSur b2 = new CSur(puenteps);
        CNorte c3 = new CNorte(puenteps);
        CSur b3 = new CSur(puenteps);
        CNorte c4 = new CNorte(puenteps);
        CSur b4 = new CSur(puenteps);
        CNorte c5 = new CNorte(puenteps);
        CSur b5 = new CSur(puenteps);
//--PONER NOMBRE A LOS HILOS
        c1.setName("norte 01");
        c2.setName("norte 02");
        c3.setName("norte 03");
        c4.setName("norte 04");
        c5.setName("norte 05");
        b1.setName("Sur 01");
        b2.setName("Sur 02");
        b3.setName("Sur 03");
        b4.setName("Sur 04");
        b5.setName("Sur 05");
//--EJECUTAR LOS HILOS
        c1.start();
        b1.start();
        c2.start();
        b2.start();
        c3.start();
        b3.start();
        c4.start();
        b4.start();
        c5.start();
        b5.start();*/
    }
}
