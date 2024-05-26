/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Controladores.AlmacenSQLData;
import Controladores.CategoriaSQLData;
import Controladores.ProductoSQLData;
import Controladores.ProveedorSQLData;
import Entidades.Categoria;
import Entidades.Producto;
import Entidades.Proveedor;
import Entidades.Almacen;
import Interfaces.AlmacenData;
import Interfaces.CategoriaData;
import Interfaces.ProductoData;
import Interfaces.ProveedorData;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fabri
 */
public class ProductoAgregarServlet extends HttpServlet {

    ProductoData productoData=new ProductoSQLData();
    ProveedorData proveedorData=new ProveedorSQLData();
    CategoriaData categoriaData=new CategoriaSQLData();
    AlmacenData almacenData=new AlmacenSQLData();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Extraemos parametros de proveedores y los mandamos al jsp
        List<Proveedor> listaProveedores = proveedorData.findProveedores();
        request.setAttribute("listadoProveedores", listaProveedores);
        
        //Extraemos parámetros de categorias y los mandamos al jsp
        List<Categoria> listaCategorias=categoriaData.findCategorias();
        request.setAttribute("listadoCategorias", listaCategorias);
        
        //Extraemos parámetros de almacen y los mandamos al jsp
        List<Almacen> listaAlmacen=almacenData.findAlmacenes();
        request.setAttribute("listadoAlmacenes", listaAlmacen);
        
        
        request.getRequestDispatcher("/Producto_Agregar.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        String NombreProducto=request.getParameter("txtNombreProducto");
        int cantidadProducto=Integer.parseInt(request.getParameter("txtCantidadProducto"));
        double precioProducto=Double.parseDouble(request.getParameter("txtPrecioProducto"));
        String caducidadProductoStr=request.getParameter("txtFechaCaducidad");
        int idCategoriaProducto=Integer.parseInt(request.getParameter("cbxCategoriaProducto"));
        int idProveedorProducto=Integer.parseInt(request.getParameter("cbxProveedorProducto"));
        int idAlmacenProducto=Integer.parseInt(request.getParameter("cbxAlmacenProducto"));
        String descripcionProducto=request.getParameter("txaDescripcionProducto");
        
        Date caducidadProducto=productoData.parseDate(caducidadProductoStr);
        String codigoProducto=productoData.generarID();
        
        Producto producto=new Producto(codigoProducto, NombreProducto, cantidadProducto, precioProducto, caducidadProducto, idProveedorProducto, idAlmacenProducto, idCategoriaProducto, descripcionProducto);
        
        productoData.agregarProducto(producto);
        request.getRequestDispatcher("/Producto_Agregar.jsp").forward(request, response);
        
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
