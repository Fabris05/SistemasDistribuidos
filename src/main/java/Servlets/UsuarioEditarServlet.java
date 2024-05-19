/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Controladores.UsuarioSQLData;
import Entidades.Usuario;
import Interfaces.UsuarioData;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fabri
 */
public class UsuarioEditarServlet extends HttpServlet {
    
    UsuarioData usuarioData=new UsuarioSQLData();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        request.getRequestDispatcher("/Usuario_Editar.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idUsuario=request.getParameter("txtId");
        System.out.println(idUsuario);
        int idUsuarioInt=Integer.parseInt(idUsuario);
        
        String nombreUsuario=request.getParameter("txtNombreUsuario");
        String apellidosUsuario=request.getParameter("txtApellidoUsuario");
        String cargoUsuario=request.getParameter("cbxCargoUsuario");
        String estadoUsuario=request.getParameter("cbxEstadoUsuario");
        String userUsuario=request.getParameter("txtUsuario");
        String passUsuario=request.getParameter("txtPassUsuario");
       
        
        Usuario usuario = new Usuario(nombreUsuario, apellidosUsuario, userUsuario, passUsuario, cargoUsuario, estadoUsuario);
        usuarioData.Editar(idUsuarioInt, usuario);
        request.getRequestDispatcher("/Usuario_Editar.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
