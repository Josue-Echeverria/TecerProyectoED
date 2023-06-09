/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Componentes;


import Cliente.Cliente;
import Cliente.Jugador;
import java.util.Random;
/**
 *
 * @author admin
 */
public class ThreadTemploBruja extends Thread{
    TemploBruja templo_bruja;
    private boolean isRunning = true;
    private boolean isPaused = false;
   // private javax.swing.JLabel refPantalla;
    private int contador = 0;
    private int contadorMinutos = 0;
     private int contadorHoras = 0;
    //CAMBIAR CLIENTE POR JUGADOR
    public Jugador jugador;
    public ThreadTemploBruja(Jugador jugador) {
        this.jugador = jugador;
    } 
    @Override
    public void run(){
        while (isRunning){
            try {
                sleep(1000);
                contador++;
                if (contador == 60){
                    contadorMinutos += 1;
                    contador = 0;
                }
                if(contadorMinutos == 1){//AQUI DEBERIA DE HABILITAR LOS COMODINES 
                    Random random = new Random();
                    jugador.comodin = random.nextInt(2) + 1;
                    jugador.avisarComodinDisponible();
                    contadorMinutos = 0;
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
