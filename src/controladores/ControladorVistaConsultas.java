/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import dao.DAOConsultaMedica;
import dao.DAOMedico;
import dao.DAOPaciente;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelos.ConsultaMedica;
import vistas.MenuPrincipal;
import vistas.FormConsultaMedica;

public class ControladorVistaConsultas implements ActionListener {

    private MenuPrincipal menu;
    private DAOConsultaMedica daoConsulta;
    private ArrayList<ConsultaMedica> listaConsultas;
    private FormConsultaMedica menuRegistro;
    private ControladorRegistroConsulta controladorRegistroConsulta;
    private DefaultTableModel modeloTabla;
    private DAOPaciente daoPaciente;
    private DAOMedico daoMedico;

    public ControladorVistaConsultas(MenuPrincipal menu) {
        this.menu = menu;
        daoConsulta = new DAOConsultaMedica();
        daoPaciente = new DAOPaciente();
        daoMedico = new DAOMedico();
        menuRegistro = new FormConsultaMedica();
        controladorRegistroConsulta = new ControladorRegistroConsulta(menuRegistro);
        menuRegistro.agregarEventos(controladorRegistroConsulta);
        modeloTabla = (DefaultTableModel) menu.getTablaConsultas().getModel();
    }

    public void actualizarVista() {
        listaConsultas = daoConsulta.consultar();
        
        modeloTabla.setRowCount(0);
        for (ConsultaMedica consulta : listaConsultas) {
            String nombrePaciente = daoPaciente.consultar(consulta.getIdPaciente()).getNombre();
            String nombreMedico = daoMedico.consultar(consulta.getIdMedico()).getNombre();
            modeloTabla.addRow(new Object[]{consulta.getId(), nombrePaciente, nombreMedico, consulta.getFecha(),});
        }
    }

    public void eliminarConsulta() {
        int filaSelccionada = menu.getTablaConsultas().getSelectedRow();
        if (filaSelccionada != -1) {
            long id = (Long) menu.getTablaConsultas().getValueAt(filaSelccionada, 0);
            if (daoConsulta.eliminar(id)) {
                JOptionPane.showMessageDialog(menu, "La consulta ha sido eliminada.", "Eliminación", JOptionPane.INFORMATION_MESSAGE);
                actualizarVista();
            } else {
                JOptionPane.showMessageDialog(menu, "No se ha podido eliminar la consulta.", "Error al eliminar", JOptionPane.ERROR_MESSAGE);
            }

        }

    }

    public void editarConsulta() {
        int filaSelccionada = menu.getTablaConsultas().getSelectedRow();
        if (filaSelccionada != -1) {
           long id = (Long) menu.getTablaConsultas().getValueAt(filaSelccionada, 0);
            ConsultaMedica tmp = daoConsulta.consultar(id);
            if (tmp != null) {
                menuRegistro.setActualizar(true);
                menuRegistro.cargarConsulta(tmp);
                menuRegistro.setVisible(true);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton boton = (JButton) e.getSource();

        switch (boton.getName()) {
            case "todas_consultas":
                actualizarVista();
                break;
            case "nueva_consulta":
                menuRegistro.limpiar();
                menuRegistro.setActualizar(false);
                menuRegistro.setVisible(true);
                break;
            case "editar_consulta":
                editarConsulta();
                break;
            case "eliminar_consulta":
                eliminarConsulta();
                break;
        }
    }
}
