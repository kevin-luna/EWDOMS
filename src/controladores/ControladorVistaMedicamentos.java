/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import dao.DAOMedicamento;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.Medicamento;
import modelos.Medico;
import vistas.MenuPrincipal;
import vistas.FormMedicamento;

/**
 *
 * @author kevin
 */
public class ControladorVistaMedicamentos implements ActionListener{

    private MenuPrincipal menu;
    private DAOMedicamento daoMedicamento;
    private ArrayList<Medicamento> listaMedicamentos;
    private FormMedicamento menuRegistro;
    private ControladorRegistroMedicamento controladorRegistroMedicamento;

    public ControladorVistaMedicamentos(MenuPrincipal menu) {
        this.menu = menu;
        daoMedicamento = new DAOMedicamento();
        menuRegistro = new FormMedicamento();
        controladorRegistroMedicamento = new ControladorRegistroMedicamento(menuRegistro);
        menuRegistro.agregarEventos(controladorRegistroMedicamento);
    }
   

    public void actualizarVista() {
        System.out.println("Solicitando la lista de medicamentos al servidor...");
        listaMedicamentos = daoMedicamento.consultar();
        menu.cargarMedicamentos(listaMedicamentos);
    }

    public void eliminarMedicamento() {
        int filaSelccionada = menu.getTablaMedicamentos().getSelectedRow();
        if (filaSelccionada != -1) {
            long id = (Long) menu.getTablaMedicamentos().getValueAt(filaSelccionada, 0);
            if (daoMedicamento.eliminar(id)) {
                JOptionPane.showMessageDialog(menu, "El medicamento ha sido eliminado..", "Eliminación exitosa", JOptionPane.INFORMATION_MESSAGE);
                actualizarVista();
            } else {
                JOptionPane.showMessageDialog(menu, "No se ha podido eliminar el medicamento.", "Error al eliminar", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void editar_medicamento() {
        int filaSeleccionada = menu.getTablaMedicamentos().getSelectedRow();
        if (filaSeleccionada != -1) {
            long id = (Long) menu.getTablaMedicamentos().getValueAt(filaSeleccionada, 0);
            Medicamento tmp = daoMedicamento.consultar(id);
            if (tmp != null) {
                menuRegistro.setActualizar(true);
                menuRegistro.cargarMedicamento(tmp);
                menuRegistro.setVisible(true);
            }
            actualizarVista();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton boton = (JButton) e.getSource();
        switch (boton.getName()) {
            case "todos_medicamentos":
                actualizarVista();
                break;
            case "nuevo_medicamento":
                menuRegistro.limpiar();
                menuRegistro.setActualizar(false);
                menuRegistro.setVisible(true);
                break;
            case "editar_medicamento":
                editar_medicamento();
                break;
            case "eliminar_medicamento":
                eliminarMedicamento();
                break;
        }
    }

}
