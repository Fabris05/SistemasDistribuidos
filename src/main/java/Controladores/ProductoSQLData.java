/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Conexion.ConexionDB;
import Entidades.Producto;
import Interfaces.ProductoData;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fabri
 */
public class ProductoSQLData implements ProductoData{
    
    /**
     * Funcion que busca ciertos datos de productos
     * @return lista
     */
    @Override
    public List<Producto> findAll() {
        ConexionDB conexiondb=new ConexionDB();
        Connection conn=conexiondb.Connected();
        List<Producto> lista=new ArrayList<Producto>();
        try{
            PreparedStatement psmt=conn.prepareStatement(BUSCAR_PRODUCTOS_TABLA);
            ResultSet rs=psmt.executeQuery();
            while(rs.next()){
                Producto producto=new Producto();
                producto.setCodigoProducto(rs.getString("CodigoProducto"));
                producto.setNombreProducto(rs.getString("nombreProducto"));
                producto.setPrecioProducto(rs.getDouble("precioProducto"));
                producto.setCantidadProducto(rs.getInt("cantidadProducto"));
                producto.setCaducidadProducto(rs.getDate("caducidadProducto"));
                lista.add(producto);
                
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try {
              if (conn != null) {
                  conexiondb.Discconet();
              }
          } catch (Exception ex1) {
              ex1.printStackTrace();
          }
        }
        return lista;
    }

    @Override
    public Producto findById(String id) {
        ConexionDB conexiondb=new ConexionDB();
        Connection conn=conexiondb.Connected();
        
        try{
            PreparedStatement psmt=conn.prepareStatement(BUSCAR_PRODUCTOS_ID);
            psmt.setString(1, id);
            
            ResultSet rs=psmt.executeQuery();
            
            if(rs.next()){
                Producto producto=new Producto();
                producto.setCodigoProducto(rs.getString("CodigoProducto"));
                producto.setNombreProducto(rs.getString("nombreProducto"));
                producto.setCantidadProducto(rs.getInt("cantidadProducto"));
                producto.setPrecioProducto(rs.getDouble("precioProducto"));
                producto.setCaducidadProducto(rs.getDate("caducidadProducto"));
                producto.setProveedorProducto(rs.getString("Proveedor"));
                producto.setCategoriaProducto(rs.getString("Categoria"));
                producto.setAlmacenProducto(rs.getString("Almacen"));
                producto.setDescripcionProducto(rs.getString("descripcionProducto"));
                return producto;
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try {
                if (conn != null) {
                    conexiondb.Discconet();  // Corrección del nombre del método a "Disconnect"
                }
            } catch (Exception ex1) {
                ex1.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public void agregarProducto(Producto producto) {
        ConexionDB conexiondb = new ConexionDB();
        Connection conn = conexiondb.Connected();
        
        try{
            PreparedStatement pstm=conn.prepareStatement(AGREGAR_PRODUCTO);
            pstm.setString(1, producto.getCodigoProducto());
            pstm.setString(2, producto.getNombreProducto());
            pstm.setInt(3, producto.getCantidadProducto());
            pstm.setDouble(4, producto.getPrecioProducto());
            pstm.setDate(5, producto.getCaducidadProducto());
            pstm.setInt(6, producto.getIdProveedorProducto());
            pstm.setInt(7, producto.getIdCategoriaProducto());
            pstm.setInt(8, producto.getIdAlmacenProducto());
            pstm.setString(9, producto.getDescripcionProducto());
            pstm.executeUpdate();
            System.out.println("Exitoso registro Producto");
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try {
                if (conn != null) {
                    conexiondb.Discconet();  // Corrección del nombre del método a "Disconnect"
                }
            } catch (Exception ex1) {
                ex1.printStackTrace();
            }
        }
    }

    @Override
    public void Editar(String id, Producto producto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void Eliminar(String Id) {
        ConexionDB conexiondb = new ConexionDB();
        Connection conn = conexiondb.Connected();
        
        try{
            PreparedStatement pstm=conn.prepareStatement(ELIMINAR_PRODUCTO);
            pstm.setString(1, Id);
            
            pstm.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try {
                if (conn != null) {
                    conexiondb.Discconet();  // Corrección del nombre del método a "Disconnect"
                }
            } catch (Exception ex1) {
                ex1.printStackTrace();
            }
        }
    }

    @Override
    public String generarID() {
        ConexionDB conexiondb = new ConexionDB();
        Connection conn = conexiondb.Connected();
        String codigoProducto = "";
        try {
            PreparedStatement psmt = conn.prepareStatement(BUSCAR_MAXIMO_CODIGO);
            ResultSet rs = psmt.executeQuery();

            if (rs.next()) {
                int maxCode = rs.getInt("MaxCode");
                maxCode++; // Incrementar el ID máximo en 1

                // Formatear el nuevo ID
                codigoProducto = String.format("P%05d", maxCode);
            } else {
                // Si no hay registros en la tabla, el primer ID será C00001
                codigoProducto = "P00001";
            }

            return codigoProducto;

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            conexiondb.Discconet();
        }
        return codigoProducto;
    }

    @Override
    public Date parseDate(String date) {
        Date caducidadProducto=null;
        try {
            // El formato debe coincidir con el formato del input date
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date parsedDate = dateFormat.parse(date);
            caducidadProducto = new java.sql.Date(parsedDate.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return caducidadProducto;
    }
    
}
