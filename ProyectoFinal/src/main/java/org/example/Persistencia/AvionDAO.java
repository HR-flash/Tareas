package org.example.Persistencia;

import org.example.modelo.Avion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AvionDAO implements InterfazDAO{
    public AvionDAO() {
    }

    @Override
    public boolean insertar(Object obj) throws SQLException {
        String sqlInsert = "INSERT INTO aviones(Modelo, Color, Tipo, Fuselaje, URL) VALUES(?, ?, ?, ?, ?);";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.getInstance("Proyecto.db").getConnection().prepareStatement(sqlInsert);
        pstm.setString(1, ((Avion) obj).getModelo());
        pstm.setString(2, ((Avion) obj).getColor());
        pstm.setString(3, ((Avion) obj).getTipo());
        pstm.setString(4, ((Avion) obj).getFuselaje());
        pstm.setString(5, ((Avion) obj).getURLFoto());
        rowCount = pstm.executeUpdate();

        return rowCount > 0;
    }

    @Override
    public boolean update(Object obj) throws SQLException {
        String sqlUpdate = "UPDATE aviones SET Modelo = ?, Color = ?, Tipo = ?, Fuselaje = ?, URL = ?  WHERE id = ? ;";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.getInstance("Proyecto.db").getConnection().prepareStatement(sqlUpdate);
        pstm.setString(1, ((Avion) obj).getModelo());
        pstm.setString(2, ((Avion) obj).getColor());
        pstm.setString(3, ((Avion) obj).getTipo());
        pstm.setString(4, ((Avion) obj).getFuselaje());
        pstm.setString(5, ((Avion) obj).getURLFoto());
        pstm.setInt(6, ((Avion) obj).getId());
        rowCount = pstm.executeUpdate();

        return rowCount > 0;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        String sqlDelete = "DELETE FROM aviones WHERE id = ? ;";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.getInstance("Proyecto.db").getConnection().prepareStatement(sqlDelete);
        pstm.setInt(1, Integer.parseInt(id));
        rowCount = pstm.executeUpdate();


        return rowCount > 0;
    }

    @Override
    public ArrayList obtenerTodo() throws SQLException {
        String sql = "SELECT * FROM aviones";
        ArrayList<Avion> resultado = new ArrayList<>();
        Statement stm = ConexionSingleton.getInstance("Proyecto.db").getConnection().createStatement();
        ResultSet rst = stm.executeQuery(sql);
        while (rst.next()){
            resultado.add(new Avion(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5),rst.getString(6) ));
        }
        return  resultado;
    }

    @Override
    public Object buscarPorId(String id) throws SQLException {
        String sql = "SELECT * FROM aviones WHERE id = ? ;";
        Avion avion = null;

        PreparedStatement pstm = ConexionSingleton.getInstance("Proyecto.db").getConnection().prepareStatement(sql);
        pstm.setInt(1, Integer.parseInt(id));
        ResultSet rst = pstm.executeQuery();
        if (rst.next()) {
            avion = new Avion(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6));

            return avion;
        }
        return null;
    }
}
