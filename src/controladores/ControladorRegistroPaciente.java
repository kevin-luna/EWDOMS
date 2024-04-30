/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

/**
 *
 * @author kevin
 */
import dao.DAOPaciente;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelos.Paciente;
import vistas.RegistroPaciente;

public class ControladorRegistroPaciente implements ActionListener {
    private Paciente paciente;
    private DAOPaciente daoPaciente;
    private RegistroPaciente menuRegistro;

    public ControladorRegistroPaciente(RegistroPaciente menuRegistro) {
        this.menuRegistro = menuRegistro;
        daoPaciente = new DAOPaciente();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Boton presionado");
        JButton boton = (JButton) e.getSource();

        switch (boton.getName()) {
            case "guardar":
                if (menuRegistro.tieneCamposVacios()) {
                    JOptionPane.showMessageDialog(menuRegistro, "No pueden quedar campos vacíos", "Atención", JOptionPane.WARNING_MESSAGE);
                    break;
                }
                paciente = new Paciente(
                        menuRegistro.obtenerNombre(),
                        menuRegistro.obtenerSangre(),
                        menuRegistro.obtenerSexo(),
                        menuRegistro.obtenerAltura(),
                        menuRegistro.obtenerPeso(),
                        menuRegistro.obtenerFechaNacimiento(),
                        menuRegistro.obtenerDireccion(),
                        menuRegistro.obtenerTelefono(),
                        menuRegistro.obtenerCorreo()
                );
                boolean status = daoPaciente.insertar(paciente);
                if (status) {
                    JOptionPane.showMessageDialog(menuRegistro, "Se agregó el paciente.", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
                    menuRegistro.limpiar();
                    menuRegistro.dispose();
                } else {
                    JOptionPane.showMessageDialog(menuRegistro, "No se pudo registrar el paciente.", "Error en el registro", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case "cancelar":
                menuRegistro.dispose();
                break;
        }
    }
}

