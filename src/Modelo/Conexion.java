/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author bryanbautista
 */
public class Conexion {
    Connection conexion=null;
    String url="jdbc:postgresql://localhost:5433/PRO_NIÑERAS";
    String usuario="postgres";
    String contra = "usuario";
    
    
    public Conexion() {
        try{
            Class.forName("org.postgresql.Driver");
            conexion = DriverManager.getConnection(url,usuario,contra);  
                 
        }catch(Exception e){JOptionPane.showMessageDialog(null, "Conexion fallida");}
    }
    
    public Connection getConexion() {
        return conexion;
    }
   
    public void cerrar(){
        try{
            conexion.close();
            JOptionPane.showMessageDialog(null, "Desconectado");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Desconexion fallida ");
        }
    }
}
