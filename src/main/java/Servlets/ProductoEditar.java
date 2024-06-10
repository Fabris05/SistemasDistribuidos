/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Controladores.ProductoSQLData;
import Entidades.Producto;
import Interfaces.ProductoData;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fabri
 */
public class ProductoEditar extends HttpServlet {
    
    ProductoData productoData=new ProductoSQLData();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/Views/Producto/Producto_Editar.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombreProducto=request.getParameter("txtNombreProducto");
        int cantidadProducto=Integer.parseInt(request.getParameter("txtCantidadProducto"));
        double precioProducto=Double.parseDouble(request.getParameter("txtPrecioProducto"));
        String caducidadProductoSTR=request.getParameter("txtFechaCaducidad");
        Date caducidadProducto=productoData.parseDate(caducidadProductoSTR);
        int idCategoria=Integer.parseInt(request.getParameter("cbxCategoriaProducto"));
        int idProveedor=Integer.parseInt(request.getParameter("cbxProveedorProducto"));
        int idAlmacen=Integer.parseInt(request.getParameter("cbxAlmacenProducto"));    
        String descripcionProducto=request.getParameter("txaDescripcionProducto");
        
        String codigoProducto=request.getParameter("txtCodigoProducto");
        Producto producto=new Producto(nombreProducto, cantidadProducto, precioProducto, caducidadProducto, idProveedor, idAlmacen,idCategoria, descripcionProducto);
        productoData.Editar(codigoProducto, producto);
        request.getRequestDispatcher("/Views/Producto/Producto_Editar.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
