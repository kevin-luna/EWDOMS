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
import modelos.Medico;
import vistas.MenuPrincipal;
import vistas.RegistroMedico;

public class ControladorVistaMedicos implements ActionListener {
    private MenuPrincipal menu;
    private DAOMedico daoMedico;
    private ArrayList<Medico> listaMedicos;
    private RegistroMedico menuRegistro;
    private ControladorRegistroMedico controladorRegistroMedico;

    public ControladorVistaMedicos(MenuPrincipal menu) {
        this.menu = menu;
        daoMedico = new DAOMedico();
        menuRegistro = new RegistroMedico();
        controladorRegistroMedico = new ControladorRegistroMedico(menuRegistro);
        menuRegistro.agregarEventos(controladorRegistroMedico);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Boton presionado");
        JButton boton = (JButton) e.getSource();
        System.out.println("El nombre del boton es"+boton.getName());
        switch (boton.getName()) {
            case "todos_medicos" -> {
                System.out.println("Solicitando la lista de medicos al servidor...");
                listaMedicos = daoMedico.consultar();
                DefaultTableModel modeloTabla = (DefaultTableModel) menu.getTablaMedicos().getModel();
                modeloTabla.setRowCount(0);
                for (Medico medico : listaMedicos) {
                    modeloTabla.addRow(new Object[]{medico.getId(), medico.getNombre(), medico.getEspecialidad(),medico.getCedula(), medico.getInstituto()});
                }
            }
            case "nuevo_medico" -> menuRegistro.setVisible(true);
            case "editar_medico" -> menuRegistro.setVisible(true);
            case "eliminar_medico" -> {
            }
        }
    }
}
