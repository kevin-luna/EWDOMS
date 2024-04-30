/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import dao.DAOMedicamento;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import modelos.Medicamento;
import vistas.MenuPrincipal;
import vistas.RegistroMedicamento;

/**
 *
 * @author kevin
 */
public class ControladorVistaMedicamentos implements ActionListener{
    private MenuPrincipal menu;
    private DAOMedicamento daoMedicamento;
    private ArrayList<Medicamento> listaMedicamentos;
    private RegistroMedicamento menuRegistro;
    private ControladorRegistroMedicamento controladorRegistroMedicamento;

    public ControladorVistaMedicamentos(MenuPrincipal menu) {
        this.menu = menu;
        daoMedicamento = new DAOMedicamento();
        menuRegistro = new RegistroMedicamento();
        controladorRegistroMedicamento = new ControladorRegistroMedicamento(menuRegistro);
        menuRegistro.agregarEventos(controladorRegistroMedicamento);
    }
     

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Boton presionado");
        JButton boton = (JButton)e.getSource();
        
        switch(boton.getName()){
            case "todos_medicamentos":
                System.out.println("Solicitando la lista de medicamentos al servidor...");
                listaMedicamentos = daoMedicamento.consultar();
                DefaultTableModel modeloTabla = (DefaultTableModel)menu.getTablaMedicamentos().getModel();
                modeloTabla.setRowCount(0);
                for(Medicamento medicamento : listaMedicamentos){
                    modeloTabla.addRow(new Object[]{medicamento.getId(),medicamento.getNombre(),medicamento.getExistencia()});
                }
                break;
            case "nuevo_medicamento":
                menuRegistro.setVisible(true);
                break;
            case "editar_medicamentos":
                menuRegistro.setVisible(true);
                break;
            case "eliminar_medicamentos:":
                break;
        }
    }
    
    
}
