/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.Usuario;

/**
 *
 * @author kevin
 */
public class DAOUsuario {
    private Conector conector;
    
    public DAOUsuario(){
        this.conector = new Conector();
    }
    
    public boolean registrarUsuario(Usuario usuario){
        try {
            Connection conexion = conector.iniciar();
            String sql = "INSERT INTO usuario VALUES(?,?)";
            PreparedStatement consulta = conexion.prepareStatement(sql);
            consulta.setString(1, usuario.getNombre());
            consulta.setString(2, usuario.getClaveAcceso());
            int status = consulta.executeUpdate();
            if(status>0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return false;
    }
    
    public boolean iniciarSesion(Usuario usuario){
        try {
            Connection conexion = conector.iniciar();
            String sql = "SELECT nombre FROM usuario WHERE nombre = ? AND clave_acceso = ?";
            PreparedStatement consulta = conexion.prepareStatement(sql);
            consulta.setString(1, usuario.getNombre());
            consulta.setString(2, usuario.getClaveAcceso());
            ResultSet coincidencias = consulta.executeQuery();
            if(coincidencias.next()){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return false;
    }
}
