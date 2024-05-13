/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas;

import controladores.ControladorClaveUsuario;
import excepciones.EntradaInvalida;
import modelos.Usuario;

/**
 *
 * @author 
 */
public class FormClaveUsuario extends javax.swing.JFrame {

    /**
     * Creates new form FormClaveUsuario
     */
    public FormClaveUsuario() {
        initComponents();
    }
    
    public String obtenerClave() throws EntradaInvalida{
        String clave = new String(this.campoClave.getPassword());
        if(clave.length()>=255) throw new EntradaInvalida("La longitud de la clave no puede ser mayor a 255 caracteres");
        return Usuario.hashClave(new String(this.campoClave.getPassword()));
    }
    
    public String obtenerConfirmacion(){
        return Usuario.hashClave(new String(this.campoConfirmacion.getPassword()));
    }
    
    public void limpiarClave(){
        this.campoClave.setText("");
    }
    
    public void limpiarConfirmacion(){
        this.campoConfirmacion.setText("");
    }
    
    
    public void limpiar(){
        limpiarClave();
        limpiarConfirmacion();
    }
    
    public void agregarEventos(ControladorClaveUsuario controlador){
        this.botonGuardar.addActionListener(controlador);
        this.botonCancelar.addActionListener(controlador);
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
        campoClave = new javax.swing.JPasswordField();
        campoConfirmacion = new javax.swing.JPasswordField();
        etiquetaNuevaClave = new javax.swing.JLabel();
        etiquetaConfirmacion = new javax.swing.JLabel();
        botonGuardar = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        etiquetaTitulo.setBackground(new java.awt.Color(0, 102, 255));
        etiquetaTitulo.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        etiquetaTitulo.setForeground(new java.awt.Color(255, 255, 255));
        etiquetaTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaTitulo.setText("Cambiar clave de acceso");
        etiquetaTitulo.setOpaque(true);

        etiquetaNuevaClave.setText("Nueva clave:");

        etiquetaConfirmacion.setText("Confirme la nueva clave:");

        botonGuardar.setText("Guardar");
        botonGuardar.setName("guardar"); // NOI18N

        botonCancelar.setText("Cancelar");
        botonCancelar.setName("cancelar"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(etiquetaTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(etiquetaConfirmacion)
                            .addComponent(etiquetaNuevaClave)
                            .addComponent(campoConfirmacion, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                            .addComponent(campoClave))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(botonGuardar)
                .addGap(43, 43, 43)
                .addComponent(botonCancelar)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(etiquetaTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(etiquetaNuevaClave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(etiquetaConfirmacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoConfirmacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonGuardar)
                    .addComponent(botonCancelar))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JPasswordField campoClave;
    private javax.swing.JPasswordField campoConfirmacion;
    private javax.swing.JLabel etiquetaConfirmacion;
    private javax.swing.JLabel etiquetaNuevaClave;
    private javax.swing.JLabel etiquetaTitulo;
    // End of variables declaration//GEN-END:variables
}
