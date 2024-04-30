package controladores;

import dao.DAOPaciente;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelos.Paciente;
import vistas.MenuPrincipal;
import vistas.RegistroPaciente;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 *
 * @author kevin
 */
public class ControladorVistaPacientes implements ActionListener {

    private MenuPrincipal menu;
    private DAOPaciente daoPaciente;
    private ArrayList<Paciente> listaPacientes;
    private RegistroPaciente menuRegistro;
    private ControladorRegistroPaciente controladorRegistroPaciente;

    public ControladorVistaPacientes(MenuPrincipal menu) {
        this.menu = menu;
        daoPaciente = new DAOPaciente();
        menuRegistro = new RegistroPaciente();
        controladorRegistroPaciente = new ControladorRegistroPaciente(menuRegistro);
        menuRegistro.agregarEventos(controladorRegistroPaciente);
    }

    public void actualizarVista() {
        System.out.println("Solicitando la lista de pacientes al servidor...");
        listaPacientes = daoPaciente.consultar();
        DefaultTableModel modeloTabla = (DefaultTableModel) menu.getTablaPacientes().getModel();
        modeloTabla.setRowCount(0);
        for (Paciente paciente : listaPacientes) {
            modeloTabla.addRow(new Object[]{
                paciente.getId(),
                paciente.getNombre(),
                paciente.getTipoSangre(),
                paciente.getSexo(),
                paciente.getAltura(),
                paciente.getPeso(),
                paciente.getFechaNacimiento(),
                paciente.getDireccion(),
                paciente.getTelefono(),
                paciente.getCorreoElectronico()
            });

        }
    }

    public void eliminarPaciente() {
        int filaSelccionada = menu.getTablaPacientes().getSelectedRow();
        long id = (Long) menu.getTablaPacientes().getValueAt(filaSelccionada, 0);
        if (filaSelccionada != -1) {
            if (daoPaciente.eliminar(id)) {
                JOptionPane.showMessageDialog(menu, "El paciente ha sido eliminado.", "Eliminación", JOptionPane.INFORMATION_MESSAGE);
                actualizarVista();
            } else {
                JOptionPane.showMessageDialog(menu, "No se ha podido eliminar el paciente.", "Error al eliminar", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Boton presionado");
        JButton boton = (JButton) e.getSource();

        switch (boton.getName()) {
            case "todos_pacientes":
                actualizarVista();
                break;
            case "nuevo_paciente":
                menuRegistro.setVisible(true);
                break;
            case "editar_paciente":
                menuRegistro.setVisible(true);
                break;
            case "eliminar_paciente":
                eliminarPaciente();
                break;
        }
    }
}
