/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.util.ArrayList;
import javax.swing.JLabel;

/**
 *
 * @author hdani
 */
public class Matriz {
    private javax.swing.JPanel label;
    private boolean isla;
    private int tipoIsla;
    private boolean barco;
    private boolean fuente;
    private boolean conector;
    public Matriz(boolean isla, int tipoIsla, boolean barco, boolean fuente, boolean conector) {
        this.isla = isla;
        this.tipoIsla = tipoIsla;
        this.barco = barco;
        this.fuente = fuente;
    }   
}
