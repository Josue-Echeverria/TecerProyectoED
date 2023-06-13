/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Componentes;

/**@author admin
 * TODO:
 * METODO COMPRAR_ARMA DEBERIA DE RECIBIR EL JUGADOR EN VEZ DEL HIERRO PARA RESTARLE EL HIERRO QUE CUESTA LA ARMA DE UN SOLO
 * 
 */

/*
    Tipos de arma:
    0 = Canion
    1 = CanionMultiple
    2 = Bomba
    3 = CanionBarbaRoja
*/
public class Armeria extends Componente{
    int precio;
    int tipo;
    public Armeria(int tipo) {
        this.tipo = tipo;
        precio = 1500;
    }
    
    

    Armas comprar_arma(int hierro){
        switch(tipo){
            case 0 -> {
                if(hierro >= 500)
                    return new Canion();
                else
                    return null;
            }
            case 1 -> {
                if(hierro > 1000)
                    return new CanionMultiple();
                else
                    return null;
            }
            case 2 -> {
                if(hierro >= 2000)
                    return new Bomba();
                else
                    return null;
            }
            case 3 -> {
                if(hierro >= 5000)
                    return new CanionBarbaRoja();        
                else
                    return null;
            }
        }
        return null;
    }

    @Override
    public String getNombre() {
        return "la armeria";
    }
    
}
