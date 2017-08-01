/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p8;

import javax.swing.JLabel;

/**
 *
 * @author warren
 */
public class dato {
    private JLabel l;
    private int pos;  
    private boolean b;

    public dato() {
        b=false;
    }

    public boolean isB() {
        return b;
    }

    public void setB(boolean b) {
        this.b = b;
    }
    public JLabel getL() {
        return l;
    }

    public void setL(JLabel l) {
        this.l = l;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    @Override
    public String toString() {
        return l.getText()+pos;
    }
    
}
