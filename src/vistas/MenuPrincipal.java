/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas;

import controladores.ControladorVistaConsultas;
import controladores.ControladorVistaMedicos;
import controladores.ControladorVistaPacientes;
import controladores.ControladorVistaRecetas;
import controladores.ControladorVistaUsuarios;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelos.Medicamento;
import modelos.Receta;
import modelos.Usuario;

/**
 *
 * @author 
 */
public class MenuPrincipal extends javax.swing.JFrame {

    private DefaultTableModel modeloTablaRecetas;
    private DefaultTableModel modeloTablaUsuarios;
    private boolean modoAdministrador;
    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal(boolean modoAdministrador) {
        initComponents();
        if(!modoAdministrador){
            pestanasVistas.remove(4);
        }
        this.modeloTablaRecetas = (DefaultTableModel) this.tablaRecetas.getModel();
        this.modeloTablaUsuarios = (DefaultTableModel)this.tablaUsuarios.getModel();
    }

    public void agregarEventos() {

    }

    public void agregarEventosVistaMedicos(ControladorVistaMedicos controlador) {
        this.botonVerTodosMedicos.addActionListener(controlador);
        this.botonNuevoMedico.addActionListener(controlador);
        this.botonEditarMedico.addActionListener(controlador);
        this.botonEliminarMedico.addActionListener(controlador);
    }

    public void agregarEventosVistaPacientes(ControladorVistaPacientes controlador) {
        this.botonVerTodosPacientes.addActionListener(controlador);
        this.botonNuevoPaciente.addActionListener(controlador);
        this.botonEditarPaciente.addActionListener(controlador);
        this.botonEliminarPaciente.addActionListener(controlador);
    }

    public void agregarEventosVistaRecetas(ControladorVistaRecetas controlador) {
        this.botonVerTodasRecetas.addActionListener(controlador);
        this.botonNuevaReceta.addActionListener(controlador);
        this.botonEditarReceta.addActionListener(controlador);
        this.botonEliminarReceta.addActionListener(controlador);
    }

    public void agregarEventosVistaConsultas(ControladorVistaConsultas controlador) {
        this.botonVerTodasConsultas.addActionListener(controlador);
        this.botonNuevaConsulta.addActionListener(controlador);
        this.botonEditarConsulta.addActionListener(controlador);
        this.botonEliminarConsulta.addActionListener(controlador);
    }
    
    public void agregarEventosVistaUsuarios(ControladorVistaUsuarios controlador){
        this.botonVerTodosUsuarios.addActionListener(controlador);
        this.botonNuevoUsuario.addActionListener(controlador);
        this.cambiarClave.addActionListener(controlador);
        this.botonEliminarUsuario.addActionListener(controlador);
    }

    public void cargarRecetas(ArrayList<Receta> recetas) {
        modeloTablaRecetas.setRowCount(0);
        for (Receta receta : recetas) {
            modeloTablaRecetas.addRow(new Object[]{receta.getId(), receta.getId_consulta(), receta.getDiagnostico(), receta.getSintomas(), receta.getRecomendaciones()});
        }
    }

    public void cargarUsuarios(ArrayList<Usuario> usuarios){
        modeloTablaUsuarios.setRowCount(0);
        for(Usuario usuario : usuarios){
            modeloTablaUsuarios.addRow(new Object[]{usuario.getNombre(),usuario.isAdministrador()==1 ? "Sí":"No"});
        }
    }
    
    public String obtenerUsuarioSeleccionado() {
        int filaSeleccionada = this.tablaUsuarios.getSelectedRow();
        if (filaSeleccionada != -1) {
            return modeloTablaUsuarios.getValueAt(filaSeleccionada, 0).toString();
        }
        return null;
    }

    public long obtenerRecetaSeleccionada() {
        int filaSeleccionada = this.tablaRecetas.getSelectedRow();
        if (filaSeleccionada != -1) {
            return Long.parseLong(modeloTablaRecetas.getValueAt(filaSeleccionada, 0).toString());
        }
        return -1;
    }

    public JTabbedPane getMedicamentos() {
        return pestanasVistas;
    }

    public void setMedicamentos(JTabbedPane Medicamentos) {
        this.pestanasVistas = Medicamentos;
    }

    public JPanel getPanelRecetas() {
        return PanelRecetas;
    }

    public void setPanelRecetas(JPanel PanelRecetas) {
        this.PanelRecetas = PanelRecetas;
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

        pestanasVistas = new javax.swing.JTabbedPane();
        panelPacientes = new javax.swing.JPanel();
        scrollPacientes = new javax.swing.JScrollPane();
        tablaPacientes = new javax.swing.JTable();
        panelSurPacientes = new javax.swing.JPanel();
        botonVerTodosPacientes = new javax.swing.JButton();
        botonNuevoPaciente = new javax.swing.JButton();
        botonEditarPaciente = new javax.swing.JButton();
        botonEliminarPaciente = new javax.swing.JButton();
        panelNortePacientes = new javax.swing.JPanel();
        panelMedicos = new javax.swing.JPanel();
        scrollMedicos = new javax.swing.JScrollPane();
        tablaMedicos = new javax.swing.JTable();
        panelSurMedicos = new javax.swing.JPanel();
        botonVerTodosMedicos = new javax.swing.JButton();
        botonNuevoMedico = new javax.swing.JButton();
        botonEditarMedico = new javax.swing.JButton();
        botonEliminarMedico = new javax.swing.JButton();
        panelNorteMedicos = new javax.swing.JPanel();
        panelConsultas = new javax.swing.JPanel();
        scrollConsultas = new javax.swing.JScrollPane();
        tablaConsultas = new javax.swing.JTable();
        panelSurConsultas = new javax.swing.JPanel();
        botonVerTodasConsultas = new javax.swing.JButton();
        botonNuevaConsulta = new javax.swing.JButton();
        botonEditarConsulta = new javax.swing.JButton();
        botonEliminarConsulta = new javax.swing.JButton();
        panelNorteConsultas = new javax.swing.JPanel();
        PanelRecetas = new javax.swing.JPanel();
        scrollRecetas = new javax.swing.JScrollPane();
        tablaRecetas = new javax.swing.JTable();
        panelSurRecetas = new javax.swing.JPanel();
        botonVerTodasRecetas = new javax.swing.JButton();
        botonNuevaReceta = new javax.swing.JButton();
        botonEditarReceta = new javax.swing.JButton();
        botonEliminarReceta = new javax.swing.JButton();
        panelNorteRecetas = new javax.swing.JPanel();
        panelUsuarios = new javax.swing.JPanel();
        scrollUsuarios = new javax.swing.JScrollPane();
        tablaUsuarios = new javax.swing.JTable();
        panelSurUsuarios = new javax.swing.JPanel();
        botonVerTodosUsuarios = new javax.swing.JButton();
        botonNuevoUsuario = new javax.swing.JButton();
        cambiarClave = new javax.swing.JButton();
        botonEliminarUsuario = new javax.swing.JButton();
        panelNorteUsuarios = new javax.swing.JPanel();
        panelTitulo = new javax.swing.JPanel();
        etiquetaIcono = new javax.swing.JLabel();
        etiquetaTitulo = new javax.swing.JLabel();
        panelPie = new javax.swing.JPanel();
        etiquetaVersion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mi Consultorio");

        pestanasVistas.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        pestanasVistas.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N

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
        panelPacientes.add(panelNortePacientes, java.awt.BorderLayout.PAGE_START);

        pestanasVistas.addTab("Pacientes", panelPacientes);

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
        panelMedicos.add(panelNorteMedicos, java.awt.BorderLayout.PAGE_START);

        pestanasVistas.addTab("Médicos", panelMedicos);

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
        panelConsultas.add(panelNorteConsultas, java.awt.BorderLayout.PAGE_START);

        pestanasVistas.addTab("Consultas", panelConsultas);

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
        PanelRecetas.add(panelNorteRecetas, java.awt.BorderLayout.PAGE_START);

        pestanasVistas.addTab("Recetas", PanelRecetas);

        panelUsuarios.setLayout(new java.awt.BorderLayout());

        tablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Administrador"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollUsuarios.setViewportView(tablaUsuarios);

        panelUsuarios.add(scrollUsuarios, java.awt.BorderLayout.CENTER);

        botonVerTodosUsuarios.setText("Ver todos");
        botonVerTodosUsuarios.setName("todos_usuarios"); // NOI18N
        panelSurUsuarios.add(botonVerTodosUsuarios);

        botonNuevoUsuario.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        botonNuevoUsuario.setText("Nuevo usuario");
        botonNuevoUsuario.setName("nuevo_usuario"); // NOI18N
        panelSurUsuarios.add(botonNuevoUsuario);

        cambiarClave.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        cambiarClave.setText("Cambiar clave");
        cambiarClave.setName("cambiar_clave"); // NOI18N
        panelSurUsuarios.add(cambiarClave);

        botonEliminarUsuario.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        botonEliminarUsuario.setText("Eliminar usuario");
        botonEliminarUsuario.setName("eliminar_usuario"); // NOI18N
        panelSurUsuarios.add(botonEliminarUsuario);

        panelUsuarios.add(panelSurUsuarios, java.awt.BorderLayout.PAGE_END);

        panelNorteUsuarios.setLayout(new java.awt.GridBagLayout());
        panelUsuarios.add(panelNorteUsuarios, java.awt.BorderLayout.PAGE_START);

        pestanasVistas.addTab("Usuarios", panelUsuarios);

        getContentPane().add(pestanasVistas, java.awt.BorderLayout.CENTER);

        panelTitulo.setBackground(new java.awt.Color(0, 102, 204));

        etiquetaIcono.setBackground(new java.awt.Color(0, 255, 51));
        etiquetaIcono.setPreferredSize(new java.awt.Dimension(50, 50));
        panelTitulo.add(etiquetaIcono);

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelRecetas;
    private javax.swing.JButton botonEditarConsulta;
    private javax.swing.JButton botonEditarMedico;
    private javax.swing.JButton botonEditarPaciente;
    private javax.swing.JButton botonEditarReceta;
    private javax.swing.JButton botonEliminarConsulta;
    private javax.swing.JButton botonEliminarMedico;
    private javax.swing.JButton botonEliminarPaciente;
    private javax.swing.JButton botonEliminarReceta;
    private javax.swing.JButton botonEliminarUsuario;
    private javax.swing.JButton botonNuevaConsulta;
    private javax.swing.JButton botonNuevaReceta;
    private javax.swing.JButton botonNuevoMedico;
    private javax.swing.JButton botonNuevoPaciente;
    private javax.swing.JButton botonNuevoUsuario;
    private javax.swing.JButton botonVerTodasConsultas;
    private javax.swing.JButton botonVerTodasRecetas;
    private javax.swing.JButton botonVerTodosMedicos;
    private javax.swing.JButton botonVerTodosPacientes;
    private javax.swing.JButton botonVerTodosUsuarios;
    private javax.swing.JButton cambiarClave;
    private javax.swing.JLabel etiquetaIcono;
    private javax.swing.JLabel etiquetaTitulo;
    private javax.swing.JLabel etiquetaVersion;
    private javax.swing.JPanel panelConsultas;
    private javax.swing.JPanel panelMedicos;
    private javax.swing.JPanel panelNorteConsultas;
    private javax.swing.JPanel panelNorteMedicos;
    private javax.swing.JPanel panelNortePacientes;
    private javax.swing.JPanel panelNorteRecetas;
    private javax.swing.JPanel panelNorteUsuarios;
    private javax.swing.JPanel panelPacientes;
    private javax.swing.JPanel panelPie;
    private javax.swing.JPanel panelSurConsultas;
    private javax.swing.JPanel panelSurMedicos;
    private javax.swing.JPanel panelSurPacientes;
    private javax.swing.JPanel panelSurRecetas;
    private javax.swing.JPanel panelSurUsuarios;
    private javax.swing.JPanel panelTitulo;
    private javax.swing.JPanel panelUsuarios;
    private javax.swing.JTabbedPane pestanasVistas;
    private javax.swing.JScrollPane scrollConsultas;
    private javax.swing.JScrollPane scrollMedicos;
    private javax.swing.JScrollPane scrollPacientes;
    private javax.swing.JScrollPane scrollRecetas;
    private javax.swing.JScrollPane scrollUsuarios;
    private javax.swing.JTable tablaConsultas;
    private javax.swing.JTable tablaMedicos;
    private javax.swing.JTable tablaPacientes;
    private javax.swing.JTable tablaRecetas;
    private javax.swing.JTable tablaUsuarios;
    // End of variables declaration//GEN-END:variables
}
