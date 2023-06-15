/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servidor;

import Cliente.Jugador;
import Modelos.Mensaje;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author jecheverria
 */
public class ServerConnectionsThread extends Thread{
    private boolean isRunning = true;
    Servidor server;

    public ServerConnectionsThread(Servidor server) {
        this.server = server;
    }
    
    public void run(){
        while (isRunning) {            
            try {
                server.pantalla.write("Esperando cliente ... ");
                if(server.threadsClientesAceptados.size() < 4){
                    Socket socket = server.server.accept();
                    ThreadServidor ts = new ThreadServidor(socket, server);
                    ts.start();
                    server.threadsClientesAceptados.add(ts);
                    server.pantalla.write("Cliente conectado");
                }else{
                    server.pantalla.write("Server lleno no se permitiran mas clientes");
                    break;
                }
                
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }   
}
