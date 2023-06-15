/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import Cliente.Jugador;
import Componentes.Armas;
import GUI.Matriz;
import Mar.Isla;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author jecheverria
 */
public class Mensaje implements Serializable{
    private String enviador;
    private String mensaje;
    
    //
    public boolean iniciar_partida = false;
    public boolean request_iniciar_partida = false;
    //Cuanddo un jugador se conecta
    public ArrayList<String> playersConnected;
    public boolean isNewPlayer = false;
    
    //Para el boton de cada user
    public boolean isSolicitudPlayer = false;
    public boolean isRespuestaPlayer = false;
    public String playerName;
    public Matriz cuadricula[][];

    
    
    
    //Si el mensaje es un comodin
    private boolean comodin = false;
    
    //Si el mensaje es una compra 
    private boolean compra = false;
    
    //Si el mensaje es una venta de bienes:
    private boolean venta = false;
    
    //Si el mensaje es un jugador
    public boolean isjugador;

    //Si el mensaje es un disparo
    public boolean isdisparo = false;
    public boolean is_confirmation_hit = false;
    public boolean hit = false;
    public int[] bomba_xys;
  //  String nombre_isla;
    public ArrayList<ArrayList<Integer>> islasAfectadas = new ArrayList<>();
    String nombre_arma;
    int x;
    int y;
    
    
    public boolean isCompra() {
        return compra;
    }

    public void setCompra(boolean compra) {
        this.compra = compra;
    }
    private Jugador jugador;


    private TipoMensaje tipo;
    private String receptor;

    public Mensaje(String enviador, String mensaje, String receptor) {
        this.enviador = enviador;
        this.isjugador = false;
        this.venta = false;
        this.compra = false;
        this.mensaje = mensaje;
        this.receptor = receptor;
        this.tipo = TipoMensaje.PRIVADO;
    }
    
    public Mensaje(String enviador, String mensaje) {
        this.isjugador = false;
        this.enviador = enviador;
        this.venta = false;
        this.compra = false;
        this.mensaje = mensaje;
        this.tipo = TipoMensaje.PUBLICO;        
    }
    public Mensaje(Jugador jugador){
        this.isjugador = true;
        this.venta = false;
        this.compra = false;        
        this.jugador = jugador;
    }
    public Mensaje(String enviador,String Victima,String nombre,int x, int y){//cuando se envia un disparo entre jugadores 
        this.nombre_arma = nombre;
        this.x = x;
        this.y = y;
        this.enviador = enviador;
        this.receptor = Victima;
        this.isdisparo = true;
    }
    public Mensaje(String enviador,String Victima,String nombre,int[] xys){
        this.nombre_arma = nombre;
        this.bomba_xys = xys;
        this.enviador = enviador;
        this.receptor = Victima;
        this.isdisparo = true;
    }
    public Mensaje(String solicitante, boolean solicitudMatriz, String Nombre){
        this.isSolicitudPlayer = true;
        this.enviador = solicitante;
        this.playerName = Nombre;
    }
    public Mensaje (boolean isPlayerConnecting, ArrayList<String> nombres){
        this.isNewPlayer = true;
        this.playersConnected = nombres;
    }
    public Mensaje(boolean inicio_partida_request){
        this.request_iniciar_partida = inicio_partida_request;
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public boolean isVenta() {
        return venta;
    }

    public String getNombre_arma() {
        return nombre_arma;
    }

    public void setVenta(boolean venta) {
        this.venta = venta;
    }


    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public boolean isComodin() {
        return comodin;
    }

    public void setComodin(boolean comodin) {
        this.comodin = comodin;
    }

    
    @Override
    public String toString() {
        return "Mensaje "+ tipo + " de " + enviador + ": " + mensaje;
    }

    public String getEnviador() {
        return enviador;
    }

    public void setEnviador(String enviador) {
        this.enviador = enviador;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public TipoMensaje getTipo() {
        return tipo;
    }

    public void setTipo(TipoMensaje tipo) {
        this.tipo = tipo;
    }

    public String getReceptor() {
        return receptor;
    }

    public void setReceptor(String receptor) {
        this.receptor = receptor;
    }
    
    public String toStringVenta(){
        return "Venta de " + enviador + ": " + mensaje;
    }
    
    public String toStringCompra(){
        return "Compra de " + enviador + ": " + mensaje;
    }
/*
    public String getNombre_isla() {
        return nombre_isla;
    }

    public void setNombre_isla(String nombre_isla) {
        this.nombre_isla = nombre_isla;
    }*/
    
    
    
    
    
}
