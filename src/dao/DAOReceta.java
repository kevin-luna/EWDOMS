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
import modelos.Receta;

/**
 * Clase DAO para la entidad Receta.
 */
public class DAOReceta implements DAO<Long, Receta> {

    Conector conector;

    public DAOReceta() {
        conector = new Conector();
    }

    @Override
    public Receta consultar(Long id) {
        Connection conexion = conector.iniciar();
        if (conexion != null) {
            String sql = "SELECT * FROM receta WHERE id = ?";
            try {
                PreparedStatement consulta = conexion.prepareStatement(sql);
                consulta.setLong(1, id);
                ResultSet coincidencias = consulta.executeQuery();
                if (coincidencias.next()) {
                    Receta receta = new Receta(
                            coincidencias.getLong("id"),
                            coincidencias.getLong("id_consulta"),
                            coincidencias.getString("diagnostico"),
                            coincidencias.getString("sintomas"),
                            coincidencias.getString("recomendaciones")
                    );
                    return receta;
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
    public ArrayList<Receta> consultar() {
        Connection conexion = conector.iniciar();
        if (conexion != null) {
            ArrayList<Receta> listaRecetas = new ArrayList<>();
            String sql = "SELECT * FROM receta";
            try {
                Statement consulta = conexion.createStatement();
                ResultSet resultados = consulta.executeQuery(sql);
                while (resultados.next()) {
                    Receta receta = new Receta(
                            resultados.getLong("id"),
                            resultados.getLong("id_consulta"),
                            resultados.getString("diagnostico"),
                            resultados.getString("sintomas"),
                            resultados.getString("recomendaciones")
                    );
                    listaRecetas.add(receta);
                }
                return listaRecetas;
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
    public boolean insertar(Receta receta) {
        Connection conexion = conector.iniciar();
        if (conexion != null) {
            String sql = "INSERT INTO receta (id_consulta, diagnostico, sintomas, recomendaciones) VALUES (?, ?, ?, ?)";
            try {
                PreparedStatement consulta = conexion.prepareStatement(sql);
                consulta.setLong(1, receta.getId_consulta());
                consulta.setString(2, receta.getDiagnostico());
                consulta.setString(3, receta.getSintomas());
                consulta.setString(4, receta.getRecomendaciones());
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
            String sql = "DELETE FROM receta WHERE id = ?";
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
    public boolean actualizar(Long id, Receta receta) {
        Connection conexion = conector.iniciar();
        if (conexion != null) {
            String sql = "UPDATE receta SET id_consulta=?, diagnostico=?, sintomas=?, recomendaciones=? WHERE id=?";
            try {
                PreparedStatement consulta = conexion.prepareStatement(sql);
                consulta.setLong(1, receta.getId_consulta());
                consulta.setString(2, receta.getDiagnostico());
                consulta.setString(3, receta.getSintomas());
                consulta.setString(4, receta.getRecomendaciones());
                consulta.setLong(5, id);
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
