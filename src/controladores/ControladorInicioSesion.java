/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import dao.DAOUsuario;
import dao.StatusConsulta;
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
    private MenuPrincipal menuPrincipal;

    public ControladorInicioSesion(FormInicioSesion formInicioSesion) {
        this.formInicioSesion = formInicioSesion;
        this.daoUsuario = new DAOUsuario();
    }
    
    public void iniciarAplicacion(boolean modoAdministrador){
        menuPrincipal = new MenuPrincipal(modoAdministrador);
        ControladorMenuPrincipal controladorMenuPrincpal = new ControladorMenuPrincipal(menuPrincipal);
        ControladorVistaMedicamentos controladorVistaMedicamentos = new ControladorVistaMedicamentos(menuPrincipal);
        ControladorVistaMedicos controladorVistaMedicos = new ControladorVistaMedicos(menuPrincipal);
        ControladorVistaPacientes controladorVistaPacientes = new ControladorVistaPacientes(menuPrincipal);
        ControladorVistaConsultas controladorVistaConsultas = new ControladorVistaConsultas(menuPrincipal);
        ControladorVistaRecetas controladorVistaRecetas = new ControladorVistaRecetas(menuPrincipal);
        ControladorVistaUsuarios controladorVistaUsuarios = new ControladorVistaUsuarios(menuPrincipal);
        
        //menuPrincipal.agregarEventos();
        menuPrincipal.agregarEventosVistaMedicamentos(controladorVistaMedicamentos);
        menuPrincipal.agregarEventosVistaMedicos(controladorVistaMedicos);
        menuPrincipal.agregarEventosVistaPacientes(controladorVistaPacientes);
        menuPrincipal.agregarEventosVistaConsultas(controladorVistaConsultas);
        menuPrincipal.agregarEventosVistaRecetas(controladorVistaRecetas);
        menuPrincipal.agregarEventosVistaUsuarios(controladorVistaUsuarios);
        menuPrincipal.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton boton = (JButton) e.getSource();
        if (boton.getName() == "iniciar_sesion") {
            this.usuario = formInicioSesion.obtenerUsuario();
            StatusConsulta status = daoUsuario.iniciarSesion(usuario);
            if(status.getCodigo()==1){
                boolean modoAdmin = daoUsuario.consultarPrivilegio(usuario.getNombre());
                formInicioSesion.dispose();
                iniciarAplicacion(modoAdmin);
                JOptionPane.showMessageDialog(menuPrincipal, status.getMensaje(), "Inicio de sesión correcto", status.getCodigo());
            }else{
                JOptionPane.showMessageDialog(formInicioSesion, status.getMensaje(), "Error al iniciar sesión", status.getCodigo());
            }
        }
    }

}
