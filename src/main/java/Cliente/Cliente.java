/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cliente;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Componentes.Mina;
import Componentes.Armeria;
import Componentes.ThreadMina;
import Componentes.TemploBruja;
import GUI.Play;
/**
 *
 * @author jecheverria
 */
public class Cliente {
    private final String IP = "localhost";
    private final int PORT = 8084;
    private Socket socket;
    public ObjectOutputStream salida;
    private DataOutputStream salidaDatos;
  //  Pantalla pantalla;
    Play pantalla;
    public Jugador jugador;
    public String nombre ;
    

    ThreadCliente threadCliente;

    public Cliente(Play matriz) {
        this.pantalla = matriz;
        conectar();
    }

    
    
    public void conectar(){
        try {
            socket = new Socket(IP, PORT);
            salida = new ObjectOutputStream(socket.getOutputStream());
            salidaDatos = new DataOutputStream(socket.getOutputStream());
            threadCliente = new ThreadCliente(socket, this);
            threadCliente.start();
            this.nombre = JOptionPane.showInputDialog("Nombre: ");
            
            salidaDatos.writeUTF(nombre);
        } catch (IOException ex) {
            
        }
    }
}
