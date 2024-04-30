/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testing;

import dao.DAOMedico;
import modelos.Medico;

/**
 *
 * @author kevin
 */
public class Test {
    public static void main(String[] args) {
        /*
        Conector conector = new Conector();
        Connection conexion;
        if((conexion = conector.iniciar())!=null) System.out.println("La conexion con el servidor se realizó correctamente.");
        else System.out.println("No se pudo conectar con el servidor.");
*/
        Medico medico = new Medico(2,"Dra. Ana Martinez", "Podologia", "0987654321", "Hospital Y");
        DAOMedico dao = new DAOMedico();
        dao.actualizar(medico.getId(), medico);
        
    }
}
