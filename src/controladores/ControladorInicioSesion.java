/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import dao.DAOUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import modelos.Usuario;
import vistas.FormInicioSesion;
import vistas.MenuPrincipal;

/**
 *
 * @author kevin
 */
public class ControladorInicioSesion implements ActionListener {

    private FormInicioSesion formInicioSesion;
    private Usuario usuario;
    private DAOUsuario daoUsuario;

    public ControladorInicioSesion(FormInicioSesion formInicioSesion) {
        this.formInicioSesion = formInicioSesion;
        this.daoUsuario = new DAOUsuario();
    }
    
    public void iniciarAplicacion(){
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        ControladorMenuPrincipal controladorMenuPrincpal = new ControladorMenuPrincipal(menuPrincipal);
        ControladorVistaMedicamentos controladorVistaMedicamentos = new ControladorVistaMedicamentos(menuPrincipal);
        ControladorVistaMedicos controladorVistaMedicos = new ControladorVistaMedicos(menuPrincipal);
        ControladorVistaPacientes controladorVistaPacientes = new ControladorVistaPacientes(menuPrincipal);
        ControladorVistaConsultas controladorVistaConsultas = new ControladorVistaConsultas(menuPrincipal);
        ControladorVistaRecetas controladorVistaRecetas = new ControladorVistaRecetas(menuPrincipal);
        
        //menuPrincipal.agregarEventos();
        menuPrincipal.agregarEventosVistaMedicamentos(controladorVistaMedicamentos);
        menuPrincipal.agregarEventosVistaMedicos(controladorVistaMedicos);
        menuPrincipal.agregarEventosVistaPacientes(controladorVistaPacientes);
        menuPrincipal.agregarEventosVistaConsultas(controladorVistaConsultas);
        menuPrincipal.agregarEventosVistaRecetas(controladorVistaRecetas);
        menuPrincipal.setVisible(true);
        JOptionPane.showMessageDialog(menuPrincipal, "Bienvenido "+usuario.getNombre(), "Inicio de sesión correcto", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton boton = (JButton) e.getSource();
        if (boton.getName() == "iniciar_sesion") {
            this.usuario = formInicioSesion.obtenerUsuario();
            if(daoUsuario.iniciarSesion(usuario)){
                formInicioSesion.dispose();
                iniciarAplicacion();
            }else{
                JOptionPane.showMessageDialog(formInicioSesion, "Usuario o contraseña incorrectos.", "Error al iniciar sesión", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}
