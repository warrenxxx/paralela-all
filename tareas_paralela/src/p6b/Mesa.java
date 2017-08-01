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
import java.util.*;
import java.io.File;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
//pedir numero de hojas y monton y las que no se engrapan



public class Mesa {

    File f = new File("Reply.txt");
    int nhojas, paquetes = 1;
    int hojasXjuego;
    String texto, sobra;
    private boolean flag;

    public Mesa(int n, int x) {
        sobra = "\nEl número de hojas sobrantes es: ";
        nhojas = n;
        hojasXjuego = x;
        texto = "";
        flag = false;
        sobra = sobra + nhojas % hojasXjuego;
        nhojas = nhojas - (nhojas % hojasXjuego);
    }

    public synchronized void amontonar() {
        int contador = 1;
        while (nhojas > 0) {
            for (int i = 0; i < hojasXjuego; i++) {
                System.out.println("La hoja " + contador + " ha sido amontonada");
                texto = texto + "\nLa hoja " + contador + " ha sido amontonada\n";
                nhojas--;
                contador++;
            }
            notify();
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
    }

    public synchronized void engrapar() {

        while (nhojas > 0) {
            System.out.println("Se han engrapado " + hojasXjuego + " hojas");
            texto = texto + "\nSe han engrapado " + hojasXjuego + " hojas\n";
            notify();
            try {
                wait();
            } catch (InterruptedException e) {
            }
            paquetes++;
        }
        System.out.println("Se han engrapado " + hojasXjuego + " hojas");
        texto = texto + "\nSe han engrapado " + hojasXjuego + " hojas\n";
        System.out.println("Se han engrapado " + paquetes + " paquetes.");
        notify();
        flag = true;
    }

    public String return_Texto() {
        return texto;

    }

    public String return_Sobra() {
        return sobra;
    }

    public boolean return_Flag() {
        return flag;
    }

    public void escribirArchivo() {
        try {
            FileWriter w = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(w);
            PrintWriter wr = new PrintWriter(bw);
            wr.write("======== R E S U L T A D O S D E G R A P A R: ========\n");
            wr.append(texto + "\n");
            wr.append("\nNúmero de paquetes: " + paquetes + "\n");
            wr.append(sobra + "\n");
            wr.close();
            bw.close();

        } catch (IOException e) {
        };
    }
}
