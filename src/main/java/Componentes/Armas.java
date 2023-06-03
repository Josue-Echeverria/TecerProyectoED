/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Componentes;

/**
 *  TO DO: PROGRAMAR TODOS LOS DISPAROS DE CADA CANION
 * @author admin
 */
public abstract class Armas{
    /*
    RETURNS:
    0 = ACERTO EL DISPARO
    1 = NO ACERTO EL DISPARO 
    2 = EL DISPARO DIO EN UN REMOLINO
    */
    public abstract int disparar(int x,int y);
}

class Canion extends Armas{
    int costo;
    Canion(){
        costo = 500;
    }
    @Override
    public int disparar(int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
class CanionMultiple extends Armas{
    int costo;
    CanionMultiple(){
        costo = 1000;
    }
    @Override
    public int disparar(int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
 
class Bomba extends Armas{
    int costo;
    Bomba(){
        costo = 2000;
    }
    @Override
    public int disparar(int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

class CanionBarbaRoja extends Armas{
    int costo;
    CanionBarbaRoja(){
        costo = 5000;
    }
    @Override
    public int disparar(int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

/*
• Cañón multiple: • Tiene un costo de 1000 Kg fabricarlo. • Si acierta un disparo de este tipo (atina algo del 
enemigo), se crean 4 disparos de torpedo al azar 
más (1x1 cada uno).

• Bomba: • Es un set de 3 cartuchos de dinamita que se 
colocan en un solo turno, en 3 celdas 
seleccionadas por el usuario. 
• Tienen un costo de 2000 Kg fabricarlos. • Cada bomba tiene un alcance de 1x2 o 2x1 
(aleatorio) 
• Cañón barba roja: • Tiene un costo de 5000 Kg. • Permite 10 cañones en un solo turno

*/