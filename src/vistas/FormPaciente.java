/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas;

import controladores.ControladorRegistroPaciente;
import excepciones.EntradaInvalida;
import modelos.Paciente;

/**
 *
 * @author amoel
 */
public class FormPaciente extends javax.swing.JFrame {
    private boolean actualizar ;
    private Paciente paciente;
    /**
     * Creates new form RegistroPaciente
     */
    public FormPaciente() {
        initComponents();
        paciente = new Paciente();
    }
    
    public void cargarPaciente(Paciente paciente){
        this.paciente = paciente;
        txtNombre.setText(paciente.getNombre());
        txtAltura.setText(Float.toString(paciente.getAltura()));
        txtPeso.setText(Float.toString(paciente.getPeso()));
        txtDireccion.setText(paciente.getDireccion());
        txtTelefono.setText(paciente.getTelefono());
        txtCorreo.setText(paciente.getCorreoElectronico());
        txtFechaNacimiento.setText(paciente.getFechaNacimiento());
        comboSexo.setSelectedItem(paciente.getSexo());
        comboSangre.setSelectedItem(paciente.getTipoSangre());
    }
    
    public Paciente obtenerPaciente() throws EntradaInvalida{
        if (!obtenerNombre().matches("^[a-zA-Z]+(?:\\s[a-zA-Z]+)*$")) {
            throw new EntradaInvalida("Nombre no válido.");
        }
        
        if (obtenerNombre().length()>=255) {
            throw new EntradaInvalida("La longitud del nombre no puede ser mayor a 255 caracteres.");
        }
        
        if (!Float.toString(obtenerAltura()).matches("^\\d{1,2}(\\.\\d+)?$")) {
            throw new EntradaInvalida("Altura no válida.");
        }
        
        if (!Float.toString(obtenerPeso()).matches("^\\d+(\\.\\d+)?$")) {
            throw new EntradaInvalida("Peso no válido.");
        }
        
        if (obtenerDireccion().length()>=255) {
            throw new EntradaInvalida("La dirección no puede exceder los 255 caracteres de longitud.");
        }
        
        if (!obtenerTelefono().matches("^\\d{10}$")) {
            throw new EntradaInvalida("Teléfono no válido.\n El teléfono debe contener 10 dígitos.");
        }
        
        if (!obtenerCorreo().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            throw new EntradaInvalida("Correo electrónico no válido.");
        }
        
        if (obtenerCorreo().length()>=255) {
            throw new EntradaInvalida("El correo electrónico no puede exceder los 254 caracteres de longitud.");
        }
        
        
        if (!obtenerFechaNacimiento().matches("^\\d{4}[-/]((0[1-9])|(1[0-2]))[-/]((0[1-9])|([1-2][0-9])|(3[0-1]))$")) {
            throw new EntradaInvalida("Fecha no válida.\nLa fecha debe estar en formato AAAA/MM/DD o AAAA-MM-DD.");
        }
        
        
        paciente.setNombre(obtenerNombre());
        paciente.setAltura(obtenerAltura());
        paciente.setPeso(obtenerPeso());
        paciente.setDireccion(obtenerDireccion());
        paciente.setTelefono(obtenerTelefono());
        paciente.setCorreoElectronico(obtenerCorreo());
        paciente.setFechaNacimiento(obtenerFechaNacimiento());
        paciente.setSexo(obtenerSexo());
        paciente.setTipoSangre(obtenerSangre());
        return paciente;
    }

    public boolean getActualizar() {
        return actualizar;
    }

    public void setActualizar(boolean actualizar) {
        this.actualizar = actualizar;
    }

    
    
    public float obtenerAltura() {
        return Float.parseFloat(txtAltura.getText());
    }

    public String obtenerCorreo() {
        return txtCorreo.getText();
    }

    public String obtenerDireccion() {
        return txtDireccion.getText();
    }

    public String obtenerFechaNacimiento() {
        return txtFechaNacimiento.getText();
    }

    public String obtenerNombre() {
        return txtNombre.getText();
    }

    public float obtenerPeso() {
        return Float.parseFloat(txtPeso.getText());
    }

    public String obtenerTelefono() {
        return txtTelefono.getText();
    }

    public String obtenerSangre() {
        return (String) comboSangre.getSelectedItem();
    }

    public String obtenerSexo() {
        return (String) comboSexo.getSelectedItem();
    }

    public void limpiarAltura() {
        txtAltura.setText("");
    }

    public void limpiarCorreo() {
        txtCorreo.setText("");
    }

    public void limpiarDireccion() {
        txtDireccion.setText("");
    }

    public void limpiarFechaNacimiento() {
        txtFechaNacimiento.setText("");
    }

    public void limpiarNombre() {
        txtNombre.setText("");
    }

    public void limpiarPeso() {
        txtPeso.setText("");
    }

    public void limpiarTelefono() {
        txtTelefono.setText("");
    }

    public void limpiarComboSangre() {
        comboSangre.setSelectedIndex(0);
    }

    public void limpiarComboSexo() {
        comboSexo.setSelectedIndex(0);
    }

    public void limpiar() {
        limpiarAltura();
        limpiarCorreo();
        limpiarDireccion();
        limpiarFechaNacimiento();
        limpiarNombre();
        limpiarPeso();
        limpiarTelefono();
        limpiarComboSangre();
        limpiarComboSexo();
    }

    public boolean tieneCamposVacios() {
        return txtAltura.getText().isEmpty()
                || txtCorreo.getText().isEmpty()
                || txtDireccion.getText().isEmpty()
                || txtFechaNacimiento.getText().isEmpty()
                || txtNombre.getText().isEmpty()
                || txtPeso.getText().isEmpty()
                || txtTelefono.getText().isEmpty();
    }

    public void agregarEventos(ControladorRegistroPaciente controlador) {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        comboSexo = new javax.swing.JComboBox<>();
        txtAltura = new javax.swing.JTextField();
        txtPeso = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtFechaNacimiento = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        botonGuardar = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();
        comboSangre = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Información del paciente");
        setResizable(false);

        jLabel1.setBackground(new java.awt.Color(51, 102, 255));
        jLabel1.setFont(new java.awt.Font("Lucida Sans", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Información del Paciente");
        jLabel1.setOpaque(true);

        jLabel3.setText("Nombre:");

        jLabel7.setText("Sexo:");

        comboSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino" }));

        jLabel9.setText("Altura:");

        jLabel10.setText("Peso:");

        jLabel11.setText("Direccion:");

        jLabel13.setText("Fecha de Nacimiento:");

        botonGuardar.setText("Guardar");
        botonGuardar.setName("guardar"); // NOI18N

        botonCancelar.setText("Cancelar");
        botonCancelar.setName("cancelar"); // NOI18N

        comboSangre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-" }));

        jLabel8.setText("Tipo de Sangre:");

        jLabel12.setText("Telefono:");

        jLabel14.setText("Correo Electronico:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel12)
                    .addComponent(jLabel14)
                    .addComponent(jLabel13)
                    .addComponent(botonGuardar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtFechaNacimiento)
                    .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPeso, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAltura, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(botonCancelar))
                    .addComponent(comboSangre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboSexo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(108, 108, 108))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(comboSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboSangre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAltura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonGuardar)
                    .addComponent(botonCancelar))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton botonCancelar;
    public javax.swing.JButton botonGuardar;
    public javax.swing.JComboBox<String> comboSangre;
    public javax.swing.JComboBox<String> comboSexo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public javax.swing.JTextField txtAltura;
    public javax.swing.JTextField txtCorreo;
    public javax.swing.JTextField txtDireccion;
    public javax.swing.JTextField txtFechaNacimiento;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtPeso;
    public javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
