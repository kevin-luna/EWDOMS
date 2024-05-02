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
import java.util.HashMap;
import java.util.HashSet;
import modelos.DetalleReceta;
import modelos.Medicamento;
import vistas.FormReceta;

public class ControladorRegistroReceta implements ActionListener {

    private DAOReceta daoReceta;
    private DAODetalleReceta daoDetalleReceta;
    private DAOMedicamento daoMedicamento;
    private FormReceta menuRegistro;
    private HashSet<String> medicamentosGuardados;
    private HashSet<String> medicamentosAgregados;
    private HashSet<String> medicamentosEliminados;
    private HashMap<String,Long> catalogoMedicamentos;
    private int medicamentoSeleccionado;

    public ControladorRegistroReceta(FormReceta menuRegistro) {
        this.menuRegistro = menuRegistro;
        daoReceta = new DAOReceta();
        daoDetalleReceta = new DAODetalleReceta();
        daoMedicamento = new DAOMedicamento();
        medicamentosAgregados = new HashSet<String>();
        medicamentosGuardados = menuRegistro.obtenerMedicamentosSeleccionados();
        medicamentosEliminados = new HashSet<String>();
    }

    private void consultarMedicamentosGuardados() {
        ArrayList<Medicamento> listaMedicamentos = daoMedicamento.consultar();
        for (Medicamento m : listaMedicamentos) {
            medicamentosGuardados.add(m.getNombre());
        }
    }

    public void guardarReceta() {
        long idReceta = daoReceta.insertar(menuRegistro.obtenerReceta());
        if (idReceta != -1) {
            this.catalogoMedicamentos = new HashMap<String,Long>();
            guardarMedicamentos(idReceta);
            JOptionPane.showMessageDialog(menuRegistro, "Se registró la receta correctamente.", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
            //menuRegistro.limpiar();
        } else {
            JOptionPane.showMessageDialog(menuRegistro, "Se registró la receta correctamente.", "Registro exitoso", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void guardarMedicamentos(long idReceta) {
        for(Medicamento medicamento : daoMedicamento.consultar()){
            this.catalogoMedicamentos.put(medicamento.getNombre(), medicamento.getId());
        }
        for (String nombreMedicamento : medicamentosAgregados) {
            daoDetalleReceta.insertar(new DetalleReceta(idReceta, catalogoMedicamentos.get(nombreMedicamento)));//Pendiente la pk de la nueva receta
        }
    }

    public void agregarMedicamento() {
        //consultarMedicamentosGuardados();//Probar como funciona sin los ultimos registros
        String medicamentoSeleccionado = menuRegistro.obtenerMedicamentoSeleccionadoCombo();
        if (!medicamentosGuardados.contains(medicamentoSeleccionado) && !medicamentosAgregados.contains(medicamentoSeleccionado)) {
            menuRegistro.agregarMedicamento();
            medicamentosAgregados.add(medicamentoSeleccionado);
        }
    }

    public void eliminarMedicamento() {
        String medicamentoSeleccionado = menuRegistro.obtenerMedicamentoSeleccionadoTabla();
        if (medicamentoSeleccionado != null && (medicamentosAgregados.contains(medicamentoSeleccionado) || medicamentosGuardados.contains(medicamentoSeleccionado))) {
            System.out.println("Eliminando medicamento");
            menuRegistro.eliminarMedicamento();
            medicamentosGuardados.remove(medicamentoSeleccionado);
            medicamentosAgregados.remove(medicamentoSeleccionado);
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
                    guardarReceta();
                }
                break;
            case "agregar_medicamento":
                agregarMedicamento();
                break;
            case "eliminar_medicamento":
                eliminarMedicamento();
                break;
            case "cancelar":
                cancelar();
                break;
        }
    }
}
