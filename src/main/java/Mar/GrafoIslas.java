/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mar;

/**
 *
 * @author lmaag
 */

import java.util.ArrayList;
import java.util.List;
import Componentes.Conector;
public class GrafoIslas {
    private List<Isla> islas;
    private List<List<Conector>> conexiones;

    public GrafoIslas() {
        islas = new ArrayList<>();
        conexiones = new ArrayList<>();
    }

    public void agregarIsla(Isla isla) {
        islas.add(isla);
        conexiones.add(new ArrayList<>());
    }

    public void agregarConexion(Conector conector) {
    int isla1 = islas.indexOf(conector.getIsla1());
    int isla2 = islas.indexOf(conector.getIsla2());
    
    if (isla1 != -1 && isla2 != -1) {
        conexiones.get(isla1).add(conector);
        conexiones.get(isla2).add(conector);
    }
}

    public List<Isla> obtenerIslas() {
        return islas;
    }

    public List<Conector> obtenerAdyacentes(int isla) {
        return conexiones.get(isla);
    }
    
    public GrafoIslas[][] obtenerMatrizAdyacencia() {
        int numIslas = islas.size();
        GrafoIslas[][] matriz = new GrafoIslas[numIslas][numIslas];

        for (int i = 0; i < numIslas; i++) {
            for (int j = 0; j < numIslas; j++) {
                if (i == j) {
                    matriz[i][j] = null; // No hay conexión entre una isla y ella misma
                } else if (conexiones.get(i).contains(j)) {
                    matriz[i][j] = this; // El grafo de islas está conectado a la isla i
                } else {
                    matriz[i][j] = null; // No hay conexión entre las islas i y j
                }
            }
        }

        return matriz;
    }
}
