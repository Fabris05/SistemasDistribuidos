<%-- 
    Document   : clientes
    Created on : 5 may. 2024, 01:57:03
    Author     : fabri
--%>

<%@page import="java.util.List"%>
<%@page import="Entidades.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="../Templates/header.jsp"%>
        
        <div class=" d-flex container justify-content-center">
            <div class="col-11 mt-4">
                
                <table class="table table-striped text-center">
                    <td>ID Cliente</td>
                    <td>Nombres</td>
                    <td>Apellidos</td>
                    <td>Dirección</td>
                    <td>DNI</td>
                    <td>Telefono</td>
                    <td>Movil</td>
                    <td>Acciones</td>

                    <%
                        List<Cliente> lista = (List<Cliente>) request.getAttribute("listadoClientes");
                        if (lista != null) {
                            for (Cliente c : lista) {
                    %>
                    <tr>
                        <td><%= c.getId()%></td>
                        <td><%= c.getNombres()%></td>
                        <td><%= c.getApellidos()%></td>
                        <td><%= c.getDireccion()%></td>
                        <td><%= c.getDNI()%></td>
                        <td><%= c.getTelefono()%></td>
                        <td><%= c.getMovil()%></td>
                        <td>
                            <button type="submit" class="btn btn-outline-primary bi-view" onclick="ejecutarAccionConParams('ver', <%= c.getId()%>);">&nbsp;Ver</button>&nbsp;
                            <button type="submit" class="btn btn-outline-primary bi-edit" onclick="ejecutarAccionConParams('editar', <%= c.getId()%>);">&nbsp;Editar</button>&nbsp;
                            <button type="submit" class="btn btn-outline-primary bi-delete" 
                                    onclick="if (confirm('¿Está seguro de eliminar este registro')) { ejecutarAccionConParams('eliminar', <%= c.getId()%>); } else { return false; }">&nbsp;Eliminar</button>
                        </td>
                    </tr>
                    <%
                            }
                        }
                    %>
                </table>

            </div>
        </div>
   
    </body>
</html>
