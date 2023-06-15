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
import java.io.Serializable;
        
public class Conector extends Componente implements Serializable{
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

    public void setIsla1(Isla isla1) {
        this.isla1 = isla1;
    }

    public void setIsla2(Isla isla2) {
        this.isla2 = isla2;
    }

    @Override
    public String getNombre() {
        return "un conector";
        }
    
    
}
