/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p6b;

/**
 *
 * @author warren
 */
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class Grapar_Grafico extends JFrame {

    protected static final SemaforoBinario s_amontonar = new SemaforoBinario(0);
    protected static final SemaforoBinario s_engrapar = new SemaforoBinario(0);
    protected static final SemaforoBinario mutex = new SemaforoBinario(1);
    private JButton btSalir;
    private JTextArea txtTerminal;
    private JLabel lbResultado;
    private JPanel pOpciones, pComandos;
    private JScrollPane scrollingArea;
    Mesa mesa;
    Thread amontonador;
    Thread engrapador;
    DefaultListModel bosque;
    static int mensaje_Imagen = 1;

    public Grapar_Grafico() {
        super("Programa Grapar");
        setLocation(50, 100);
        
        iniComponentes();
        setSize(900, 650);
    }

    private void iniComponentes() {
        txtTerminal = new JTextArea(10, 20);
        txtTerminal.setEditable(false);
        scrollingArea = new JScrollPane(txtTerminal);
        scrollingArea.setBounds(new Rectangle(30, 50, 650, 250));
        String hoj;
        String mont;
        int Hojas;
        int HojasxMonton;
        hoj = JOptionPane.showInputDialog("Introduzca el número de hojas");
        mont = JOptionPane.showInputDialog("Introduzca el número de hojas por montón");
        Hojas = Integer.parseInt(hoj);
        HojasxMonton = Integer.parseInt(mont);
        mesa = new Mesa(Hojas, HojasxMonton);
        amontonador = new Thread(new Amontonar(mesa));
        engrapador = new Thread(new Engrapar(mesa));
        amontonador.start();
        engrapador.start();
        while (engrapador.isAlive() != false) {
            if (mesa.return_Flag() == true) {
                txtTerminal.append(mesa.return_Texto());
            }
        }
        txtTerminal.append(mesa.return_Sobra());
        lbResultado = new JLabel("Grapar");
        
        btSalir = new JButton("Salir");
        btSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        pOpciones = new JPanel();
        pOpciones.add(lbResultado);
        add(pOpciones, BorderLayout.PAGE_START);
        add(scrollingArea, BorderLayout.CENTER);
        pComandos = new JPanel();
        pComandos.add(btSalir);
        add(pComandos, BorderLayout.PAGE_END);
        mesa.escribirArchivo();
    }

    public static void main(String[] args) {
        Grapar_Grafico frame = new Grapar_Grafico();
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
