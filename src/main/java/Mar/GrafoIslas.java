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
import Mar.Isla;
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
    
    public Isla[][] generarMatrizAdyacencia() {
        int numIslas = islas.size();
        Isla[][] matrizAdyacencia = new Isla[numIslas][numIslas];

        // Inicializar la matriz de adyacencia con ceros
        for (int i = 0; i < numIslas; i++) {
            for (int j = 0; j < numIslas; j++) {
                matrizAdyacencia[i][j] = new Isla("Null");
            }
        }

        // Llenar la matriz de adyacencia con las conexiones existentes
        for (int i = 0; i < numIslas; i++) {
            List<Conector> adyacentes = conexiones.get(i);
            for (Conector conector : adyacentes) {
                Isla isla1 = conector.getIsla1();
                Isla isla2 = conector.getIsla2();
                int indice1 = islas.indexOf(isla1);
                int indice2 = islas.indexOf(isla2);
                matrizAdyacencia[indice1][indice2] = matrizAdyacencia[indice2][indice1] = isla1;
            }
        }

        return matrizAdyacencia;
    }
}
