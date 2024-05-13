/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import dao.DAOUsuario;
import dao.StatusConsulta;
import excepciones.EntradaInvalida;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import vistas.FormClaveUsuario;

/**
 *
 * @author kevin
 */
public class ControladorClaveUsuario implements ActionListener {

    private FormClaveUsuario formClaveUsuario;
    private DAOUsuario daoUsuario;
    private String nombreUsuario;

    public ControladorClaveUsuario(FormClaveUsuario formClaveUsuario) {
        this.formClaveUsuario = formClaveUsuario;
        this.daoUsuario = new DAOUsuario();
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton boton = (JButton) e.getSource();
        switch (boton.getName()) {
            case "guardar":
                try {
                    String nuevaClave = formClaveUsuario.obtenerClave();
                    if (nuevaClave.equals(formClaveUsuario.obtenerConfirmacion())) {
                        StatusConsulta status = daoUsuario.cambiarClave(this.nombreUsuario, nuevaClave);
                        if (status.getCodigo() == 1) {
                            JOptionPane.showMessageDialog(formClaveUsuario, status.getMensaje(), "Cambio de clave exitoso", JOptionPane.INFORMATION_MESSAGE);
                            formClaveUsuario.dispose();
                        } else {
                            JOptionPane.showMessageDialog(formClaveUsuario, status.getMensaje(), "Error al cambiar la clave", JOptionPane.INFORMATION_MESSAGE);
                        }

                    } else {
                        JOptionPane.showMessageDialog(formClaveUsuario, "Las claves no coinciden.", "Error al cambiar la clave", JOptionPane.ERROR_MESSAGE);
                    }
                }catch(EntradaInvalida ex){
                    JOptionPane.showMessageDialog(formClaveUsuario, ex.getMessage(), "Error al cambiar la clave", JOptionPane.WARNING_MESSAGE);
                }
                break;
            case "cancelar":
                formClaveUsuario.limpiar();
                formClaveUsuario.dispose();
                break;
        }
    }

}
