/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Componentes;

/**
 *
 * @author lmaag
 */
import Mar.Isla; 
        
public class Conector {
    private Isla isla1;
    private Isla isla2;

    public Conector(Isla isla1, Isla isla2) {
        this.isla1 = isla1;
        this.isla2 = isla2;
    }

    public Isla getIsla1() {
        return isla1;
    }

    public Isla getIsla2() {
        return isla2;
    }
}
