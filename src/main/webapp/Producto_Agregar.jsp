<%-- 
    Document   : Producto_Agregar
    Created on : 18 may. 2024, 13:06:36
    Author     : fabri
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%  response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");  
            if (session.getAttribute("user")==null){
                response.sendRedirect("login.jsp");
            }
    %>
    <body>
        <%@include file="../Templates/header.jsp"%>
        <div class="container-fluid">
            <div class="col p-4 mt-2">
                <div class="col-12">
                    <h4>Añadir nuevo producto</h4>
                    <div><!-- Formulario -->
                        
                        <form action="Agregar_Producto" method="post">
                            <div class="d-flex row gap-3 justify-content-center">
                                <div class="col-md-2 mt-3">
                                    <label class="form-label fw-bold">Código Producto</label>
                                    <input class="form-control" name="txtIDProducto" placeholder="Codigo del producto" disabled >
                                </div>

                                <div class="col-md-2 mt-3">
                                    <label class="form-label fw-bold">Producto</label>
                                    <input class="form-control" name="txtNombreProducto" placeholder="Nombre del Producto" autocomplete="off">
                                </div>

                                <div class="col-md-2 mt-3">
                                    <label class="form-label fw-bold">Cantidad</label>
                                    <input class="form-control" name="txtCantidadProducto" placeholder="Lote del Producto" autocomplete="off">
                                </div>

                                <div class="col-md-2 mt-3">
                                    <label class="form-label fw-bold">Precio Venta S/.</label>
                                    <input class="form-control" name="txtPrecioProducto" placeholder="Precio del Producto" autocomplete="off">
                                </div>
                                
                                <div class="col-md-2 mt-3">
                                    <label class="form-label fw-bold">Caducidad</label>
                                    <input type="date" class="form-control" name="txtFechaCaducidad"/>
                                </div>

                                <div class="col-md-2 mt-3">
                                    <label class="form-label fw-bold">Categoría</label>
                                    <select class="form-select" name="cbxCategoriaProducto">
                                        <c:forEach var="categoria" items="${listadoCategorias}">
                                            <option value="${categoria.idCategoria}">${categoria.categoria}</option>
                                        </c:forEach>
                                    </select>
                                </div>

                                <div class="col-md-2 mt-3">
                                    <label class="form-label fw-bold">Proveedor</label>
                                    <select class="form-select" name="cbxProveedorProducto">
                                         <c:forEach var="proveedor" items="${listadoProveedores}">
                                            <option value="${proveedor.idProveedor}">${proveedor.nombreProveedor}</option>
                                        </c:forEach>
                                    </select>
                                </div>

                                <div class="col-md-2 mt-3">
                                    <label class="form-label fw-bold">Almacén</label>
                                    <select class="form-select" name="cbxAlmacenProducto">
                                        <c:forEach var="almacen" items="${listadoAlmacenes}">
                                            <option value="${almacen.idAlmacen}">${almacen.almacen}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                
                                <div class="col-md-4 mt-3">
                                    <label class="form-label fw-bold">Descripción</label>
                                    <textarea class="form-control" name="txaDescripcionProducto" rows="2"></textarea>
                                </div>
                            </div>

                            <div class="d-flex row-2 justify-content-center mt-5"> <!-- Boton registrar cliente -->
                                <Button type="submit" class="btn btn-success" style="display: flex; align-items: center;" name="validad" value="Aceptar">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-plus-fill" viewBox="0 0 16 16">
                                    <path d="M1 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6"/>
                                    <path fill-rule="evenodd" d="M13.5 5a.5.5 0 0 1 .5.5V7h1.5a.5.5 0 0 1 0 1H14v1.5a.5.5 0 0 1-1 0V8h-1.5a.5.5 0 0 1 0-1H13V5.5a.5.5 0 0 1 .5-.5"/>
                                    </svg>
                                    &nbsp;Agregar Producto
                                </Button>
                            </div> 
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
