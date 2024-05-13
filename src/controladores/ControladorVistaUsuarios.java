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
import vistas.FormClaveUsuario;
import vistas.FormUsuario;
import vistas.MenuPrincipal;

/**
 *
 * @author 
 */
public class ControladorVistaUsuarios implements ActionListener{
    
    private MenuPrincipal menu;
    private DAOUsuario daoUsuario;
    private ArrayList<Usuario> listaUsuarios;
    private FormUsuario menuRegistro;
    private ControladorRegistroUsuario controladorRegistroUsuario;
    private FormClaveUsuario menuClaveUsuario;
    private ControladorClaveUsuario controladorClaveUsuario;

    public ControladorVistaUsuarios(MenuPrincipal menu) {
        this.menu = menu;
        this.daoUsuario = new DAOUsuario();
        this.menuRegistro = new FormUsuario();
        this.controladorRegistroUsuario = new ControladorRegistroUsuario(menuRegistro);
        this.menuRegistro.agregarEventos(controladorRegistroUsuario);
        this.menuClaveUsuario = new FormClaveUsuario();
        this.controladorClaveUsuario = new ControladorClaveUsuario(menuClaveUsuario);
        this.menuClaveUsuario.agregarEventos(controladorClaveUsuario);
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
    
    public void insertarUsuario(){
        menuRegistro.limpiar();
        menuRegistro.setVisible(true);
    }
    
    public void cambiarClave(){
        String nombreUsuario = menu.obtenerUsuarioSeleccionado();
        if(nombreUsuario!=null){
            controladorClaveUsuario.setNombreUsuario(nombreUsuario);
            menuClaveUsuario.limpiar();
            menuClaveUsuario.setVisible(true);
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
                insertarUsuario();
                break;
            case "cambiar_clave":
                cambiarClave();
                break;
            case "eliminar_usuario":
                eliminarUsuario();
                break;
        }
    }
    
}
