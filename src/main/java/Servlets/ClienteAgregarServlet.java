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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fabri
 */
public class ClienteAgregarServlet extends HttpServlet {

    private ClienteData clienteDATA=new ClienteSQLData();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.getRequestDispatcher("/Cliente_Agregar.jsp").forward(request, response);
        
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String id_Cliente=request.getParameter("txtIdCliente");
        String nombreCliente=request.getParameter("txtNombreCliente");
        String apellidoCliente=request.getParameter("txtApellidoCliente");
        String tipoDocumentoCliente=request.getParameter("cbxTipoDocumentoCliente");
        String numDocumentoCLiente=request.getParameter("txtNumeroDocumentoCliente");
        String direccionCliente=request.getParameter("txtDireccionCliente");
        String telefonoCliente=request.getParameter("txtTelefonoCliente");
        String celularCliente=request.getParameter("txtCelularCliente");
        
        String idClienteGenerado = clienteDATA.generarID();
        System.out.println(idClienteGenerado);
        Cliente cliente = new Cliente(idClienteGenerado, apellidoCliente, nombreCliente, direccionCliente, tipoDocumentoCliente, numDocumentoCLiente, telefonoCliente, celularCliente);
        
        clienteDATA.Guardar(cliente);

        // Redireccionar a una página de éxito o mostrar un mensaje de éxito en la misma página
        request.setAttribute("guardadoExitoso", true);
        
        request.getRequestDispatcher("/Cliente_Agregar.jsp").forward(request, response);
        
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
