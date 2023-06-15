/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Componentes;

import Cliente.Cliente;
import Cliente.Jugador;
import java.io.Serializable;

import static java.lang.Thread.sleep;

/**
 *
 * @author admin
 */
public class ThreadMina extends Thread implements Serializable{
    Mina mina;
    private boolean isRunning = true;
    private boolean isPaused = false;
    private int contador = 0;
    int segundos_en_producir;
    int kgs_acero_que_produce;
    private int contadorMinutos = 0;
    private String segundos;
    private String minutos;
    public Jugador jugador ;
    public ThreadMina(Jugador jugador,int segundos_en_producir,int kgs_acero_que_produce) {
        this.jugador = jugador;
        this.kgs_acero_que_produce = kgs_acero_que_produce;
        this.segundos_en_producir = segundos_en_producir;
    } 
    @Override
    public void run(){
        while (isRunning){
            try {
                sleep(1000);
                contador++;
                if (contador == segundos_en_producir){
                    jugador.acero += kgs_acero_que_produce;
                    jugador.actualizar_acero();
                    contador = 0;
                }
                
            } catch (InterruptedException ex) {
            }
        }
    }
    public boolean pausa(){
        this.isPaused = !this.isPaused;
        return this.isPaused;
    }
    
    public void finish(){
        this.isRunning = false;
        this.isPaused = false;
    }
}
