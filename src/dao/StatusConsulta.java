/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author kevin
 */
public class StatusConsulta {
    private int codigo;
    private String mensaje;
    public static StatusConsulta ERROR_SQL = new StatusConsulta(1, "Ocurrió un error al comunicarse con el servidor.");
    public static StatusConsulta ERROR_OPERACION = new StatusConsulta(1, "No ha sido posible ejecutar la operacion.");

    public StatusConsulta(int status, String mensaje) {
        this.codigo = status;
        this.mensaje = mensaje;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int status) {
        this.codigo = status;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
}
