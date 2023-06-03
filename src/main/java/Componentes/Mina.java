 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Componentes;

import Cliente.Pantalla;
import Cliente.Cliente;
/**
 *
 * @author admin
 */
public class Mina extends Componente{
    int precio;
    public ThreadMina thread;
    public Mina(javax.swing.JLabel label,Cliente cliente,int segundos_en_producir,int kgs_acero_que_produce) {
        thread = new ThreadMina(label,cliente,segundos_en_producir,kgs_acero_que_produce);
        thread.start();
        precio = 1000;
    }
}
