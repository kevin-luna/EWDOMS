/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author kevin
 */
public class Receta {
    private long id;
    private long id_consulta;
    private String diagnostico;
    private String sintomas;
    private String recomendaciones;

    public Receta(long id, long id_consulta, String diagnostico, String sintomas, String recomendaciones) {
        this.id = id;
        this.id_consulta = id_consulta;
        this.diagnostico = diagnostico;
        this.sintomas = sintomas;
        this.recomendaciones = recomendaciones;
    }

    public Receta(long id_consulta, String diagnostico, String sintomas, String recomendaciones) {
        this.id_consulta = id_consulta;
        this.diagnostico = diagnostico;
        this.sintomas = sintomas;
        this.recomendaciones = recomendaciones;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId_consulta() {
        return id_consulta;
    }

    public void setId_consulta(long id_consulta) {
        this.id_consulta = id_consulta;
    }
    
    
    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public String getRecomendaciones() {
        return recomendaciones;
    }

    public void setRecomendaciones(String recomendaciones) {
        this.recomendaciones = recomendaciones;
    }
    
    
}
