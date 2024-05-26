/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Conexion.ConexionDB;
import Entidades.Almacen;
import Interfaces.AlmacenData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fabri
 */
public class AlmacenSQLData implements AlmacenData{

    @Override
    public List<Almacen> findAlmacenes() {
        ConexionDB conexiondb=new ConexionDB();
        Connection conn=conexiondb.Connected();
        List<Almacen> list=new ArrayList<Almacen>();
        try{
            PreparedStatement pstm=conn.prepareStatement(BUSCAR_ID_NOMBRE_ALMACEN);
            ResultSet rs=pstm.executeQuery();
            
            while(rs.next()){
                Almacen almacen =new Almacen();
                
                almacen.setIdAlmacen(rs.getInt("idAlmacen"));
                almacen.setAlmacen(rs.getString("almacen"));
                
                list.add(almacen);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return list;
    }
    
}
