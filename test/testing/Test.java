/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testing;

import java.sql.Connection;
import dao.Conector;

/**
 *
 * @author kevin
 */
public class Test {
    public static void main(String[] args) {
        Conector conector = new Conector();
        Connection conexion;
        if((conexion = conector.iniciar())!=null) System.out.println("La conexion con el servidor se realizó correctamente.");
        else System.out.println("No se pudo conectar con el servidor.");
    }
}
