<%-- 
    Document   : Proveedor_Editar
    Created on : 9 jun. 2024, 23:14:06
    Author     : fabri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Proveedor</title>
    </head>
    <body>
        <%@include file="/Templates/header.jsp"%>
        <div class="container-fluid">
            <div class="col p-4 mt-2">
                <div class="col-12">
                    <h4>Editar datos del proveedor</h4>
                    <div>
                        <!-- Formulario -->
                        <form action="ProveedorEditar" method="post">
                            <div class="d-flex row gap-3 justify-content-center">
                                <input type="hidden" class="form-control" name="txtCodigoProveedor" value="${proveedor.codigoProveedor}"/>
                                <div class="col-md-2 mt-3">
                                    <label class="form-label fw-bold">Código proveedor</label>
                                    <input class="form-control" name="txtCodigoProveedor" value="${proveedor.codigoProveedor}" disabled/>
                                </div>

                                <div class="col-md-2 mt-3">
                                    <label class="form-label fw-bold">RUC</label>
                                    <input class="form-control" name="txtRUC" value="${proveedor.RUCProveedor}" autocomplete="off" required="on"/>
                                </div>

                                <div class="col-md-2 mt-3">
                                    <label class="form-label fw-bold">Razón Social</label>
                                    <input class="form-control" name="txtRazonSocial" value="${proveedor.razonSocialProveedor}" autocomplete="off" required="on"/>
                                </div>

                                <div class="col-md-2 mt-3">
                                    <label class="form-label fw-bold">Proveedor</label>
                                    <input class="form-control" name="txtProveedor" value="${proveedor.nombreProveedor}" autocomplete="off" required="on">
                                </div>

                                <div class="col-md-2 mt-3">
                                    <label class="form-label fw-bold">Teléfono</label>
                                    <input class="form-control" name="txtTelefonoProveedor" value="${proveedor.telefonoProveedor}" autocomplete="off" required="on">
                                </div>

                                <div class="col-md-3 mt-3">
                                    <label class="form-label fw-bold">Email</label>
                                    <input class="form-control" name="txtEmailProveedor" value="${proveedor.emailProveedor}" autocomplete="off" required="on">
                                </div>

                                <div class="col-md-3 mt-3">
                                    <label class="form-label fw-bold">Dirección</label>
                                    <input class="form-control" name="txtDireccionProveedor" value="${proveedor.ubicacionProveedor}" autocomplete="off" required="on">
                                </div>
                                
                                <div class="col-md-3 mt-3">
                                    <label class="form-label fw-bold">Descripción</label> 
                                    <textarea class="form-control" name="txaDescripcionProveedor" rows="1">${proveedor.descripcionProveedor}</textarea>
                                </div>
                            </div>

                            <div class="d-flex col gap-3 justify-content-center">
                                <div class="d-flex row-2 justify-content-center mt-5">
                                    <button type="submit" class="btn btn-success" style="display: flex; align-items: center;" name="validad" value="Aceptar">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-plus-fill" viewBox="0 0 16 16">
                                        <path d="M1 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6"/>
                                        <path fill-rule="evenodd" d="M13.5 5a.5.5 0 0 1 .5.5V7h1.5a.5.5 0 0 1 0 1H14v1.5a.5.5 0 0 1-1 0V8h-1.5a.5.5 0 0 1 0-1H13V5.5a.5.5 0 0 1 .5-.5"/>
                                        </svg>
                                        &nbsp;Guardar datos
                                    </button>
                                </div> 

                                <div class="d-flex row-2 justify-content-center mt-5"> <!-- Boton registrar cliente -->
                                    <a role="button" href="../SistemasDistribuidos/Proveedores" class="btn btn-danger" style="display: flex; align-items: center;" name="validad" value="Aceptar">
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
