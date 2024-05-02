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
import modelos.ConsultaMedica;

/**
 * Clase DAO para la entidad ConsultaMedica.
 */
public class DAOConsultaMedica implements DAO<Long, ConsultaMedica> {

    Conector conector;

    public DAOConsultaMedica() {
        conector = new Conector();
    }

    @Override
    public ConsultaMedica consultar(Long id) {
        Connection conexion = conector.iniciar();
        if (conexion != null) {
            String sql = "SELECT * FROM consulta_medica WHERE id = ?";
            try {
                PreparedStatement consulta = conexion.prepareStatement(sql);
                consulta.setLong(1, id);
                ResultSet coincidencias = consulta.executeQuery();
                if (coincidencias.next()) {
                    ConsultaMedica consultaMedica = new ConsultaMedica(
                            coincidencias.getLong("id"),
                            coincidencias.getLong("id_paciente"),
                            coincidencias.getLong("id_medico"),
                            coincidencias.getString("fecha")
                    );
                    return consultaMedica;
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                return null;
            } finally {
                conector.terminar();
            }
        }
        return null;
    }

    @Override
    public ArrayList<ConsultaMedica> consultar() {
        Connection conexion = conector.iniciar();
        if (conexion != null) {
            ArrayList<ConsultaMedica> listaConsultas = new ArrayList<>();
            String sql = "SELECT * FROM consulta_medica";
            try {
                Statement consulta = conexion.createStatement();
                ResultSet resultados = consulta.executeQuery(sql);
                while (resultados.next()) {
                    ConsultaMedica consultaMedica = new ConsultaMedica(
                            resultados.getLong("id"),
                            resultados.getLong("id_paciente"),
                            resultados.getLong("id_medico"),
                            resultados.getString("fecha")
                    );
                    listaConsultas.add(consultaMedica);
                }
                return listaConsultas;
            } catch (SQLException ex) {
                ex.printStackTrace();
                return null;
            } finally {
                conector.terminar();
            }
        }
        return null;
    }

    @Override
    public long insertar(ConsultaMedica consultaMedica) {
        Connection conexion = conector.iniciar();
        if (conexion != null) {
            String sql = "INSERT INTO consulta_medica (id_paciente, id_medico, fecha) VALUES (?, ?,?)";
            try {
                PreparedStatement consulta = conexion.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
                consulta.setLong(1, consultaMedica.getIdPaciente());
                consulta.setLong(2, consultaMedica.getIdMedico());
                consulta.setString(3, consultaMedica.getFecha());
                
                int status = consulta.executeUpdate();
                if(status>0){
                    ResultSet llavePrimaria =  consulta.getGeneratedKeys();
                    return llavePrimaria.getLong(1);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                return -1;
            } finally {
                conector.terminar();
            }
        }
        return -1;
    }

    @Override
    public boolean eliminar(Long id) {
        Connection conexion = conector.iniciar();
        if (conexion != null) {
            String sql = "DELETE FROM consulta_medica WHERE id = ?";
            try {
                PreparedStatement consulta = conexion.prepareStatement(sql);
                consulta.setLong(1, id);
                int filasAfectadas = consulta.executeUpdate();
                return filasAfectadas != 0;
            } catch (SQLException ex) {
                ex.printStackTrace();
                return false;
            } finally {
                conector.terminar();
            }
        }
        return false;
    }

    @Override
    public boolean actualizar(Long id, ConsultaMedica consultaMedica) {
        Connection conexion = conector.iniciar();
        if (conexion != null) {
            String sql = "UPDATE consulta_medica SET id_paciente=?, id_medico=?, fecha=? WHERE id=?";
            try {
                PreparedStatement consulta = conexion.prepareStatement(sql);
                consulta.setLong(1, consultaMedica.getIdPaciente());
                consulta.setString(2, consultaMedica.getFecha());
                consulta.setLong(3, id);
                consulta.executeUpdate();
                return true;
            } catch (SQLException ex) {
                ex.printStackTrace();
                return false;
            } finally {
                conector.terminar();
            }
        }
        return false;
    }
}
