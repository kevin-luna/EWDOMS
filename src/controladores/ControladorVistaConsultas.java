/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import dao.DAOConsultaMedica;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelos.ConsultaMedica;
import vistas.MenuPrincipal;
import vistas.RegistroConsultaMedica;

public class ControladorVistaConsultas implements ActionListener {

    private MenuPrincipal menu;
    private DAOConsultaMedica daoConsulta;
    private ArrayList<ConsultaMedica> listaConsultas;
    private RegistroConsultaMedica menuRegistro;
    private ControladorRegistroConsulta controladorRegistroConsulta;
    private DefaultTableModel modeloTabla;

    public ControladorVistaConsultas(MenuPrincipal menu) {
        this.menu = menu;
        daoConsulta = new DAOConsultaMedica();
        menuRegistro = new RegistroConsultaMedica();
        controladorRegistroConsulta = new ControladorRegistroConsulta(menuRegistro);
        menuRegistro.agregarEventos(controladorRegistroConsulta);
        modeloTabla = (DefaultTableModel) menu.getTablaConsultas().getModel();
    }

    public void actualizarVista() {
        listaConsultas = daoConsulta.consultar();
        modeloTabla.setRowCount(0);
        for (ConsultaMedica consulta : listaConsultas) {
            modeloTabla.addRow(new Object[]{consulta.getId(), consulta.getIdPaciente(), consulta.getIdMedico(), consulta.getFecha(),});
        }
    }
    
    public void eliminarConsulta(){
        int filaSelccionada = menu.getTablaConsultas().getSelectedRow();
                long id = (Long) menu.getTablaConsultas().getValueAt(filaSelccionada, 0);
                if (filaSelccionada != -1) {
                    if (daoConsulta.eliminar(id)) {
                        JOptionPane.showMessageDialog(menu, "La consulta ha sido eliminada.", "Eliminación", JOptionPane.INFORMATION_MESSAGE);
                        actualizarVista();
                    } else {
                        JOptionPane.showMessageDialog(menu, "No se ha podido eliminar la consulta.", "Error al eliminar", JOptionPane.ERROR_MESSAGE);
                    }
                }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Boton presionado");
        JButton boton = (JButton) e.getSource();

        switch (boton.getName()) {
            case "todas_consultas":
                actualizarVista();
                break;
            case "nueva_consulta":
                menuRegistro.setVisible(true);
                break;
            case "editar_consulta":
                menuRegistro.setVisible(true);
                break;
            case "eliminar_consulta":
                eliminarConsulta();
                break;
        }
    }
}
