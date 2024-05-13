/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas;

import controladores.ControladorRegistroMedico;
import excepciones.EntradaInvalida;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static jdk.internal.joptsimple.util.RegexMatcher.regex;
import modelos.Medico;

/**
 *
 * @author amoel
 */
public class FormMedico extends javax.swing.JFrame {

    private boolean actualizar;
    private Medico medico;
    /**
     * Creates new form RegistroMedico
     */
    public FormMedico() {
        initComponents();
        this.medico = new Medico();
    }

    public Medico obtenerMedico() throws EntradaInvalida{
        String cedula = txtCedula.getText();
        String nombre = txtNombre.getText();
        String especialidad = txtEspecialidad.getText();
        String instituto = txtInstituto.getText();
        String regexCedula = "^[A-Z]{3,4}\\d{6}(?:[A-Z]|\\d)$";
        String regexLetras = "^[a-zA-Z]+(\\s[a-zA-Z]+)*$";

        
        Pattern pattern = Pattern.compile(regexLetras);

        // Crear un objeto Matcher para buscar la expresión regular en la cadena de fecha
        Matcher matcher = pattern.matcher(nombre);

        // Verificar si la fecha coincide con la expresión regular
        if(!matcher.matches()){
            throw new EntradaInvalida("El nombre solo puede contener letras y espacios,\npero no puede haber espacios al principio ni al final.");
        }
        
        
        matcher = pattern.matcher(especialidad);
        if (!matcher.matches()) {
            throw new EntradaInvalida("La especialidad solo puede contener letras,\npero no puede haber espacios al principio ni al final.");
        }
        
        pattern = Pattern.compile(regexCedula);
        matcher = pattern.matcher(cedula);
        if (!matcher.matches()) {
            throw new EntradaInvalida("La cédula no tiene un formato válido.");
        }
        pattern = Pattern.compile(regexLetras);
        matcher = pattern.matcher(instituto);
        if (!matcher.matches()) {
            throw new EntradaInvalida("El instituto solo puede contener letras o espacios,\npero no puede haber espacios al principio ni al final.");
        }
        
        if(nombre.length()>=255) throw new EntradaInvalida("La longitud del nombre no puede exceder los 255 caracteres.");
        if(especialidad.length()>=255) throw new EntradaInvalida("La longitud de la especialidad no puede exceder los 255 caracteres.");
        if(cedula.length()>=12) throw new EntradaInvalida("La longitud de la cedula no puede exceder los 11 caracteres.");
         if(instituto.length()>=255) throw new EntradaInvalida("La longitud del instituto no puede exceder los 255 caracteres.");

        medico.setNombre(nombre);
        medico.setEspecialidad(especialidad);
        medico.setCedula(cedula);
        medico.setInstituto(instituto);
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
    
    public void cargarMedico(Medico medico){
        this.medico = medico;
        txtNombre.setText(medico.getNombre());
        txtEspecialidad.setText(medico.getEspecialidad());
        txtCedula.setText(medico.getCedula());;
        txtInstituto.setText(medico.getInstituto());
    }

    public boolean getActualizar() {
        return actualizar;
    }

    public void setActualizar(boolean actualizar) {
        this.actualizar = actualizar;
    }

    public String obtenerContenidoCedula() {
        return txtCedula.getText();
    }

    public String obtenerContenidoEspecialidad() {
        return txtEspecialidad.getText();
    }

    public String obtenerContenidoInstituto() {
        return txtInstituto.getText();
    }

    public String obtenerContenidoNombre() {
        return txtNombre.getText();
    }

    public void limpiarCedula() {
        txtCedula.setText("");
    }

    public void limpiarEspecialidad() {
        txtEspecialidad.setText("");
    }

    public void limpiarInstituto() {
        txtInstituto.setText("");
    }

    public void limpiarNombre() {
        txtNombre.setText("");
    }

    public void limpiar() {
        limpiarCedula();
        limpiarEspecialidad();
        limpiarInstituto();
        limpiarNombre();
    }
    
    public boolean tieneCamposVacios(){
        return txtCedula.getText().isEmpty() || txtEspecialidad.getText().isEmpty() || txtInstituto.getText().isEmpty() ||  txtNombre.getText().isEmpty();
    }
    
    public void agregarEventos(ControladorRegistroMedico controlador){
        this.botonAgregar.addActionListener(controlador);
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

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        etiquetaInstituto = new javax.swing.JLabel();
        botonAgregar = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();
        txtEspecialidad = new javax.swing.JTextField();
        etiquetaEspecialidad = new javax.swing.JLabel();
        etiquetaNombre = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        etiquetaCedula = new javax.swing.JLabel();
        txtInstituto = new javax.swing.JTextField();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Información del médico");
        setResizable(false);

        jLabel1.setBackground(new java.awt.Color(51, 102, 255));
        jLabel1.setFont(new java.awt.Font("Lucida Sans", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Información del Medico");
        jLabel1.setOpaque(true);

        etiquetaInstituto.setText("Instituto:");

        botonAgregar.setText("Guardar");
        botonAgregar.setName("guardar"); // NOI18N

        botonCancelar.setText("Cancelar");
        botonCancelar.setName("cancelar"); // NOI18N

        etiquetaEspecialidad.setText("Especialidad:");

        etiquetaNombre.setText("Nombre:");

        etiquetaCedula.setText("Cedula:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(91, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etiquetaEspecialidad)
                            .addComponent(etiquetaCedula)
                            .addComponent(etiquetaInstituto)
                            .addComponent(etiquetaNombre))
                        .addGap(123, 123, 123)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                            .addComponent(txtEspecialidad)
                            .addComponent(txtCedula, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                            .addComponent(txtInstituto)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonCancelar)))
                .addGap(107, 107, 107))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiquetaNombre))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiquetaEspecialidad))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiquetaCedula))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtInstituto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiquetaInstituto))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonAgregar)
                    .addComponent(botonCancelar))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton botonAgregar;
    public javax.swing.JButton botonCancelar;
    private javax.swing.JLabel etiquetaCedula;
    private javax.swing.JLabel etiquetaEspecialidad;
    private javax.swing.JLabel etiquetaInstituto;
    private javax.swing.JLabel etiquetaNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public javax.swing.JTextField txtCedula;
    public javax.swing.JTextField txtEspecialidad;
    public javax.swing.JTextField txtInstituto;
    public javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
