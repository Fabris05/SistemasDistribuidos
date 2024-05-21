/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author fabri
 */
public class ConexionDB {
    static String driver="com.mysql.jdbc.Driver";
//    static String url="jdbc:mysql://localhost:3306/bd_rest";
//    static String user="root";
//    static String pass="12345";
    static String urlAiven="jdbc:mysql://ferreteria-integrador-fabricioslazar0503-58fe.f.aivencloud.com:12142/bd_rest";
    static String userAiven="avnadmin";
    static String passAiven="AVNS_rWZcz8S1BKRPefCQLr-";
    
    
    protected Connection conn=null;
    public ConexionDB() {
            try{
            Class.forName(driver);
            conn= (Connection) DriverManager.getConnection(urlAiven,userAiven,passAiven);
            if(conn!=null){
                System.out.println("Conexión realizada..."+conn);
                //JOptionPane.showMessageDialog(null,"Conectado");
            }
         }catch(SQLException ex){
             System.out.println("Conexión fallida..."+ex.getMessage());
         }catch (ClassNotFoundException ex) {
            System.out.println("Falta Driver "+ex.getMessage());
        }       
    }
    public Connection Connected(){
        return conn;
    }
    public Connection Discconet(){    
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Error de desconexión.. "+ex.getMessage());
        }
        return null;
    }
}
