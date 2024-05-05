/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Conexion.ConexionDB;
import Entidades.Cliente;
import Interfaces.ClienteData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
              cliente.setDNI(rs.getString("DNI"));
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
    
}
