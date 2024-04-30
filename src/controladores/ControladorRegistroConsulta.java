/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import dao.DAOConsultaMedica;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelos.ConsultaMedica;
import vistas.RegistroConsultaMedica;

public class ControladorRegistroConsulta implements ActionListener {
    private ConsultaMedica consulta;
    private DAOConsultaMedica daoConsulta;
    private RegistroConsultaMedica menuRegistro;

    public ControladorRegistroConsulta(RegistroConsultaMedica menuRegistro) {
        this.menuRegistro = menuRegistro;
        daoConsulta = new DAOConsultaMedica();
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
                consulta = new ConsultaMedica(
                        menuRegistro.obtenerIdPaciente(),
                        menuRegistro.obtenerIdMedico(),
                        menuRegistro.obtenerFecha()
                );
                boolean status = daoConsulta.insertar(consulta);
                if (status) {
                    JOptionPane.showMessageDialog(menuRegistro, "Se agregó la consulta.", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
                    menuRegistro.limpiar();
                    menuRegistro.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(menuRegistro, "No se pudo registrar la consulta.", "Error en el registro", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case "cancelar":
                menuRegistro.setVisible(false);
                break;
        }
    }
}
