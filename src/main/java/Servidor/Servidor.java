/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servidor;

import Cliente.Jugador;
import Modelos.Mensaje;
import Modelos.TipoMensaje;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {
    private final int PORT = 8084;
    ServerSocket server;
    public PantallaServidor pantalla;
    ArrayList<ThreadServidor> threadsClientesAceptados;
    ArrayList<Jugador> jugadores;
    ServerConnectionsThread conexionsThread;
    public ProcesadorMensaje lector;

    public Servidor(PantallaServidor pantalla){
        this.pantalla = pantalla;
        connect();
        threadsClientesAceptados = new ArrayList<ThreadServidor>();
        conexionsThread = new ServerConnectionsThread(this);
        conexionsThread.start();
        jugadores = new ArrayList<Jugador>();
        lector = new ProcesadorMensaje(this);        
    }
    
    public void connect(){
        try {
            server = new ServerSocket(PORT);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void broadcoast(Mensaje mensaje) {
        String[] arregloMensaje = mensaje.getMensaje().split("-");
        if("CHAT".equals(arregloMensaje[0].toUpperCase())){
            mensaje.setMensaje(arregloMensaje[1]);
            mensaje.setTipo(TipoMensaje.PUBLICO);
            this.pantalla.write("Recibido: " + mensaje.toString());
            mensajeTodos(mensaje);
        } else if ("PRIVADO".equals(arregloMensaje[0].toUpperCase())){
            mensaje.setReceptor(arregloMensaje[1]);
            mensaje.setMensaje(arregloMensaje[2]);
            mensaje.setTipo(TipoMensaje.PRIVADO);
            this.pantalla.write("Recibido: " + mensaje.toString());
            privateMessage(mensaje);
        }else{
            String mensaje_procesado;
            try {
                mensaje_procesado = lector.leeMensaje(mensaje);
                mensaje.setMensaje(mensaje_procesado);
            } catch (IOException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.pantalla.write(mensaje.getMensaje());
        }
    }
    
    public void enviarDisparo(Mensaje mensaje_disparo){//El mensaje deberia venir con el mae que va recibir el pichaso
        ThreadServidor victima = this.bucarCliente("222");
        System.out.println(victima.jugador.acero);
        try {
            victima.salida.writeObject(mensaje_disparo);
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void privateMessage(Mensaje mensaje){
        
        for (ThreadServidor cliente : threadsClientesAceptados) {
            try {
                if(mensaje.getReceptor().equals(cliente.nombre)){
                    cliente.salida.writeObject(mensaje);
                    break;
                }
            } catch (IOException ex) {
            
            }
        }
        this.pantalla.write("Enviado " + threadsClientesAceptados.size() +" veces: " + mensaje);
        
    }
    public void mensajeTodos(Mensaje mensaje){
        for (ThreadServidor cliente : threadsClientesAceptados) {
            try {
                cliente.salida.writeObject(mensaje);
                //cliente.salida.
            } catch (IOException ex) {
       
            }
        }
        this.pantalla.write("Enviado " + threadsClientesAceptados.size() +" veces: " + mensaje);
    }
    
    Jugador buscarJugador(String nombre){
        for (Jugador jugador  : jugadores) {   
            if(nombre.toUpperCase().equals(jugador.nombre.toUpperCase()))
                return jugador;  
        }
        return null;
    }
    
    ThreadServidor bucarCliente(String nombre){
        for (ThreadServidor cliente  : threadsClientesAceptados) {
            if(nombre.toUpperCase().equals(cliente.nombre.toUpperCase()))
                return cliente;  
        }
        return null;
    }
    
}
