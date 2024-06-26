<%-- 
    Document   : Producto_Listar
    Created on : 18 may. 2024, 12:50:20
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
         <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <title>Mis Productos</title>
        <script type="text/javascript">
            function ejecutarAccionConParams(codigoProducto, accionButton ) {
                document.getElementById("accionButton").value = accionButton;
                document.getElementById("codigoProducto").value = codigoProducto;
                
                if(accionButton==='verCategoria'){
                    var myModal = new bootstrap.Modal(document.getElementById('editModal'));
                    myModal.show();
                
                }else if (accionButton==='verAlmacen'){
                    var myModal = new bootstrap.Modal(document.getElementById('editModalAlmacen'));
                    myModal.show();
                }else{
                    //document.getElementById("frm").submit();
                }
                
                //document.getElementById("frm").submit();
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
        <%@include file="/Templates/header.jsp"%>
        <div class=" d-flex container justify-content-center">
            <div class="col-12 mt-5">
                <h4>Mis Productos<span class="badge badge-secondary"></span></h4>
                <form id="frm" name="frm" action="Productos" method="POST" class="mt-4">
                    <input type="hidden" id="codigoProducto" name="codigoProducto"/>
                    <input type="hidden" id="codigoCategoria" name="codigoCategoria"/>
                    <input type="hidden" id="accionButton" name="accionButton"/>
                    <div class="">
                        <button type="button" class="btn btn-info" onclick="ejecutarAccionConParams('1','verCategoria');">Consultar Categoria</button>
                        <button type="button" class="btn btn-info" onclick="ejecutarAccionConParams('1','verAlmacen');">Consultar Almacén</button>
                    </div>
                    
                    <table class="table table-striped text-center mt-5">

                        <td>Código Producto</td>
                        <td>Producto</td>
                        <td>Precio</td>
                        <td>Stock</td>
                        <td>Caducidad</td>
                        <td>Acciones</td>
                        <c:forEach var="p" items="${requestScope.listadoProductos}">
                            
                            <tr>
                                <td>${p.codigoProducto}</td>
                                <td>${p.nombreProducto}</td>
                                <td>${p.precioProducto}</td>
                                <td>${p.cantidadProducto}</td>
                                <td>${p.caducidadProducto}</td>
                                <td>
                                    <button type="submit" class="btn btn-primary btn-sm bi-view" onclick="ejecutarAccionConParams('${p.codigoProducto}','ver');">Ver</button>&nbsp;
                                    <button type="button" class="btn btn-secondary btn-sm bi-edit" onclick="ejecutarAccionConParams('${p.codigoProducto}','editar');">Editar</button>&nbsp;
                                    <button type="submit" class="btn btn-danger btn-sm bi-delete" onclick="if (confirm('¿Está seguro de eliminar este registro')) { ejecutarAccionConParams('${p.codigoProducto}', 'eliminar'); } else { return false; }">Eliminar</button>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </form>
            </div>
        </div>
        <%@include file="/Views/Categoria/GestionarCategoria.jsp" %>
        <%@include file="/Views/Almacen/GestionarAlmacen.jsp"%>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" crossorigin="anonymous"></script>        

    </body>
</html>
