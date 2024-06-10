/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Controladores.AlmacenSQLData;
import Controladores.CategoriaSQLData;
import Controladores.ProductoSQLData;
import Controladores.ProveedorSQLData;
import Entidades.Almacen;
import Entidades.Categoria;
import Entidades.Producto;
import Entidades.Proveedor;
import Interfaces.AlmacenData;
import Interfaces.CategoriaData;
import Interfaces.ProductoData;
import Interfaces.ProveedorData;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fabri
 */
public class ProductoServlet extends HttpServlet {

    private ProductoData productoData = new ProductoSQLData();
    private AlmacenData almacenData=new AlmacenSQLData();
    private CategoriaData categoriaData=new CategoriaSQLData();
    private ProveedorData proveedorData=new ProveedorSQLData();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        List<Producto> lista = productoData.findAll();
        //-- Almacenarlo en una variable
        request.setAttribute("listadoProductos", lista);
        request.getRequestDispatcher("/Producto_Listar.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idProducto=request.getParameter("codigoProducto");
        String action=request.getParameter("accionButton");
        
        switch (action){
            
            case "ver":
                Producto productoVer=productoData.findById(idProducto);
                System.out.println("ID del producto a ver: " + idProducto); // Imprime el ID del cliente
                System.out.println("accion: " + action); // Imprime el ID del cliente
                request.setAttribute("producto", productoVer);
                request.getRequestDispatcher("/Producto_Consultar.jsp").forward(request, response);
                
                break;
            case "editar":
                Producto productoEditar = productoData.findById(idProducto);
                
                List<Proveedor> listaProveedores = proveedorData.findProveedores();
                request.setAttribute("listadoProveedores", listaProveedores);

                List<Categoria> listaCategorias = categoriaData.findCategorias();
                request.setAttribute("listadoCategorias", listaCategorias);

                List<Almacen> listaAlmacen = almacenData.findAlmacenes();
                request.setAttribute("listadoAlmacenes", listaAlmacen);
                
                request.setAttribute("producto", productoEditar);
                request.getRequestDispatcher("/Views/Producto/Producto_Editar.jsp").forward(request, response);
//               response.sendRedirect("/SistemasDistribuidos/ProductoEditar");
                break;
            case "eliminar":
                productoData.Eliminar(idProducto);
                List<Producto> lista = productoData.findAll();
                request.setAttribute("listadoProductos", lista);
                request.getRequestDispatcher("/Producto_Listar.jsp").forward(request, response);
                break;
                
            default:
                break;
        }
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
