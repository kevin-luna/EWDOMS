/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import dao.DAODetalleReceta;
import dao.DAOReceta;
import javax.swing.JButton;
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

    public void agregarReceta() {
        menuRegistro.limpiar();
        menuRegistro.setActualizar(false);
        menuRegistro.setVisible(true);
    }

    public void eliminarReceta(long id) {
        if (id != -1) {
            if (daoReceta.eliminar(id)) {
                JOptionPane.showMessageDialog(menu, "La receta ha sido eliminada.", "Eliminación exitosa", JOptionPane.INFORMATION_MESSAGE);
                actualizarVista();
            } else {
                JOptionPane.showMessageDialog(menu, "No se ha podido eliminar la receta.", "Error al eliminar", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void editarReceta(long id) {
        if (id != -1) {
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

    public void actualizarVista() {
        listaRecetas = daoReceta.consultar();
        menu.cargarRecetas(listaRecetas);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton boton = (JButton) e.getSource();

        switch (boton.getName()) {
            case "todas_recetas":
                actualizarVista();
                break;
            case "nueva_receta":
                agregarReceta();
                break;
            case "editar_receta":
                editarReceta(menu.obtenerRecetaSeleccionada());
                break;
            case "eliminar_receta":
                eliminarReceta(menu.obtenerRecetaSeleccionada());
                break;
        }
    }
}
