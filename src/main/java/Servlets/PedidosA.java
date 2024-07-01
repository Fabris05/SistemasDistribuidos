/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Controladores.ClienteSQLData;
import Controladores.PedidoSQLData;
import Controladores.ProductoSQLData;
import Entidades.Cliente;
import Entidades.Pedido;
import Entidades.Producto;
import Entidades.Usuario;
import Interfaces.ClienteData;
import Interfaces.PedidoData;
import Interfaces.ProductoData;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author fabri
 */
public class PedidosA extends HttpServlet {

    ClienteData clienteData = new ClienteSQLData();
    ProductoData productoData = new ProductoSQLData();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        request.getRequestDispatcher("/Views/Pedido/PedidoAñadir.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        BufferedReader reader = request.getReader();
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {sb.append(line);}
        
        String jsonString = sb.toString();

        JSONObject jsonObject = new JSONObject(jsonString);
        
        String actionJSON=jsonObject.getString("action");
        
        String action = (actionJSON==null) ? request.getParameter("action"):actionJSON;
        
        HttpSession session = request.getSession();
        switch (action) {
            case "buscarCliente":
                String tipoDocumento = jsonObject.getString("cbxTipoDocumento");
                String numDocumento = jsonObject.getString("txtNumDocumentoCliente");
                Cliente cliente = clienteData.findByDocumento(tipoDocumento, numDocumento);

                session.setAttribute("clienteActual", cliente);
                
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");

                if (isAjax(request)) {
                   if(cliente != null){
                       JSONObject clienteJson = new JSONObject();
                       clienteJson.put("nombre", cliente.getNombres());
                       clienteJson.put("apellido", cliente.getApellidos());
                       clienteJson.put("correoElectronico", cliente.getEmail());
                       response.getWriter().write(clienteJson.toString());
                   }else{
                       response.getWriter().write("{\"error\":\"Cliente no encontrado, verifica los datos\"}");
                   }
                } else {
                    request.getRequestDispatcher("/Views/Pedido/PedidoAñadir.jsp").forward(request, response);
                }
                break;
            case "buscarProducto":
                String codigoProducto = jsonObject.getString("txtcodigoProducto");
                Producto producto = productoData.findById(codigoProducto);
                request.setAttribute("producto", producto);
                if (isAjax(request)) {
                    if(producto != null){
                        JSONObject productoJson=new JSONObject();
                        productoJson.put("nombre", producto.getNombreProducto());
                        productoJson.put("stock", producto.getCantidadProducto());
                        productoJson.put("precio", producto.getPrecioProducto());
                        response.getWriter().write(productoJson.toString());
                        
                    }else{
                        response.getWriter().write("{\"error\":\"Producto no encontrado, verifica los datos\"}");
                    }
                } else {
                    request.getRequestDispatcher("/Views/Pedido/PedidoAñadir.jsp").forward(request, response);
                }
                break;
                
            case "finalizarPedido":
                // Se obtienen datos de la sesión
                Cliente clienteRecuperado = (Cliente) session.getAttribute("clienteActual");
                Usuario usuarioRecuperado = (Usuario) session.getAttribute("user");

                int idUsuario = Integer.parseInt(usuarioRecuperado.getIdUsuario());
                String idCliente = clienteRecuperado.getId();
                double precioParcial=Double.parseDouble(jsonObject.getString("txtPrecioParcialVenta"));
                double igv = Double.parseDouble(jsonObject.getString("txtIGV_Venta"));
                double precioFinal = Double.parseDouble(jsonObject.getString("txtPrecioFinalVenta"));


                JSONArray productosArray = jsonObject.getJSONArray("productos");

                List<Pedido> productosPedido = new ArrayList<>();
                for (int i = 0; i < productosArray.length(); i++) {
                    JSONObject productoJson = productosArray.getJSONObject(i);
                    Pedido productoPedido = new Pedido(
                            productoJson.getDouble("precioU"),
                            productoJson.getDouble("precioF"),
                            productoJson.getString("codigo"),
                            productoJson.getString("nombre"),
                            Integer.parseInt(productoJson.getString("cantidad"))
                    );
                    productosPedido.add(productoPedido);
                }
                Pedido pedido = new Pedido(idCliente, precioParcial, igv, precioFinal, idUsuario);
                PedidoSQLData pedidoData = new PedidoSQLData();
                pedidoData.agregarPedido(pedido, productosPedido, request);

                // Crear y enviar la respuesta JSON
                JSONObject jsonResponse = new JSONObject();
                jsonResponse.put("mensaje", "Venta finalizada con éxito");
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(jsonResponse.toString());

                break;
            default:
                throw new AssertionError("Unknown action: " + action);
        }
    }

    private boolean isAjax(HttpServletRequest request) {
        return "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    
}
