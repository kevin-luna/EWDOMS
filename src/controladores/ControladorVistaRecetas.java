/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import dao.DAOReceta;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelos.Receta;
import vistas.MenuPrincipal;
import vistas.FormReceta;

public class ControladorVistaRecetas implements ActionListener {

    private MenuPrincipal menu;
    private DAOReceta daoReceta;
    private ArrayList<Receta> listaRecetas;
    private FormReceta menuRegistro;
    private ControladorRegistroReceta controladorRegistroReceta;

    public ControladorVistaRecetas(MenuPrincipal menu) {
        this.menu = menu;
        daoReceta = new DAOReceta();
        menuRegistro = new FormReceta();
        controladorRegistroReceta = new ControladorRegistroReceta(menuRegistro);
        menuRegistro.agregarEventos(controladorRegistroReceta);
    }

    public void eliminarReceta() {
        int filaSelccionada = menu.getTablaRecetas().getSelectedRow();
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
                menuRegistro.setVisible(true);
                break;
            case "editar_receta":
                menuRegistro.setVisible(true);
                break;
            case "eliminar_receta":
                eliminarReceta();
                break;
        }
    }
}
