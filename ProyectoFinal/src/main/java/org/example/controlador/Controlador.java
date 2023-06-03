package org.example.controlador;

import org.example.modelo.Avion;
import org.example.modelo.ModeloTabla;
import org.example.vista.Ventana;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;

public class Controlador extends MouseAdapter {
    private Ventana view;
    private ModeloTabla modelo;
    public Controlador(Ventana view) {
        this.view = view;
        modelo = new ModeloTabla();

        this.view.getTblProyecto().addMouseListener(this);
        this.view.getTblProyecto().setModel(modelo);
        this.view.getBtnCargar().addMouseListener(this);
        this.view.getBtnAgregar().addMouseListener(this);
        this.view.getBtnEliminar().addMouseListener(this);
        this.view.getBtnActualizar().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == view.getTblProyecto()){
            System.out.println("Evento sobre la tabla");
            int index = this.view.getTblProyecto().getSelectedRow();
            Avion tmp = modelo.getavionindex(index);
            try {
                this.view.getImagen().setIcon(tmp.getImagen());
                this.view.getImagen().setText("");
            }catch (MalformedURLException mfeu){
                System.out.println(e.toString());

            }
        }


        if (e.getSource()== this.view.getBtnEliminar()){
            int selectedRow = view.getTblProyecto().getSelectedRow();
            if (selectedRow != -1) {
                int confirm = JOptionPane.showConfirmDialog(view,"Desea eliminar esta fila ?","Apoco si Tilin?",JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    modelo.eliminarDatos(selectedRow);
                    view.getTblProyecto().clearSelection();
                }
            } else {
                JOptionPane.showMessageDialog(view, "Seleccione una fila para eliminar", "Error", JOptionPane.ERROR_MESSAGE);
            }
            //System.out.println("*Lo borra UwU*");
            this.view.getTblProyecto().updateUI();

        }


        if (e.getSource() == view.getBtnActualizar()) {
            int index = this.view.getTblProyecto().getSelectedRow();
            if (index >= 0) {
                Avion avion = new Avion();
                avion.setModelo(this.view.getTxtModelo().getText());
                avion.setColor(this.view.getTxtColor().getText());
                avion.setTipo(this.view.getTxtTipo().getText());
                avion.setFuselaje(this.view.getTxtFuselaje().getText());
                avion.setURLFoto(this.view.getTxtURLFoto().getText());
                modelo.ActualizarDatos(index, avion);
                this.view.getTblProyecto().clearSelection();
                this.view.limpiar();
            } else {
                JOptionPane.showMessageDialog(view, "Seleccione una fila para actualizar", "Error", JOptionPane.ERROR_MESSAGE);
            }
            this.view.getTblProyecto().updateUI();
        }


        if (e.getSource() == this.view.getBtnCargar()){

            modelo.cargarDatos();
            this.view.getTblProyecto().setModel(modelo);
            this.view.getTblProyecto().updateUI();
        }

        if ( e.getSource() == this.view.getBtnAgregar()){
            Avion avion = new Avion();
            avion.setId(this.view.getTxtId().getColumns());
            avion.setModelo(this.view.getTxtModelo().getText());
            avion.setColor(this.view.getTxtColor().getText());
            avion.setTipo(this.view.getTxtTipo().getText());
            avion.setFuselaje(this.view.getTxtFuselaje().getText());
            avion.setURLFoto(this.view.getTxtURLFoto().getText());
            if(modelo.agregarAvion(avion)){
                JOptionPane.showMessageDialog(view, "Se agrego correctamente","Aviso",JOptionPane.INFORMATION_MESSAGE);
                this.view.getTblProyecto().updateUI();
            }else {
                JOptionPane.showMessageDialog(view,"No se pudo agregar a la base de datos.","Error al insertar",JOptionPane.ERROR_MESSAGE);

            }
            this.view.limpiar();
        }
    }
}
