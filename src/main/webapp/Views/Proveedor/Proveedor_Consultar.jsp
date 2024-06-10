<%-- 
    Document   : Proveedor_Consultar
    Created on : 5 jun. 2024, 22:35:40
    Author     : fabri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Proveedor</title>
    </head>
    <body>
        <%@include file="/Templates/header.jsp"%>
        <div class="container-fluid">
            <div class="col p-4 mt-2">
                <div class="col-12">
                    <h4>Datos del Proveedor</h4>
                    <div class="mt-4"><!-- Formulario -->
                        <form action="Agregar_Clientes" method="pxst">
                            <div class="d-flex row gap-3 justify-content-center">

                                <div class="col-md-2 mt-3">
                                    <label class="form-label fw-bold">Código Proveedor</label>
                                    <input class="form-control" name="txtIdCliente" value="${proveedor.codigoProveedor}"disabled/>
                                </div>

                                <div class="col-md-2 mt-3">
                                    <label class="form-label fw-bold">RUC</label>
                                    <input class="form-control" name="txtNombreCliente" value="${proveedor.RUCProveedor}" disabled/>
                                </div>

                                <div class="col-md-2 mt-3">
                                    <label class="form-label fw-bold">Razón Social</label>
                                    <input class="form-control" name="txtApellidoCliente" value="${proveedor.razonSocialProveedor}" disabled/>
                                </div>

                                <div class="col-md-2 mt-3">
                                    <label class="form-label fw-bold">Proveedor</label>
                                    <input class="form-control" name="txtTipoDocumento" value="${proveedor.nombreProveedor}" disabled/>

                                </div>

                                <div class="col-md-2 mt-3">
                                    <label class="form-label fw-bold">Teléfono</label>
                                    <input class="form-control" name="txtDireccionCliente" value="${proveedor.telefonoProveedor}"disabled/>
                                </div>

                                <div class="col-md-2 mt-3">
                                    <label class="form-label fw-bold">Coreo Electrónico</label>
                                    <input class="form-control" name="txtTelefonoCliente" value="${proveedor.emailProveedor}" disabled/>
                                </div>

                                <div class="col-md-2 mt-3">
                                    <label class="form-label fw-bold">Dirección</label>
                                    <input class="form-control" name="txtCelularCliente" value="${proveedor.ubicacionProveedor}" disabled/>
                                </div>
                                
                                <div class="col-md-3 mt-3">
                                    <label class="form-label fw-bold">Descripción</label> 
                                    <textarea class="form-control" name="txaDescripcionProveedor" rows="1" disabled>${proveedor.descripcionProveedor}</textarea>
                                </div>
                            </div>

                            <div class="d-flex row-2 justify-content-center mt-5"> <!-- Boton regresar -->
                                <a role="button" href="/SistemasDistribuidos/Proveedores"" class="btn btn-danger" style="display: flex; align-items: center;" name="validad" value="Aceptar">
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
