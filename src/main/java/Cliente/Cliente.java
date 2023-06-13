/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cliente;

import Componentes.Armas;
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
import Mar.Isla;
import Modelos.Mensaje;
import java.util.Random;
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
    
    public void recibirDisparo(Mensaje mensaje){//
        if(mensaje.is_confirmation_hit){
            if(mensaje.hit){
                this.jugador.bitacora.append("Se acerto el disparo en la posicion ("+mensaje.getX()+","+mensaje.getY()+") y se volo "+mensaje.getNombre_isla() +"\n");
            }else{
                this.jugador.bitacora.append("Se fallo el disparo en la posicion ("+mensaje.getX()+","+mensaje.getY()+")\n");
            }
        }else{
            this.pantalla.recibirDisparo(mensaje.getEnviador(),mensaje.getNombre_arma(),mensaje.getX(),mensaje.getY());
            Isla victima = this.jugador.recibir_disparo(mensaje.getX(),mensaje.getY());
            if(victima != null){
                if(mensaje.getNombre_arma().toUpperCase().equals("CANION MULTIPLE")){
                    for(int i = 0; i <4;i++){
                        Random random = new Random();
                        int randomX = random.nextInt(20);
                        int randomY = random.nextInt(20);
                        this.pantalla.recibirDisparo(mensaje.getEnviador(),mensaje.getNombre_arma(),randomX,randomY);
                        this.jugador.recibir_disparo(randomX,randomY);
                    }
                }
                mensaje.is_confirmation_hit = true;
                mensaje.hit = true;
                mensaje.setNombre_isla(victima.componente.getNombre());

            }else{
                mensaje.is_confirmation_hit = true;
                mensaje.hit = false;
            }
            try {
                    this.salida.writeObject(mensaje);
                } catch (IOException ex) {
                    Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        
    }
}
