import java.awt.*;
import java.util.*;
import java.util.ArrayList;
public class Automovil {
    private String marca;
    private String subMarca;
    private byte modelo;
    private Color color;

    public Automovil() {
    }

    public Automovil(String marca, String subMarca, byte modelo, Color color) {
        this.marca = marca;
        this.subMarca = subMarca;
        this.modelo = modelo;
        this.color = color;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getSubMarca() {
        return subMarca;
    }

    public void setSubMarca(String subMarca) {
        this.subMarca = subMarca;
    }

    public byte getModelo() {
        return modelo;
    }

    public void setModelo(byte modelo) {
        this.modelo = modelo;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }


//Inicia ToString
    @Override
    public String toString() {
        return "Automovil{" +
                "marca='" + marca + '\'' +
                ", subMarca='" + subMarca + '\'' +
                ", modelo=" + modelo +
                ", color=" + color +
                '}';
    }
    ///Acaba
    public static void main(String[] args) {
        Automovil auto = new Automovil("VM","Bocho",(byte)88, Color.BLUE);
        System.out.println(auto);
    }
}
