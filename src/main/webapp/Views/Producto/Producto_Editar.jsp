<%-- 
    Document   : Producto_Editar
    Created on : 8 jun. 2024, 19:20:24
    Author     : fabri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Producto</title>
    </head>
    <body>
        <%@include file="/Templates/header.jsp"%>
        <div class="container-fluid">
            <div class="col p-4 mt-2">
                <div class="col-12">
                    <h4>Editar datos del producto</h4>
                    <div><!-- Formulario -->
                        <form action="ProductoEditar" method="POST">
                            <div class="d-flex row gap-3 justify-content-center">
                                <input type="hidden" name="txtCodigoProducto" value="${producto.codigoProducto}"/>
                                <div class="col-md-2 mt-3">
                                    <label class="form-label fw-bold">Código Producto</label>
                                    <input class="form-control" name="txtCodigoProducto" value="${producto.codigoProducto}" disabled/>
                                </div>

                                <div class="col-md-2 mt-3">
                                    <label class="form-label fw-bold">Producto</label>
                                    <input class="form-control" name="txtNombreProducto" value="${producto.nombreProducto}"/>
                                </div>

                                <div class="col-md-2 mt-3">
                                    <label class="form-label fw-bold">Cantidad</label>
                                    <input type="number" class="form-control" name="txtCantidadProducto" value="${producto.cantidadProducto}" autocomplete="off"/>
                                </div>

                                <div class="col-md-2 mt-3">
                                    <label class="form-label fw-bold">Precio de Venta S/.</label>
                                    <input class="form-control" name="txtPrecioProducto" value="${producto.precioProducto}" autocomplete="off">
                                </div>

                                <div class="col-md-2 mt-3">
                                    <label class="form-label fw-bold">Caducidad</label>
                                    <input type="date" class="form-control" value="${producto.caducidadProducto}" name="txtFechaCaducidad"/>
                                </div>

                                <div class="col-md-2 mt-3">
                                    <label class="form-label fw-bold">Categoría</label>
                                    <select class="form-select" name="cbxCategoriaProducto">
                                        <c:forEach var="categoria" items="${listadoCategorias}">
                                            <option value="${categoria.idCategoria}"
                                                <c:if test="${categoria.idCategoria == producto.idCategoriaProducto}">selected="selected"</c:if>>
                                                 ${categoria.categoria}
                                            </option>
                                        </c:forEach>
                                    </select>
                                </div>

                                <div class="col-md-2 mt-3">
                                    <label class="form-label fw-bold">Proveedor</label>
                                    <select class="form-select" name="cbxProveedorProducto">
                                         <c:forEach var="proveedor" items="${listadoProveedores}">
                                            <option value="${proveedor.idProveedor}"
                                                <c:if test="${proveedor.idProveedor==producto.idProveedorProducto}">selected="selected"</c:if>>
                                                ${proveedor.nombreProveedor}
                                            </option>
                                        </c:forEach>
                                    </select>
                                </div>

                                <div class="col-md-2 mt-3">
                                    <label class="form-label fw-bold">Almacén</label>
                                    <select class="form-select" name="cbxAlmacenProducto">
                                        <c:forEach var="almacen" items="${listadoAlmacenes}">
                                            <option value="${almacen.idAlmacen}"
                                                <c:if test="${almacen.idAlmacen==producto.idAlmacenProducto}">selected="selected"</c:if>>
                                                ${almacen.almacen}
                                            </option>
                                        </c:forEach>
                                    </select>
                                </div>
                                
                                <div class="col-md-4 mt-3">
                                    <label class="form-label fw-bold">Descripción</label>
                                    <textarea class="form-control" name="txaDescripcionProducto" rows="2">${producto.descripcionProducto}</textarea>
                                </div>
                            </div>
                            <div class="d-flex col gap-3 justify-content-center">
                                <div class="d-flex row-2 justify-content-center mt-5"> <!-- Boton registrar cliente -->
                                    <button type="submit" class="btn btn-success" style="display: flex; align-items: center;" name="validad" value="Aceptar">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-plus-fill" viewBox="0 0 16 16">
                                        <path d="M1 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6"/>
                                        <path fill-rule="evenodd" d="M13.5 5a.5.5 0 0 1 .5.5V7h1.5a.5.5 0 0 1 0 1H14v1.5a.5.5 0 0 1-1 0V8h-1.5a.5.5 0 0 1 0-1H13V5.5a.5.5 0 0 1 .5-.5"/>
                                        </svg>
                                        &nbsp;Guardar datos
                                    </button>
                                </div> 

                                <div class="d-flex row-2 justify-content-center mt-5"> <!-- Boton registrar cliente -->
                                    <a role="button" href="../SistemasDistribuidos/Productos" class="btn btn-danger" style="display: flex; align-items: center;" name="validad" value="Aceptar">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-left-circle-fill" viewBox="0 0 16 16">
                                        <path d="M8 0a8 8 0 1 0 0 16A8 8 0 0 0 8 0m3.5 7.5a.5.5 0 0 1 0 1H5.707l2.147 2.146a.5.5 0 0 1-.708.708l-3-3a.5.5 0 0 1 0-.708l3-3a.5.5 0 1 1 .708.708L5.707 7.5z"/>
                                        </svg>
                                        &nbsp;Regresar
                                    </a>
                                </div> 
                            </div>
                        </form>
                    </div>   
                </div>
            </div>
        </div>
                            
    </body>
</html>
