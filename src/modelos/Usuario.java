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

    public Usuario(String nombre, String claveAcceso) {
        this.nombre = nombre;
        hashClave(claveAcceso);
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

    public void setClaveAcceso(String contraseña) {
        hashClave(claveAcceso);
    }

    public int isAdministrador() {
        return administrador;
    }

    public void setAdministrador(int administrador) {
        this.administrador = administrador;
    }

    private void hashClave(String claveAcceso) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = digest.digest(claveAcceso.getBytes());
            
            // Convertir bytes a representación hexadecimal
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            this.claveAcceso = sb.toString();
        } catch (NoSuchAlgorithmException ex) {
            System.out.println("No se ha podido hashear la contraseña.");
        }
    }
}
