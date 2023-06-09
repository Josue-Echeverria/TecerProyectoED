package Mar;

import Componentes.Componente;
import java.io.Serializable;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author lmaag
 */
public class Isla implements Serializable  {
    public Componente componente;
    public String tipoIsla;
    private boolean FuenteEnergia;
    private boolean Fabrica;
    private boolean Templo;
    private boolean Mercado;
    private int cantidadBarcosGuerra;
    int y;
    int x;

    public Isla(Componente componente){
         this.componente = componente;
    }

    public boolean isFuenteEnergia() {
        return FuenteEnergia;
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    


/*
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
*/
    public String getTipoIsla() {
        return tipoIsla;
    }

    public void setTipoIsla(String tipoIsla) {
        this.tipoIsla = tipoIsla;
    }
}
