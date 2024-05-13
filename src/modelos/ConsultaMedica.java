/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author 
 */
public class ConsultaMedica {
    private long id;
    private long id_paciente;
    private long id_medico;
    private String fecha;

    public ConsultaMedica(long id, long id_paciente, long id_medico, String fecha) {
        this.id = id;
        this.id_paciente = id_paciente;
        this.id_medico = id_medico;
        this.fecha = fecha;
    }

    public ConsultaMedica(long id_paciente, long id_medico, String fecha) {
        this.id_paciente = id_paciente;
        this.id_medico = id_medico;
        this.fecha = fecha;
    }
    
    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdPaciente() {
        return id_paciente;
    }

    public void setIdPaciente(long id_paciente) {
        this.id_paciente = id_paciente;
    }

    public long getIdMedico() {
        return id_medico;
    }

    public void setIdMedico(long id_medico) {
        this.id_medico = id_medico;
    }
    
    

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "ConsultaMedica{" + "id=" + id + ", id_paciente=" + id_paciente + ", id_medico=" + id_medico + ", fecha=" + fecha + '}';
    }
    
    
    
    
}
