/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Componentes;

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
    public abstract int disparar(int x,int y);
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
    
}

class Canion extends Armas{
    int costo;
    Canion(){
        costo = 500;
    }
    @Override
    public int disparar(int x, int y) {
        return 0;
    }
    
}
class CanionMultiple extends Armas{
    int costo;
    CanionMultiple(){
        costo = 1000;
    }
    @Override
    public int disparar(int x, int y) {
        return 0;
    }
}
 
class Bomba extends Armas{
    int costo;
    Bomba(){
        costo = 2000;
    }
    @Override
    public int disparar(int x, int y) {
        return 0;
    }
}

class CanionBarbaRoja extends Armas{
    int costo;
    CanionBarbaRoja(){
        costo = 5000;
    }
    @Override
    public int disparar(int x, int y) {
        return 0;
    }
}

/*

*/