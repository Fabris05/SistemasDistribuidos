/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Controladores.AlmacenSQLData;
import Interfaces.AlmacenData;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fabri
 */
public class Almacen extends HttpServlet {
    
    AlmacenData almacenData=new AlmacenSQLData();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String almacenForm=request.getParameter("txtAlmacen");
        String ubicacionForm=request.getParameter("txtUbicacion");
        String ubicacion=(ubicacionForm==null) ? "-" : ubicacionForm;
        String descripcionForm=request.getParameter("txaDescripcionAlmacen");
        String descripcion=(descripcionForm==null) ? "-" : descripcionForm;
        
        Entidades.Almacen almacen = new Entidades.Almacen(almacenForm, ubicacion, descripcion);
        almacenData.agregarAlmacen(almacen);
        response.sendRedirect(request.getContextPath() + "/Productos");
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
