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
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = request.getParameter("txtUsuario");
        String Pass = request.getParameter("txtPass");
        
        try{
          boolean access=usuarioData.autenticarUsuario(request, user, Pass);
          
          if(access==true){
              response.sendRedirect(request.getContextPath() + "/index.jsp"); //Redirige al index por mientras
          }else{
              request.setAttribute("mensajeError", "Usuario o contraseña incorrectos");
              request.getRequestDispatcher("/login.jsp").forward(request, response);
          }
        }catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
