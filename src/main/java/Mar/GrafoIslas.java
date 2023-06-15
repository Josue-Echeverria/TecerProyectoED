/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mar;

/**
 *
 * @author lmaag
 */
import Mar.Isla;
import java.util.ArrayList;
import java.util.List;
import Componentes.Conector;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;

public class GrafoIslas implements Serializable {
    private HashMap<Isla, ArrayList<Isla>> grafo;

    public GrafoIslas() {
        this.grafo = new HashMap<>();
    }

    public void agregarArista(Isla origen, Isla destino) {
        if (grafo.containsKey(origen)) {
            grafo.get(origen).add(destino);
        } else {
            ArrayList<Isla> destinos = new ArrayList<>();
            destinos.add(destino);
            grafo.put(origen, destinos);
        }
        if (grafo.containsKey(destino)) {
            grafo.get(destino).add(origen);
        } else {
            ArrayList<Isla> destinosOpuestos = new ArrayList<>();
            destinosOpuestos.add(origen);
            grafo.put(destino, destinosOpuestos);
        }
    }

    public ArrayList<ArrayList<Isla>> caminos(Isla inicio, Isla fin) {
        HashSet<Isla> visitados = new HashSet<>();
        ArrayList<Isla> caminoActual = new ArrayList<>();
        ArrayList<ArrayList<Isla>> caminosEncontrados = new ArrayList<>();
        encontrarCaminos(inicio, fin, visitados, caminoActual, caminosEncontrados);
        return caminosEncontrados;
    }

    private void encontrarCaminos(Isla nodoActual, Isla fin, HashSet<Isla> visitados, 
        ArrayList<Isla> caminoActual, ArrayList<ArrayList<Isla>> caminosEncontrados) {
        
        visitados.add(nodoActual);
        caminoActual.add(nodoActual);

        if (nodoActual.equals(fin)) {
            caminosEncontrados.add(new ArrayList<>(caminoActual));
        }

        if (grafo.containsKey(nodoActual)) {
            for (Isla vecino : grafo.get(nodoActual)) {
                if (!visitados.contains(vecino)) {
                    encontrarCaminos(vecino, fin, visitados, caminoActual, caminosEncontrados);
                }
            }
        }

        visitados.remove(nodoActual);
        caminoActual.remove(caminoActual.size() - 1);
    }
    
    public ArrayList<Isla> getDestinos(Isla origen) {
        if (grafo.containsKey(origen)) {
            return grafo.get(origen);
        }
        return null;
    }
    
    public void actualizarVisibilidadEnemigo(Isla isla) {
        if (grafo.containsKey(isla)) {
            ArrayList<Isla> destinos = grafo.get(isla);
            for (Isla destino : destinos) {
                destino.setVisibleEnemigo(true); // Actualizar el parámetro visibleEnemigo a true
                actualizarVisibilidadEnemigo(destino); // Llamada recursiva para los destinos conectados
            }
        }
    }
    public void borrarConexion(Isla origen, Isla destino) {
    if (grafo.containsKey(origen)) {
        ArrayList<Isla> destinos = grafo.get(origen);
        destinos.remove(destino);
    }
    
    if (grafo.containsKey(destino)) {
        ArrayList<Isla> destinosOpuestos = grafo.get(destino);
        destinosOpuestos.remove(origen);
    }
}

    public Isla borrarIsla(Isla isla) {
        if (grafo.containsKey(isla)) {
            // Eliminar conexiones asociadas a la isla a borrar
            ArrayList<Isla> destinos = grafo.get(isla);
            for (Isla destino : destinos) {
                grafo.get(destino).remove(isla);
            }

            grafo.remove(isla); // Eliminar la isla del grafo
            return isla;
        }
        return null;
    }
    public Isla buscarIslaPorCoordenadas(int x, int y) {
        for (Isla isla : grafo.keySet()) {
            if (isla.getX() == x && isla.getY() == y) {
                return isla;
            }
        }
        return null;
    }
}