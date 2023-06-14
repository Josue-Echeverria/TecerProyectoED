/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cliente;

import Componentes.Armas;
import Componentes.Armeria;
import Mar.GrafoIslas;
import Mar.Isla;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author admin
 */

public class Jugador implements Serializable{
    
    public int acero;
    public javax.swing.JLabel label_acero;
    public int dinero;
    public javax.swing.JLabel label_dinero;
    public int comodin = 1;
    public boolean acepto_oferta;
    public Armas arma_cargada;
    public int canion = 10;
    private javax.swing.JLabel boton_canion;
    public int canion_multiple = 10;
    private javax.swing.JLabel boton_canion_multiple;
    public int canion_barba_roja = 10;
    private javax.swing.JLabel boton_canion_barba_roja;
    public int bomba = 10;
    private javax.swing.JLabel boton_bomba;
    public javax.swing.JTextArea bitacora;
    
    public GrafoIslas grafo;
    private int disparos_barba_roja;
    public boolean tiene_mercado;    
    public String nombre;
    public boolean puede_colocar_mercado = false;
    public boolean puede_colocar_armeria = false;
    public boolean puede_colocar_mina = false;
    public boolean puede_colocar_templo = false;
    public int escudos = 0;
    public GrafoIslas grafos;
    public Armeria armas;
    public boolean admin;
    public Isla[][] matriz;
    public String target;
    
    public Jugador(String nombre){
        this.nombre = nombre;
        acero = 100000;
        this.comodin = 1;
        dinero = 100000;
        this.arma_cargada = new Armas() {
            @Override
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

            @Override
            public void setXY(int[] pos) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public int[] getXY() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        };
        grafo = new GrafoIslas();
     //   comodin = 0;
    }
    public Jugador(GrafoIslas grafos, Armeria armas, boolean admin) {
        this.grafos = grafos;
        this.armas = armas;
        this.admin = admin;
        this.matriz = this.grafos.generarMatrizAdyacencia();
    }

    /*
    Confirma si se tiene suficiente de lo que quiere vender
    */
    public boolean confirmaVenta(String clase, int cantidad){
        switch(clase.toUpperCase()){
            case "ACERO" -> {
                return this.acero >= cantidad;
            }
            case "CANION" -> {
                return this.canion >= cantidad;
            }
            case "CANION MULTIPLE" -> {
                return this.canion_multiple >= cantidad;
            }
            case "BOMBA" -> {
                return this.bomba >= cantidad;
            }
            case "CANION BARBA ROJA" -> {
                return this.canion_barba_roja >= cantidad;
            } 
        }
        return false;
    }
    
    
    public void recibirOferta(String clase,int cantidad ,int precio, String nombre_vendedor){
        this.acepto_oferta = false;
        int option = JOptionPane.showOptionDialog(null,
                "El jugador "+nombre_vendedor+" te quiere vender "+cantidad+ " de "+clase+" por "+precio+" unidades",
                "Oferta", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
        
        if (option == JOptionPane.OK_OPTION) {
            if(confirmarCompra(precio)){
                comprar(clase,cantidad,precio);
                JOptionPane.showMessageDialog(null, "Compra exitosa", "Aviso", JOptionPane.WARNING_MESSAGE);
                acepto_oferta = true;
            }else 
                JOptionPane.showMessageDialog(null, "No tienes suficiente dinero", "Aviso", JOptionPane.WARNING_MESSAGE);
        } else if (option == JOptionPane.CANCEL_OPTION || option == JOptionPane.CLOSED_OPTION) {
            
        }
    }
    
    public void comprar(String clase,int cantidad, int precio){
        switch(clase.toUpperCase()){
            case "ACERO" -> {
                this.dinero -= precio;
                this.acero += cantidad;
                this.label_acero.setText("Acero: "+this.acero);
                this.label_dinero.setText("Dinero: "+this.dinero);
            }
            case "CANION" -> {
                this.dinero -= precio;
                this.canion += cantidad;
                actualizarArmas();
                actualizar_dinero();
            }
            case "CANION MULTIPLE" -> {
                this.dinero -= precio;
                this.canion_multiple += cantidad;
                actualizarArmas();
                actualizar_dinero();
            }
            case "BOMBA" -> {
                this.dinero -= precio;
                this.bomba += cantidad;            
                actualizarArmas();
                actualizar_dinero();
            }
            case "CANION BARBA ROJA" -> {
                this.dinero -= precio;
                this.canion_barba_roja += cantidad;
                actualizarArmas();
                actualizar_dinero();
            } 
        }
    }

    
    public void vender(String clase,int cantidad, int precio){
        switch(clase.toUpperCase()){
            case "ACERO" -> {
                this.dinero += precio;
                this.acero -= cantidad;
                actualizar_acero();
                actualizar_dinero();
            }
            case "CANION" -> {
                this.dinero += precio;
                this.canion -= cantidad;
                actualizarArmas();
                actualizar_dinero();
            }
            case "CANION MULTIPLE" -> {
                this.dinero += precio;
                this.canion_multiple -= cantidad;
                actualizarArmas();
                actualizar_dinero();
            }
            case "BOMBA" -> {
                this.dinero += precio;
                this.bomba -= cantidad;
                actualizarArmas();
                actualizar_dinero();
            }
            case "CANION BARBA ROJA" -> {
                this.dinero += precio;
                this.canion_barba_roja -= cantidad;
                actualizarArmas();
                actualizar_dinero();
            } 
        }
    }
    

    public void actualizarArmas(){
        this.boton_canion.setText("Canion * "+this.canion);
        this.boton_canion_multiple.setText("Canion multiple * "+this.canion_multiple);
        this.boton_canion_barba_roja.setText("Canion barba roja * "+this.canion_barba_roja);
        this.boton_bomba.setText("Bomba * "+this.bomba);
    }
    
    public void cargar_arma(String arma){
        switch(arma){
            case "CANION" -> {
                this.arma_cargada = arma_cargada.cargarCanion();
                JOptionPane.showMessageDialog(null, "Has cargado el canion, selecciona una casilla enemiga para disparar", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
            case "CANION MULTIPLE" -> {
                this.arma_cargada = arma_cargada.cargarCanionMultiple();
                JOptionPane.showMessageDialog(null, "Has cargado el canion multiple, selecciona una casilla enemiga para disparar", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
            case "BOMBA" -> {
                this.arma_cargada = arma_cargada.cargarBomba();
                JOptionPane.showMessageDialog(null, "Has cargado el bomba, selecciona una casilla enemiga para disparar", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
            case "CANION BARBA ROJA" -> {
                this.arma_cargada = arma_cargada.cargarCanionBarbaRoja();
                JOptionPane.showMessageDialog(null, "Has cargado el canion barba roja, selecciona una casilla enemiga para disparar", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    
    public void restarArma(String nombre){
        switch(nombre.toUpperCase()){
            case "CANION" -> {
                this.canion--;
                break;
            }
            case "CANION MULTIPLE" -> {
                this.canion_multiple--;
                break;
            }
            case "BOMBA" -> {
                this.bomba--;
                break;
            }
            case "CANION BARBA ROJA" -> {
                this.canion_barba_roja--;
                break;
            }
        }
    }
    
    //deberia de restar a la arma que tenia cargada
    public void disparar_arma_cargada(){
        escribirDisparoBitacora();
        String name = arma_cargada.getName();
        this.arma_cargada = arma_cargada.disparar();
        if(this.arma_cargada.getX() == -1){
            restarArma(name);
            actualizarArmas();
        }
    }
    
    public Isla recibir_disparo(int x, int y){
        Isla isla = this.grafo.islaEnPos(x, y);
        if(isla != null){
            return grafo.borrarIsla(isla);
        }else{
            return null;
        }
    }
    
    
    public void AñadirIslas(Isla isla) {
        for (int i = 0; i < this.matriz.length; i++) {
            for (int j = 0; j < this.matriz[i].length; j++) {
                if (this.matriz[i][j] == null) {
                    matriz[i][j] = isla;
                    isla.setX(i);
                    isla.setY(j);
                }
            }
        }
    }
    
    void escribirDisparoBitacora(){
        if(arma_cargada.getName().equals("Bomba"))
            this.bitacora.append("Has explotado una bomba en las posiciones ("+arma_cargada.getXY()[0]+","+arma_cargada.getXY()[1]+") y ("+arma_cargada.getXY()[2]+","+arma_cargada.getXY()[3]+")\n");
        else
            this.bitacora.append("Has disparado " + arma_cargada.getName()+" en la posicion: ("+arma_cargada.getX()+","+arma_cargada.getY()+")\n");
    }
    public JLabel getLabel_acero() {
        return label_acero;
    }

    public void setLabel_acero(JLabel label_acero) {
        this.label_acero = label_acero;
    }

    public JLabel getLabel_dinero() {
        return label_dinero;
    }

    public void setLabel_dinero(JLabel label_dinero) {
        this.label_dinero = label_dinero;
    }
    
    public void setBoton_canion(JLabel boton_canion) {
        this.boton_canion = boton_canion;
    }

    public void setBoton_canion_multiple(JLabel boton_canion_multiple) {
        this.boton_canion_multiple = boton_canion_multiple;
    }

    public void setBoton_canion_barba_roja(JLabel boton_canion_barba_roja) {
        this.boton_canion_barba_roja = boton_canion_barba_roja;
    }

    public void setBoton_bomba(JLabel boton_bomba) {
        this.boton_bomba = boton_bomba;
    }
    
    public void actualizar_dinero(){
        this.label_dinero.setText("Dinero: "+this.dinero);
    }
    public void actualizar_acero(){
        this.label_acero.setText("Acero: "+this.acero);
    }
    public void jugadorInexistente(){
        JOptionPane.showMessageDialog(null, "El jugador no existe", "Error", JOptionPane.ERROR_MESSAGE);
    }
    public boolean confirmarCompra(int precio){
        return this.dinero >= precio;
    }
    public void avisarComodinDisponible(){
        String comodin;
        if(this.comodin == 1){
            comodin = "KRAKEN";
        }else{
            comodin = "ESCUDO";
        }
        JOptionPane.showMessageDialog(null, "Gracias al templo de bruja puedes usar el comodin de "+comodin, "Aviso", JOptionPane.WARNING_MESSAGE);
    }
    public void avisarEscudoActivo(){
        JOptionPane.showMessageDialog(null, "Has utilizado el comodin de escudos ahora eres inmune a "+this.escudos+" disparos", "Aviso", JOptionPane.WARNING_MESSAGE);

    }

    public JTextArea getBitacora() {
        return bitacora;
    }

    public void setBitacora(JTextArea bitacora) {
        this.bitacora = bitacora;
    }
    
}
