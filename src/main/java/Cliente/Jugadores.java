/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cliente;
import Mar.GrafoIslas;
import Componentes.Armeria;
import Mar.Isla;
/**
 *
 * @author lmaag
 */
public class Jugadores {
    public GrafoIslas grafos;
    public Armeria armas;
    public boolean admin;
    public Isla[][] matriz;

    public Jugadores(GrafoIslas grafos, Armeria armas, boolean admin) {
        this.grafos = grafos;
        this.armas = armas;
        this.admin = admin;
        this.matriz = this.grafos.generarMatrizAdyacencia();
    }
    
    public void AñadirIslas(Isla isla) {
        for (int i = 0; i < this.matriz.length; i++) {
            for (int j = 0; j < this.matriz[i].length; j++) {
                if (this.matriz[i][j] == null) {
                    matriz[i][j] = isla;
                    isla.setX(i);
                    isla.setY(j);
                }
            }
        }
    }
    
}
