/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Componentes;

import Cliente.Cliente;
import Cliente.Pantalla;
import static java.lang.Thread.sleep;

/**
 *
 * @author admin
 */
public class ThreadMina extends Thread{
    Mina mina;
    private boolean isRunning = true;
    private boolean isPaused = false;
    private javax.swing.JLabel refPantalla;
    private int contador = 0;
    int segundos_en_producir;
    int kgs_acero_que_produce;
    private int contadorMinutos = 0;
    private String segundos;
    private String minutos;
    public Cliente cliente;
    public ThreadMina(javax.swing.JLabel refPantalla,Cliente cliente,int segundos_en_producir,int kgs_acero_que_produce) {
        this.cliente = cliente;
        this.kgs_acero_que_produce = kgs_acero_que_produce;
        this.segundos_en_producir = segundos_en_producir;
        this.refPantalla = refPantalla;
    } 
    @Override
    public void run(){
        while (isRunning){
            try {
                sleep(1000);
                contador++;
                
                if (contador == segundos_en_producir){
                    cliente.acero += kgs_acero_que_produce;
                }
                if (contadorMinutos == 60){
                    contadorMinutos += 1;
                    contador = 0;
                }
                if(contador < 10){
                    
                    segundos = ("0"+Integer.toString(contador));
                }else{
                    segundos = (Integer.toString(contador));
                }
                if(contadorMinutos < 10){
                    
                    minutos = ("0"+Integer.toString(contadorMinutos));
                }else{
                     minutos = (Integer.toString(contadorMinutos));
                }
                if(contadorMinutos == 5){//AQUI DEBERIA DE HABILITAR LOS COMODINES 
   
                }else{ //AQUI DEBERIA DE SER DONDE MODIFICA LA INTERFAZ
                    System.out.println(minutos+":"+segundos);
                    refPantalla.setText(minutos+":"+segundos);
                    
                }
            } catch (InterruptedException ex) {
            }
            
            while (isPaused) {                
                try {
                    sleep(500);
                } catch (InterruptedException ex) {
                }
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
