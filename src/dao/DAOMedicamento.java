
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
import modelos.Medicamento;

/**
 * Clase DAO para la entidad Medicamento.
 */
public class DAOMedicamento implements DAO<Long, Medicamento> {

    Conector conector;

    public DAOMedicamento() {
        conector = new Conector();
    }

    @Override
    public Medicamento consultar(Long id) {
        Connection conexion = conector.iniciar();
        if (conexion != null) {
            String sql = "SELECT * FROM medicamento WHERE id = ?";
            try {
                PreparedStatement consulta = conexion.prepareStatement(sql);
                consulta.setLong(1, id);
                ResultSet coincidencias = consulta.executeQuery();
                if (coincidencias.next()) {
                    Medicamento medicamento = new Medicamento(
                            coincidencias.getLong("id"),
                            coincidencias.getString("nombre"),
                            coincidencias.getInt("existencia")
                    );
                    return medicamento;
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

    public ArrayList<Medicamento> buscar(String nombre) {
        ArrayList<Medicamento> listaResultados = new ArrayList<Medicamento>();
        Connection conexion = conector.iniciar();
        if (conexion != null) {
            String sql = "SELECT * FROM medicamento WHERE nombre LIKE ?";
            try {
                PreparedStatement consulta = conexion.prepareStatement(sql);
                consulta.setString(1, nombre);
                ResultSet coincidencias = consulta.executeQuery();
                while (coincidencias.next()) {
                    Medicamento medicamento = new Medicamento(
                            coincidencias.getLong("id"),
                            coincidencias.getString("nombre"),
                            coincidencias.getInt("existencia")
                    );
                    listaResultados.add(medicamento);
                }
                return listaResultados;
            } catch (SQLException ex) {
                return null;
            } finally {
                conector.terminar();
            }
        }
        return null;
    }

    @Override
    public ArrayList<Medicamento> consultar() {
        Connection conexion = conector.iniciar();
        if (conexion != null) {
            ArrayList<Medicamento> listaMedicamentos = new ArrayList<>();
            String sql = "SELECT * FROM medicamento";
            try {
                Statement consulta = conexion.createStatement();
                ResultSet coincidencias = consulta.executeQuery(sql);
                while (coincidencias.next()) {
                    Medicamento medicamento = new Medicamento(
                            coincidencias.getLong("id"),
                            coincidencias.getString("nombre"),
                            coincidencias.getInt("existencia")
                    );
                    listaMedicamentos.add(medicamento);
                }
                return listaMedicamentos;
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
    public long insertar(Medicamento medicamento) {
        Connection conexion = conector.iniciar();
        if (conexion != null) {
            String sql = "INSERT INTO medicamento (nombre, existencia) VALUES (?, ?)";
            try {
                PreparedStatement consulta = conexion.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
                consulta.setString(1, medicamento.getNombre());
                consulta.setInt(2, medicamento.getExistencia());
                int status = consulta.executeUpdate();
                if(status>0){
                    ResultSet llavePrimaria =  consulta.getGeneratedKeys();
                    llavePrimaria.next();
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
            String sql = "DELETE FROM medicamento WHERE id = ?";
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
    public boolean actualizar(Long id, Medicamento medicamento) {
        Connection conexion = conector.iniciar();
        if (conexion != null) {
            String sql = "UPDATE medicamento SET nombre=?, existencia=? WHERE id=?";
            try {
                PreparedStatement consulta = conexion.prepareStatement(sql);
                consulta.setString(1, medicamento.getNombre());
                consulta.setInt(2, medicamento.getExistencia());
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
