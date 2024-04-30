/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import dao.DAOMedico;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelos.Medico;
import vistas.MenuPrincipal;
import vistas.FormMedico;

public class ControladorVistaMedicos implements ActionListener {

    private MenuPrincipal menu;
    private DAOMedico daoMedico;
    private ArrayList<Medico> listaMedicos;
    private FormMedico menuRegistro;
    private ControladorRegistroMedico controladorRegistroMedico;
    private DefaultTableModel modeloTabla;

    public ControladorVistaMedicos(MenuPrincipal menu) {
        this.menu = menu;
        daoMedico = new DAOMedico();
        menuRegistro = new FormMedico();
        controladorRegistroMedico = new ControladorRegistroMedico(menuRegistro);
        menuRegistro.agregarEventos(controladorRegistroMedico);
        modeloTabla = (DefaultTableModel) menu.getTablaConsultas().getModel();
    }

    public void actualizarVista() {
        listaMedicos = daoMedico.consultar();
        DefaultTableModel modeloTabla = (DefaultTableModel) menu.getTablaMedicos().getModel();
        modeloTabla.setRowCount(0);
        for (Medico medico : listaMedicos) {
            modeloTabla.addRow(new Object[]{medico.getId(), medico.getNombre(), medico.getEspecialidad(), medico.getCedula(), medico.getInstituto()});
        }
    }

    public void eliminarMedico() {
        int filaSelccionada = menu.getTablaMedicos().getSelectedRow();
        if (filaSelccionada != -1) {
            long id = (Long) menu.getTablaMedicos().getValueAt(filaSelccionada, 0);
            if (daoMedico.eliminar(id)) {
                JOptionPane.showMessageDialog(menu, "El médico ha sido eliminado.", "Eliminación exitosa", JOptionPane.INFORMATION_MESSAGE);
                actualizarVista();
            } else {
                JOptionPane.showMessageDialog(menu, "No se ha podido eliminar el médico.", "Error al eliminar", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void editarMedico() {
        int filaSelccionada = menu.getTablaMedicos().getSelectedRow();
        if (filaSelccionada != -1) {
            long id = (Long) menu.getTablaMedicos().getValueAt(filaSelccionada, 0);
            Medico tmp = daoMedico.consultar(id);
            if (tmp != null) {
                menuRegistro.setActualizar(true);
                menuRegistro.cargarMedico(tmp);
                menuRegistro.setVisible(true);
            }
            actualizarVista();
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton boton = (JButton) e.getSource();
        switch (boton.getName()) {
            case "todos_medicos" -> {
                actualizarVista();
            }
            case "nuevo_medico" -> {
                menuRegistro.setActualizar(false);
                menuRegistro.setVisible(true);
            }
            case "editar_medico" -> {
                editarMedico();
            }
            case "eliminar_medico" -> {
                eliminarMedico();
            }

        }
    }
}
