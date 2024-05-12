/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas;

import controladores.ControladorRegistroReceta;
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
import modelos.DetalleReceta;
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
    private DetalleReceta detalleReceta;
    private HashMap<Long, ConsultaMedica> catalogoConsultas;
    private HashMap<String, Long> catalogoMedicamentos;
    private HashSet<String> listaMedicamentos;
    private DefaultTableModel modeloTablaMedicamentos;

    /**
     * Creates new form RegistroReceta
     */
    public FormReceta() {
        initComponents();
        modeloTablaMedicamentos = (DefaultTableModel) tablaMedicamentos.getModel();
        catalogoConsultas = new HashMap<Long,ConsultaMedica>();
        listaMedicamentos = new HashSet<String>();
    }

    public void cargarCatalogoMedicamentos(ArrayList<Medicamento> catalogoMedicamentos) {
        for (Medicamento m : catalogoMedicamentos) {
            comboMedicamento.addItem(m.getNombre());
        }
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

    public void cargarMedicamentos(ArrayList<Medicamento> medicamentos) {
        modeloTablaMedicamentos.setRowCount(0);
        for (Medicamento m : medicamentos) {
            modeloTablaMedicamentos.addRow(new Object[]{m.getNombre()});
            listaMedicamentos.add(m.getNombre());
        }
    }

    public HashSet<String> obtenerMedicamentosSeleccionados() {
        return this.listaMedicamentos;
    }

    public String obtenerMedicamentoSeleccionadoCombo() {
        return comboMedicamento.getSelectedItem().toString();
    }

    public String obtenerMedicamentoSeleccionadoTabla() {
        int filaSeleccionada = this.tablaMedicamentos.getSelectedRow();
        if (filaSeleccionada != -1) {
            return modeloTablaMedicamentos.getValueAt(filaSeleccionada, 0).toString();
        }
        return null;
    }

    public void agregarMedicamento() {
        modeloTablaMedicamentos.addRow(new Object[]{comboMedicamento.getSelectedItem()});
    }

    public void eliminarMedicamento() {
        int filaSeleccionada = tablaMedicamentos.getSelectedRow();
        if (filaSeleccionada != -1) {
            modeloTablaMedicamentos.removeRow(filaSeleccionada);
        }
    }

    public Receta obtenerReceta() {
        return receta = new Receta(obtenerIdConsulta(), obtenerDiagnostico(), obtenerSintomas(), obtenerRecomendaciones());
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

    public String obtenerMedicamento() {
        return (String) comboMedicamento.getSelectedItem();
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

    public void limpiarComboMedicamento() {
        if (comboMedicamento.getItemCount() > 0) {
            comboMedicamento.setSelectedIndex(0);
        }
    }

    public void limpiarMedicamentos() {
        modeloTablaMedicamentos.setRowCount(0);
    }

// Método para limpiar todos los componentes
    public void limpiar() {
        limpiarDiagnostico();
        limpiarSintomas();
        limpiarIdConsulta();
        limpiarRecomendaciones();
        limpiarComboMedicamento();
        limpiarMedicamentos();
        if(comboMedicamento.getItemCount()>0)comboMedicamento.removeAllItems();
        if(comboConsulta.getItemCount()>0)comboConsulta.removeAllItems();
        this.listaMedicamentos.clear();
    }

    public boolean tieneCamposVacios() {
        return txtaDiagnostico.getText().isEmpty()
                || txtaSintomas.getText().isEmpty()
                || txtaRecomendaciones.getText().isEmpty()
                || tablaMedicamentos.getModel().getRowCount() == 0;
    }

    public void agregarEventos(ControladorRegistroReceta controlador) {
        this.btnAgregarMedicamento.addActionListener(controlador);
        this.btnEliminarMedicamento.addActionListener(controlador);
        this.btnAgregar.addActionListener(controlador);
        this.btnCancelar.addActionListener(controlador);
    }

    public ConsultaMedica getConsulta() {
        return consulta;
    }

    public void setConsulta(ConsultaMedica consulta) {
        this.consulta = consulta;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    public DefaultTableModel getModeloListaMedicamentos() {
        return modeloTablaMedicamentos;
    }

    public void setModeloListaMedicamentos(DefaultTableModel modeloListaMedicamentos) {
        this.modeloTablaMedicamentos = modeloListaMedicamentos;
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public void setBtnAgregar(JButton btnAgregar) {
        this.btnAgregar = btnAgregar;
    }

    public JButton getBtnAgregarMedicamento() {
        return btnAgregarMedicamento;
    }

    public void setBtnAgregarMedicamento(JButton btnAgregarMedicamento) {
        this.btnAgregarMedicamento = btnAgregarMedicamento;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public void setBtnCancelar(JButton btnCancelar) {
        this.btnCancelar = btnCancelar;
    }

    public JButton getBtnEliminarMedicamento() {
        return btnEliminarMedicamento;
    }

    public void setBtnEliminarMedicamento(JButton btnEliminarMedicamento) {
        this.btnEliminarMedicamento = btnEliminarMedicamento;
    }

    public JComboBox<String> getComboConsulta() {
        return comboConsulta;
    }

    public void setComboConsulta(JComboBox<String> comboConsulta) {
        this.comboConsulta = comboConsulta;
    }

    public JComboBox<String> getComboMedicamento() {
        return comboMedicamento;
    }

    public void setComboMedicamento(JComboBox<String> comboMedicamento) {
        this.comboMedicamento = comboMedicamento;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JLabel getjLabel12() {
        return jLabel12;
    }

    public void setjLabel12(JLabel jLabel12) {
        this.jLabel12 = jLabel12;
    }

    public JLabel getjLabel13() {
        return jLabel13;
    }

    public void setjLabel13(JLabel jLabel13) {
        this.jLabel13 = jLabel13;
    }

    public JLabel getjLabel14() {
        return jLabel14;
    }

    public void setjLabel14(JLabel jLabel14) {
        this.jLabel14 = jLabel14;
    }

    public JLabel getjLabel3() {
        return jLabel3;
    }

    public void setjLabel3(JLabel jLabel3) {
        this.jLabel3 = jLabel3;
    }

    public JScrollPane getjScrollPane2() {
        return jScrollPane2;
    }

    public void setjScrollPane2(JScrollPane jScrollPane2) {
        this.jScrollPane2 = jScrollPane2;
    }

    public JScrollPane getjScrollPane3() {
        return jScrollPane3;
    }

    public void setjScrollPane3(JScrollPane jScrollPane3) {
        this.jScrollPane3 = jScrollPane3;
    }

    public JScrollPane getjScrollPane4() {
        return jScrollPane4;
    }

    public void setjScrollPane4(JScrollPane jScrollPane4) {
        this.jScrollPane4 = jScrollPane4;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JTable getTablaMedicamentos() {
        return tablaMedicamentos;
    }

    public void setTablaMedicamentos(JTable jTable1) {
        this.tablaMedicamentos = jTable1;
    }

    public JTextArea getTxaDiagnostico() {
        return txtaDiagnostico;
    }

    public void setTxaDiagnostico(JTextArea txaDiagnostico) {
        this.txtaDiagnostico = txaDiagnostico;
    }

    public JTextArea getTxaSintomas() {
        return txtaSintomas;
    }

    public void setTxaSintomas(JTextArea txaSintomas) {
        this.txtaSintomas = txaSintomas;
    }

    public JTextArea getDiagnostico() {
        return txtaDiagnostico;
    }

    public void setDiagnostico(JTextArea txaDiagnostico) {
        this.txtaDiagnostico = txaDiagnostico;
    }

    public JTextArea getSintomas() {
        return txtaSintomas;
    }

    public void setSintomas(JTextArea txaSintomas) {
        this.txtaSintomas = txaSintomas;
    }

    public JTextArea getTxtaRecomendaciones() {
        return txtaRecomendaciones;
    }

    public void setTxtaRecomendaciones(JTextArea txtaRecomendaciones) {
        this.txtaRecomendaciones = txtaRecomendaciones;
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
        btnAgregar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtaSintomas = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtaDiagnostico = new javax.swing.JTextArea();
        comboMedicamento = new javax.swing.JComboBox<>();
        btnAgregarMedicamento = new javax.swing.JButton();
        btnEliminarMedicamento = new javax.swing.JButton();
        comboConsulta = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtaRecomendaciones = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaMedicamentos = new javax.swing.JTable();
        botonAumentar = new javax.swing.JButton();
        botonDisminuir = new javax.swing.JButton();

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

        btnAgregar.setText("Guardar");
        btnAgregar.setName("guardar"); // NOI18N

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

        btnAgregarMedicamento.setText("Agregar Medicamento");
        btnAgregarMedicamento.setName("agregar_medicamento"); // NOI18N

        btnEliminarMedicamento.setText("Eliminar Medicamento");
        btnEliminarMedicamento.setName("eliminar_medicamento"); // NOI18N

        txtaRecomendaciones.setColumns(20);
        txtaRecomendaciones.setRows(5);
        jScrollPane4.setViewportView(txtaRecomendaciones);

        tablaMedicamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Medicamento", "Cantidad"
            }
        ));
        jScrollPane1.setViewportView(tablaMedicamentos);

        botonAumentar.setText("Aumentar cantidad");

        botonDisminuir.setText("Disminuir cantidad");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel12))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(comboMedicamento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnAgregarMedicamento, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                                        .addComponent(btnEliminarMedicamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(botonAumentar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(botonDisminuir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGap(184, 184, 184))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnAgregar)
                        .addGap(120, 120, 120)))
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
                .addComponent(jLabel13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(comboMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAgregarMedicamento)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminarMedicamento)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(botonAumentar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botonDisminuir))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(127, 158, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAgregar)
                            .addComponent(btnCancelar))
                        .addGap(79, 79, 79))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAumentar;
    private javax.swing.JButton botonDisminuir;
    public javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAgregarMedicamento;
    public javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminarMedicamento;
    private javax.swing.JComboBox<String> comboConsulta;
    private javax.swing.JComboBox<String> comboMedicamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tablaMedicamentos;
    private javax.swing.JTextArea txtaDiagnostico;
    private javax.swing.JTextArea txtaRecomendaciones;
    private javax.swing.JTextArea txtaSintomas;
    // End of variables declaration//GEN-END:variables
}
