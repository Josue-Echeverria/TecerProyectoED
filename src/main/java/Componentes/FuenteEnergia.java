/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Componentes;

import java.io.Serializable;

/**
 *
 * @author lmaag
 */
public class FuenteEnergia extends Componente implements Serializable{
    private int precio;  // Precio de la fuente de energía
    private boolean destruido;  // Indica si les destruyeron la fuente
    private int posicionX;  // Ubicación en el mar X
    private int posicionY;  // Ubicación en el mar Y
    private boolean visiblePropio;
    private boolean visibleEnemigo;
    
    // Métodos

    public boolean isDestruido() {
        return destruido;
    }

    public void setDestruido(boolean destruido) {
        this.destruido = destruido;
    }

    public int getPosicionX() {
        return posicionX;
    }

    public void setPosicionX(int posicionX) {
        this.posicionX = posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }

    public void setPosicionY(int posicionY) {
        this.posicionY = posicionY;
    }

    @Override
    public String getNombre() {
        return "la fuente de energia";
    }

    
    
}
