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

import java.io.*;
import java.net.*;
public class ClienteCitas {

    public static void main(String[] args) throws IOException {
//        if (args.length != 1) {
//            System.out.println("Uso: java ClienteCitas <nombre_host>");
//            return;
//        }
        // crear el DatagramSocket del cliente
        // (el constructor justamente liga el DatagramSocket a cualquier puerto local
        // disponible. No importa a q' puerto el cliente es ligado pues los
        // DatagramPackets contienen la información de direccionamiento).
        DatagramSocket socket = new DatagramSocket();
        // enviar peticion al server
        byte[] buffer = new byte[256];
        // obtener la direccion IP para el host nombrado en la línea de comandos, q' es
        // el nombre de la máquina en la cual el server está corriendo
        // (el numero de puerto 4445 es el numero de puerto que el server uso para crear
        // su DatagramSocket)
        InetAddress direccionIP = InetAddress.getByName("192.168.1.2");
        DatagramPacket paquete = new DatagramPacket(buffer, buffer.length, direccionIP, 4445);
        socket.send(paquete);
        
        // obtener respuesta
        paquete = new DatagramPacket(buffer, buffer.length);
        socket.receive(paquete);
        // mostrar la respuesta ó cita
        String citaRecibida = new String(paquete.getData(), 0, paquete.getLength());
        InetAddress address = InetAddress.getLocalHost();
        System.out.println("Direccion Socket Servidor :"+paquete.getSocketAddress());
        System.out.println("Puerto Cliente : "+address+" "+socket.getLocalPort());
        System.out.println("Cita del momento: " + citaRecibida);
        socket.close();
        
        
    }
}