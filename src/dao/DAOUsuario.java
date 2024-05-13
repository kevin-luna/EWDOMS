/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.Usuario;

/**
 *
 * @author 
 */
public class DAOUsuario {
    private Conector conector;
    
    public DAOUsuario(){
        this.conector = new Conector();
    }
    
    public StatusConsulta cambiarClave(String nombreUsuario,String nuevaClave){
        try {
            Connection conexion = conector.iniciar();
            String sql = "{call ActualizarClaveAcceso(?,?)}";
            CallableStatement consulta = conexion.prepareCall(sql);
            consulta.setString(1, nombreUsuario);
            consulta.setString(2, nuevaClave);
            consulta.execute();
            ResultSet respuesta = consulta.getResultSet();
            respuesta.next();
            return new StatusConsulta(respuesta.getInt(1),respuesta.getString(2));
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return StatusConsulta.ERROR_SQL;
        }
    }
    
    public Usuario consultarUsuario(String nombre){
        try {
            Connection conexion = conector.iniciar();
            String sql = "{call ConsultarUsuarioPorNombre(?)}";
            CallableStatement consulta = conexion.prepareCall(sql);
            consulta.setString(1, nombre);
            consulta.execute();
            ResultSet coincidencias = consulta.getResultSet();
            if(coincidencias.next()){
                return new Usuario(coincidencias.getString(1),coincidencias.getInt(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return null;
    }
    
    public ArrayList<Usuario> consultarUsuarios(){
        ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
        try {
            Connection conexion = conector.iniciar();
            String sql = "{call TraerTodosLosUsuarios()}";
            CallableStatement consulta = conexion.prepareCall(sql);
            consulta.execute();
            ResultSet coincidencias = consulta.getResultSet();
            while(coincidencias.next()){
                listaUsuarios.add(new Usuario(coincidencias.getString("nombre"),coincidencias.getInt("administrador")));
            }
            return listaUsuarios;
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    
    public boolean consultarPrivilegio(String nombre){
        try {
            Connection conexion = conector.iniciar();
            String sql = "{call ObtenerPrivilegiosUsuario(?)}";
            CallableStatement consulta = conexion.prepareCall(sql);
            consulta.setString(1, nombre);
            consulta.execute();
            ResultSet coincidencias = consulta.getResultSet();
            
            if(coincidencias.next() && coincidencias.getInt("administrador")==1) return true;
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return false;
    }
    
    public StatusConsulta insertar(Usuario usuario){
        try {
            Connection conexion = conector.iniciar();
            String sql = "{call InsertarUsuario(?,?,?)}";
            CallableStatement consulta = conexion.prepareCall(sql);
            consulta.setString(1, usuario.getNombre());
            consulta.setString(2, usuario.getClaveAcceso());
            consulta.setInt(3, usuario.isAdministrador());
            consulta.execute();
            ResultSet status = consulta.getResultSet();
            if(status.next()) return new StatusConsulta(status.getInt("status"),status.getString("mensaje"));
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return StatusConsulta.ERROR_SQL;
        }
        return StatusConsulta.ERROR_OPERACION;
    }
    
    public boolean eliminar(String nombre){
        try {
            Connection conexion = conector.iniciar();
            String sql = "{call EliminarUsuario(?)}";
            CallableStatement consulta = conexion.prepareCall(sql);
            consulta.setString(1, nombre);
            if(consulta.executeUpdate()>0)return true;
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return false;
    }
    
    public StatusConsulta iniciarSesion(Usuario usuario){
        try {
            Connection conexion = conector.iniciar();
            String sql = "{call IniciarSesion(?,?)}";
            CallableStatement consulta = conexion.prepareCall(sql);
            consulta.setString(1, usuario.getNombre());
            consulta.setString(2, usuario.getClaveAcceso());
            consulta.execute();
            ResultSet coincidencias = consulta.getResultSet();
            if(coincidencias.next()){
                return new StatusConsulta(coincidencias.getInt("status"), coincidencias.getString("mensaje"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return StatusConsulta.ERROR_SQL;
        }
        return StatusConsulta.ERROR_OPERACION;
    }
}
