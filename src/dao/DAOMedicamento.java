
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
import dao.Conector;
import dao.DAO;
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
    
    @Override
    public ArrayList<Medicamento> consultar() {
        Connection conexion = conector.iniciar();
        if (conexion != null) {
            ArrayList<Medicamento> listaMedicamentos = new ArrayList<>();
            String sql = "SELECT * FROM medicamento";
            try {
                Statement consulta = conexion.createStatement();
                ResultSet resultados = consulta.executeQuery(sql);
                while (resultados.next()) {
                    Medicamento medicamento = new Medicamento(
                            resultados.getLong("id"),
                            resultados.getString("nombre"),
                            resultados.getInt("existencia")
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
    public boolean insertar(Medicamento medicamento) {
        Connection conexion = conector.iniciar();
        if (conexion != null) {
            String sql = "INSERT INTO medicamento (nombre, existencia) VALUES (?, ?)";
            try {
                PreparedStatement consulta = conexion.prepareStatement(sql);
                consulta.setString(1, medicamento.getNombre());
                consulta.setInt(2, medicamento.getExistencia());
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