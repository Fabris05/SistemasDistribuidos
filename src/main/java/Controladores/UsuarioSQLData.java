/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Conexion.ConexionDB;
import Entidades.Usuario;
import Interfaces.UsuarioData;
import java.net.http.HttpRequest;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author fabri
 */
public class UsuarioSQLData implements UsuarioData{

    @Override
    public List<Usuario> findAll() {
        ConexionDB conexiondb=new ConexionDB();
        Connection conn=conexiondb.Connected();
      List<Usuario> lista = new ArrayList<Usuario>();
      try {
          PreparedStatement pstmt = conn.prepareStatement("SELECT Id_Usuario, usuario, nombre, apellidos, estado FROM Usuario");
          ResultSet rs = pstmt.executeQuery();
          while (rs.next()) {
              Usuario usuario = new Usuario();
              usuario.setIdUsuario(rs.getString("Id_Usuario"));
              usuario.setUser(rs.getString("usuario"));
              usuario.setNombreUsuario(rs.getString("nombre"));
              usuario.setApellidoUsuario(rs.getString("apellidos"));
              usuario.setEstado(rs.getString("estado"));
              lista.add(usuario);
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

    @Override
    public String hashPassword(String pass) {
        MessageDigest md = null;

        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
            return null;
        }

        byte[] hash = md.digest(pass.getBytes(StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();

        for (byte b : hash) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    @Override
    public void agregarUsuario(Usuario usuario) {
        ConexionDB conexiondb = new ConexionDB();
        Connection conn = conexiondb.Connected();

        String sql = "INSERT INTO Usuario (nombre, apellidos, usuario, pass, nivel, estado) VALUES (?, ?, ?, ?, ?, ?);";

        try {
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1, usuario.getNombreUsuario());
            psmt.setString(2, usuario.getApellidoUsuario());
            psmt.setString(3, usuario.getUser());
            psmt.setString(4, usuario.getPass());
            psmt.setString(5, usuario.getNivel());
            psmt.setString(6, usuario.getEstado());  // Cambiado a 6 para el sexto parámetro

            psmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();  // Añadir manejo de excepciones para diagnosticar problemas
        } finally {
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
    public Usuario findById(int id) {
        ConexionDB conexiondb = new ConexionDB();
        Connection conn = conexiondb.Connected();
        
        try{
            PreparedStatement psmt=conn.prepareStatement(BUSCAR_USUARIO_ID);
            psmt.setInt(1, id);
            
            ResultSet rs=psmt.executeQuery();
            
            if(rs.next()){
                Usuario usuario=new Usuario();
                usuario.setIdUsuario(rs.getString("Id_Usuario"));
                usuario.setNombreUsuario(rs.getString("nombre"));
                usuario.setApellidoUsuario(rs.getString("apellidos"));
                usuario.setUser(rs.getString("usuario"));
                usuario.setPass(rs.getString("pass"));
                usuario.setNivel(rs.getString("nivel"));
                usuario.setEstado(rs.getString("estado"));
                
                return usuario;
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
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
    public void Eliminar(int Id) {
        ConexionDB conexiondb=new ConexionDB();
        Connection conn=conexiondb.Connected();
        
        try{
            PreparedStatement pstm=conn.prepareStatement(ELIMINAR_USUARIO_ID);
            pstm.setInt(1, Id);
            pstm.executeUpdate();
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
    }

    @Override
    public void Editar(int id, Usuario usuario) {
        ConexionDB conexiondb=new ConexionDB();
        Connection conn=conexiondb.Connected();
        
        try{
            PreparedStatement psmt=conn.prepareStatement(EDITAR_USUARIO_ID);
            psmt.setString(1, usuario.getNombreUsuario());
            psmt.setString(2, usuario.getApellidoUsuario());
            psmt.setString(3, usuario.getUser());
            psmt.setString(4, usuario.getPass());
            psmt.setString(5, usuario.getNivel());
            psmt.setString(6, usuario.getEstado());
            psmt.setInt(7, id);
            
            psmt.executeUpdate();
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
    }

    @Override
    public boolean autenticarUsuario(HttpServletRequest request, String user, String pass) {
        ConexionDB conexiondb = new ConexionDB();
        Connection conn = conexiondb.Connected(); 
        String passHash=this.hashPassword(pass);
        try{
            PreparedStatement pstm=conn.prepareStatement(VALIDAR_USUARIO);
            pstm.setString(1, user);
            ResultSet rs=pstm.executeQuery();
            
            if(rs.next()){
                
                String passDB=rs.getString("pass");
                String nivelUsuario=rs.getString("nivel");
                String estadoUsuario=rs.getString("estado");
                String nombreUsuario=rs.getString("nombre");
                
                if(passHash.equals(passDB) && estadoUsuario.equals("activo")){
                    
                    Usuario nuser = new Usuario(user, nivelUsuario, nombreUsuario);              
                    HttpSession session = request.getSession();
                    session.invalidate();
                    session = request.getSession(true);
                    session.setAttribute("user", nuser);
                    session.setMaxInactiveInterval(120);
                    return true;
                }
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            conexiondb.Discconet();
        }
        return false;
    }
    
}
