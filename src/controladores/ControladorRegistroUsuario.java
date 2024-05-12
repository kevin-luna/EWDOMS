/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import dao.DAOUsuario;
import dao.StatusConsulta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import modelos.Usuario;
import vistas.FormUsuario;

/**
 *
 * @author kevin
 */
public class ControladorRegistroUsuario implements ActionListener{
    
    private FormUsuario menuRegistro;
    private DAOUsuario daoUsuario;

    public ControladorRegistroUsuario(FormUsuario menuRegistro) {
        this.menuRegistro = menuRegistro;
        this.daoUsuario = new DAOUsuario();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton boton = (JButton)e.getSource();
        switch(boton.getName()){
            case "guardar":
                Usuario usuario = menuRegistro.obtenerUsuario();
                StatusConsulta status = daoUsuario.insertar(usuario);
                if(status.getCodigo()==1){
                    JOptionPane.showMessageDialog(menuRegistro, status.getMensaje(), "Usuario agregado exitosamente", status.getCodigo());
                    menuRegistro.dispose();
                }else{
                    JOptionPane.showMessageDialog(menuRegistro, status.getMensaje(), "Error al agregar usuario", status.getCodigo());
                }
                break;
            case "cancelar":
                menuRegistro.dispose();
                break;
        }
    }
    
}
