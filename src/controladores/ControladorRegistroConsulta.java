/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import dao.DAOConsultaMedica;
import excepciones.EntradaInvalida;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelos.ConsultaMedica;
import vistas.FormConsultaMedica;

public class ControladorRegistroConsulta implements ActionListener {

    private ConsultaMedica consulta;
    private DAOConsultaMedica daoConsulta;
    private FormConsultaMedica menuRegistro;

    public ControladorRegistroConsulta(FormConsultaMedica menuRegistro) {
        this.menuRegistro = menuRegistro;
        daoConsulta = new DAOConsultaMedica();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton boton = (JButton) e.getSource();

        switch (boton.getName()) {
            case "guardar":
                try {
                    if (menuRegistro.tieneCamposVacios()) {
                        JOptionPane.showMessageDialog(menuRegistro, "No pueden quedar campos vacíos", "Atención", JOptionPane.WARNING_MESSAGE);
                        break;
                    }
                    consulta = menuRegistro.obtenerConsulta();
                    boolean status;
                    String accion, accion2;
                    if (menuRegistro.getActualizar()) {
                        accion = "actuaizó";
                        accion2 = "actualizar";
                        status = daoConsulta.actualizar(menuRegistro.obtenerConsulta().getId(), menuRegistro.obtenerConsulta());
                    } else {
                        accion = "registró";
                        accion2 = "registrar";
                        status = daoConsulta.insertar(consulta) != -1;
                    }
                    if (status) {
                        JOptionPane.showMessageDialog(menuRegistro, "La consulta se " + accion + " exitosamente.", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
                        menuRegistro.limpiar();
                        menuRegistro.dispose();
                    } else {
                        JOptionPane.showMessageDialog(menuRegistro, "No se pudo " + accion2 + " actualizar.", "Error en el registro", JOptionPane.ERROR_MESSAGE);
                    }
                }catch(EntradaInvalida ex){
                    JOptionPane.showMessageDialog(menuRegistro, ex.getMessage(), "Entrada invalida", JOptionPane.WARNING_MESSAGE);
                }
                break;
            case "cancelar":
                menuRegistro.dispose();
                break;
        }
    }
}
