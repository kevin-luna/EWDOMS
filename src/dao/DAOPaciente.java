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
import modelos.Paciente;

/**
 * Clase DAO para la entidad Paciente.
 */
public class DAOPaciente implements DAO<Long, Paciente> {

    Conector conector;

    public DAOPaciente() {
        conector = new Conector();
    }

    @Override
    public Paciente consultar(Long id) {
        Connection conexion = conector.iniciar();
        if (conexion != null) {
            String sql = "SELECT * FROM paciente WHERE id = ?";
            try {
                PreparedStatement consulta = conexion.prepareStatement(sql);
                consulta.setLong(1, id);
                ResultSet coincidencias = consulta.executeQuery();
                if (coincidencias.next()) {
                    Paciente paciente = new Paciente(
                            coincidencias.getLong("id"),
                            coincidencias.getString("nombre"),
                            coincidencias.getString("tipo_sangre"),
                            coincidencias.getString("sexo"),
                            coincidencias.getFloat("altura"),
                            coincidencias.getFloat("peso"),
                            coincidencias.getString("fecha_nacimiento"),
                            coincidencias.getString("direccion"),
                            coincidencias.getString("telefono"),
                            coincidencias.getString("correo_electronico")
                    );
                    return paciente;
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

    public ArrayList<Paciente> buscar(String nombre) {
        ArrayList<Paciente> listaResultados = new ArrayList<Paciente>();
        Connection conexion = conector.iniciar();
        if (conexion != null) {
            String sql = "SELECT * FROM paciente WHERE nombre LIKE ?";
            try {
                PreparedStatement consulta = conexion.prepareStatement(sql);
                consulta.setString(1, nombre);
                ResultSet coincidencias = consulta.executeQuery();
                while (coincidencias.next()) {
                    Paciente paciente = new Paciente(
                            coincidencias.getLong("id"),
                            coincidencias.getString("nombre"),
                            coincidencias.getString("tipo_sangre"),
                            coincidencias.getString("sexo"),
                            coincidencias.getFloat("altura"),
                            coincidencias.getFloat("peso"),
                            coincidencias.getString("fecha_nacimiento"),
                            coincidencias.getString("direccion"),
                            coincidencias.getString("telefono"),
                            coincidencias.getString("correo_electronico")
                    );
                    listaResultados.add(paciente);
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
    public ArrayList<Paciente> consultar() {
        Connection conexion = conector.iniciar();
        if (conexion != null) {
            ArrayList<Paciente> listaPacientes = new ArrayList<>();
            String sql = "SELECT * FROM paciente";
            try {
                Statement consulta = conexion.createStatement();
                ResultSet coincidencias = consulta.executeQuery(sql);
                while (coincidencias.next()) {
                    Paciente paciente = new Paciente(
                            coincidencias.getLong("id"),
                            coincidencias.getString("nombre"),
                            coincidencias.getString("tipo_sangre"),
                            coincidencias.getString("sexo"),
                            coincidencias.getFloat("altura"),
                            coincidencias.getFloat("peso"),
                            coincidencias.getString("fecha_nacimiento"),
                            coincidencias.getString("direccion"),
                            coincidencias.getString("telefono"),
                            coincidencias.getString("correo_electronico")
                    );
                    listaPacientes.add(paciente);
                }
                return listaPacientes;
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
    public boolean insertar(Paciente paciente) {
        Connection conexion = conector.iniciar();
        if (conexion != null) {
            String sql = "INSERT INTO paciente (nombre, tipo_sangre, sexo, altura, peso, fecha_nacimiento, direccion, telefono, correo_electronico) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try {
                PreparedStatement consulta = conexion.prepareStatement(sql);
                consulta.setString(1, paciente.getNombre());
                consulta.setString(2, paciente.getTipoSangre());
                consulta.setString(3, paciente.getSexo());
                consulta.setFloat(4, paciente.getAltura());
                consulta.setFloat(5, paciente.getPeso());
                consulta.setString(6, paciente.getFechaNacimiento());
                consulta.setString(7, paciente.getDireccion());
                consulta.setString(8, paciente.getTelefono());
                consulta.setString(9, paciente.getCorreoElectronico());
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
            String sql = "DELETE FROM paciente WHERE id = ?";
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
    public boolean actualizar(Long id, Paciente paciente) {
        Connection conexion = conector.iniciar();
        if (conexion != null) {
            String sql = "UPDATE paciente SET nombre=?, tipo_sangre=?, sexo=?, altura=?, peso=?, fecha_nacimiento=?, direccion=?, telefono=?, correo_electronico=? WHERE id=?";
            try {
                PreparedStatement consulta = conexion.prepareStatement(sql);
                consulta.setString(1, paciente.getNombre());
                consulta.setString(2, paciente.getTipoSangre());
                consulta.setString(3, paciente.getSexo());
                consulta.setFloat(4, paciente.getAltura());
                consulta.setFloat(5, paciente.getPeso());
                consulta.setString(6, paciente.getFechaNacimiento());
                consulta.setString(7, paciente.getDireccion());
                consulta.setString(8, paciente.getTelefono());
                consulta.setString(9, paciente.getCorreoElectronico());
                consulta.setLong(10, id);
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
