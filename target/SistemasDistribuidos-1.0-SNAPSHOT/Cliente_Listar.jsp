<%-- 
    Document   : clientes
    Created on : 5 may. 2024, 01:57:03
    Author     : fabri
--%>

<%@page import="java.util.List"%>
<%@page import="Entidades.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <title>JMis Clientes</title>
            
        <script type="text/javascript">
            function ejecutarAccionConParams(idCliente, accionButton ) {
                document.getElementById("accionButton").value = accionButton;
                document.getElementById("idCliente").value = idCliente;
                
                document.getElementById("frm").submit();
                console.log(idCliente);
                console.log(accionButton);
            }
        </script>
    </head>
    <%  response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");  
            if (session.getAttribute("user")==null){
                response.sendRedirect("login.jsp");
            }
    %>
    <body>
        <%@include file="../Templates/header.jsp"%>
        
        <div class=" d-flex container justify-content-center">
            <div class="col-12 mt-4">
                <h4>Mis clientes<span class="badge badge-secondary"></span></h4>
                <form id="frm" name="frm" action="Clientes" method="POST" class="mt-4">
                    <input type="hidden" id="idCliente" name="idCliente"/>
                    <input type="hidden" id="accionButton" name="accionButton"/>
                    <table class="table table-striped text-center">

                        <td>ID Cliente</td>
                        <td>Nombres</td>
                        <td>Apellidos</td>
                        <td>Tipo Documento</td>
                        <td>N° Documento</td>
                        <td>Direccion</td>
                        <td>Telefono</td>
                        <td>Movil</td>
                        <td>Acciones</td>

                        <c:forEach var="p" items="${requestScope.listadoClientes}">
                            <tr>
                                <td>${p.id}</td>
                                <td>${p.nombres}</td>
                                <td>${p.apellidos}</td>
                                <td>${p.tipoDocumento}</td>
                                <td>${p.numeroDocumento}</td>
                                <td>${p.direccion}</td>
                                <td>${p.telefono}</td>
                                <td>${p.movil}</td>
                                <td>
                                    <button type="submit" class="btn btn-primary btn-sm bi-view" onclick="ejecutarAccionConParams('${p.id}','ver');">Ver</button>&nbsp;
                                    <button type="submit" class="btn btn-secondary btn-sm bi-edit" onclick="ejecutarAccionConParams('${p.id}','editar');">Editar</button>&nbsp;
                                    <button type="submit" class="btn btn-danger btn-sm bi-delete" onclick="if (confirm('¿Está seguro de eliminar este registro')) { ejecutarAccionConParams('${p.id}', 'eliminar'); } else { return false; }">&nbsp;Eliminar</button>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </form>
                
                

            </div>
        </div>
   
    </body>
</html>
