/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas;

import controladores.ControladorVistaConsultas;
import controladores.ControladorVistaMedicamentos;
import controladores.ControladorVistaMedicos;
import controladores.ControladorVistaPacientes;
import controladores.ControladorVistaRecetas;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author kevin
 */
public class MenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal() {
        initComponents();
    }
    
    public void agregarEventos(){
        
    }
    
    public void agregarEventosVistaMedicamentos(ControladorVistaMedicamentos controlador){
    System.out.println("Se registraron los eventos correctamente");
    this.botonVerTodosMedicamentos.addActionListener(controlador);
    this.botonNuevoMedicamento.addActionListener(controlador);
    this.botonEditarMedicamento.addActionListener(controlador);
    this.botonEliminarMedicamento.addActionListener(controlador);
}

public void agregarEventosVistaMedicos(ControladorVistaMedicos controlador){
    this.botonVerTodosMedicos.addActionListener(controlador);
    this.botonNuevoMedico.addActionListener(controlador);
    this.botonEditarMedico.addActionListener(controlador);
    this.botonEliminarMedico.addActionListener(controlador);
}

public void agregarEventosVistaPacientes(ControladorVistaPacientes controlador){
    this.botonVerTodosPacientes.addActionListener(controlador);
    this.botonNuevoPaciente.addActionListener(controlador);
    this.botonEditarPaciente.addActionListener(controlador);
    this.botonEliminarPaciente.addActionListener(controlador);
}

public void agregarEventosVistaRecetas(ControladorVistaRecetas controlador){
    this.botonVerTodasRecetas.addActionListener(controlador);
    this.botonNuevaReceta.addActionListener(controlador);
    this.botonEditarReceta.addActionListener(controlador);
    this.botonEliminarReceta.addActionListener(controlador);
}

public void agregarEventosVistaConsultas(ControladorVistaConsultas controlador){
    this.botonVerTodasConsultas.addActionListener(controlador);
    this.botonNuevaConsulta.addActionListener(controlador);
    this.botonEditarConsulta.addActionListener(controlador);
    this.botonEliminarConsulta.addActionListener(controlador);
}


    public JTabbedPane getMedicamentos() {
        return Medicamentos;
    }

    public void setMedicamentos(JTabbedPane Medicamentos) {
        this.Medicamentos = Medicamentos;
    }

    public JPanel getPanelRecetas() {
        return PanelRecetas;
    }

    public void setPanelRecetas(JPanel PanelRecetas) {
        this.PanelRecetas = PanelRecetas;
    }

    public JButton getBotonBuscarConsultas() {
        return botonBuscarConsultas;
    }

    public void setBotonBuscarConsultas(JButton botonBuscarConsultas) {
        this.botonBuscarConsultas = botonBuscarConsultas;
    }

    public JButton getBotonBuscarMedicamentos() {
        return botonBuscarMedicamentos;
    }

    public void setBotonBuscarMedicamentos(JButton botonBuscarMedicamentos) {
        this.botonBuscarMedicamentos = botonBuscarMedicamentos;
    }

    public JButton getBotonBuscarMedicos() {
        return botonBuscarMedicos;
    }

    public void setBotonBuscarMedicos(JButton botonBuscarMedicos) {
        this.botonBuscarMedicos = botonBuscarMedicos;
    }

    public JButton getBotonBuscarPacientes() {
        return botonBuscarPacientes;
    }

    public void setBotonBuscarPacientes(JButton botonBuscarPacientes) {
        this.botonBuscarPacientes = botonBuscarPacientes;
    }

    public JButton getBotonBuscarRecetas() {
        return botonBuscarRecetas;
    }

    public void setBotonBuscarRecetas(JButton botonBuscarRecetas) {
        this.botonBuscarRecetas = botonBuscarRecetas;
    }

    public JButton getBotonEditar2() {
        return botonEditarReceta;
    }

    public void setBotonEditar2(JButton botonEditar2) {
        this.botonEditarReceta = botonEditar2;
    }

    public JButton getBotonEditarConsulta() {
        return botonEditarConsulta;
    }

    public void setBotonEditarConsulta(JButton botonEditarConsulta) {
        this.botonEditarConsulta = botonEditarConsulta;
    }

    public JButton getBotonEditarMedicamento() {
        return botonEditarMedicamento;
    }

    public void setBotonEditarMedicamento(JButton botonEditarMedicamento) {
        this.botonEditarMedicamento = botonEditarMedicamento;
    }

    public JButton getBotonEditarMedico() {
        return botonEditarMedico;
    }

    public void setBotonEditarMedico(JButton botonEditarMedico) {
        this.botonEditarMedico = botonEditarMedico;
    }

    public JButton getBotonEditarPaciente() {
        return botonEditarPaciente;
    }

    public void setBotonEditarPaciente(JButton botonEditarPaciente) {
        this.botonEditarPaciente = botonEditarPaciente;
    }

    public JButton getBotonEliminar2() {
        return botonEliminarReceta;
    }

    public void setBotonEliminar2(JButton botonEliminar2) {
        this.botonEliminarReceta = botonEliminar2;
    }

    public JButton getBotonEliminarConsulta() {
        return botonEliminarConsulta;
    }

    public void setBotonEliminarConsulta(JButton botonEliminarConsulta) {
        this.botonEliminarConsulta = botonEliminarConsulta;
    }

    public JButton getBotonEliminarMedicamento() {
        return botonEliminarMedicamento;
    }

    public void setBotonEliminarMedicamento(JButton botonEliminarMedicamento) {
        this.botonEliminarMedicamento = botonEliminarMedicamento;
    }

    public JButton getBotonEliminarMedico() {
        return botonEliminarMedico;
    }

    public void setBotonEliminarMedico(JButton botonEliminarMedico) {
        this.botonEliminarMedico = botonEliminarMedico;
    }

    public JButton getBotonEliminarPaciente() {
        return botonEliminarPaciente;
    }

    public void setBotonEliminarPaciente(JButton botonEliminarPaciente) {
        this.botonEliminarPaciente = botonEliminarPaciente;
    }

    public JButton getBotonNuevaConsulta() {
        return botonNuevaConsulta;
    }

    public void setBotonNuevaConsulta(JButton botonNuevaConsulta) {
        this.botonNuevaConsulta = botonNuevaConsulta;
    }

    public JButton getBotonNuevo2() {
        return botonNuevaReceta;
    }

    public void setBotonNuevo2(JButton botonNuevo2) {
        this.botonNuevaReceta = botonNuevo2;
    }

    public JButton getBotonNuevoMedicamento() {
        return botonNuevoMedicamento;
    }

    public void setBotonNuevoMedicamento(JButton botonNuevoMedicamento) {
        this.botonNuevoMedicamento = botonNuevoMedicamento;
    }

    public JButton getBotonNuevoMedico() {
        return botonNuevoMedico;
    }

    public void setBotonNuevoMedico(JButton botonNuevoMedico) {
        this.botonNuevoMedico = botonNuevoMedico;
    }

    public JButton getBotonNuevoPaciente() {
        return botonNuevoPaciente;
    }

    public void setBotonNuevoPaciente(JButton botonNuevoPaciente) {
        this.botonNuevoPaciente = botonNuevoPaciente;
    }

    public JButton getBotonVerTodasConsultas() {
        return botonVerTodasConsultas;
    }

    public void setBotonVerTodasConsultas(JButton botonVerTodasConsultas) {
        this.botonVerTodasConsultas = botonVerTodasConsultas;
    }

    public JButton getBotonVerTodasRecetas() {
        return botonVerTodasRecetas;
    }

    public void setBotonVerTodasRecetas(JButton botonVerTodasRecetas) {
        this.botonVerTodasRecetas = botonVerTodasRecetas;
    }

    public JButton getBotonVerTodosMedicamentos() {
        return botonVerTodosMedicamentos;
    }

    public void setBotonVerTodosMedicamentos(JButton botonVerTodosMedicamentos) {
        this.botonVerTodosMedicamentos = botonVerTodosMedicamentos;
    }

    public JButton getBotonVerTodosMedicos() {
        return botonVerTodosMedicos;
    }

    public void setBotonVerTodosMedicos(JButton botonVerTodosMedicos) {
        this.botonVerTodosMedicos = botonVerTodosMedicos;
    }

    public JButton getBotonVerTodosPacientes() {
        return botonVerTodosPacientes;
    }

    public void setBotonVerTodosPacientes(JButton botonVerTodosPacientes) {
        this.botonVerTodosPacientes = botonVerTodosPacientes;
    }

    public JTextField getCampoBusquedaConsultas() {
        return campoBusquedaConsultas;
    }

    public void setCampoBusquedaConsultas(JTextField campoBusquedaConsultas) {
        this.campoBusquedaConsultas = campoBusquedaConsultas;
    }

    public JTextField getCampoBusquedaMedicamentos() {
        return campoBusquedaMedicamentos;
    }

    public void setCampoBusquedaMedicamentos(JTextField campoBusquedaMedicamentos) {
        this.campoBusquedaMedicamentos = campoBusquedaMedicamentos;
    }

    public JTextField getCampoBusquedaMedicos() {
        return campoBusquedaMedicos;
    }

    public void setCampoBusquedaMedicos(JTextField campoBusquedaMedicos) {
        this.campoBusquedaMedicos = campoBusquedaMedicos;
    }

    public JTextField getCampoBusquedaPacientes() {
        return campoBusquedaPacientes;
    }

    public void setCampoBusquedaPacientes(JTextField campoBusquedaPacientes) {
        this.campoBusquedaPacientes = campoBusquedaPacientes;
    }

    public JTextField getCampoBusquedaRecetas() {
        return campoBusquedaRecetas;
    }

    public void setCampoBusquedaRecetas(JTextField campoBusquedaRecetas) {
        this.campoBusquedaRecetas = campoBusquedaRecetas;
    }

    public JLabel getEtiquetaNombreConsultas() {
        return etiquetaNombreConsultas;
    }

    public void setEtiquetaNombreConsultas(JLabel etiquetaNombreConsultas) {
        this.etiquetaNombreConsultas = etiquetaNombreConsultas;
    }

    public JLabel getEtiquetaNombreMedicamentos() {
        return etiquetaNombreMedicamentos;
    }

    public void setEtiquetaNombreMedicamentos(JLabel etiquetaNombreMedicamentos) {
        this.etiquetaNombreMedicamentos = etiquetaNombreMedicamentos;
    }

    public JLabel getEtiquetaNombreMedico() {
        return etiquetaNombreMedico;
    }

    public void setEtiquetaNombreMedico(JLabel etiquetaNombreMedico) {
        this.etiquetaNombreMedico = etiquetaNombreMedico;
    }

    public JLabel getEtiquetaNombrePacientes() {
        return etiquetaNombrePacientes;
    }

    public void setEtiquetaNombrePacientes(JLabel etiquetaNombrePacientes) {
        this.etiquetaNombrePacientes = etiquetaNombrePacientes;
    }

    public JLabel getEtiquetaNombreRecetas() {
        return etiquetaNombreRecetas;
    }

    public void setEtiquetaNombreRecetas(JLabel etiquetaNombreRecetas) {
        this.etiquetaNombreRecetas = etiquetaNombreRecetas;
    }

    public JLabel getEtiquetaTitulo() {
        return etiquetaTitulo;
    }

    public void setEtiquetaTitulo(JLabel etiquetaTitulo) {
        this.etiquetaTitulo = etiquetaTitulo;
    }

    public JLabel getEtiquetaVersion() {
        return etiquetaVersion;
    }

    public void setEtiquetaVersion(JLabel etiquetaVersion) {
        this.etiquetaVersion = etiquetaVersion;
    }

    public JPanel getPanelConsultas() {
        return panelConsultas;
    }

    public void setPanelConsultas(JPanel panelConsultas) {
        this.panelConsultas = panelConsultas;
    }

    public JPanel getPanelMedicamentos() {
        return panelMedicamentos;
    }

    public void setPanelMedicamentos(JPanel panelMedicamentos) {
        this.panelMedicamentos = panelMedicamentos;
    }

    public JPanel getPanelMedicos() {
        return panelMedicos;
    }

    public void setPanelMedicos(JPanel panelMedicos) {
        this.panelMedicos = panelMedicos;
    }

    public JPanel getPanelNorteConsultas() {
        return panelNorteConsultas;
    }

    public void setPanelNorteConsultas(JPanel panelNorteConsultas) {
        this.panelNorteConsultas = panelNorteConsultas;
    }

    public JPanel getPanelNorteMedicamentos() {
        return panelNorteMedicamentos;
    }

    public void setPanelNorteMedicamentos(JPanel panelNorteMedicamentos) {
        this.panelNorteMedicamentos = panelNorteMedicamentos;
    }

    public JPanel getPanelNorteMedicos() {
        return panelNorteMedicos;
    }

    public void setPanelNorteMedicos(JPanel panelNorteMedicos) {
        this.panelNorteMedicos = panelNorteMedicos;
    }

    public JPanel getPanelNortePacientes() {
        return panelNortePacientes;
    }

    public void setPanelNortePacientes(JPanel panelNortePacientes) {
        this.panelNortePacientes = panelNortePacientes;
    }

    public JPanel getPanelNorteRecetas() {
        return panelNorteRecetas;
    }

    public void setPanelNorteRecetas(JPanel panelNorteRecetas) {
        this.panelNorteRecetas = panelNorteRecetas;
    }

    public JPanel getPanelPacientes() {
        return panelPacientes;
    }

    public void setPanelPacientes(JPanel panelPacientes) {
        this.panelPacientes = panelPacientes;
    }

    public JPanel getPanelPie() {
        return panelPie;
    }

    public void setPanelPie(JPanel panelPie) {
        this.panelPie = panelPie;
    }

    public JPanel getPanelSurConsultas() {
        return panelSurConsultas;
    }

    public void setPanelSurConsultas(JPanel panelSurConsultas) {
        this.panelSurConsultas = panelSurConsultas;
    }

    public JPanel getPanelSurMedicamentos() {
        return panelSurMedicamentos;
    }

    public void setPanelSurMedicamentos(JPanel panelSurMedicamentos) {
        this.panelSurMedicamentos = panelSurMedicamentos;
    }

    public JPanel getPanelSurMedicos() {
        return panelSurMedicos;
    }

    public void setPanelSurMedicos(JPanel panelSurMedicos) {
        this.panelSurMedicos = panelSurMedicos;
    }

    public JPanel getPanelSurPacientes() {
        return panelSurPacientes;
    }

    public void setPanelSurPacientes(JPanel panelSurPacientes) {
        this.panelSurPacientes = panelSurPacientes;
    }

    public JPanel getPanelSurRecetas() {
        return panelSurRecetas;
    }

    public void setPanelSurRecetas(JPanel panelSurRecetas) {
        this.panelSurRecetas = panelSurRecetas;
    }

    public JPanel getPanelTitulo() {
        return panelTitulo;
    }

    public void setPanelTitulo(JPanel panelTitulo) {
        this.panelTitulo = panelTitulo;
    }

    public JScrollPane getScrollConsultas() {
        return scrollConsultas;
    }

    public void setScrollConsultas(JScrollPane scrollConsultas) {
        this.scrollConsultas = scrollConsultas;
    }

    public JScrollPane getScrollMedicamentos() {
        return scrollMedicamentos;
    }

    public void setScrollMedicamentos(JScrollPane scrollMedicamentos) {
        this.scrollMedicamentos = scrollMedicamentos;
    }

    public JScrollPane getScrollMedicos() {
        return scrollMedicos;
    }

    public void setScrollMedicos(JScrollPane scrollMedicos) {
        this.scrollMedicos = scrollMedicos;
    }

    public JScrollPane getScrollPacientes() {
        return scrollPacientes;
    }

    public void setScrollPacientes(JScrollPane scrollPacientes) {
        this.scrollPacientes = scrollPacientes;
    }

    public JScrollPane getScrollRecetas() {
        return scrollRecetas;
    }

    public void setScrollRecetas(JScrollPane scrollRecetas) {
        this.scrollRecetas = scrollRecetas;
    }

    public JTable getTablaConsultas() {
        return tablaConsultas;
    }

    public void setTablaConsultas(JTable tablaConsultas) {
        this.tablaConsultas = tablaConsultas;
    }

    public JTable getTablaMedicamentos() {
        return tablaMedicamentos;
    }

    public void setTablaMedicamentos(JTable tablaMedicamentos) {
        this.tablaMedicamentos = tablaMedicamentos;
    }

    public JTable getTablaMedicos() {
        return tablaMedicos;
    }

    public void setTablaMedicos(JTable tablaMedicos) {
        this.tablaMedicos = tablaMedicos;
    }

    public JTable getTablaPacientes() {
        return tablaPacientes;
    }

    public void setTablaPacientes(JTable tablaPacientes) {
        this.tablaPacientes = tablaPacientes;
    }

    public JTable getTablaRecetas() {
        return tablaRecetas;
    }

    public void setTablaRecetas(JTable tablaRecetas) {
        this.tablaRecetas = tablaRecetas;
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        Medicamentos = new javax.swing.JTabbedPane();
        panelPacientes = new javax.swing.JPanel();
        scrollPacientes = new javax.swing.JScrollPane();
        tablaPacientes = new javax.swing.JTable();
        panelSurPacientes = new javax.swing.JPanel();
        botonVerTodosPacientes = new javax.swing.JButton();
        botonNuevoPaciente = new javax.swing.JButton();
        botonEditarPaciente = new javax.swing.JButton();
        botonEliminarPaciente = new javax.swing.JButton();
        panelNortePacientes = new javax.swing.JPanel();
        etiquetaNombrePacientes = new javax.swing.JLabel();
        campoBusquedaPacientes = new javax.swing.JTextField();
        botonBuscarPacientes = new javax.swing.JButton();
        panelMedicos = new javax.swing.JPanel();
        scrollMedicos = new javax.swing.JScrollPane();
        tablaMedicos = new javax.swing.JTable();
        panelSurMedicos = new javax.swing.JPanel();
        botonVerTodosMedicos = new javax.swing.JButton();
        botonNuevoMedico = new javax.swing.JButton();
        botonEditarMedico = new javax.swing.JButton();
        botonEliminarMedico = new javax.swing.JButton();
        panelNorteMedicos = new javax.swing.JPanel();
        etiquetaNombreMedico = new javax.swing.JLabel();
        campoBusquedaMedicos = new javax.swing.JTextField();
        botonBuscarMedicos = new javax.swing.JButton();
        panelConsultas = new javax.swing.JPanel();
        scrollConsultas = new javax.swing.JScrollPane();
        tablaConsultas = new javax.swing.JTable();
        panelSurConsultas = new javax.swing.JPanel();
        botonVerTodasConsultas = new javax.swing.JButton();
        botonNuevaConsulta = new javax.swing.JButton();
        botonEditarConsulta = new javax.swing.JButton();
        botonEliminarConsulta = new javax.swing.JButton();
        panelNorteConsultas = new javax.swing.JPanel();
        etiquetaNombreConsultas = new javax.swing.JLabel();
        campoBusquedaConsultas = new javax.swing.JTextField();
        botonBuscarConsultas = new javax.swing.JButton();
        PanelRecetas = new javax.swing.JPanel();
        scrollRecetas = new javax.swing.JScrollPane();
        tablaRecetas = new javax.swing.JTable();
        panelSurRecetas = new javax.swing.JPanel();
        botonVerTodasRecetas = new javax.swing.JButton();
        botonNuevaReceta = new javax.swing.JButton();
        botonEditarReceta = new javax.swing.JButton();
        botonEliminarReceta = new javax.swing.JButton();
        panelNorteRecetas = new javax.swing.JPanel();
        etiquetaNombreRecetas = new javax.swing.JLabel();
        campoBusquedaRecetas = new javax.swing.JTextField();
        botonBuscarRecetas = new javax.swing.JButton();
        panelMedicamentos = new javax.swing.JPanel();
        scrollMedicamentos = new javax.swing.JScrollPane();
        tablaMedicamentos = new javax.swing.JTable();
        panelSurMedicamentos = new javax.swing.JPanel();
        botonVerTodosMedicamentos = new javax.swing.JButton();
        botonNuevoMedicamento = new javax.swing.JButton();
        botonEditarMedicamento = new javax.swing.JButton();
        botonEliminarMedicamento = new javax.swing.JButton();
        panelNorteMedicamentos = new javax.swing.JPanel();
        etiquetaNombreMedicamentos = new javax.swing.JLabel();
        campoBusquedaMedicamentos = new javax.swing.JTextField();
        botonBuscarMedicamentos = new javax.swing.JButton();
        panelTitulo = new javax.swing.JPanel();
        etiquetaTitulo = new javax.swing.JLabel();
        panelPie = new javax.swing.JPanel();
        etiquetaVersion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mi Consultorio");

        Medicamentos.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        Medicamentos.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N

        panelPacientes.setLayout(new java.awt.BorderLayout());

        tablaPacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Tipo de sangre", "Sexo", "Altura", "Peso", "Fecha de nacimiento", "Dirección", "Teléfono", "Correo electrónico"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollPacientes.setViewportView(tablaPacientes);

        panelPacientes.add(scrollPacientes, java.awt.BorderLayout.CENTER);

        botonVerTodosPacientes.setText("Ver todos");
        botonVerTodosPacientes.setName("todos_pacientes"); // NOI18N
        panelSurPacientes.add(botonVerTodosPacientes);

        botonNuevoPaciente.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        botonNuevoPaciente.setText("Nuevo paciente");
        botonNuevoPaciente.setName("nuevo_paciente"); // NOI18N
        botonNuevoPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNuevoPacienteActionPerformed(evt);
            }
        });
        panelSurPacientes.add(botonNuevoPaciente);

        botonEditarPaciente.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        botonEditarPaciente.setText("Editar paciente");
        botonEditarPaciente.setName("editar_paciente"); // NOI18N
        panelSurPacientes.add(botonEditarPaciente);

        botonEliminarPaciente.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        botonEliminarPaciente.setText("Eliminar paciente");
        botonEliminarPaciente.setName("eliminar_paciente"); // NOI18N
        panelSurPacientes.add(botonEliminarPaciente);

        panelPacientes.add(panelSurPacientes, java.awt.BorderLayout.PAGE_END);

        panelNortePacientes.setLayout(new java.awt.GridBagLayout());

        etiquetaNombrePacientes.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        etiquetaNombrePacientes.setText("Nombre:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.weightx = 0.15;
        panelNortePacientes.add(etiquetaNombrePacientes, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.7;
        panelNortePacientes.add(campoBusquedaPacientes, gridBagConstraints);

        botonBuscarPacientes.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        botonBuscarPacientes.setText("Buscar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.weightx = 0.15;
        panelNortePacientes.add(botonBuscarPacientes, gridBagConstraints);

        panelPacientes.add(panelNortePacientes, java.awt.BorderLayout.PAGE_START);

        Medicamentos.addTab("Pacientes", panelPacientes);

        panelMedicos.setLayout(new java.awt.BorderLayout());

        tablaMedicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Especialidad", "Cedula", "Instituto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollMedicos.setViewportView(tablaMedicos);

        panelMedicos.add(scrollMedicos, java.awt.BorderLayout.CENTER);

        botonVerTodosMedicos.setText("Ver todos");
        botonVerTodosMedicos.setName("todos_medicos"); // NOI18N
        panelSurMedicos.add(botonVerTodosMedicos);

        botonNuevoMedico.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        botonNuevoMedico.setText("Nuevo médico");
        botonNuevoMedico.setName("nuevo_medico"); // NOI18N
        botonNuevoMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNuevoMedicoActionPerformed(evt);
            }
        });
        panelSurMedicos.add(botonNuevoMedico);

        botonEditarMedico.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        botonEditarMedico.setText("Editar medico");
        botonEditarMedico.setName("editar_medico"); // NOI18N
        panelSurMedicos.add(botonEditarMedico);

        botonEliminarMedico.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        botonEliminarMedico.setText("Eliminar medico");
        botonEliminarMedico.setName("eliminar_medico"); // NOI18N
        panelSurMedicos.add(botonEliminarMedico);

        panelMedicos.add(panelSurMedicos, java.awt.BorderLayout.PAGE_END);

        panelNorteMedicos.setLayout(new java.awt.GridBagLayout());

        etiquetaNombreMedico.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        etiquetaNombreMedico.setText("Nombre:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.weightx = 0.15;
        panelNorteMedicos.add(etiquetaNombreMedico, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.7;
        panelNorteMedicos.add(campoBusquedaMedicos, gridBagConstraints);

        botonBuscarMedicos.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        botonBuscarMedicos.setText("Buscar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.weightx = 0.15;
        panelNorteMedicos.add(botonBuscarMedicos, gridBagConstraints);

        panelMedicos.add(panelNorteMedicos, java.awt.BorderLayout.PAGE_START);

        Medicamentos.addTab("Médicos", panelMedicos);

        panelConsultas.setLayout(new java.awt.BorderLayout());

        tablaConsultas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Paciente", "Medico", "Fecha"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollConsultas.setViewportView(tablaConsultas);

        panelConsultas.add(scrollConsultas, java.awt.BorderLayout.CENTER);

        botonVerTodasConsultas.setText("Ver todas");
        botonVerTodasConsultas.setName("todas_consultas"); // NOI18N
        panelSurConsultas.add(botonVerTodasConsultas);

        botonNuevaConsulta.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        botonNuevaConsulta.setText("Programar consulta");
        botonNuevaConsulta.setName("nueva_consulta"); // NOI18N
        botonNuevaConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNuevaConsultaActionPerformed(evt);
            }
        });
        panelSurConsultas.add(botonNuevaConsulta);

        botonEditarConsulta.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        botonEditarConsulta.setText("Editar consulta");
        botonEditarConsulta.setName("editar_consulta"); // NOI18N
        panelSurConsultas.add(botonEditarConsulta);

        botonEliminarConsulta.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        botonEliminarConsulta.setText("Eliminar consulta");
        botonEliminarConsulta.setName("eliminar_consulta"); // NOI18N
        panelSurConsultas.add(botonEliminarConsulta);

        panelConsultas.add(panelSurConsultas, java.awt.BorderLayout.PAGE_END);

        panelNorteConsultas.setLayout(new java.awt.GridBagLayout());

        etiquetaNombreConsultas.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        etiquetaNombreConsultas.setText("Nombre:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.weightx = 0.15;
        panelNorteConsultas.add(etiquetaNombreConsultas, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.7;
        panelNorteConsultas.add(campoBusquedaConsultas, gridBagConstraints);

        botonBuscarConsultas.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        botonBuscarConsultas.setText("Buscar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.weightx = 0.15;
        panelNorteConsultas.add(botonBuscarConsultas, gridBagConstraints);

        panelConsultas.add(panelNorteConsultas, java.awt.BorderLayout.PAGE_START);

        Medicamentos.addTab("Consultas", panelConsultas);

        PanelRecetas.setLayout(new java.awt.BorderLayout());

        tablaRecetas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Consulta", "Diagnostico", "Síntomas", "Recomendaciones"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollRecetas.setViewportView(tablaRecetas);

        PanelRecetas.add(scrollRecetas, java.awt.BorderLayout.CENTER);

        botonVerTodasRecetas.setText("Ver todas");
        botonVerTodasRecetas.setName("todas_recetas"); // NOI18N
        panelSurRecetas.add(botonVerTodasRecetas);

        botonNuevaReceta.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        botonNuevaReceta.setText("Nueva receta");
        botonNuevaReceta.setName("nueva_receta"); // NOI18N
        botonNuevaReceta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNuevaRecetaActionPerformed(evt);
            }
        });
        panelSurRecetas.add(botonNuevaReceta);

        botonEditarReceta.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        botonEditarReceta.setText("Editar receta");
        botonEditarReceta.setName("editar_receta"); // NOI18N
        panelSurRecetas.add(botonEditarReceta);

        botonEliminarReceta.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        botonEliminarReceta.setText("Eliminar receta");
        botonEliminarReceta.setName("eliminar_receta"); // NOI18N
        panelSurRecetas.add(botonEliminarReceta);

        PanelRecetas.add(panelSurRecetas, java.awt.BorderLayout.PAGE_END);

        panelNorteRecetas.setLayout(new java.awt.GridBagLayout());

        etiquetaNombreRecetas.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        etiquetaNombreRecetas.setText("Nombre:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.weightx = 0.15;
        panelNorteRecetas.add(etiquetaNombreRecetas, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.7;
        panelNorteRecetas.add(campoBusquedaRecetas, gridBagConstraints);

        botonBuscarRecetas.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        botonBuscarRecetas.setText("Buscar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.weightx = 0.15;
        panelNorteRecetas.add(botonBuscarRecetas, gridBagConstraints);

        PanelRecetas.add(panelNorteRecetas, java.awt.BorderLayout.PAGE_START);

        Medicamentos.addTab("Recetas", PanelRecetas);

        panelMedicamentos.setLayout(new java.awt.BorderLayout());

        tablaMedicamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Existencia"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollMedicamentos.setViewportView(tablaMedicamentos);

        panelMedicamentos.add(scrollMedicamentos, java.awt.BorderLayout.CENTER);

        botonVerTodosMedicamentos.setText("Ver todos");
        botonVerTodosMedicamentos.setName("todos_medicamentos"); // NOI18N
        panelSurMedicamentos.add(botonVerTodosMedicamentos);

        botonNuevoMedicamento.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        botonNuevoMedicamento.setText("Nuevo medicamento");
        botonNuevoMedicamento.setName("nuevo_medicamento"); // NOI18N
        panelSurMedicamentos.add(botonNuevoMedicamento);

        botonEditarMedicamento.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        botonEditarMedicamento.setText("Editar medicamento");
        botonEditarMedicamento.setName("editar_medicamento"); // NOI18N
        panelSurMedicamentos.add(botonEditarMedicamento);

        botonEliminarMedicamento.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        botonEliminarMedicamento.setText("Eliminar medicamento");
        botonEliminarMedicamento.setName("eliminar_medicamento"); // NOI18N
        panelSurMedicamentos.add(botonEliminarMedicamento);

        panelMedicamentos.add(panelSurMedicamentos, java.awt.BorderLayout.PAGE_END);

        panelNorteMedicamentos.setLayout(new java.awt.GridBagLayout());

        etiquetaNombreMedicamentos.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        etiquetaNombreMedicamentos.setText("Nombre:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.weightx = 0.15;
        panelNorteMedicamentos.add(etiquetaNombreMedicamentos, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.7;
        panelNorteMedicamentos.add(campoBusquedaMedicamentos, gridBagConstraints);

        botonBuscarMedicamentos.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        botonBuscarMedicamentos.setText("Buscar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.weightx = 0.15;
        panelNorteMedicamentos.add(botonBuscarMedicamentos, gridBagConstraints);

        panelMedicamentos.add(panelNorteMedicamentos, java.awt.BorderLayout.PAGE_START);

        Medicamentos.addTab("Medicamentos", panelMedicamentos);

        getContentPane().add(Medicamentos, java.awt.BorderLayout.CENTER);

        panelTitulo.setBackground(new java.awt.Color(0, 102, 204));

        etiquetaTitulo.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        etiquetaTitulo.setForeground(new java.awt.Color(255, 255, 255));
        etiquetaTitulo.setText("Mi Consultorio");
        panelTitulo.add(etiquetaTitulo);

        getContentPane().add(panelTitulo, java.awt.BorderLayout.NORTH);

        panelPie.setBackground(new java.awt.Color(0, 102, 204));
        panelPie.setLayout(new java.awt.BorderLayout());

        etiquetaVersion.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        etiquetaVersion.setForeground(new java.awt.Color(255, 255, 255));
        etiquetaVersion.setText("V1.0");
        panelPie.add(etiquetaVersion, java.awt.BorderLayout.EAST);

        getContentPane().add(panelPie, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonNuevoMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNuevoMedicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonNuevoMedicoActionPerformed

    private void botonNuevaConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNuevaConsultaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonNuevaConsultaActionPerformed

    private void botonNuevaRecetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNuevaRecetaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonNuevaRecetaActionPerformed

    private void botonNuevoPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNuevoPacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonNuevoPacienteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane Medicamentos;
    private javax.swing.JPanel PanelRecetas;
    private javax.swing.JButton botonBuscarConsultas;
    private javax.swing.JButton botonBuscarMedicamentos;
    private javax.swing.JButton botonBuscarMedicos;
    private javax.swing.JButton botonBuscarPacientes;
    private javax.swing.JButton botonBuscarRecetas;
    private javax.swing.JButton botonEditarConsulta;
    private javax.swing.JButton botonEditarMedicamento;
    private javax.swing.JButton botonEditarMedico;
    private javax.swing.JButton botonEditarPaciente;
    private javax.swing.JButton botonEditarReceta;
    private javax.swing.JButton botonEliminarConsulta;
    private javax.swing.JButton botonEliminarMedicamento;
    private javax.swing.JButton botonEliminarMedico;
    private javax.swing.JButton botonEliminarPaciente;
    private javax.swing.JButton botonEliminarReceta;
    private javax.swing.JButton botonNuevaConsulta;
    private javax.swing.JButton botonNuevaReceta;
    private javax.swing.JButton botonNuevoMedicamento;
    private javax.swing.JButton botonNuevoMedico;
    private javax.swing.JButton botonNuevoPaciente;
    private javax.swing.JButton botonVerTodasConsultas;
    private javax.swing.JButton botonVerTodasRecetas;
    private javax.swing.JButton botonVerTodosMedicamentos;
    private javax.swing.JButton botonVerTodosMedicos;
    private javax.swing.JButton botonVerTodosPacientes;
    private javax.swing.JTextField campoBusquedaConsultas;
    private javax.swing.JTextField campoBusquedaMedicamentos;
    private javax.swing.JTextField campoBusquedaMedicos;
    private javax.swing.JTextField campoBusquedaPacientes;
    private javax.swing.JTextField campoBusquedaRecetas;
    private javax.swing.JLabel etiquetaNombreConsultas;
    private javax.swing.JLabel etiquetaNombreMedicamentos;
    private javax.swing.JLabel etiquetaNombreMedico;
    private javax.swing.JLabel etiquetaNombrePacientes;
    private javax.swing.JLabel etiquetaNombreRecetas;
    private javax.swing.JLabel etiquetaTitulo;
    private javax.swing.JLabel etiquetaVersion;
    private javax.swing.JPanel panelConsultas;
    private javax.swing.JPanel panelMedicamentos;
    private javax.swing.JPanel panelMedicos;
    private javax.swing.JPanel panelNorteConsultas;
    private javax.swing.JPanel panelNorteMedicamentos;
    private javax.swing.JPanel panelNorteMedicos;
    private javax.swing.JPanel panelNortePacientes;
    private javax.swing.JPanel panelNorteRecetas;
    private javax.swing.JPanel panelPacientes;
    private javax.swing.JPanel panelPie;
    private javax.swing.JPanel panelSurConsultas;
    private javax.swing.JPanel panelSurMedicamentos;
    private javax.swing.JPanel panelSurMedicos;
    private javax.swing.JPanel panelSurPacientes;
    private javax.swing.JPanel panelSurRecetas;
    private javax.swing.JPanel panelTitulo;
    private javax.swing.JScrollPane scrollConsultas;
    private javax.swing.JScrollPane scrollMedicamentos;
    private javax.swing.JScrollPane scrollMedicos;
    private javax.swing.JScrollPane scrollPacientes;
    private javax.swing.JScrollPane scrollRecetas;
    private javax.swing.JTable tablaConsultas;
    private javax.swing.JTable tablaMedicamentos;
    private javax.swing.JTable tablaMedicos;
    private javax.swing.JTable tablaPacientes;
    private javax.swing.JTable tablaRecetas;
    // End of variables declaration//GEN-END:variables
}
