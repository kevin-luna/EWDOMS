/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelos.Medico;

/**
 *
 * @author kevin
 */
public class DAOMedico implements DAO<Long, Medico>{

    Conector conector;
    
    public DAOMedico() {
        conector = new Conector();
    }
    
    @Override
    public Medico consultar(Long id) {
        Connection conexion = conector.iniciar();
        if(conexion!=null){
            String sql = "SELECT * FROM medico WHERE id = ?";
            try {
                PreparedStatement consulta = conexion.prepareStatement(sql);
                consulta.setLong(1,id);
                ResultSet coincidencias = consulta.executeQuery();
                if(coincidencias.next()){
                    Medico objeto = new Medico(coincidencias.getLong("id"),
                            coincidencias.getString("nombre"),
                            coincidencias.getString("especialidad"),
                            coincidencias.getString("cedula"),
                            coincidencias.getString("instituto"));
                    return objeto;
                }
            } catch (SQLException ex) {
                return null;
            }finally{
                conector.terminar();
            }
        }
        return null;
    }
    
    public Medico consultar(String nombre) {
        Connection conexion = conector.iniciar();
        if(conexion!=null){
            String sql = "SELECT * FROM medico WHERE nombre LIKE ?";
            try {
                PreparedStatement consulta = conexion.prepareStatement(sql);
                consulta.setString(1,nombre);
                ResultSet coincidencias = consulta.executeQuery();
                if(coincidencias.next()){
                    Medico objeto = new Medico(coincidencias.getLong("id"),
                            coincidencias.getString("nombre"),
                            coincidencias.getString("especialidad"),
                            coincidencias.getString("cedula"),
                            coincidencias.getString("instituto"));
                    return objeto;
                }
            } catch (SQLException ex) {
                return null;
            }finally{
                conector.terminar();
            }
        }
        return null;
    }

    @Override
    public ArrayList<Medico> consultar() {
        Connection conexion = conector.iniciar();
        if(conexion!=null){
            ArrayList<Medico> lista = new ArrayList<Medico>();
            String sql = "SELECT * FROM medico";
            try {
                Statement consulta = conexion.createStatement();
                ResultSet coincidencias = consulta.executeQuery(sql);
                while(coincidencias.next()){
                    Medico objeto = new Medico(coincidencias.getLong("id"),
                            coincidencias.getString("nombre"),
                            coincidencias.getString("especialidad"),
                            coincidencias.getString("cedula"),
                            coincidencias.getString("instituto"));
                    lista.add(objeto);
                }
                return lista;
            } catch (SQLException ex) {
                return lista;
            }finally{
                conector.terminar();
            }
        }
        return null;
    }

    @Override
    public boolean insertar(Medico objeto) {
        Connection conexion = conector.iniciar();
        if(conexion!=null){
            String sql = "INSERT INTO medico (nombre,especialidad,cedula,instituto) VALUES(?,?,?,?)";
            try {
                PreparedStatement consulta = conexion.prepareStatement(sql);
                consulta.setString(1,objeto.getNombre());
                consulta.setString(2, objeto.getEspecialidad());
                consulta.setString(3, objeto.getCedula());
                consulta.setString(4, objeto.getInstituto());
                consulta.execute();
                return true;
            } catch (SQLException ex) {
                System.out.println("Error SQL");
                return false;
            }finally{
                conector.terminar();
            }
        }
        return false;
    }

    @Override
    public boolean eliminar(Long id) {
        Connection conexion = conector.iniciar();
        if(conexion!=null){
            String sql = "DELETE FROM medico WHERE id = ?";
            try {
                PreparedStatement consulta = conexion.prepareStatement(sql);
                consulta.setLong(1,id);
                int filas_afectadas = consulta.executeUpdate();
                if(filas_afectadas!=0)return true;
            } catch (SQLException ex) {
                return false;
            }finally{
                conector.terminar();
            }
        }
        return false;
    }

    @Override
    public boolean actualizar(Long id, Medico objeto) {
        Connection conexion = conector.iniciar();
        if(conexion!=null){
            String sql = "UPDATE medico SET nombre=?,especialidad=?,cedula=?,instituto=? WHERE id = ?";
            try {
                PreparedStatement consulta = conexion.prepareStatement(sql);
                consulta.setString(1,objeto.getNombre());
                consulta.setString(2, objeto.getEspecialidad());
                consulta.setString(3, objeto.getCedula());
                consulta.setString(4, objeto.getInstituto());
                consulta.setLong(5, id);
                consulta.execute();
                return true;
            } catch (SQLException ex) {
                System.out.println("Error SQL");
                return false;
            }finally{
                conector.terminar();
            }
        }
        return false;
    }
}
