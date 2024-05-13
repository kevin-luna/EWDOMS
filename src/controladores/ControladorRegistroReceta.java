/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import dao.DAOReceta;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelos.Receta;
import vistas.FormReceta;

public class ControladorRegistroReceta implements ActionListener {

    private DAOReceta daoReceta;
    private FormReceta menuRegistro;
    private long ultimaReceta;

    public ControladorRegistroReceta(FormReceta menuRegistro) {
        this.menuRegistro = menuRegistro;
        daoReceta = new DAOReceta();
    }


    public void guardarReceta() {
        long idReceta = daoReceta.insertar(menuRegistro.obtenerReceta());
        if (idReceta != -1) {
            JOptionPane.showMessageDialog(menuRegistro, "Se registró la receta correctamente.", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
            menuRegistro.dispose();
        } else {
            JOptionPane.showMessageDialog(menuRegistro, "Ocurrió un error al registrar la receta.", "Error de registro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void actualizarReceta() {
        Receta receta = menuRegistro.obtenerReceta();
        boolean status = daoReceta.actualizar(receta.getId(), receta);
        if (status) {
            JOptionPane.showMessageDialog(menuRegistro, "Se actualizó la receta correctamente.", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(menuRegistro, "No se pudo actualizar la receta.", "Error al actualizar", JOptionPane.ERROR_MESSAGE);
        }
    }
    

    public void cancelar() {
        menuRegistro.limpiar();
        menuRegistro.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton boton = (JButton) e.getSource();

        switch (boton.getName()) {
            case "guardar":
                if (menuRegistro.tieneCamposVacios()) {
                    JOptionPane.showMessageDialog(menuRegistro, "No pueden quedar campos vacíos", "Atención", JOptionPane.WARNING_MESSAGE);
                    break;
                } else {
                    if (menuRegistro.getActualizar()) {
                        actualizarReceta();
                    } else {
                        guardarReceta();
                    }
                }
                break;
            case "cancelar":
                cancelar();
                break;
        }
    }
}
