/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Entidades.Cliente;
import Interfaces.ClienteData;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Controladores.ClienteSQLData;

/**
 *
 * @author fabri
 */
public class ClienteServlet extends HttpServlet {

    private ClienteData clienteData = new ClienteSQLData();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //-- Obtener los datos de los clientes
        List<Cliente> lista = clienteData.findAll();
        //-- Almacenarlo en una variable
        request.setAttribute("listadoClientes", lista);
        //-- Invocar al JSP que pintara los datos de la variable
        request.getRequestDispatcher("/Cliente_Listar.jsp").forward(request, response);
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String idCliente=request.getParameter("idCliente");
        String action=request.getParameter("accionButton");
        
        switch (action){
            
            case "ver":
                Cliente clienteVer=clienteData.findById(idCliente);
                System.out.println("ID del cliente a ver: " + idCliente); // Imprime el ID del cliente
                System.out.println("accion: " + action); // Imprime el ID del cliente
                request.setAttribute("cliente", clienteVer);
                request.getRequestDispatcher("/Cliente_Consultar.jsp").forward(request, response);
                
                break;
            case "editar":
                Cliente clienteEditar=clienteData.findById(idCliente);
                System.out.println("ID del cliente a editar: " + idCliente); // Imprime el ID del cliente
                System.out.println("accion: " + action); // Imprime el ID del cliente
                request.setAttribute("cliente", clienteEditar);
                request.getRequestDispatcher("/Cliente_Editar.jsp").forward(request, response);
                
//               request.getRequestDispatcher("/Cliente_Editar.jsp").forward(request, response);
                break;
            case "eliminar":
                
                // -- Lógica de Eliminar
                
                clienteData.Eliminar(idCliente);
                
                System.out.println("ID del cliente a eliminar: " + idCliente); // Imprime el ID del cliente
                System.out.println("accion: " + action); // Imprime el ID del cliente
                
                //-- Refrescar nuevamente la lista (ya no debe aparecer el elemento eliminado)
                List<Cliente> lista = clienteData.findAll();
                //-- Almacenarlo en una variable
                request.setAttribute("listadoClientes", lista);
                //-- Invocar al JSP que pintara los datos de la variable
                request.getRequestDispatcher("/Cliente_Listar.jsp").forward(request, response);
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
