/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Controladores.ProveedorSQLData;
import Entidades.Proveedor;
import Interfaces.ProveedorData;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fabri
 */
@WebServlet(name = "Proveedores", urlPatterns = {"/Proveedores"})
public class Proveedores extends HttpServlet {

    ProveedorData proveedorData=new ProveedorSQLData();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Proveedor> listProvedor=proveedorData.findAll();
        
        request.setAttribute("listadoProveedores", listProvedor);
        
        request.getRequestDispatcher("Views/Proveedor/Proveedor_Listar.jsp").forward(request, response);
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action=request.getParameter("accionButton");
        String codigoProveedor=request.getParameter("codigoProveedor");
        switch (action) {
            case "ver":
                Proveedor proveedor=proveedorData.findById(codigoProveedor);
                request.setAttribute("proveedor", proveedor);
                request.getRequestDispatcher("/Views/Proveedor/Proveedor_Consultar.jsp").forward(request, response);
                break;
            case "editar":
                Proveedor proveedorEditar=proveedorData.findById(codigoProveedor);
                request.setAttribute("proveedor", proveedorEditar);
                request.getRequestDispatcher("/Views/Proveedor/Proveedor_Editar.jsp").forward(request, response);
                break;
                
            case "eliminar":
                proveedorData.eliminarProveedor(codigoProveedor);
                List<Proveedor> listProvedor = proveedorData.findAll();
                request.setAttribute("listadoProveedores", listProvedor);
                request.getRequestDispatcher("Views/Proveedor/Proveedor_Listar.jsp").forward(request, response);
                break;
            default:
                throw new AssertionError();
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
