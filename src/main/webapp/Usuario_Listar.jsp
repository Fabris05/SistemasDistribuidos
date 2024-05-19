<%-- 
    Document   : Usuario_Listar
    Created on : 18 may. 2024, 14:33:56
    Author     : fabri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mis Usuarios</title>
        <script type="text/javascript">
            function ejecutarAccionConParams(idUsuario, accionButton ) {
                document.getElementById("accionButton").value = accionButton;
                document.getElementById("idUsuario").value = idUsuario;
                
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
            <div class="col-12 mt-5">
                <h4>Mis usuarios<span class="badge badge-secondary"></span></h4>
                
                <form id="frm" name="frm" action="Usuarios" method="POST" class="mt-4">
                    <input type="hidden" id="idUsuario" name="idUsuario"/>
                    <input type="hidden" id="accionButton" name="accionButton"/>
                    <table class="table table-striped text-center">

                        <td>ID Usuario</td>
                        <td>Usuario</td>
                        <td>Nombre</td>
                        <td>Apellidos</td>
                        <td>Estado</td>
                        <td>Acciones</td>

                        <c:forEach var="p" items="${requestScope.listadoUsuarios}">
                            <tr>
                                <td>${p.idUsuario}</td>
                                <td>${p.user}</td>
                                <td>${p.nombreUsuario}</td>
                                <td>${p.apellidoUsuario}</td>
                                <td>${p.estado}</td>
                                <td>
                                    <button type="submit" class="btn btn-primary btn-sm bi-view" onclick="ejecutarAccionConParams('${p.idUsuario}','ver');">Ver</button>&nbsp;
                                    <button type="submit" class="btn btn-secondary btn-sm bi-edit" onclick="ejecutarAccionConParams('${p.idUsuario}','editar');">Editar</button>&nbsp;
                                    <button type="submit" class="btn btn-danger btn-sm bi-delete" onclick="if (confirm('¿Está seguro de eliminar este registro')) { ejecutarAccionConParams('${p.idUsuario}', 'eliminar'); } else { return false; }">&nbsp;Eliminar</button>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </form>
            </div>
        </div>
    </body>
</html>
