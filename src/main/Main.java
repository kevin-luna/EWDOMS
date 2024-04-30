/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import controladores.ControladorMenuPrincipal;
import controladores.ControladorVistaConsultas;
import controladores.ControladorVistaMedicamentos;
import controladores.ControladorVistaMedicos;
import controladores.ControladorVistaPacientes;
import controladores.ControladorVistaRecetas;
import vistas.MenuPrincipal;

/**
 *
 * @author kevin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
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
    }
    
}
