/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author kevin
 */
public class Medicamento {
    private long id;
    private String nombre;
    private int existencia;

    public Medicamento(long id, String nombre, int existencia) {
        this.id = id;
        this.nombre = nombre;
        this.existencia = existencia;
    }

    public Medicamento(long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Medicamento(String nombre, int existencia) {
        this.nombre = nombre;
        this.existencia = existencia;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }
    
    
}
