<%-- 
    Document   : Producto_Consultar
    Created on : 18 may. 2024, 13:41:58
    Author     : fabri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ver Producto</title>
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
                    <h4>Datos del producto</h4>
                    <div><!-- Formulario -->
                        <form action="#" method="pxst">
                            <div class="d-flex row gap-3 justify-content-center">

                                <div class="col-md-2 mt-3">
                                    <label class="form-label fw-bold">ID Producto</label>
                                    <input type="text" class="form-control" name="txtIDProducto" value="#" disabled/>
                                </div>

                                <div class="col-md-2 mt-3">
                                    <label class="form-label fw-bold">Producto</label>
                                    <input type="text" class="form-control" name="txtNombreProducto" value="#" disabled/>
                                </div>

                                <div class="col-md-2 mt-3">
                                    <label class="form-label fw-bold">Lote</label>
                                    <input type="text" class="form-control" name="txtLoteProducto" value="#" disabled/>
                                </div>

                                <div class="col-md-2 mt-3">
                                    <label class="form-label fw-bold">Precio Venta S/.</label>
                                    <input type="text" class="form-control" name="txtPrecioProducto" value="#" disabled/>
                                </div>

                                <div class="col-md-2 mt-3">
                                    <label class="form-label fw-bold">Caducidad</label>
                                    <input type="text" class="form-control" name="txtCaducidadProducto" value="#" disabled/>
                                </div>

                                <div class="col-md-2 mt-3">
                                    <label class="form-label fw-bold">Categoría</label>
                                    <input type="text" class="form-control" name="txtCategoriaProducto" value="#" disabled/>
                                </div>

                                <div class="col-md-2 mt-3">
                                    <label class="form-label fw-bold">Proveedor</label>
                                    <input type="text" class="form-control" name="txtProveedorProducto" value="#" disabled/>
                                </div>

                                <div class="col-md-2 mt-3">
                                    <label class="form-label fw-bold">Almacén</label>
                                    <input type="text" class="form-control" name="txtAlmacenProducto" value="#" disabled/>
                                </div >
                                
                                <div class="col-md-3 mt-3">
                                    <label class="form-label fw-bold">Descripción</label>
                                    <textarea class="form-control" id="exampleFormControlTextarea1" rows="2" disabled></textarea>
                                </div>
                            </div>

                            </div>

                            <div class="d-flex row-2 justify-content-center mt-5"> <!-- Boton registrar cliente -->
                                <a role="button" href="../SistemasDistribuidos/Clientes"" class="btn btn-danger" style="display: flex; align-items: center;" name="validad" value="Aceptar">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-left-circle-fill" viewBox="0 0 16 16">
                                    <path d="M8 0a8 8 0 1 0 0 16A8 8 0 0 0 8 0m3.5 7.5a.5.5 0 0 1 0 1H5.707l2.147 2.146a.5.5 0 0 1-.708.708l-3-3a.5.5 0 0 1 0-.708l3-3a.5.5 0 1 1 .708.708L5.707 7.5z"/>
                                    </svg>
                                    &nbsp;Regresar
                                </a>
                            </div> 
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
