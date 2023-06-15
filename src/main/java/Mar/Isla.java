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
    public Isla(int x, int y, FuenteEnergia fuenteEner) {
        this.x = x;
        this.y = y;
        this.fuenteEnergia = fuenteEner;
    }

    public Isla(int x, int y, Mercado mercadito) {
        this.x = x;
        this.y = y;
        this.mercadito = mercadito;
    }

    public Isla(int x, int y, TemploBruja templo) {
        this.x = x;
        this.y = y;
        this.templo = templo;
    }

    public Isla(int x, int y, Mina mina) {
        this.x = x;
        this.y = y;
        this.mina = mina;
    }

    public Isla(int x, int y, Armeria armeria) {
        this.x = x;
        this.y = y;
        this.armeria = armeria;
    }

    public Isla(int x, int y, Conector conector) {
        this.x = x;
        this.y = y;
        this.conector = conector;
    }
    public void setTipoIsla(String tipoIsla) {
        this.tipoIsla = tipoIsla;
    }
        public FuenteEnergia getFuenteEner() {
        return fuenteEnergia;
    }

    public Mercado getMercadito() {
        return mercadito;
    }

    public TemploBruja getTemplo() {
        return templo;
    }

    public Mina getMina() {
        return mina;
    }

    public Armeria getArmeria() {
        return armeria;
    }

    public Conector getConector() {
        return conector;
    }
    public int tipoToInt(){
        String nombre = this.componente.getNombre();
        switch(nombre){
            case "la fuente de energia"->{
                return 0;
            }
            case "el conector"->{
                return 1;
            }
            case "el mercado"->{
                return 2;
            }
            case "la mina"->{
                return 3;
            }
            case "el templo de bruja"->{
                return 4;
            }
            case "la armeria"->{
                return 5;
            }
            
        }
        return -1;
    
    }
}
