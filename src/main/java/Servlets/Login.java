/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Conexion.ConexionDB;
import Controladores.ClienteSQLData;
import Controladores.UsuarioSQLData;
import Entidades.Usuario;
import Interfaces.UsuarioData;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author fabri
 */
public class Login extends HttpServlet {
    
    private UsuarioData usuarioData=new UsuarioSQLData();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        //Validacion del usuario en el Login y creacion de la session
        
        ConexionDB conexiondb=new ConexionDB();
        Connection conn=conexiondb.Connected();

        String user = request.getParameter("txtUsuario");
        String Pass = request.getParameter("txtPass");
        String passHash=usuarioData.hashPassword(Pass);
        
        
        try{
            
            String sqlLogin="SELECT usuario, pass, nivel, estado, nombre FROM Usuario WHERE usuario= ?;";
            
            PreparedStatement pstmt=conn.prepareStatement(sqlLogin);
            pstmt.setString(1, user);
            ResultSet rs=pstmt.executeQuery();
            System.out.println(passHash);
            if(rs.next()){
                String passDB=rs.getString("pass");
                String nivelUsuario=rs.getString("nivel");
                String estadoUsuario=rs.getString("estado");
                String nombreUsuario=rs.getString("nombre");
                
                if(passHash.equals(passDB) && estadoUsuario.equals("activo")){
                    Usuario nuser = new Usuario(user, nivelUsuario, nombreUsuario);

                    // Obtener la sesión y guardar el objeto usuarios en ella
                    HttpSession session = request.getSession();
                    session.setAttribute("user", nuser);
                    session.setMaxInactiveInterval(40);
                    
                    String usuario = ((Usuario) session.getAttribute("user")).getPass();
                    String nivel = ((Usuario) session.getAttribute("user")).getNivel();
                    System.out.println("Usuario: " + usuario);
                    System.out.println("Nivel: " + nivel);
                    // Redirigir a la página de inicio segura
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    
                }else{
                    System.err.println("ContraseñaIncorrecta");
                }
            }else{
                // Credenciales incorrectas, redirigir a una página de error o mostrar un mensaje de error
                request.getRequestDispatcher("ErrorLogin").forward(request, response);
            }
   
        }catch (Exception ex) {
            System.err.println(ex);
        }finally{
            conexiondb.Discconet();
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
