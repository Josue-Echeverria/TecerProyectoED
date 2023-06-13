/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JLabel;

/**
 *
 * @author hdani
 */
public class Matriz {
    private JLabel label;
    private int tipo; //   0 = vacio, 1 = fuente, 2 = mercado, 3 = conector, 4 = mina, 5 = templo, 6 = armeria.
    public Matriz(JLabel label) {
        this.label = label;
        this.tipo = 0;
    }  
    
    public void cambieColor(String tipo){
        Color custom;
        switch (tipo){
            case "Fuente":
                custom = new Color(204, 0, 51);
                label.setBackground(custom);
                this.tipo = 1;
                break;
            case "Conector":     
                custom = new Color(242, 242, 242);
                label.setBackground(custom);
                this.tipo = 3;
                break;
            case "Mercado":
                custom = new Color(0, 204, 0);
                label.setBackground(custom);
                this.tipo = 2;
                break;
        }
    }
    
    public void setText(String text){
        this.label.setText(text);
    }
}
