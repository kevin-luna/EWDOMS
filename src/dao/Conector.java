/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author kevin
 */
public class Conector {
    private static final String bd = "consultorio_medico";
    private static final String usuario = "root";
    private static final String password = "root";
    private static final String host = "localhost";
    private static final String puerto = "3306";
    private static String url;
    private Connection conexion;
    
    public Conector(){
        url = "jdbc:mysql://"+host+":"+puerto+"/"+bd;
    }
    
    public Connection iniciar(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url,usuario,password);
            return conexion;
        }catch (SQLException | ClassNotFoundException ex){
            return null;
        }
    }
    
    public boolean terminar(){
        try{
            conexion.close();
            return true;
        }catch(SQLException ex){
            return false;
        }
    }
}
