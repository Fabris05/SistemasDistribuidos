/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Controladores.CategoriaSQLData;
import Interfaces.CategoriaData;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fabri
 */
public class Categoria extends HttpServlet {
    
    CategoriaData categoriaData=new CategoriaSQLData();
    
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
        processRequest(request, response);
        
        String accionButton=request.getParameter("accionButton");
//        int idCategoria=Integer.parseInt(request.getParameter("codigoCategoria"));
        
        switch (accionButton) {
            case "agregar":
                try {
                    String categoriaForm = request.getParameter("txtCategoria");
                    String descripcionForm = request.getParameter("txaDescripcionCategoria");
                    String descripcionCategoria = (descripcionForm == null) ? "-" : descripcionForm;

                    Entidades.Categoria categoria = new Entidades.Categoria(categoriaForm, descripcionCategoria);
                    categoriaData.agregarCategoria(categoria);
                    response.sendRedirect(request.getContextPath() + "/Productos");
                    
                    //Agregar una alerta de categoria agregada
                } catch (Exception ex) {
                    ex.printStackTrace();
                    //Agregar una alerta de categoria eliminada
                }
                break;
            case "eliminar":
                try{
//                    categoriaData.eliminarCategoria(idCategoria);
//                    response.sendRedirect(request.getContextPath() + "/Productos");
                    //Agregar una alerta de categoria agregada
                }catch(Exception ex){
                    ex.printStackTrace();
                    //Agregar una alerta de categoria eliminada
                }
                break;
            default:
                throw new AssertionError();
        }
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
