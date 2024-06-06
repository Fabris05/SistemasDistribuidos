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
    
    /**
     * Método que retorna lista de proveedores (id, proveedor)
     * @return lista
     */
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
    
    /**
     * Método que retorna lista de proveedores de la BD
     * @return list
     */
    @Override
    public List<Proveedor> findAll() {
        ConexionDB conexiondb=new ConexionDB();
        Connection conn=conexiondb.Connected();
        List<Proveedor> list= new ArrayList<Proveedor>();
        try{
            PreparedStatement pstm=conn.prepareStatement(BUSCAR_PROVEEDORES);
            ResultSet rs=pstm.executeQuery();
            while(rs.next()){
                Proveedor proveedor=new Proveedor();
                proveedor.setCodigoProveedor(rs.getString("CodigoProveedor"));
                proveedor.setRUCProveedor(rs.getString("RUC"));
                proveedor.setNombreProveedor(rs.getString("proveedor"));
                proveedor.setTelefonoProveedor(rs.getString("telefono"));
                proveedor.setEmailProveedor(rs.getString("email"));
                list.add(proveedor);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            conexiondb.Discconet();
        }
        return list;
    }
    
    /**
     * Método que registra proveedores en la BD
     * @param proveedor 
     */
    
    @Override
    public void registrarProveedor(Proveedor proveedor) {
        ConexionDB conexiondb=new ConexionDB();
        Connection conn=conexiondb.Connected();
        
        try{
            
            PreparedStatement psmt=conn.prepareStatement(AGREGAR_PROVEEDOR);
            psmt.setString(1, this.generarID());
            psmt.setString(2, proveedor.getRUCProveedor());
            psmt.setString(3, proveedor.getRazonSocialProveedor());
            psmt.setString(4, proveedor.getNombreProveedor());
            psmt.setString(5, proveedor.getTelefonoProveedor());
            psmt.setString(6, proveedor.getEmailProveedor());
            psmt.setString(7, proveedor.getUbicacionProveedor());
            psmt.setString(8, proveedor.getDescripcionProveedor());
            
            psmt.executeUpdate();
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            conexiondb.Discconet();
        }
    }
    
    /**
     * Método que elimina un proveedor
     * @param codigo 
     */
    @Override
    public void eliminarProveedor(String codigo) {
        ConexionDB conexiondb = new ConexionDB();
        Connection conn = conexiondb.Connected();
        try{
            PreparedStatement pstm=conn.prepareStatement(ELIMINAR_PROVEEDOR);
            pstm.setString(1, codigo);
            pstm.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            conexiondb.Discconet();
        }
    }
    
    @Override
    public String generarID() {
        ConexionDB conexiondb = new ConexionDB();
        Connection conn = conexiondb.Connected();
        String CodigoProveedor = "";
        String sql = "SELECT MAX(CAST(SUBSTRING(CodigoProveedor, 2) AS UNSIGNED)) AS MaxId FROM Proveedor";
        try {
            PreparedStatement psmt = conn.prepareStatement(sql);
            ResultSet rs = psmt.executeQuery();

            if (rs.next()) {
                int maxId = rs.getInt("MaxId");
                maxId++; // Incrementar el ID máximo en 1

                // Formatear el nuevo ID
                CodigoProveedor = String.format("R%05d", maxId);
            } else {
                // Si no hay registros en la tabla, el primer ID será C00001
                CodigoProveedor = "R00001";
            }

            return CodigoProveedor;

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            conexiondb.Discconet();
        }
        return CodigoProveedor;
    }
    
    /**
     * Método que busca un proveedor por su codigo
     * @param codigo
     * @return 
     */
    @Override
    public Proveedor findById(String codigo) {
        ConexionDB conexiondb = new ConexionDB();
        Connection conn = conexiondb.Connected();
        try{
            PreparedStatement pstm=conn.prepareStatement(BUSCAR_PROVEEDOR_CODIGO);
            pstm.setString(1, codigo);
            
            ResultSet rs=pstm.executeQuery();
            
            if(rs.next()){
                Proveedor proveedor=new Proveedor();
                proveedor.setCodigoProveedor(codigo);
                proveedor.setRUCProveedor(rs.getString("RUC"));
                proveedor.setRazonSocialProveedor(rs.getString("razonSocial"));
                proveedor.setNombreProveedor(rs.getString("proveedor"));
                proveedor.setTelefonoProveedor(rs.getString("telefono"));
                proveedor.setEmailProveedor(rs.getString("email"));
                proveedor.setUbicacionProveedor(rs.getString("ubicacion"));
                proveedor.setDescripcionProveedor(rs.getString("descripcion"));
                return proveedor;
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            conexiondb.Discconet();
        }
        return null;
    }
    
    
}
