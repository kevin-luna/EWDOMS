/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import dao.DAODetalleReceta;
import dao.DAOMedicamento;
import dao.DAOReceta;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.table.DefaultTableModel;
import modelos.DetalleReceta;
import modelos.Medicamento;
import modelos.Receta;
import vistas.FormReceta;

public class ControladorRegistroReceta implements ActionListener {
    private DAOReceta daoReceta;
    private DAODetalleReceta daoDetalleReceta;
    private FormReceta menuRegistro;
    private HashSet<Long> medicamentosGuardados;
    private HashSet<Long> medicamentosAgregados;
    private HashSet<Long> medicamentosEliminados;
    private int medicamentoSeleccionado;

    public ControladorRegistroReceta(FormReceta menuRegistro) {
        this.menuRegistro = menuRegistro;
        daoReceta = new DAOReceta();
        daoDetalleReceta = new DAODetalleReceta();
        medicamentosAgregados = new HashSet<Long>();
        medicamentosGuardados = new HashSet<Long>();
        medicamentosEliminados = new HashSet<Long>();
    }

    public void guardarReceta() {
        
    }
    
    public void agregarMedicamento(){
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton boton = (JButton) e.getSource();

        switch (boton.getName()) {
            case "guardar":
                if (menuRegistro.tieneCamposVacios()) {
                    JOptionPane.showMessageDialog(menuRegistro, "No pueden quedar campos vacíos", "Atención", JOptionPane.WARNING_MESSAGE);
                    break;
                }else{
                    guardarReceta();
                }
                break;
            case "agregar_medicamento":
                agregarMedicamento();
                break;
            case "eliminar_medicamento":

                break;
            case "cancelar":
                menuRegistro.dispose();
                break;
        }
    }
}
