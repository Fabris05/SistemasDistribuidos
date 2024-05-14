/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Controladores.ClienteSQLData;
import Entidades.Cliente;
import Interfaces.ClienteData;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fabri
 */
@WebServlet(name = "ClienteEditarServlet", urlPatterns = {"/ClienteEditarServlet"})
public class ClienteEditarServlet extends HttpServlet {

    private ClienteData clienteData = new ClienteSQLData();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/Cliente_Editar.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idCliente=request.getParameter("txtIdCliente");
        String nombreCliente = request.getParameter("txtNombreCliente");
        String apellidoCliente = request.getParameter("txtApellidoCliente");
        String tipoDocumentoCliente = request.getParameter("cbxTipoDocumentoCliente");
        String numDocumentoCLiente = request.getParameter("txtNumeroDocumentoCliente");
        String direccionCliente = request.getParameter("txtDireccionCliente");
        String telefonoCliente = request.getParameter("txtTelefonoCliente");
        String celularCliente = request.getParameter("txtCelularCliente");

        Cliente cliente = new Cliente(apellidoCliente, nombreCliente, direccionCliente, tipoDocumentoCliente, numDocumentoCLiente, telefonoCliente, celularCliente);

        clienteData.Editar(idCliente, cliente);

        request.getRequestDispatcher("/Cliente_Editar.jsp").forward(request, response);
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
