<%-- 
    Document   : Proveedor_Listar
    Created on : 1 jun. 2024, 23:42:56
    Author     : fabri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mis Proveedores</title>
        <script type="text/javascript">
            function ejecutarAccionConParams(codigoProveedor, accionButton ) {
                document.getElementById("accionButton").value = accionButton;
                document.getElementById("codigoProveedor").value = codigoProveedor;   
                document.getElementById("frm").submit();
            }
        </script>
    </head>
    <body>
        <%@include file="/Templates/header.jsp"%>
        
        <div class=" d-flex container justify-content-center">
            <div class="col-12 mt-5">
                <h4>Mis Proveedores<span class="badge badge-secondary"></span></h4>
                
                <form id="frm" name="frm" action="Proveedores" method="POST" class="mt-4">
                    <input type="hidden" id="codigoProveedor" name="codigoProveedor"/>
                    <input type="hidden" id="accionButton" name="accionButton"/>
                    <table class="table table-striped text-center">

                        <td>Código</td>
                        <td>RUC</td>
                        <td>Proveedor</td>
                        <td>Teléfono</td>
                        <td>Email</td>
                        <td>Acciones</td>

                        <c:forEach var="p" items="${requestScope.listadoProveedores}">
                            <tr>
                                <td>${p.codigoProveedor}</td>
                                <td>${p.RUCProveedor}</td>
                                <td>${p.nombreProveedor}</td>
                                <td>${p.telefonoProveedor}</td>
                                <td>${p.emailProveedor}</td>
                                <td>
                                    <button type="submit" class="btn btn-primary btn-sm bi-view" onclick="ejecutarAccionConParams('${p.codigoProveedor}','ver');">Ver</button>&nbsp;
                                    <button type="submit" class="btn btn-secondary btn-sm bi-edit" onclick="ejecutarAccionConParams('${p.codigoProveedor}','editar');">Editar</button>&nbsp;
                                    <button type="submit" class="btn btn-danger btn-sm bi-delete" onclick="if (confirm('¿Está seguro de eliminar este registro')) { ejecutarAccionConParams('${p.codigoProveedor}', 'eliminar'); } else { return false; }">&nbsp;Eliminar</button>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </form>
            </div>
        </div>
    </body>  
</html>
