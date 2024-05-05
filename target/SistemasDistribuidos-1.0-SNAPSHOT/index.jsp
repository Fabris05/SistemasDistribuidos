<%-- 
    Document   : index
    Created on : 4 may. 2024, 14:22:23
    Author     : fabri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%  response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");  
            if (session.getAttribute("user")==null){
                response.sendRedirect("login.jsp");
            }
        %>
         
        <%@include file="../Templates/header.jsp"%>
        <!--
        <h1>Menú Principal</h1>
        <form action="ValidarLogin" method="GET">  
            <p><a href="ClienteServlet">Clientes</a></p>
            <p><a href="Productos.jsp">Producto</a></p>
            <p><a href="Pedidos.jsp">Pedidos</a></p>
            <p><a href="CerrarSesion">Cerrar Sesión</a></p>
        </form>
        -->
    </body>
</html>
