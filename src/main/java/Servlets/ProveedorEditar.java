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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fabri
 */
public class ProveedorEditar extends HttpServlet {
    
    ProveedorData proveedorData=new ProveedorSQLData();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/Views/Proveedor/Proveedor_Editar.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String rucProveedor=request.getParameter("txtRUC");
        String razonProveedor=request.getParameter("txtRazonSocial");
        String nombreProveedor=request.getParameter("txtProveedor");
        String telefonoProveedor=request.getParameter("txtTelefonoProveedor");
        String emailProveedor=request.getParameter("txtEmailProveedor");
        String ubicacionProveedor=request.getParameter("txtDireccionProveedor");
        String descripcion=request.getParameter("txaDescripcionProveedor");
        String descripcionProveedor=(descripcion==null) ? "-" : descripcion;
        
        String codigoProveedor=request.getParameter("txtCodigoProveedor");
        
        Proveedor proveedor=new Proveedor(rucProveedor, razonProveedor, nombreProveedor, telefonoProveedor, emailProveedor, ubicacionProveedor, descripcionProveedor);
        
        proveedorData.editarProveedor(codigoProveedor, proveedor);
        
        request.getRequestDispatcher("/Views/Proveedor/Proveedor_Editar.jsp").forward(request, response);
        
    }

 
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
