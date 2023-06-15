/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Componentes;

import Cliente.Cliente;
import Cliente.Jugador;
import java.io.Serializable;


/**
 *
 * @author admin
 */
public class TemploBruja extends Componente implements Serializable{
    int precio;
    public boolean esVisible;
    ThreadTemploBruja thread_templo_bruja;
    public TemploBruja(Jugador jugador) {
        precio = 2500;
        thread_templo_bruja = new ThreadTemploBruja(jugador);
        thread_templo_bruja.start();
    }

    @Override
    public String getNombre() {
        return "el templo de bruja";
    }
    
}
