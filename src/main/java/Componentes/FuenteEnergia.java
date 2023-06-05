/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Componentes;

/**
 *
 * @author lmaag
 */
public class FuenteEnergia {
    private int precio;  // Precio de la fuente de energía
    private boolean destruido;  // Indica si les destruyeron la fuente
    private int posicionX;  // Ubicación en el mar X
    private int posicionY;  // Ubicación en el mar Y
    
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

    
    
}
