/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import dao.DAODetalleReceta;
import dao.DAOMedicamento;
import dao.DAOReceta;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelos.Medicamento;
import modelos.Receta;
import vistas.MenuPrincipal;
import vistas.FormReceta;

public class ControladorVistaRecetas implements ActionListener {

    private MenuPrincipal menu;
    private DAOReceta daoReceta;
    private DAODetalleReceta daoDetalleReceta;
    private ArrayList<Receta> listaRecetas;
    private FormReceta menuRegistro;
    private ControladorRegistroReceta controladorRegistroReceta;

    public ControladorVistaRecetas(MenuPrincipal menu) {
        this.menu = menu;
        daoReceta = new DAOReceta();
        daoDetalleReceta = new DAODetalleReceta();
        menuRegistro = new FormReceta();
        controladorRegistroReceta = new ControladorRegistroReceta(menuRegistro);
        menuRegistro.agregarEventos(controladorRegistroReceta);
    }

    public void eliminarReceta() {
        int filaSelccionada = menu.getTablaRecetas().getSelectedRow();
        if (filaSelccionada != -1) {
            long id = (Long) menu.getTablaRecetas().getValueAt(filaSelccionada, 0);
            if (filaSelccionada != -1) {
                if (daoReceta.eliminar(id)) {
                    JOptionPane.showMessageDialog(menu, "La receta ha sido eliminada.", "Eliminación exitosa", JOptionPane.INFORMATION_MESSAGE);
                    actualizarVista();
                } else {
                    JOptionPane.showMessageDialog(menu, "No se ha podido eliminar la receta.", "Error al eliminar", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    public void editarReceta() {
        int filaSelccionada = menu.getTablaRecetas().getSelectedRow();
        if (filaSelccionada != -1) {
            menuRegistro.setActualizar(true);
            long id = (Long) menu.getTablaRecetas().getValueAt(filaSelccionada, 0);
            if (filaSelccionada != -1) {
                Receta receta = daoReceta.consultar(id);
                ArrayList<Medicamento> medicamentos = daoDetalleReceta.consultar(id);
                if (receta != null) {
                    menuRegistro.setActualizar(true);
                    menuRegistro.cargarReceta(receta);
                    menuRegistro.cargarMedicamentos(medicamentos);
                    menuRegistro.setVisible(true);
                }
            }
        }
    }

    public void actualizarVista() {
        listaRecetas = daoReceta.consultar();
        DefaultTableModel modeloTabla = (DefaultTableModel) menu.getTablaRecetas().getModel();
        modeloTabla.setRowCount(0);
        for (Receta receta : listaRecetas) {
            modeloTabla.addRow(new Object[]{receta.getId(), receta.getId(), receta.getDiagnostico(), receta.getSintomas(), receta.getRecomendaciones()});
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton boton = (JButton) e.getSource();

        switch (boton.getName()) {
            case "todas_recetas":
                actualizarVista();
                break;
            case "nueva_receta":
                menuRegistro.limpiar();
                menuRegistro.setActualizar(false);
                menuRegistro.setVisible(true);
                break;
            case "editar_receta":
                editarReceta();
                break;
            case "eliminar_receta":
                eliminarReceta();
                break;
        }
    }
}
