package Mar;

import Componentes.Armeria;
import Componentes.Componente;
import Componentes.Conector;
import Componentes.FuenteEnergia;
import Componentes.Mercado;
import Componentes.Mina;
import Componentes.TemploBruja;
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
    private FuenteEnergia fuenteEnergia;
    private Mercado mercadito;
    private TemploBruja templo;
    private Mina mina;
    private Armeria armeria;
    private Conector conector;
    private int cantidadBarcosGuerra;
    public boolean visibleEnemigo;
    int y;
    int x;

    public Isla(Componente componente){
         this.componente = componente;
    }
    public void setVisibleEnemigo(boolean visibleEnemigo) {
        this.visibleEnemigo = visibleEnemigo;
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
    
    public String getTipoIsla() {
        return tipoIsla;
    }

    public void setTipoIsla(String tipoIsla) {
        this.tipoIsla = tipoIsla;
    }
}
