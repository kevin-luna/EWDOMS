/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas;

import controladores.ControladorRegistroUsuario;
import modelos.Usuario;

/**
 *
 * @author kevin
 */
public class FormUsuario extends javax.swing.JFrame {

    /**
     * Creates new form FormUsuario
     */
    public FormUsuario() {
        initComponents();
    }
    
    public Usuario obtenerUsuario(){
        return new Usuario(this.campoNombre.getText(),new String(this.campoClave.getPassword()),this.comboAdministrador.getSelectedIndex());
    }
    
    public void agregarEventos(ControladorRegistroUsuario controlador){
        this.botonGuardar.addActionListener(controlador);
        this.botonCancelar.addActionListener(controlador);
    }
    
    public void cargarUsuario(Usuario usuario){
        this.campoNombre.setText(usuario.getNombre());
        this.comboAdministrador.setSelectedIndex(usuario.isAdministrador());
    }
    
    public void limpiarNombre(){
        this.campoNombre.setText("");
    }
    
    public void limpiarClave(){
        this.campoClave.setText("");
    }
    
    public void limpiarAdministrador(){
        this.comboAdministrador.setSelectedIndex(0);
    }
    
    public void limpiar(){
        limpiarNombre();
        limpiarClave();
        limpiarAdministrador();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        etiquetaTitulo = new javax.swing.JLabel();
        etiquetaNombre = new javax.swing.JLabel();
        etiquetaClave = new javax.swing.JLabel();
        etiquetaAdministrador = new javax.swing.JLabel();
        campoNombre = new javax.swing.JTextField();
        comboAdministrador = new javax.swing.JComboBox<>();
        botonGuardar = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();
        campoClave = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Información del usuario");
        setResizable(false);

        etiquetaTitulo.setBackground(new java.awt.Color(0, 102, 255));
        etiquetaTitulo.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        etiquetaTitulo.setForeground(new java.awt.Color(255, 255, 255));
        etiquetaTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaTitulo.setText("Información del Usuario");
        etiquetaTitulo.setOpaque(true);

        etiquetaNombre.setText("Nombre:");

        etiquetaClave.setText("Clave de acceso:");

        etiquetaAdministrador.setText("Administrador:");

        comboAdministrador.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No", "Sí" }));

        botonGuardar.setText("Guardar");
        botonGuardar.setName("guardar"); // NOI18N

        botonCancelar.setText("Cancelar");
        botonCancelar.setName("cancelar"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(etiquetaAdministrador)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(etiquetaClave)
                                .addComponent(etiquetaNombre, javax.swing.GroupLayout.Alignment.TRAILING)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campoNombre)
                            .addComponent(comboAdministrador, 0, 270, Short.MAX_VALUE)
                            .addComponent(campoClave)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(botonGuardar)
                        .addGap(18, 18, 18)
                        .addComponent(botonCancelar)))
                .addContainerGap(55, Short.MAX_VALUE))
            .addComponent(etiquetaTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(etiquetaTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaNombre)
                    .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaClave)
                    .addComponent(campoClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etiquetaAdministrador)
                    .addComponent(comboAdministrador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonGuardar)
                    .addComponent(botonCancelar))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JPasswordField campoClave;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JComboBox<String> comboAdministrador;
    private javax.swing.JLabel etiquetaAdministrador;
    private javax.swing.JLabel etiquetaClave;
    private javax.swing.JLabel etiquetaNombre;
    private javax.swing.JLabel etiquetaTitulo;
    // End of variables declaration//GEN-END:variables
}
