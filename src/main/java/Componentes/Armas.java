/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Componentes;

import Mar.GrafoIslas;
import java.io.Serializable;

/**
 *  TO DO: PROGRAMAR TODOS LOS DISPAROS DE CADA CANION
 * @author admin
 */
public abstract class Armas implements Serializable{
    
    /*
    RETURNS:
    0 = ACERTO EL DISPARO
    1 = NO ACERTO EL DISPARO 
    2 = EL DISPARO DIO EN UN REMOLINO
    */
    public Armas(){
        
    }
    public abstract Armas disparar();
    public Canion cargarCanion(){
        return new Canion();
    }
    public CanionMultiple cargarCanionMultiple(){
        return new CanionMultiple();
    }
    public Bomba cargarBomba(){
        return new Bomba();
    }
    public CanionBarbaRoja cargarCanionBarbaRoja(){
        return new CanionBarbaRoja();
    }
    public abstract void setXY(int x,int y);
    public abstract int getX();
    public abstract int getY();
    public abstract String getName();
    
}

class Canion extends Armas{
    int costo;
    int x;
    int y;
    Canion(){
        costo = 500;
    }
    @Override
    public Armas disparar() {
    
        return new Armas() {
            public Armas disparar() {
                return null;
            }
            @Override
            public void setXY(int x, int y) {
            }
            @Override
            public int getX() {
                return -1;
            }
            @Override
            public int getY() {
                return -1;
            }
            @Override
            public String getName() {
                return "";
            }
        };
        
    }

    @Override
    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public String getName() {
        return "Canion";
    }
    
}
class CanionMultiple extends Armas{
    int costo;
    int x;
    int y;
    CanionMultiple(){
        costo = 1000;
    }
    @Override
    public Armas disparar() {
        return new Armas() {
            public Armas disparar() {
                return null;
            }
            @Override
            public void setXY(int x, int y) {
            }
            @Override
            public int getX() {
                return -1;
            }
            @Override
            public int getY() {
                return -1;
            }
            @Override
            public String getName() {
                return "";
            }
            };
    }

    @Override
    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;    }
    
    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public String getName() {
        return "Canion multiple";
    }
}
 
class Bomba extends Armas{
    int costo;
    int x;
    int y;
    Bomba(){
        costo = 2000;
    }
    @Override
    public Armas disparar() {
       return new Armas() {
            public Armas disparar() {
                return null;
            }
            @Override
            public void setXY(int x, int y) {
            }
            @Override
            public int getX() {
                return -1;
            }
            @Override
            public int getY() {
                return -1;
            }
            @Override
            public String getName() {
                return "";
            }
        };
    }

    @Override
    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public String getName() {
        return "Bomba";
    }
}

class CanionBarbaRoja extends Armas{
    int costo;
    int disparos_disponibles;
    int x;
    int y;    
    CanionBarbaRoja(){
        costo = 5000;
        disparos_disponibles = 9;
    }
    
    @Override
    public Armas disparar() {
        if(this.disparos_disponibles == 0){
            return new Armas() {
            public Armas disparar() {
                return null;
            }
            @Override
            public void setXY(int x, int y) {
            }
            @Override
            public int getX() {
                return -1;
            }
            @Override
            public int getY() {
                return -1;
            }
            @Override
            public String getName() {
                return "";
            }
            };
        }else{
            this.disparos_disponibles--;
            return this;
        }
    }

    @Override
    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public String getName() {
        return "Canion barba roja";
    }
}