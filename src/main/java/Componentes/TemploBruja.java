/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Componentes;

import Cliente.Cliente;
import Cliente.Pantalla;


/**
 *
 * @author admin
 */
public class TemploBruja extends Componente{
    int precio;
    ThreadTemploBruja thread_templo_bruja;
    public TemploBruja(javax.swing.JLabel label,Cliente cliente) {
        precio = 2500;
        thread_templo_bruja = new ThreadTemploBruja(label,cliente);
        thread_templo_bruja.start();
    }
    
}
