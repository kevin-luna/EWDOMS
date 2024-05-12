/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kevin
 */
public class Usuario {

    private String nombre;
    private String claveAcceso;
    private int administrador;

    public Usuario(String nombre, String claveAcceso, int administrador) {
        this.nombre = nombre;
        this.claveAcceso = hashClave(claveAcceso);
        this.administrador = administrador;
    }

    public Usuario(String nombre, String claveAcceso) {
        this.nombre = nombre;
        this.claveAcceso = hashClave(claveAcceso);
    }

    public Usuario(String nombre, int administrador) {
        this.nombre = nombre;
        this.administrador = administrador;
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClaveAcceso() {
        return claveAcceso;
    }

    public void setClaveAcceso(String claveAcceso) {
        this.claveAcceso = hashClave(claveAcceso);
    }

    public int isAdministrador() {
        return administrador;
    }

    public void setAdministrador(int administrador) {
        this.administrador = administrador;
    }
    


    public static String hashClave(String claveAcceso) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = digest.digest(claveAcceso.getBytes());
            
            // Convertir bytes a representación hexadecimal
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException ex) {
            System.out.println("No se ha podido hashear la contraseña.");
        }
        return null;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + ", claveAcceso=" + claveAcceso + ", administrador=" + administrador + '}';
    }
    
    
}
