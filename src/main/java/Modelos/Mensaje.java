/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import Cliente.Jugador;
import Componentes.Armas;
import Mar.Isla;
import java.io.Serializable;

/**
 *
 * @author jecheverria
 */
public class Mensaje implements Serializable{
    private String enviador;
    private String mensaje;
    //Si el mensaje es un comodin
    private boolean comodin;
    
    //Si el mensaje es una compra 
    private boolean compra;
    
    //Si el mensaje es una venta de bienes:
    private boolean venta;
    
    //Si el mensaje es un jugador
    public boolean isjugador;

    //Si el mensaje es un disparo
    public boolean isdisparo;
    public boolean is_confirmation_hit;
    public boolean hit;
    String nombre_isla;
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
    public Mensaje(String enviador,String nombre,int x, int y){//cuando se envia un disparo entre jugadores 
        this.nombre_arma = nombre;
        this.x = x;
        this.y = y;
        this.enviador = enviador;
        this.isdisparo = true;
        this.isjugador = false;
        this.venta = false;
        this.compra = false;
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

    public String getNombre_isla() {
        return nombre_isla;
    }

    public void setNombre_isla(String nombre_isla) {
        this.nombre_isla = nombre_isla;
    }
    
    
    
    
    
}
