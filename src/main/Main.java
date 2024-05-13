/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import controladores.ControladorInicioSesion;
import vistas.FormInicioSesion;

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
        FormInicioSesion menuInicioSesion = new FormInicioSesion();
        ControladorInicioSesion controladorInicioSesion = new ControladorInicioSesion(menuInicioSesion);
        menuInicioSesion.agregarEventos(controladorInicioSesion);
        menuInicioSesion.setVisible(true);
    }
    
}
