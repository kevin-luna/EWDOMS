/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import dao.DAODetalleReceta;
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

    private Receta receta;
    private DAOReceta daoReceta;
    private DAODetalleReceta daoDetalleReceta;
    private FormReceta menuRegistro;
    private HashSet<Long> medicamentosGuardados;
    private HashSet<Long> medicamentosAgregados;
    private HashSet<Long> medicamentosEliminados;
    private DefaultTableModel modeloTabla;
    private int medicamentoSeleccionado;

    public ControladorRegistroReceta(FormReceta menuRegistro) {
        this.menuRegistro = menuRegistro;
        daoReceta = new DAOReceta();
        daoDetalleReceta = new DAODetalleReceta();
        modeloTabla = menuRegistro.getModeloListaMedicamentos();
        medicamentosAgregados = new HashSet<Long>();
        medicamentosGuardados = new HashSet<Long>();
        medicamentosEliminados = new HashSet<Long>();
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
                
                receta = menuRegistro.obtenerReceta();
                
                ArrayList<Medicamento> tmp = daoDetalleReceta.consultar(receta.getId());
                medicamentosGuardados.clear();
                for(Medicamento medicamento: tmp){
                    medicamentosGuardados.add(medicamento.getId());
                }
                
                
                boolean statusReceta;
                String accion, accion2;
                if(menuRegistro.getActualizar()){
                    accion = "actualizó";
                    accion2 = "actualizar";
                    
                    statusReceta = daoReceta.actualizar(receta.getId(), receta);
                }else{
                    accion = "agregó";
                    accion2 = "agregar";
                    statusReceta = daoReceta.insertar(receta);
                }
                if (statusReceta) {
                    for(Long idMedicamento : medicamentosAgregados){
                        if(!medicamentosGuardados.contains(idMedicamento))
                        daoDetalleReceta.insertar(new DetalleReceta(receta.getId(),idMedicamento));
                    }
                    for(Long idMedicamento: medicamentosEliminados){
                        System.out.println("Borrando el medicamento para "+menuRegistro.obtenerIdConsulta()+" "+idMedicamento);
                            daoDetalleReceta.eliminar(menuRegistro.obtenerIdConsulta(), idMedicamento);
                    }
                    JOptionPane.showMessageDialog(menuRegistro, "Se "+accion+" la receta.", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
                    menuRegistro.limpiar();
                    menuRegistro.dispose();
                } else {
                    JOptionPane.showMessageDialog(menuRegistro, "No se pudo "+accion2+" la receta.", "Error en el registro", JOptionPane.ERROR_MESSAGE);
                }
                break;

            case "agregar_medicamento":
                System.out.println("Entra");
                medicamentoSeleccionado = menuRegistro.getComboMedicamento().getSelectedIndex();
                if (!medicamentosAgregados.contains(menuRegistro.getListaMedicamentos().get(medicamentoSeleccionado).getId())) {
                    modeloTabla.addRow(new Object[]{menuRegistro.getListaMedicamentos().get(medicamentoSeleccionado).getNombre()});
                    medicamentosAgregados.add(menuRegistro.getListaMedicamentos().get(medicamentoSeleccionado).getId());
                }
                break;
            case "eliminar_medicamento":
                medicamentoSeleccionado = menuRegistro.getTablaMedicamentos().getSelectedRow();
                if(medicamentoSeleccionado!=-1){
                    menuRegistro.getModeloListaMedicamentos().removeRow(medicamentoSeleccionado);
                if(medicamentosGuardados.contains(menuRegistro.getListaMedicamentos().get(medicamentoSeleccionado).getId()))
                    medicamentosEliminados.add(menuRegistro.getListaMedicamentos().get(medicamentoSeleccionado).getId());
                medicamentosAgregados.remove(menuRegistro.getListaMedicamentos().get(medicamentoSeleccionado).getId());
                }
                break;
            case "cancelar":
                menuRegistro.dispose();
                break;
        }
    }
}
