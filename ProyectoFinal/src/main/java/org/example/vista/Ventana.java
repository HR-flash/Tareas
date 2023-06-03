package org.example.vista;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    private JLabel lblId;
    private JLabel lblModelo;
    private JLabel lblColor;
    private JLabel lblTipo;
    private JLabel lblFuselaje;
    private JLabel lblURLFoto;
    private JLabel Imagen;
    private JLabel Cargar;
    private JTextField txtId;
    private JTextField txtModelo;
    private JTextField txtColor;
    private JTextField txtTipo;
    private JTextField txtFuselaje;
    private JTextField txtURLFoto;
    private JButton btnAgregar;
    private JButton btnCargar;
    private JButton btnEliminar;
    private JTable tblProyecto;
    private JScrollPane scrollPane;
    private GridLayout layout;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private  JButton btnActualizar;

    public Ventana(String title) throws HeadlessException {
        super(title);
        this.setSize(800,800);
        layout = new GridLayout(2,2);
        this.getContentPane().setLayout(layout);




        //////PANEL 1
        panel1 = new JPanel(new FlowLayout());
        panel1.setBackground(new Color(137, 215, 176));
        lblId = new JLabel("Id: ");
        lblModelo = new JLabel("Modelo: ");
        lblColor = new JLabel("Color: ");
        lblTipo = new JLabel("Tipo: ");
        lblFuselaje = new JLabel("Fuselaje: ");
        lblURLFoto = new JLabel("URL: ");
        txtId = new JTextField(3);
        txtId.setText("0");
        txtId.setEnabled(false);
        txtModelo = new JTextField(15);
        txtColor = new JTextField(10);
        txtTipo = new JTextField(10);
        txtFuselaje = new JTextField(15);
        txtURLFoto = new JTextField(20);
        btnAgregar = new JButton("Agregar");
        panel1.add(lblId);
        panel1.add(txtId);
        panel1.add(lblModelo);
        panel1.add(txtModelo);
        panel1.add(lblColor);
        panel1.add(txtColor);
        panel1.add(lblTipo);
        panel1.add(txtTipo);
        panel1.add(lblFuselaje);
        panel1.add(txtFuselaje);
        panel1.add(lblURLFoto);
        panel1.add(txtURLFoto);
        panel1.add(btnAgregar);





        //////PANEL 2
        panel2 = new JPanel(new FlowLayout());
        panel2.setBackground(new Color(192, 116, 225));
        Cargar = new JLabel("PRESIONA PARA CARGAR LOS DATOS DE LA TABLA: ");
        panel2.add(Cargar);
        btnCargar = new JButton("Cargar");
        panel2.add(btnCargar);
        tblProyecto = new JTable();
        scrollPane = new JScrollPane(tblProyecto);
        panel2.add(scrollPane);




        //////PANEL 3
        panel3 = new JPanel(new FlowLayout());
        panel3.setBackground(new Color(212, 137, 215));
        Imagen = new JLabel("....");
        this.panel3.add(Imagen);





        //////PANEL 4
        panel4 = new JPanel(new FlowLayout());
        panel4.setBackground(new Color(232, 128, 128));
        btnEliminar = new JButton("Eliminar");
        panel4.add(btnEliminar);
        btnActualizar = new JButton("Actualizar");
        panel4.add(btnActualizar);




        this.getContentPane().add(panel1,0);
        this.getContentPane().add(panel2,1);
        this.getContentPane().add(panel3,2);
        this.getContentPane().add(panel4,3);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public JLabel getLblId() {
        return lblId;
    }

    public void setLblId(JLabel lblId) {
        this.lblId = lblId;
    }

    public JLabel getLblModelo() {
        return lblModelo;
    }

    public void setLblModelo(JLabel lblModelo) {
        this.lblModelo = lblModelo;
    }

    public JLabel getLblColor() {
        return lblColor;
    }

    public void setLblColor(JLabel lblColor) {
        this.lblColor = lblColor;
    }

    public JLabel getLblTipo() {
        return lblTipo;
    }

    public void setLblTipo(JLabel lblTipo) {
        this.lblTipo = lblTipo;
    }

    public JLabel getLblFuselaje() {
        return lblFuselaje;
    }

    public void setLblFuselaje(JLabel lblFuselaje) {
        this.lblFuselaje = lblFuselaje;
    }

    public JLabel getLblURLFoto() {
        return lblURLFoto;
    }

    public void setLblURLFoto(JLabel lblURLFoto) {
        this.lblURLFoto = lblURLFoto;
    }

    public JLabel getImagen() {
        return Imagen;
    }

    public void setImagen(JLabel imagen) {
        this.Imagen = imagen;
    }

    public JTextField getTxtId() {
        return txtId;
    }

    public void setTxtId(JTextField txtId) {
        this.txtId = txtId;
    }

    public JTextField getTxtModelo() {
        return txtModelo;
    }

    public void setTxtModelo(JTextField txtModelo) {
        this.txtModelo = txtModelo;
    }

    public JTextField getTxtColor() {
        return txtColor;
    }

    public void setTxtColor(JTextField txtColor) {
        this.txtColor = txtColor;
    }

    public JTextField getTxtTipo() {
        return txtTipo;
    }

    public void setTxtTipo(JTextField txtTipo) {
        this.txtTipo = txtTipo;
    }

    public JTextField getTxtFuselaje() {
        return txtFuselaje;
    }

    public void setTxtFuselaje(JTextField txtFuselaje) {
        this.txtFuselaje = txtFuselaje;
    }

    public JTextField getTxtURLFoto() {
        return txtURLFoto;
    }

    public void setTxtURLFoto(JTextField txtURLFoto) {
        this.txtURLFoto = txtURLFoto;
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public void setBtnAgregar(JButton btnAgregar) {
        this.btnAgregar = btnAgregar;
    }

    public JButton getBtnCargar() {
        return btnCargar;
    }

    public void setBtnCargar(JButton btnCargar) {
        this.btnCargar = btnCargar;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(JButton btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    public JTable getTblProyecto() {
        return tblProyecto;
    }

    public void setTblProyecto(JTable tblProyecto) {
        this.tblProyecto = tblProyecto;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    @Override
    public GridLayout getLayout() {
        return layout;
    }

    public void setLayout(GridLayout layout) {
        this.layout = layout;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JPanel getPanel2() {
        return panel2;
    }

    public void setPanel2(JPanel panel2) {
        this.panel2 = panel2;
    }

    public JPanel getPanel3() {
        return panel3;
    }

    public void setPanel3(JPanel panel3) {
        this.panel3 = panel3;
    }

    public JPanel getPanel4() {
        return panel4;
    }

    public void setPanel4(JPanel panel4) {
        this.panel4 = panel4;
    }

    public JLabel getCargar() {
        return Cargar;
    }

    public void setCargar(JLabel cargar) {
        Cargar = cargar;
    }

    public JButton getBtnActualizar() {
        return btnActualizar;
    }

    public void setBtnActualizar(JButton btnActualizar) {
        this.btnActualizar = btnActualizar;
    }

    public void limpiar(){
        txtModelo.setText("");
        txtColor.setText("");
        txtTipo.setText("");
        txtFuselaje.setText("");
        txtURLFoto.setText("");
    }
}
