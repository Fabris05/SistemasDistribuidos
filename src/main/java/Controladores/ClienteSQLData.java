/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Conexion.ConexionDB;
import Entidades.Cliente;
import Interfaces.ClienteData;
import com.mysql.cj.protocol.Resultset;
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
public class ClienteSQLData implements ClienteData {

    @Override
    public List<Cliente> findAll() {
        ConexionDB conexiondb=new ConexionDB();
        Connection conn=conexiondb.Connected();
      List<Cliente> lista = new ArrayList<Cliente>();
      try {
          PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM Cliente");
          ResultSet rs = pstmt.executeQuery();
          while (rs.next()) {
              Cliente cliente = new Cliente();
              cliente.setId(rs.getString("Id_Cliente"));
              cliente.setApellidos(rs.getString("Apellidos"));
              cliente.setNombres(rs.getString("Nombres"));
              cliente.setDireccion(rs.getString("Direccion"));
              cliente.setTipoDocumento(rs.getString("TipoDocumento"));
              cliente.setNumeroDocumento(rs.getString("numeroDocumento"));
              cliente.setTelefono(rs.getString("Telefono"));
              cliente.setMovil(rs.getString("Movil"));
              lista.add(cliente);
          }
      } catch (Exception ex) {
          ex.printStackTrace();
      } finally {
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

    // Guardar Cliente en la base de datos
    
    @Override
    public void Guardar(Cliente cliente) {
        ConexionDB conexiondb=new ConexionDB();
        Connection conn=conexiondb.Connected();
        
        try{
            String urlInsert="INSERT INTO Cliente (Id_Cliente, Apellidos, Nombres, Direccion, TipoDocumento, numeroDocumento, Telefono, Movil)"
                    + " VALUES (?,?,?,?,?,?,?, ?)";
            PreparedStatement pstm=conn.prepareStatement(urlInsert);
            String Id_Cliente=generarID();
            pstm.setString(1, Id_Cliente);
            pstm.setString(2, cliente.getApellidos());
            pstm.setString(3, cliente.getNombres());
            pstm.setString(4, cliente.getDireccion());
            pstm.setString(5, cliente.getTipoDocumento());
            pstm.setString(6, cliente.getNumeroDocumento());
            pstm.setString(7, cliente.getTelefono());
            pstm.setString(8, cliente.getMovil());
            
            pstm.executeUpdate();
            System.out.println("Exitoso");
        }catch (SQLException ex) {
            System.err.print(ex);
        }finally {
          try {
              if (conn != null) {
                  conexiondb.Discconet();
              }
          } catch (Exception ex1) {
              ex1.printStackTrace();
          }
      }   
    }

    @Override
    public void Eliminar(String Id) {
        ConexionDB conexiondb=new ConexionDB();
        Connection conn=conexiondb.Connected();
        
        try{
            String sql="DELETE FROM Cliente WHERE Id_CLiente=?";
            PreparedStatement pstm=conn.prepareStatement(sql);
            
            pstm.setString(1, Id);
            pstm.executeUpdate();
        }catch(Exception ex){
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
        
        
    }

    @Override
    public String generarID() {
        ConexionDB conexiondb = new ConexionDB();
        Connection conn = conexiondb.Connected();
        String Id_Cliente = "";
        String sql = "SELECT MAX(CAST(SUBSTRING(Id_Cliente, 2) AS UNSIGNED)) AS MaxId FROM Cliente";
        try {
            PreparedStatement psmt = conn.prepareStatement(sql);
            ResultSet rs = psmt.executeQuery();

            if (rs.next()) {
                int maxId = rs.getInt("MaxId");
                maxId++; // Incrementar el ID máximo en 1

                // Formatear el nuevo ID
                Id_Cliente = String.format("C%05d", maxId);
            } else {
                // Si no hay registros en la tabla, el primer ID será C00001
                Id_Cliente = "C00001";
            }

            return Id_Cliente;

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            conexiondb.Discconet();
        }
        return Id_Cliente;
    }

    @Override
    public Cliente findById(String id) {
        ConexionDB conexiondb = new ConexionDB();
        Connection conn = conexiondb.Connected();
        
        try{
            String sql=("SELECT * FROM Cliente WHERE Id_Cliente=?");
            PreparedStatement psmt=conn.prepareStatement(sql);
            psmt.setString(1, id);
            
            ResultSet rs=psmt.executeQuery();
            
            if(rs.next()){
                Cliente cliente=new Cliente();
                cliente.setId(id);
                cliente.setNombres(rs.getString("Nombres"));
                cliente.setApellidos(rs.getString("Apellidos"));
                cliente.setTipoDocumento(rs.getString("TipoDocumento"));
                cliente.setNumeroDocumento(rs.getString("numeroDocumento"));
                cliente.setDireccion(rs.getString("Direccion"));
                cliente.setTelefono(rs.getString("Telefono"));
                cliente.setMovil(rs.getString("Movil"));
                
                return cliente;
            }
            
        }catch(Exception ex){
            System.err.println(ex);
        }finally{
            conexiondb.Discconet();
        }
        return null;
    }

    @Override
    public void Editar(String id, Cliente cliente) {
        ConexionDB conexiondb = new ConexionDB();
        Connection conn = conexiondb.Connected();
        
        try{
            
            String sql="UPDATE Cliente SET Apellidos=?, Nombres=?, Direccion=?, "
                    + "TipoDocumento=?, numeroDocumento=?, Telefono=?, Movil=? WHERE Id_CLiente=?";
            
            PreparedStatement psmt=conn.prepareStatement(sql);
            psmt.setString(1, cliente.getApellidos());
            psmt.setString(2, cliente.getNombres());
            psmt.setString(3, cliente.getDireccion());
            psmt.setString(4, cliente.getTipoDocumento());
            psmt.setString(5, cliente.getNumeroDocumento());
            psmt.setString(6, cliente.getTelefono());
            psmt.setString(7, cliente.getMovil());
            psmt.setString(8, id);
            
            psmt.executeUpdate();
            
        }catch(SQLException ex){
            System.err.println(ex);
        }finally{
            conexiondb.Discconet();
        }
        
        
    }
}
