/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.ArrayList;

/**
 *
 * @author kevin
 */
public interface DAO<K,T> {
    
    public T consultar(K id);
    public ArrayList<T> consultar();
    public long insertar(T objeto);
    public boolean eliminar(K id);
    public boolean actualizar(K id,T objeto);
}
