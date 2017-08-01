/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p6.animacion;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import p6.CGrapa;
import p6.grapa;
import p6.monton;

/**
 *
 * @author warren
 */
public class hola extends JFrame {

    JPanel p;
        public static JLabel[][] k = new JLabel[4][8];
        public static ht[][] hilos = new ht[4][8];
    public hola() {
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


        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 8; j++) {
                k[i][j] = new JLabel(new ImageIcon(getClass().getResource("tren.png")));
                p.add(k[i][j]);
                k[i][j].setVisible(false);
                k[i][j].setBounds(100*i+10, 100, 50, 120);
                hilos[i][j] = new ht(k[i][j], false);
                p.revalidate();
                p.repaint();
                hilos[i][j].start();
            }
        }
        CGrapa RCmontacargas; //--recurso compartido

        RCmontacargas = new CGrapa(8); //--inicia el montacargas
        for(int i=0;i<4;i++){
            monton m=new monton(RCmontacargas,i);
            m.start();
        }
//--crear hilos de vehiculos grandes
        grapa v=new grapa(RCmontacargas); //--hilos de vehiculos grandes
//--crear hilos de vehiculos pequeños
//--ejecutar hilos
        v.start();    }
}
