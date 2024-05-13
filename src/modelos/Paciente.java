/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author kevin
 */
public class Paciente {
    private long id;
    private String nombre;
    private String tipo_sangre;
    private String sexo;
    private float altura;
    private float peso;
    private String fecha_nacimiento;
    private String direccion;
    private String telefono;
    private String correo_electronico;
    
    public Paciente(){
        
    }

    public Paciente(long id, String nombre, String tipo_sangre, String sexo, float altura, float peso, String fecha_nacimiento, String direccion, String telefono, String correo_electronico) {
        this.id = id;
        this.nombre = nombre;
        this.tipo_sangre = tipo_sangre;
        this.sexo = sexo;
        this.altura = altura;
        this.peso = peso;
        this.fecha_nacimiento = fecha_nacimiento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo_electronico = correo_electronico;
    }

    public Paciente(String nombre, String tipo_sangre, String sexo, float altura, float peso, String fecha_nacimiento, String direccion, String telefono, String correo_electronico) {
        this.nombre = nombre;
        this.tipo_sangre = tipo_sangre;
        this.sexo = sexo;
        this.altura = altura;
        this.peso = peso;
        this.fecha_nacimiento = fecha_nacimiento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo_electronico = correo_electronico;
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

    public String getTipoSangre() {
        return tipo_sangre;
    }

    public void setTipoSangre(String tipo_sangre) {
        this.tipo_sangre = tipo_sangre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getFechaNacimiento() {
        return fecha_nacimiento;
    }

    public void setFechaNacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreoElectronico() {
        return correo_electronico;
    }

    public void setCorreoElectronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    @Override
    public String toString() {
        return "Paciente{" + "id=" + id + ", nombre=" + nombre + ", tipo_sangre=" + tipo_sangre + ", sexo=" + sexo + ", altura=" + altura + ", peso=" + peso + ", fecha_nacimiento=" + fecha_nacimiento + ", direccion=" + direccion + ", telefono=" + telefono + ", correo_electronico=" + correo_electronico + '}';
    }
    
    
    
}
