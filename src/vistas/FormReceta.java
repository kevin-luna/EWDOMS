/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas;

import controladores.ControladorRegistroReceta;
import excepciones.EntradaInvalida;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import modelos.ConsultaMedica;
import modelos.Medicamento;
import modelos.Receta;

/**
 *
 * @author amoel
 */
public class FormReceta extends javax.swing.JFrame {

    private boolean actualizar;
    private Receta receta;
    private ConsultaMedica consulta;
    private Medicamento medicamento;
    private HashMap<Long, ConsultaMedica> catalogoConsultas;

    /**
     * Creates new form RegistroReceta
     */
    public FormReceta() {
        initComponents();
        catalogoConsultas = new HashMap<Long,ConsultaMedica>();
    }


    public void cargarCatalogoConsultas(ArrayList<ConsultaMedica> catalogoConsultas) {
        for (ConsultaMedica c : catalogoConsultas) {
            comboConsulta.addItem(Long.toString(c.getId()));
            this.catalogoConsultas.put(c.getId(), c);
        }
    }

    public void cargarReceta(Receta receta) {
        this.receta = receta;
        txtaDiagnostico.setText(receta.getDiagnostico());
        txtaSintomas.setText(receta.getSintomas());
        txtaRecomendaciones.setText(receta.getRecomendaciones());
        txtaMedicamentos.setText(receta.getMedicamentos());
        long idConsulta = receta.getId_consulta();
        ComboBoxModel<String> modelo = comboConsulta.getModel();
        for (int i = 0; i < modelo.getSize(); i++) {
            String valor = modelo.getElementAt(i);
            if(valor == null ? Long.toString(idConsulta) == null : valor.equals(Long.toString(idConsulta))){
                comboConsulta.setSelectedIndex(i);
                break;
            }
        }
    }


    public Receta obtenerReceta() throws EntradaInvalida{
        if(obtenerDiagnostico().length()>=255) throw new EntradaInvalida("La sección de diagnóstico no puede ser mayor a 255 caracteres.");
        if(obtenerSintomas().length()>=255) throw new EntradaInvalida("La sección de síntomas no puede ser mayor a 255 caracteres.");
        if(obtenerRecomendaciones().length()>=255) throw new EntradaInvalida("La sección de recomendaciones no puede ser mayor a 255 caracteres.");
        if(obtenerMedicamentos().length()>=255) throw new EntradaInvalida("La sección de medicamentos no puede ser mayor a 255 caracteres.");
        
        
        this.receta.setId_consulta(obtenerIdConsulta());
        this.receta.setDiagnostico(obtenerDiagnostico());
        this.receta.setSintomas(obtenerSintomas());
        this.receta.setRecomendaciones(obtenerRecomendaciones());
        this.receta.setMedicamentos(obtenerMedicamentos());
        return this.receta;
    }

    public boolean getActualizar() {
        return actualizar;
    }

    public void setActualizar(boolean actualizar) {
        this.actualizar = actualizar;
    }

    // Métodos para obtener el contenido
    public String obtenerDiagnostico() {
        return txtaDiagnostico.getText();
    }

    public String obtenerSintomas() {
        return txtaSintomas.getText();
    }

    public Long obtenerIdConsulta() {
        return Long.parseLong(this.comboConsulta.getSelectedItem().toString());
    }

    public String obtenerRecomendaciones() {
        return txtaRecomendaciones.getText();
    }
    
    public String obtenerMedicamentos(){
        return txtaMedicamentos.getText();
    }


// Métodos para limpiar el contenido
    public void limpiarDiagnostico() {
        txtaDiagnostico.setText("");
    }

    public void limpiarSintomas() {
        txtaSintomas.setText("");
    }

    public void limpiarIdConsulta() {
        if (comboConsulta.getItemCount() > 0) {
            comboConsulta.setSelectedIndex(0);
        }
    }

    public void limpiarRecomendaciones() {
        txtaRecomendaciones.setText("");
    }
    
    public void limpiarMedicamentos(){
        txtaMedicamentos.setText("");
    }



// Método para limpiar todos los componentes
    public void limpiar() {
        limpiarDiagnostico();
        limpiarSintomas();
        limpiarIdConsulta();
        limpiarRecomendaciones();
        limpiarMedicamentos();
        if(comboConsulta.getItemCount()>0)comboConsulta.removeAllItems();
    }

    public boolean tieneCamposVacios() {
        return txtaDiagnostico.getText().isEmpty()
                || txtaSintomas.getText().isEmpty()
                || txtaRecomendaciones.getText().isEmpty();
    }

    public void agregarEventos(ControladorRegistroReceta controlador) {
        this.btnGuardar.addActionListener(controlador);
        this.btnCancelar.addActionListener(controlador);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtaSintomas = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtaDiagnostico = new javax.swing.JTextArea();
        comboConsulta = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtaRecomendaciones = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtaMedicamentos = new javax.swing.JTextArea();
        etiquetaMedicamentos = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Información de la receta");
        setResizable(false);

        jLabel1.setBackground(new java.awt.Color(51, 102, 255));
        jLabel1.setFont(new java.awt.Font("Lucida Sans", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Información de la Receta");
        jLabel1.setOpaque(true);

        jLabel12.setText("Diagnostico:");

        jLabel3.setText("ID Consulta:");

        btnGuardar.setText("Guardar");
        btnGuardar.setName("guardar"); // NOI18N

        btnCancelar.setText("Cancelar");
        btnCancelar.setName("cancelar"); // NOI18N

        jLabel13.setText("Recomendaciones:");

        txtaSintomas.setColumns(20);
        txtaSintomas.setRows(5);
        jScrollPane2.setViewportView(txtaSintomas);

        jLabel14.setText("Sintomas:");

        txtaDiagnostico.setColumns(20);
        txtaDiagnostico.setRows(5);
        jScrollPane3.setViewportView(txtaDiagnostico);

        txtaRecomendaciones.setColumns(20);
        txtaRecomendaciones.setRows(5);
        jScrollPane4.setViewportView(txtaRecomendaciones);

        txtaMedicamentos.setColumns(20);
        txtaMedicamentos.setRows(5);
        jScrollPane5.setViewportView(txtaMedicamentos);

        etiquetaMedicamentos.setText("Medicamentos:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnGuardar)
                        .addGap(120, 120, 120))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etiquetaMedicamentos)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane5)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel12))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(comboConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)))
                        .addGap(184, 184, 184)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCancelar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jScrollPane2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel14)
                                .addGap(482, 482, 482))
                            .addComponent(jScrollPane4))
                        .addGap(73, 73, 73))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(etiquetaMedicamentos))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                    .addComponent(jScrollPane5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addGap(79, 79, 79))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCancelar;
    public javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> comboConsulta;
    private javax.swing.JLabel etiquetaMedicamentos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea txtaDiagnostico;
    private javax.swing.JTextArea txtaMedicamentos;
    private javax.swing.JTextArea txtaRecomendaciones;
    private javax.swing.JTextArea txtaSintomas;
    // End of variables declaration//GEN-END:variables
}
