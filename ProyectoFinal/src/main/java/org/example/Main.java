package org.example;

import org.example.Persistencia.AvionDAO;
import org.example.controlador.Controlador;
import org.example.modelo.Avion;
import org.example.vista.Ventana;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        Ventana ventana = new Ventana("MVC y LDBC");
        Controlador controller = new Controlador(ventana);
    }
}