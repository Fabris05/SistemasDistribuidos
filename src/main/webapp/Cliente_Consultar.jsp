<%-- 
    Document   : Cliente_Consultar
    Created on : 13 may. 2024, 17:41:47
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
        <title>Datos del Cliente</title>
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
                    <h4>Datos del cliente</h4>
                    <div><!-- Formulario -->
                        <form action="Agregar_Clientes" method="pxst">
                            <div class="d-flex row gap-3 justify-content-center">

                                <div class="col-md-2 mt-3">
                                    <label class="form-label fw-bold">ID Cliente</label>
                                    <input class="form-control" name="txtIdCliente" value="${cliente.id}"disabled/>
                                </div>

                                <div class="col-md-2 mt-3">
                                    <label class="form-label fw-bold">Nombre</label>
                                    <input class="form-control" name="txtNombreCliente" value="${cliente.nombres}" disabled/>
                                </div>

                                <div class="col-md-2 mt-3">
                                    <label class="form-label fw-bold">Apellidos</label>
                                    <input class="form-control" name="txtApellidoCliente" value="${cliente.apellidos}" disabled/>
                                </div>

                                <div class="col-md-2 mt-3">
                                    <label class="form-label fw-bold">Tipo de Documento</label>
                                    <input class="form-control" name="txtTipoDocumento" value="${cliente.tipoDocumento}" disabled/>
                                    
                                </div>

                                <div class="col-md-2 mt-3">
                                    <label class="form-label fw-bold">Número de Documento</label>
                                    <input class="form-control" name="txtNumeroDocumentoCliente" value="${cliente.numeroDocumento}"  disabled/>
                                </div>

                                <div class="col-md-2 mt-3">
                                    <label class="form-label fw-bold">Dirección</label>
                                    <input class="form-control" name="txtDireccionCliente" value="${cliente.direccion}"disabled/>
                                </div>

                                <div class="col-md-2 mt-3">
                                    <label class="form-label fw-bold">Teléfono</label>
                                    <input class="form-control" name="txtTelefonoCliente" value="${cliente.telefono}" disabled/>
                                </div>

                                <div class="col-md-2 mt-3">
                                    <label class="form-label fw-bold">Móvil</label>
                                    <input class="form-control" name="txtCelularCliente" value="${cliente.movil}" disabled/>
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
