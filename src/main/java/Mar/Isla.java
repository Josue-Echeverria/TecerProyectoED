package Mar;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author lmaag
 */
public class Isla {
    int id;
    String tipoIsla;
    int x;
    int y;

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
    
    public Isla(int id, String tipoIsla) {
        this.id = id;
        this.tipoIsla = tipoIsla;
    }

    public Isla(String tipoIsla) {
        this.tipoIsla = tipoIsla;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoIsla() {
        return tipoIsla;
    }

    public void setTipoIsla(String tipoIsla) {
        this.tipoIsla = tipoIsla;
    }
}
