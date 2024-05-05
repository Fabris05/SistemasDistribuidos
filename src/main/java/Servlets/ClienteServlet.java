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
        request.getRequestDispatcher("/clientes.jsp").forward(request, response);
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
