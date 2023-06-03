package org.example.modelo;

import org.example.Persistencia.AvionDAO;


import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloTabla implements TableModel {
    public static final int COLUMNS = 6;
    private ArrayList<Avion> datos;
    private AvionDAO ldao;

    public ModeloTabla() {
        ldao = new AvionDAO();
        datos = new ArrayList<>();
    }

    public ModeloTabla(ArrayList<Avion> datos) {
        this.datos = datos;
        ldao = new AvionDAO();
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMNS;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Id";
            case 1:
                return "Modelo";
            case 2:
                return "Color";
            case 3:
                return "Tipo";
            case 4:
                return "Fuselaje";
            case 5:
                return "URL";
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return String.class;
            case 4:
                return String.class;
            case 5:
                return String.class;
        }
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Avion tmp = datos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return tmp.getId();
            case 1:
                return tmp.getModelo();
            case 2:
                return tmp.getColor();
            case 3:
                return tmp.getTipo();
            case 4:
                return tmp.getFuselaje();
            case 5:
                return tmp.getURLFoto();
        }
        return null;
    }

    @Override
    public void setValueAt(Object o, int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                //datos.get(rowIndex).getId();
                break;
            case 1:
                datos.get(rowIndex).setModelo((String) o);
                break;
            case 2:
                datos.get(rowIndex).setColor((String) o);
                break;
            case 3:
                datos.get(rowIndex).setTipo((String) o);
                break;
            case 4:
                datos.get(rowIndex).setFuselaje((String) o);
                break;
            case 5:
                datos.get(rowIndex).setURLFoto((String) o);
                break;
            default:
                System.out.println("No se modifica nada");
        }

    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {


    }

    public void eliminarDatos(int rowIndex){
        if (rowIndex >= 0 && rowIndex < datos.size()) {
            Avion avion = datos.get(rowIndex);
            try {
                if (ldao.delete(Integer.toString(avion.getId()))) {
                    datos.remove(rowIndex);
                } else {
                    System.out.println("No se pudo eliminar");
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void ActualizarDatos(int rowIndex, Avion avion) {
        if (rowIndex >= 0 && rowIndex < datos.size()) {
            Avion actual = datos.get(rowIndex);
            actual.setModelo(avion.getModelo());
            actual.setColor(avion.getColor());
            actual.setTipo(avion.getTipo());
            actual.setFuselaje(avion.getFuselaje());
            actual.setURLFoto(avion.getURLFoto());
            try {
                ldao.update(actual);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    public void cargarDatos(){
        try {
            ArrayList<Avion> tirar = ldao.obtenerTodo();
            System.out.println(tirar);
            datos = ldao.obtenerTodo();
        }catch (SQLException sqle){
            System.out.println(sqle.getMessage());
        }

    }
    public boolean agregarAvion(Avion avion){
        boolean resultado = false;
        try {
            if (ldao.insertar(avion)){
                datos.add(avion);
                resultado = true;
            }else{
                resultado = false;
            }
        }catch (SQLException sqle){
            System.out.println(sqle.getMessage());
        }

        return resultado;
    }
    public Avion getavionindex(int idx){
        return datos.get(idx);
    }
}
