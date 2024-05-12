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
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import modelos.Medicamento;
import vistas.FormMedicamento;

/**
 *
 * @author kevin
 */
public class ControladorRegistroMedicamento implements ActionListener, ChangeListener{

    Medicamento medicamento;
    DAOMedicamento daoMedicamento;
    FormMedicamento menuRegistro;

    public ControladorRegistroMedicamento(FormMedicamento menuRegistro) {
        this.menuRegistro = menuRegistro;
        daoMedicamento = new DAOMedicamento();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton boton = (JButton)e.getSource();
        switch(boton.getName()){
            case "guardar" :
                if(menuRegistro.tieneCamposVacios()){
                    JOptionPane.showMessageDialog(menuRegistro, "No pueden quedar campos vacíos", "Atención", JOptionPane.WARNING_MESSAGE);
                    break;
                }
                medicamento = new Medicamento(menuRegistro.obtenerContenidoNombre(),menuRegistro.obtenerContenidoExistencia());
                boolean status;
                String accion,accion2;
                if(menuRegistro.getActualizar()){
                    accion = "actualizó";
                    accion2="actualizar";
                    status = daoMedicamento.actualizar(menuRegistro.obtenerMedicamento().getId(),menuRegistro.obtenerMedicamento());
                }else{
                    accion = "registró";
                    accion2 = "registrar";
                    status = daoMedicamento.insertar(medicamento)!=-1;
                }
                if(status){
                    JOptionPane.showMessageDialog(menuRegistro, "Se "+accion+" el medicamento.", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
                    menuRegistro.limpiar();
                    menuRegistro.dispose();
                }else{
                    JOptionPane.showMessageDialog(menuRegistro, "No se pudo "+accion2+" el medicamento.", "Error en el registro", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case "cancelar":
                menuRegistro.dispose();
                break;
        }
    }
    
    @Override
    public void stateChanged(ChangeEvent e) {
        JSpinner spinnerCantidad = (JSpinner)e.getSource();
        int valor = (int)spinnerCantidad.getValue();
        if(valor<=0)spinnerCantidad.setValue(1);
    }
    
}
