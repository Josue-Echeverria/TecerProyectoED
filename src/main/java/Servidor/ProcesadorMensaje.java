/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servidor;

import Cliente.Cliente;
import Cliente.Jugador;
import Modelos.Mensaje;
import Servidor.Servidor;
import Servidor.Servidor;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author admin
 */
public class ProcesadorMensaje {
    public Servidor server;
    public String[] arregloMensaje;
    public ProcesadorMensaje(Servidor server) {
        this.server = server;
    }
    
    public String leeMensaje(Mensaje mensaje_recibido) throws IOException{
        arregloMensaje = mensaje_recibido.getMensaje().split("-");
        switch (arregloMensaje[0].toUpperCase()) {
            case "DISPARAR":
                return "Disparo a: ";
            case "VENDER":// ejemplo: VENDER-ACERO-10000-JUGADOR-500
                          // (COMANDO)-(VENDIENDO)-(CANTIDAD VENDIENDO)-(POSIBLE COMPRADOR)-(PRECIO)
                Jugador jugador_vendiendo = this.server.buscarJugador(mensaje_recibido.getEnviador());
                if(jugador_vendiendo.confirmaVenta(arregloMensaje[1].toUpperCase(), Integer.parseInt(arregloMensaje[2]))){// if returns true le alcanza pa vender
                    Jugador jugador_comprando = this.server.buscarJugador(arregloMensaje[3]);
                    if(jugador_comprando == null){
                        jugador_vendiendo.jugadorInexistente();
                        return mensaje_recibido.toStringVenta()+"\nVenta sin exito(jugador no existe)";
                    }
                    ThreadServidor cliente_comprando = this.server.bucarCliente(arregloMensaje[3]);
                    mensaje_recibido.setVenta(true);
                    cliente_comprando.salida.writeObject(mensaje_recibido);
                    return mensaje_recibido.toStringVenta();
                    
                }else
                    return mensaje_recibido.toStringVenta()+"\nVenta sin exito(el usuario no tiene suficiente dinero)";
            case "COMPRAR":
                    ThreadServidor cliente_vendiendo = this.server.bucarCliente(arregloMensaje[1]);
                    mensaje_recibido.setCompra(true);
                    cliente_vendiendo.salida.writeObject(mensaje_recibido);
                      /*  Jugador jugador_vendiendo2 = ;
                        System.out.println(jugador_vendiendo2.nombre);
                        System.out.println(jugador_vendiendo2.acero);
                        jugador_vendiendo2*///this.server.buscarJugador(arregloMensaje[1].toUpperCase()).vender(arregloMensaje[2].toUpperCase(),Integer.parseInt(arregloMensaje[3]), Integer.parseInt(arregloMensaje[4]));
                return "Venta realizada con exito";
           /* case "COMODIN":
                ThreadServidor cliente_usando_comodin = this.server.bucarCliente(mensaje_recibido.getEnviador());
                if(arregloMensaje[1].toUpperCase() == "ESCUDO"){
                    Random random = new Random();
                    mensaje_recibido.setComodin(true);
                    cliente_usando_comodin.salida.writeObject(new Mensaje()) = 
                    cliente_usando_comodin.avisarEscudoActivo();
                }
                return "El usuario utilizara su comodin";
            */default:
                
                return "Error";
        } 
    }
    
    
}
