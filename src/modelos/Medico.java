/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author kevin
 */
public class Medico {
    private long id;
    private String nombre;
    private String especialidad;
    private String cedula;
    private String instituto;
    
    public Medico(){
        
    }

    public Medico(long id, String nombre, String especialidad, String cedula, String instituto) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.cedula = cedula;
        this.instituto = instituto;
    }

    public Medico(String nombre, String especialidad, String cedula, String instituto) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.cedula = cedula;
        this.instituto = instituto;
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

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getInstituto() {
        return instituto;
    }

    public void setInstituto(String instituto) {
        this.instituto = instituto;
    }
    
    
}
