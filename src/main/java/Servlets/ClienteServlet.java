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
import java.util.ArrayList;

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
                request.setAttribute("cliente", clienteVer);
                request.getRequestDispatcher("/Cliente_Consultar.jsp").forward(request, response);
                break;
            case "editar":
                
                Cliente clienteEditar=clienteData.findById(idCliente);
                request.setAttribute("cliente", clienteEditar);
                request.getRequestDispatcher("/Cliente_Editar.jsp").forward(request, response);
                break;
                
            case "eliminar":

                clienteData.Eliminar(idCliente);
                List<Cliente> lista = clienteData.findAll();
                request.setAttribute("listadoClientes", lista);
                request.getRequestDispatcher("/Cliente_Listar.jsp").forward(request, response);
                break;
            case "buscar":
                String tipoDocumento=request.getParameter("cbxTipoDocumento");
                String numDocumento=request.getParameter("txtNumDocumento");
                
                Cliente cliente=clienteData.findByDocumento(tipoDocumento, numDocumento);
                
                if(cliente!=null){
                    List<Cliente> listadoClientes = new ArrayList<>();
                    listadoClientes.add(cliente);
                    request.setAttribute("listadoClientes", listadoClientes);
                    request.getRequestDispatcher("/Cliente_Listar.jsp").forward(request, response);
                }else{
                    request.setAttribute("mensajeError", "Cliente no encontrado");
                    List<Cliente> listaC = clienteData.findAll();
                    request.setAttribute("listadoClientes", listaC);
                    request.getRequestDispatcher("/Cliente_Listar.jsp").forward(request, response);
                }
                break;
            case "refrescar":
                response.sendRedirect(request.getContextPath() + "/Clientes");
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
