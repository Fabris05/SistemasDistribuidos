/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Controladores.ProductoSQLData;
import Entidades.Producto;
import Interfaces.ProductoData;
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
//                Cliente clienteEditar=clienteData.findById(idCliente);
//                System.out.println("ID del cliente a editar: " + idCliente); // Imprime el ID del cliente
//                System.out.println("accion: " + action); // Imprime el ID del cliente
//                request.setAttribute("cliente", clienteEditar);
//                request.getRequestDispatcher("/Cliente_Editar.jsp").forward(request, response);
                
//               request.getRequestDispatcher("/Cliente_Editar.jsp").forward(request, response);
                break;
            case "eliminar":
                
                // -- Lógica de Eliminar
                
                productoData.Eliminar(idProducto);
//                
                //-- Refrescar nuevamente la lista (ya no debe aparecer el elemento eliminado)
                List<Producto> lista = productoData.findAll();
                //-- Almacenarlo en una variable
                request.setAttribute("listadoProductos", lista);
                //-- Invocar al JSP que pintara los datos de la variable
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
