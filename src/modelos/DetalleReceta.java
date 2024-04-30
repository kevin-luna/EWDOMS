/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author kevin
 */
public class DetalleReceta {
    private long id_receta;
    private long id_medicamento;

    public DetalleReceta(long id_receta, long id_medicamento) {
        this.id_receta = id_receta;
        this.id_medicamento = id_medicamento;
    }

    public long getId_receta() {
        return id_receta;
    }

    public void setId_receta(long id_receta) {
        this.id_receta = id_receta;
    }

    public long getId_medicamento() {
        return id_medicamento;
    }

    public void setId_medicamento(long id_medicamento) {
        this.id_medicamento = id_medicamento;
    }
}
