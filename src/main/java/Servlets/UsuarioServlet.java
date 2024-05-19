/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Controladores.UsuarioSQLData;
import Entidades.Cliente;
import Entidades.Usuario;
import Interfaces.UsuarioData;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fabri
 */
public class UsuarioServlet extends HttpServlet {
    
    private UsuarioData usuarioData=new UsuarioSQLData();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Usuario> lista= usuarioData.findAll();
        request.setAttribute("listadoUsuarios", lista);
        request.getRequestDispatcher("/Usuario_Listar.jsp").forward(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        String idUsuario=request.getParameter("idUsuario");
        String action=request.getParameter("accionButton");
        int idUsuarioInt=Integer.parseInt(idUsuario);
        switch(action){
            case "ver":
                
                Usuario usuarioVer=usuarioData.findById(idUsuarioInt);
                System.out.println("El id del usuario es: "+idUsuario);
                request.setAttribute("usuario", usuarioVer);
                request.getRequestDispatcher("/Usuario_Consultar.jsp").forward(request, response);
                break;
            case "editar":

                Usuario usuarioEditar=usuarioData.findById(idUsuarioInt);
                System.out.println("ID del usuario a editar: " + idUsuarioInt); // Imprime el ID del cliente
                System.out.println("accion: " + action); // Imprime el ID del cliente
                request.setAttribute("usuario", usuarioEditar);
                request.getRequestDispatcher("/Usuario_Editar.jsp").forward(request, response);
                
                break;
            case "eliminar":
                usuarioData.Eliminar(idUsuarioInt);
                List<Usuario> lista = usuarioData.findAll();
                request.setAttribute("listadoUsuarios", lista);
                request.getRequestDispatcher("/Usuario_Listar.jsp").forward(request, response);
                break;
        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
