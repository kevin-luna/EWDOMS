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
import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.table.DefaultTableModel;
import modelos.DetalleReceta;
import modelos.Receta;
import vistas.RegistroReceta;

public class ControladorRegistroReceta implements ActionListener {

    private Receta receta;
    private DAOReceta daoReceta;
    private RegistroReceta menuRegistro;
    private HashSet<Long> medicamentosAgregados;
    private DefaultTableModel modeloTabla;
    private int medicamentoSeleccionado;

    public ControladorRegistroReceta(RegistroReceta menuRegistro) {
        this.menuRegistro = menuRegistro;
        daoReceta = new DAOReceta();
        modeloTabla = menuRegistro.getModeloListaMedicamentos();
        medicamentosAgregados = new HashSet<Long>();
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
                receta = new Receta(
                        menuRegistro.obtenerIdConsulta(),
                        menuRegistro.obtenerDiagnostico(),
                        menuRegistro.obtenerSintomas(),
                        menuRegistro.obtenerRecomendaciones()
                );
                
                
                boolean status = daoReceta.insertar(receta);
                if (status) {
                    JOptionPane.showMessageDialog(menuRegistro, "Se agregó la receta.", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
                    menuRegistro.limpiar();
                    menuRegistro.dispose();
                } else {
                    JOptionPane.showMessageDialog(menuRegistro, "No se pudo registrar la receta.", "Error en el registro", JOptionPane.ERROR_MESSAGE);
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
                menuRegistro.getModeloListaMedicamentos().removeRow(medicamentoSeleccionado);
                medicamentosAgregados.remove(menuRegistro.getListaMedicamentos().get(medicamentoSeleccionado).getId());
                break;
            case "cancelar":
                menuRegistro.dispose();
                break;
        }
    }
}
