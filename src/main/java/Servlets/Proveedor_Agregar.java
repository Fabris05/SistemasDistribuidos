
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
public class Proveedor_Agregar extends HttpServlet {
    
    ProveedorData proveedorData=new ProveedorSQLData();
 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/Views/Proveedor/Proveedor_Agregar.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ruc=request.getParameter("txtRUC");
                String razonSocial=request.getParameter("txtRazonSocial");
                String proveedorForm=request.getParameter("txtProveedor");
                String telefono=request.getParameter("txtTelefonoProveedor");
                String email=request.getParameter("txtEmailProveedor");
                String direccion=request.getParameter("txtDireccionProveedor");
                String descripciontxa= request.getParameter("txaDescripcionProveedor");
                String descripcion= (descripciontxa==null) ? "-" : descripciontxa;
                
                Proveedor proveedor=new Proveedor(ruc, razonSocial, proveedorForm, telefono, email, direccion, descripcion);
                proveedorData.registrarProveedor(proveedor);
               response.sendRedirect("/SistemasDistribuidos/Proveedores");
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
