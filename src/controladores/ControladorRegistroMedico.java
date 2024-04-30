/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package controladores;

import dao.DAOMedico;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import modelos.Medico;
import vistas.RegistroMedico;

public class ControladorRegistroMedico implements ActionListener {
    private Medico medico;
    private DAOMedico daoMedico;
    private RegistroMedico menuRegistro;

    public ControladorRegistroMedico(RegistroMedico menuRegistro) {
        this.menuRegistro = menuRegistro;
        daoMedico = new DAOMedico();
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
                medico = new Medico(menuRegistro.obtenerContenidoNombre(), menuRegistro.obtenerContenidoEspecialidad(), menuRegistro.obtenerContenidoCedula(), menuRegistro.obtenerContenidoInstituto());
                boolean status = daoMedico.insertar(medico);
                if (status) {
                    JOptionPane.showMessageDialog(menuRegistro, "Se agregó el médico.", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
                    menuRegistro.limpiar();
                    menuRegistro.dispose();
                } else {
                    JOptionPane.showMessageDialog(menuRegistro, "No se pudo registrar el médico.", "Error en el registro", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case "cancelar":
                menuRegistro.dispose();
                break;
        }
    }
}