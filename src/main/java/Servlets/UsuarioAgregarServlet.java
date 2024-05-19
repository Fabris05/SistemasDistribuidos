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
public class UsuarioAgregarServlet extends HttpServlet {

       private UsuarioData usuarioData=new UsuarioSQLData();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/Usuario_Agregar.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nombreUsuario=request.getParameter("txtNombreUsuario");
        String apellidoUsuario=request.getParameter("txtApellidoUsuario");
        String userUsuario=request.getParameter("txtUsuario");
        String cargoUsuario=request.getParameter("cbxCargoUsuario");
        String estadoUsuario=request.getParameter("cbxEstadoUsuario");
        String contraseñaUsuario=request.getParameter("txtpassUsuario");
        
        
        System.out.println("Nombre: " + nombreUsuario);
        System.out.println("Apellido: " + apellidoUsuario);
        System.out.println("Usuario: " + userUsuario);
        System.out.println("Cargo: " + cargoUsuario);
        System.out.println("Estado: " + estadoUsuario);
        System.out.println("Contraseña: " + contraseñaUsuario);
        
        String contraseñaHash=usuarioData.hashPassword(contraseñaUsuario);
       
        Usuario usuario=new Usuario(nombreUsuario, apellidoUsuario, userUsuario, contraseñaHash, cargoUsuario, estadoUsuario);
        
        usuarioData.agregarUsuario(usuario);
        
        request.getRequestDispatcher("/Usuario_Agregar.jsp").forward(request, response);
        
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
