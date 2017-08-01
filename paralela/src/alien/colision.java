/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alien;

/**
 *
 * @author Warren
 */
import java.awt.EventQueue;
import javax.swing.JFrame;

public class colision extends JFrame {

    public colision() {
        
        initUI();
    }
    
    private void initUI() {
        
        add(new tablero());
        
        setResizable(false);
        pack();
        
        setTitle("Collision");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                colision ex = new colision();
                ex.setVisible(true);
            }
        });
    }
}
