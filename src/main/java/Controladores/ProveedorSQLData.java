/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Conexion.ConexionDB;
import Entidades.Proveedor;
import Interfaces.ProveedorData;
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
public class ProveedorSQLData implements ProveedorData{

    @Override
    public List<Proveedor> findProveedores() {
        ConexionDB conexiondb = new ConexionDB();
        Connection conn = conexiondb.Connected();
        List<Proveedor> lista=new ArrayList<Proveedor>();
        try{
            PreparedStatement pstm=conn.prepareStatement(BUSCAR_ID_NOMBRE_PROVEEDOR);
            ResultSet rs=pstm.executeQuery();
            
            while(rs.next()){
                Proveedor proveedor=new Proveedor();
                proveedor.setIdProveedor(rs.getInt("Id_Proveedor"));
                proveedor.setNombreProveedor(rs.getString("proveedor"));
                
                lista.add(proveedor);
                
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return lista;
    }
}
