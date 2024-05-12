/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import dao.DAOUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import modelos.Usuario;
import vistas.MenuPrincipal;

/**
 *
 * @author kevin
 */
public class ControladorVistaUsuarios implements ActionListener{
    
    private MenuPrincipal menu;
    private DAOUsuario daoUsuario;
    private ArrayList<Usuario> listaUsuarios;

    public ControladorVistaUsuarios(MenuPrincipal menu) {
        this.menu = menu;
        this.daoUsuario = new DAOUsuario();
    }
    
    
    public void actualizarUsuarios(){
        listaUsuarios = daoUsuario.consultarUsuarios();
        menu.cargarUsuarios(listaUsuarios);
    }
    
    public void eliminarUsuario(){
        String nombre = menu.obtenerUsuarioSeleccionado();
        if(nombre!=null){
            daoUsuario.eliminar(nombre);
            actualizarUsuarios();
        }
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton boton = (JButton)e.getSource();
        switch(boton.getName()){
            case "todos_usuarios":
                actualizarUsuarios();
                break;
            case "nuevo_usuario":
                
                break;
            case "editar_usuario":
                
                break;
            case "eliminar_usuario":
                eliminarUsuario();
                break;
        }
    }
    
}
