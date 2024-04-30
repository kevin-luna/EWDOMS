/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import dao.DAOMedicamento;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import modelos.Medicamento;
import vistas.RegistroMedicamento;

/**
 *
 * @author kevin
 */
public class ControladorRegistroMedicamento implements ActionListener{

    Medicamento medicamento;
    DAOMedicamento daoMedicamento;
    RegistroMedicamento menuRegistro;

    public ControladorRegistroMedicamento(RegistroMedicamento menuRegistro) {
        this.menuRegistro = menuRegistro;
        daoMedicamento = new DAOMedicamento();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Boton presionado");
        JButton boton = (JButton)e.getSource();
        switch(boton.getName()){
            case "guardar" -> {
                if(menuRegistro.tieneCamposVacios()){
                    JOptionPane.showMessageDialog(menuRegistro, "No pueden quedar campos vacíos", "Atención", JOptionPane.WARNING_MESSAGE);
                    break;
                }
                medicamento = new Medicamento(menuRegistro.obtenerContenidoNombre(),menuRegistro.obtenerContenidoExistencia());
                boolean status = daoMedicamento.insertar(medicamento);
                if(status){
                    JOptionPane.showMessageDialog(menuRegistro, "Se agregó el registró el medicamento.", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
                    menuRegistro.limpiar();
                    menuRegistro.setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(menuRegistro, "No se pudo registrar el medicamento.", "Error en el registro", JOptionPane.ERROR_MESSAGE);
                }
            }
            case "cancelar" -> menuRegistro.setVisible(false);
        }
    }
    
}