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
/**
 *
 * @author jecheverria
 */
public class Cliente {
    private final String IP = "localhost";
    private final int PORT = 8084;
    private Socket socket;
    ObjectOutputStream salida;
    private DataOutputStream salidaDatos;
    Pantalla pantalla;
    String nombre ;
    
    /*******PASAR ESTAS VARIABLES A CLASE JUGADOR********/
    public int acero;
    public int dinero;
    public boolean puede_usar_comodin;
    //public Mina mina;
    //public TemploBruja templo_bruja;
    
    
    /*******PASAR ESTAS VARIABLES A CLASE JUGADOR********/
    ThreadCliente threadCliente;

    public Cliente(Pantalla pantalla) {
        acero = 0;
        dinero = 0;
        puede_usar_comodin = false;
        this.pantalla = pantalla;
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
