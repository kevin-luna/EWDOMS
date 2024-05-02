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
import vistas.FormMedico;

public class ControladorRegistroMedico implements ActionListener {
    private Medico medico;
    private DAOMedico daoMedico;
    private FormMedico menuRegistro;

    public ControladorRegistroMedico(FormMedico menuRegistro) {
        this.menuRegistro = menuRegistro;
        daoMedico = new DAOMedico();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton boton = (JButton) e.getSource();
        
        switch (boton.getName()) {
            case "guardar":
                if (menuRegistro.tieneCamposVacios()) {
                    JOptionPane.showMessageDialog(menuRegistro, "No pueden quedar campos vacíos", "Atención", JOptionPane.WARNING_MESSAGE);
                    break;
                }
                boolean status;
                String accion,accion2;
                if(menuRegistro.getActualizar()){
                    accion = "actualizò";
                    accion2 = "actualizar";
                    status = daoMedico.actualizar(menuRegistro.obtenerMedico().getId(), menuRegistro.obtenerMedico());
                }else{
                    accion = "registró";
                    accion2 = "registrar";
                    status = daoMedico.insertar(menuRegistro.obtenerMedico())!=-1;
                }
                if (status) {
                    JOptionPane.showMessageDialog(menuRegistro, "Se "+accion+" el médico.", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
                    menuRegistro.limpiar();
                    menuRegistro.dispose();
                } else {
                    JOptionPane.showMessageDialog(menuRegistro, "No se pudo "+accion2+" el médico.", "Error en el registro", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case "cancelar":
                menuRegistro.dispose();
                break;
        }
    }
}