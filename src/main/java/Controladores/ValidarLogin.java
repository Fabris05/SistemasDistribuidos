/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controladores;

import Conexion.ConexionDB;
import Entidades.usuarios;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author fabri
 */
@WebServlet(name = "ValidarLogin", urlPatterns = {"/ValidarLogin"})
public class ValidarLogin extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        ConexionDB conexiondb=new ConexionDB();
        Connection conn=conexiondb.Connected();

        String user = request.getParameter("txtUsuario");
        String Pass = request.getParameter("txtPass");
        
        usuarios userOb=new usuarios(user, Pass);
        
        try{
            
            String sqlLogin="SELECT usuario, pass FROM Usuario WHERE usuario= ? and pass=?";
            
            PreparedStatement pstmt=conn.prepareStatement(sqlLogin);
            pstmt.setString(1, user);
            pstmt.setString(2, Pass);
            ResultSet rs=pstmt.executeQuery();
            
            if(rs.next()){
                String passDB=rs.getString("pass");
                
                if(userOb.getPass().equals(passDB)){
                    usuarios nuser = new usuarios(user, Pass);

                    // Obtener la sesión y guardar el objeto usuarios en ella
                    HttpSession session = request.getSession();
                    session.setAttribute("user", nuser);

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
