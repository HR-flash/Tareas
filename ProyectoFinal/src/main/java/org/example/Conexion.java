package org.example;

import java.sql.*;

import org.sqlite.JDBC;

public class Conexion {
    public static void main(String[] args) {
        String DB_url = "jdbc:sqlite:Proyecto.db";
        Connection conexion = null;

        try{
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection(DB_url);
            Statement stm = conexion.createStatement();
            ResultSet rst = stm.executeQuery("SELECT * FROM aviones;");
            while (rst.next()){
                System.out.println(rst.getString(1)+ " " +rst.getString(2)+" " +rst.getString(3)+" " +rst.getString(4)+" " +rst.getString(5)+" " +rst.getString(6));
            }
            conexion.close();
        }catch (ClassNotFoundException cne){
            cne.printStackTrace();
        }catch (SQLException sqle){
            sqle.printStackTrace();
        }

    }
}
