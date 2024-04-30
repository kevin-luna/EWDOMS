/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelos.DetalleReceta;
import modelos.Medicamento;
import java.util.ArrayList;

/**
 * Clase DAO para la entidad DetalleReceta.
 */
public class DAODetalleReceta {

    Conector conector;

    public DAODetalleReceta() {
        conector = new Conector();
    }

    public ArrayList<Medicamento> consultar(Long id) {
        // No se consulta individualmente un detalle de receta
        ArrayList<Medicamento> lista = new ArrayList<Medicamento>();
        Connection conexion = conector.iniciar();
        if (conexion != null) {
            String sql = "SELECT id_medicamento,medicamento.nombre FROM detalle_receta JOIN consultorio_medico.medicamento ON detalle_receta.id_medicamento = medicamento.id WHERE id_receta = ?";
            try {
                PreparedStatement consulta = conexion.prepareStatement(sql);
                consulta.setLong(1, id);
                ResultSet coincidencias = consulta.executeQuery();
                while (coincidencias.next()) {
                    Medicamento medicamento = new Medicamento(
                            coincidencias.getLong("id_medicamento"),
                            coincidencias.getString("nombre")
                    );
                }
                return lista;
            } catch (SQLException ex) {
                ex.printStackTrace();
                return null;
            } finally {
                conector.terminar();
            }
        }
        return null;
    }

    public boolean insertar(DetalleReceta detalleReceta) {
        Connection conexion = conector.iniciar();
        if (conexion != null) {
            String sql = "INSERT INTO detalle_receta (id_receta, id_medicamento) VALUES (?, ?)";
            try {
                PreparedStatement consulta = conexion.prepareStatement(sql);
                consulta.setLong(1, detalleReceta.getId_receta());
                consulta.setLong(2, detalleReceta.getId_medicamento());
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

    public boolean insertar(ArrayList<DetalleReceta> detalle) {
        Connection conexion = conector.iniciar();
        if (conexion != null) {
            String sql = "INSERT INTO detalle_receta (id_receta, id_medicamento) VALUES (?, ?)";
            try {
                for (DetalleReceta d : detalle) {
                    PreparedStatement consulta = conexion.prepareStatement(sql);
                    consulta.setLong(1, d.getId_receta());
                    consulta.setLong(2, d.getId_medicamento());
                    consulta.executeUpdate();
                }
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

    public boolean eliminar(Long id_receta, Long id_medicamento) {
        Connection conexion = conector.iniciar();
        if (conexion != null) {
            String sql = "DELETE FROM medicamento WHERE id_receta = ? AND id_medicamento = ?";
            try {
                PreparedStatement consulta = conexion.prepareStatement(sql);
                consulta.setLong(1, id_receta);
                consulta.setLong(2, id_medicamento);
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
}
