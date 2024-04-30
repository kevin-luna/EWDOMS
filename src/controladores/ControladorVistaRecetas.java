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
import modelos.Receta;
import vistas.MenuPrincipal;
import vistas.RegistroReceta;

public class ControladorVistaRecetas implements ActionListener {
    private MenuPrincipal menu;
    private DAOReceta daoReceta;
    private ArrayList<Receta> listaRecetas;
    private RegistroReceta menuRegistro;
    private ControladorRegistroReceta controladorRegistroReceta;

    public ControladorVistaRecetas(MenuPrincipal menu) {
        this.menu = menu;
        daoReceta = new DAOReceta();
        menuRegistro = new RegistroReceta();
        controladorRegistroReceta = new ControladorRegistroReceta(menuRegistro);
        menuRegistro.agregarEventos(controladorRegistroReceta);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Boton presionado");
        JButton boton = (JButton) e.getSource();

        switch (boton.getName()) {
            case "todas_recetas":
                System.out.println("Solicitando la lista de recetas al servidor...");
                listaRecetas = daoReceta.consultar();
                DefaultTableModel modeloTabla = (DefaultTableModel) menu.getTablaRecetas().getModel();
                modeloTabla.setRowCount(0);
                for (Receta receta : listaRecetas) {
                    modeloTabla.addRow(new Object[]{receta.getId(), receta.getId(), receta.getDiagnostico(), receta.getSintomas(), receta.getRecomendaciones()});
                }
                break;
            case "nueva_receta":
                menuRegistro.setVisible(true);
                break;
            case "editar_receta":
                menuRegistro.setVisible(true);
                break;
            case "eliminar_receta":
                break;
        }
    }
}
