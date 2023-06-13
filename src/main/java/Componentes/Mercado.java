/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Componentes;

/**
 *
 * @author admin
 */
public class Mercado extends Componente{
    int precio;
    public boolean esVisible;
    public Mercado() {
        precio = 2000;
    }

    @Override
    public String getNombre() {
        return "el mercado";
    }
}
