/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servidor;

import Cliente.Jugador;
import Modelos.Mensaje;
import Modelos.TipoMensaje;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jecheverria
 */
public class ThreadServidor extends Thread{
    public Socket socket;
    public Jugador jugador;
    private Servidor server;
    private ObjectInputStream entrada;
    private DataInputStream entradaDatos;
    ObjectOutputStream salida;
    String nombre;
    
    private boolean isRunning = true;

    public ThreadServidor(Socket socket, Servidor server) {
        this.socket = socket;
        this.server = server;
        try {
            entrada = new ObjectInputStream(socket.getInputStream());
            salida = new ObjectOutputStream(socket.getOutputStream());
            entradaDatos = new DataInputStream(socket.getInputStream());
        } catch (IOException ex) {
            
        }
    }

    @Override
    public void run() {
        Mensaje mensaje;
        try {
            nombre = entradaDatos.readUTF(); // lee el nombre
            Jugador nuevo = new Jugador(nombre);
            this.jugador = nuevo;
            Mensaje mensaje_jugador = new Mensaje(nuevo);
            server.pantalla.write("Recibido nombre: " + mensaje_jugador.getJugador().nombre);
            server.jugadores.add(nuevo);    
            server.mensajeTodos(new Mensaje(true,server.getNombresClientes()));
            this.salida.writeObject(mensaje_jugador);
        } catch (IOException ex) {
            Logger.getLogger(ThreadServidor.class.getName()).log(Level.SEVERE, null, ex);
        }

        while (isRunning){
            try {
                try {
                    mensaje = (Mensaje) entrada.readObject();       
                    if(mensaje.isdisparo){
                        server.enviarDisparo(mensaje);
                    }else if (mensaje.isSolicitudPlayer){
                        server.requestPlayer(mensaje);
                    }else if (mensaje.isRespuestaPlayer){
                        server.sendPlayer(mensaje);
                    }else
                        server.broadcoast(mensaje);
                } catch (ClassNotFoundException ex) {
                    System.out.println("Error: " + ex.getMessage());
                }

            } catch (IOException ex) {}

            }
    }
}
