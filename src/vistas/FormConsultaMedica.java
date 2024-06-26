/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas;

import controladores.ControladorRegistroConsulta;
import dao.DAOMedico;
import dao.DAOPaciente;
import excepciones.EntradaInvalida;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import modelos.ConsultaMedica;
import modelos.Medico;
import modelos.Paciente;

/**
 *
 * @author amoel
 */
public class FormConsultaMedica extends javax.swing.JFrame {

    /**
     * Creates new form RegistroConsultaMedica
     */
    private Paciente paciente;
    private Medico medico;
    private DAOPaciente daoPaciente;
    private DAOMedico dAOMedico;
    private ArrayList<Paciente> listaPacientes;
    private ArrayList<Medico> listaMedico;
    private ConsultaMedica consulta;
    private boolean actualizar;
    
    public FormConsultaMedica() {
        initComponents();
        daoPaciente = new DAOPaciente();
        dAOMedico = new DAOMedico();
        listaPacientes = daoPaciente.consultar();
        listaMedico = dAOMedico.consultar();
        
        for(Paciente p: listaPacientes){
            comboPaciente.addItem(p.getNombre());
        }
        
        for(Medico m : listaMedico){
            comboMedico.addItem(m.getNombre());
        }
    }
    
    public void cargarConsulta(ConsultaMedica consulta){
        this.consulta = consulta;
        txtFecha.setText(consulta.getFecha());
    }
    
    public ConsultaMedica obtenerConsulta() throws EntradaInvalida{
        String fecha = this.obtenerFecha();
        // Expresión regular para el formato AAAA/MM/DD
        String regex = "^(\\d{4})[/-](0[1-9]|1[0-2])[/-](0[1-9]|[1-2][0-9]|3[0-1])$";

        // Compilar la expresión regular en un objeto Pattern
        Pattern pattern = Pattern.compile(regex);

        // Crear un objeto Matcher para buscar la expresión regular en la cadena de fecha
        Matcher matcher = pattern.matcher(fecha);
        
        if (!matcher.matches())throw new EntradaInvalida("Formato de fecha no válido.\nProporcione una fecha de la forma AAAA/MM/DD.");
        consulta.setIdMedico(obtenerIdMedico());
        consulta.setIdPaciente(obtenerIdPaciente());
        consulta.setFecha(obtenerFecha());
        return consulta;
    }

    public boolean getActualizar() {
        return actualizar;
    }

    public void setActualizar(boolean actualizar) {
        this.actualizar = actualizar;
    }
    
    
    public String obtenerFecha() {
        return txtFecha.getText();
    }
    
    public long obtenerIdMedico() {
        int pos = comboMedico.getSelectedIndex();
        return listaMedico.get(pos).getId();
    }
    
    public long obtenerIdPaciente() {
        int pos = comboPaciente.getSelectedIndex();
        return listaPacientes.get(pos).getId();
    }
    
    public void limpiarFecha(){
        txtFecha.setText("");
    }
    
    public void limpiar() {
        comboPaciente.setSelectedIndex(0);
        comboMedico.setSelectedIndex(0);
        limpiarFecha();
    }
    
    public boolean tieneCamposVacios(){
        return txtFecha.getText().isEmpty();
    }
    

    public void agregarEventos(ControladorRegistroConsulta controlador){
        this.btnAgregar.addActionListener(controlador);
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

        jLabel12 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtFecha = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        comboPaciente = new javax.swing.JComboBox<>();
        comboMedico = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Información de la consulta");
        setResizable(false);

        jLabel12.setText("Medico:");

        jLabel3.setText("Paciente:");

        jLabel1.setBackground(new java.awt.Color(51, 102, 255));
        jLabel1.setFont(new java.awt.Font("Lucida Sans", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Información de la Consulta");
        jLabel1.setOpaque(true);

        btnAgregar.setText("Guardar");
        btnAgregar.setName("guardar"); // NOI18N

        btnCancelar.setText("Cancelar");
        btnCancelar.setName("cancelar"); // NOI18N

        jLabel13.setText("Fecha:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar)
                        .addGap(54, 54, 54))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel3))
                                .addGap(22, 22, 22))
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(comboPaciente, 0, 255, Short.MAX_VALUE)
                                .addComponent(txtFecha))
                            .addComponent(comboMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(comboMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnCancelar))
                .addGap(0, 103, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAgregar;
    public javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox<String> comboMedico;
    private javax.swing.JComboBox<String> comboPaciente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    public javax.swing.JTextField txtFecha;
    // End of variables declaration//GEN-END:variables
}
