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
        <title>Mis Clientes</title>
            
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
            <div class="col-12 mt-5">
                <h3>Mis clientes<span class="badge badge-secondary"></span></h3>
                <form id="frm" name="frm" action="Clientes" method="POST" class="mt-4">
                    <h5>Buscar Cliente</h5>
                    <div class="d-flex col-12 gap-2"> <!-- BUSCAR CLIENTE -->
                        <div class="col-2">
                            <select class="form-select" name="cbxTipoDocumento">
                                <option value="DNI">DNI</option>
                                <option value="CE">Carnet Extranjería</option>
                                <option value="PASAPORTE">Pasaporte</option>
                            </select>
                        </div>
                        
                        <div class="col-6">
                            <div class="d-flex col gap-2">
                                <div class="col-4">
                                    <input type="number" class="form-control" name="txtNumDocumento" placeholder="N° de documento" autocomplete="off"/>
                                </div>
                                <div class="col-3">
                                    <button type="submit" class="btn btn-primary" style="display: flex; align-items: center;" onclick="ejecutarAccionConParams('${p.id}','buscar');">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
                                        <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001q.044.06.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1 1 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0"/>
                                        </svg>
                                        &nbsp;Buscar
                                    </button>
                                </div>
                            </div>
                        </div>
                        <!-- Alerta de error -->
                        <c:if test="${not empty mensajeError}">
                            <div class="alert alert-danger alert-dismissible fade show mt-3" role="alert">
                                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor" class="bi bi-exclamation-triangle-fill flex-shrink-0 me-2" viewBox="0 0 16 16" role="img" aria-label="Warning:">
                                <path d="M8.982 1.566a1.13 1.13 0 0 0-1.96 0L.165 13.233c-.457.778.091 1.767.98 1.767h13.713c.889 0 1.438-.99.98-1.767L8.982 1.566zM8 5c.535 0 .954.462.9.995l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 5.995A.905.905 0 0 1 8 5zm.002 6a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"/>
                                </svg>
                                ${mensajeError}
                                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                            </div>
                        </c:if>
                    </div>
                    <input type="hidden" id="idCliente" name="idCliente"/>
                    <input type="hidden" id="accionButton" name="accionButton"/>
                    <table class="table table-striped text-center mt-5">

                        <td class="fw-bold">ID Cliente</td>
                        <td class="fw-bold">Nombres</td>
                        <td class="fw-bold">Apellidos</td>
                        <td class="fw-bold">Tipo Documento</td>
                        <td class="fw-bold">N° Documento</td>
                        <td class="fw-bold">Dirección</td>
                        <td class="fw-bold">Teléfono</td>
                        <td class="fw-bold">Móvil</td>
                        <td class="fw-bold">Acciones</td>

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
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" crossorigin="anonymous"></script>
    </body>
</html>
