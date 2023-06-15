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
public class Mina extends Componente implements Serializable{
    int precio;
    public boolean esVisible;
    public ThreadMina thread;
    public Mina(Jugador jugador,int segundos_en_producir,int kgs_acero_que_produce) {
        thread = new ThreadMina(jugador,segundos_en_producir,kgs_acero_que_produce);
        thread.start();
        precio = 1000;
    }

    @Override
    public String getNombre() {
        return "la mina";
    }
}
