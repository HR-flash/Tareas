package org.example.modelo;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Avion {
    private int Id;
    private String Modelo;
    private String Color;
    private String Tipo;
    private String Fuselaje;
    private String URLFoto;

    public Avion() {
    }

    public Avion(int Id, String modelo, String color, String tipo, String fuselaje, String URLFoto) {
        this.Id = Id;
        Modelo = modelo;
        Color = color;
        Tipo = tipo;
        Fuselaje = fuselaje;
        this.URLFoto = URLFoto;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String modelo) {
        Modelo = modelo;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public String getFuselaje() {
        return Fuselaje;
    }

    public void setFuselaje(String fuselaje) {
        Fuselaje = fuselaje;
    }

    public String getURLFoto() {
        return URLFoto;
    }

    public void setURLFoto(String URLFoto) {
        this.URLFoto = URLFoto;
    }

    @Override
    public String toString() {
        return "Avion{" +
                "Id=" + Id +
                ", Modelo='" + Modelo + '\'' +
                ", Color='" + Color + '\'' +
                ", Tipo='" + Tipo + '\'' +
                ", Fuselaje='" + Fuselaje + '\'' +
                ", URL='" + URLFoto + '\'' +
                '}';
    }
    public ImageIcon getImagen() throws MalformedURLException{
        URL urlimagen = new URL(this.URLFoto);
        return  new ImageIcon(urlimagen);
    }
}
