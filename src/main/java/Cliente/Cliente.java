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
            JOptionPane.showMessageDialog(null, "Servidor lleno imposible conectar", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void recibirDisparo(Mensaje mensaje){//
        if(mensaje.is_confirmation_hit){
            escribirDisparoEnBitacora(mensaje);
        }else{
            if(mensaje.getNombre_arma().equals("Kraken")) {
                this.pantalla.invocarKraken(mensaje.getEnviador());
                //this.jugador.recibirKraken();
                ArrayList<ArrayList<Integer>> victima = this.jugador.recibirKraken();
                
                mensaje.is_confirmation_hit = true;
                mensaje.hit = true;
               // mensaje.setNombre_isla(victima.get(0).componente.getNombre());
                mensaje.islasAfectadas = victima;
                this.pantalla.disparoAcertado(intToTipo(victima.get(0).get(2)));
            }
            if(mensaje.getNombre_arma().equals("Bomba")){
                this.pantalla.recibirDisparo(mensaje.getEnviador(),mensaje.getNombre_arma(), mensaje.bomba_xys);
                this.jugador.recibir_disparo(mensaje.getX(),mensaje.getY());
                ArrayList<ArrayList<Integer>> victima = null;
                for(int i = 0; i <2;i++){
                    victima = this.jugador.recibir_disparo( mensaje.bomba_xys[i], mensaje.bomba_xys[i+1]);
                    if(!victima.isEmpty())
                        break;
                }
                if(victima != null){
                    mensaje.bomba_xys[0] = victima.get(0).get(0);
                    mensaje.bomba_xys[1] = victima.get(0).get(1);
                    mensaje.is_confirmation_hit = true;
                    mensaje.hit = true;
                   // mensaje.setNombre_isla(victima.get(0).componente.getNombre());
                    mensaje.islasAfectadas = victima;
                    this.pantalla.disparoAcertado(intToTipo(victima.get(0).get(2)));
                }else{
                    mensaje.is_confirmation_hit = true;
                    mensaje.hit = false;
                    this.pantalla.disparoFallado();
                }
            }else{
                this.pantalla.recibirDisparo(mensaje.getEnviador(),mensaje.getNombre_arma(),mensaje.getX(),mensaje.getY());
               
                ArrayList<ArrayList<Integer>> victima = this.jugador.recibir_disparo(mensaje.getX(),mensaje.getY());
               
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
                   // mensaje.setNombre_isla(victima.get(0).componente.getNombre());
                    mensaje.islasAfectadas = victima;
                    this.pantalla.disparoAcertado(intToTipo(victima.get(0).get(2)));

                }else{
                    this.pantalla.disparoFallado();
                    mensaje.is_confirmation_hit = true;
                    mensaje.hit = false;
                }
            }
            mensaje.setReceptor(mensaje.getEnviador());
            try {
                this.salida.writeObject(mensaje);
            } catch (IOException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void recibirNewPlayers(ArrayList<String> nombres){
        this.pantalla.disablePlayerButtons();
        for(String newplayername :nombres){
            System.out.println(newplayername);
            if(newplayername.equals(this.nombre)){
                continue;
            }
            if(!this.pantalla.getjButton_player1().isEnabled()){
                this.pantalla.getjButton_player1().setText(newplayername);
                this.pantalla.getjButton_player1().setEnabled(true);
                continue;
            }
            if(!this.pantalla.getjButton_player2().isEnabled()){
                this.pantalla.getjButton_player2().setText(newplayername);
                this.pantalla.getjButton_player2().setEnabled(true);
                continue;            
            }
            if(!this.pantalla.getjButton_player3().isEnabled()){
                this.pantalla.getjButton_player3().setText(newplayername);
                this.pantalla.getjButton_player3().setEnabled(true);
                continue;
            }
        }
    }
    public void escribirDisparoEnBitacora(Mensaje mensaje){
        if(mensaje.getNombre_arma().equals("Bomba")){
            if(mensaje.hit)
                this.jugador.bitacora.append("Se acerto el disparo en la posicion ("+mensaje.bomba_xys[0]+","+mensaje.bomba_xys[1]+") y se volo "+intToTipo(mensaje.islasAfectadas.get(0).get(2)) +"\n");
            else
                this.jugador.bitacora.append("Se fallo la bomba en las posiciones ("+mensaje.bomba_xys[0]+","+mensaje.bomba_xys[1]+") y ("+mensaje.bomba_xys[2]+","+mensaje.bomba_xys[3]+")\n");
        }else{
            if(mensaje.hit)
                this.jugador.bitacora.append("Se acerto el disparo en la posicion ("+mensaje.getX()+","+mensaje.getY()+") y se volo "+intToTipo(mensaje.islasAfectadas.get(0).get(2)) +"\n");
            else
                this.jugador.bitacora.append("Se fallo el disparo en la posicion ("+mensaje.getX()+","+mensaje.getY()+")\n");
        }
    }
    public void iniciar_partida(){
        
    }
    String intToTipo(int entero){
        switch(entero){
            case 0->{
                return "la fuente de energia";
            }
            case 1->{
                return "el conector";
            }
            case 2->{
                return "el mercado";
            }
            case 3->{
                return "la mina";
            }
            case 4->{
                return "el templo de bruja";
            }
            case 5->{
                return "la armeria";
            }
            
        }
        return null;
    }
}
