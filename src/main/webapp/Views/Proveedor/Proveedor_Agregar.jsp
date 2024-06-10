<%-- 
    Document   : Proveedor_Agregar
    Created on : 1 jun. 2024, 23:59:36
    Author     : fabri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Proveedor</title>
    </head>
    <body>
        <%@include file="/Templates/header.jsp"%>
        <div class="container-fluid">
            <div class="col p-4 mt-2">
                <div class="col-12">
                    <h4>Añadir nuevo proveedor</h4>
                    <div>
                        <!-- Formulario -->
                        <form action="Proveedor_Agregar" method="post">
                            <div class="d-flex row gap-3 justify-content-center">
                                <div class="col-md-2 mt-3">
                                    <label class="form-label fw-bold">ID Proveedor</label>
                                    <input class="form-control" name="txtxIdProveedor" placeholder="ID del Proveedor" disabled >
                                </div>

                                <div class="col-md-2 mt-3">
                                    <label class="form-label fw-bold">RUC</label>
                                    <input class="form-control" name="txtRUC" placeholder="RUC" autocomplete="off" required/>
                                </div>

                                <div class="col-md-2 mt-3">
                                    <label class="form-label fw-bold">Razón Social</label>
                                    <input class="form-control" name="txtRazonSocial" placeholder="Razón Social" autocomplete="off" required/>
                                </div>

                                <div class="col-md-2 mt-3">
                                    <label class="form-label fw-bold">Proveedor</label>
                                    <input class="form-control" name="txtProveedor" placeholder="Proveedor" autocomplete="off" required>
                                </div>

                                <div class="col-md-2 mt-3">
                                    <label class="form-label fw-bold">Teléfono</label>
                                    <input class="form-control" name="txtTelefonoProveedor" placeholder="Télefono del proveedor" autocomplete="off" required>
                                </div>

                                <div class="col-md-3 mt-3">
                                    <label class="form-label fw-bold">Email</label>
                                    <input class="form-control" name="txtEmailProveedor" placeholder="Correo del proveedor" autocomplete="off" required>
                                </div>

                                <div class="col-md-3 mt-3">
                                    <label class="form-label fw-bold">Dirección</label>
                                    <input class="form-control" name="txtDireccionProveedor" placeholder="Dirección del proveedor" autocomplete="off" required>
                                </div>
                                
                                <div class="col-md-3 mt-3">
                                    <label class="form-label fw-bold">Descripción</label> 
                                    <textarea class="form-control" name="txaDescripcionProveedor" rows="1"></textarea>
                                </div>
                            </div>

                            <div class="d-flex row-2 justify-content-center mt-5"> <!-- Boton registrar proveedor -->
                                <Button type="submit" class="btn btn-success" style="display: flex; align-items: center;" name="validad" value="Aceptar">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-plus-fill" viewBox="0 0 16 16">
                                    <path d="M1 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6"/>
                                    <path fill-rule="evenodd" d="M13.5 5a.5.5 0 0 1 .5.5V7h1.5a.5.5 0 0 1 0 1H14v1.5a.5.5 0 0 1-1 0V8h-1.5a.5.5 0 0 1 0-1H13V5.5a.5.5 0 0 1 .5-.5"/>
                                    </svg>
                                    &nbsp;Registrar Proveedor
                                </Button>
                            </div> 
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
