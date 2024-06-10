<%-- 
    Document   : Cliente_Editar
    Created on : 13 may. 2024, 19:21:12
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
                    <h4>Editar datos de cliente</h4>
                    <div><!-- Formulario -->
                        <form action="ClienteEditarServlet" method="POST">
                            <div class="d-flex row gap-3 justify-content-center">
                                <input type="hidden" name="txtIdCliente" value="${cliente.id}"/>
                                <div class="col-md-2 mt-3">
                                    <label class="form-label fw-bold">ID Cliente</label>
                                    <input class="form-control" value="${cliente.id}" disabled/>
                                </div>

                                <div class="col-md-2 mt-3">
                                    <label class="form-label fw-bold">Nombre</label>
                                    <input class="form-control" name="txtNombreCliente" value="${cliente.nombres}"/>
                                </div>

                                <div class="col-md-2 mt-3">
                                    <label class="form-label fw-bold">Apellidos</label>
                                    <input class="form-control" name="txtApellidoCliente" value="${cliente.apellidos}" autocomplete="off"/>
                                </div>

                                <div class="col-md-2 mt-3">
                                    <label class="form-label fw-bold">Tipo de Documento</label>

                                    <select class="form-select" name="cbxTipoDocumentoCliente">
                                        <option value="DNI" ${cliente.tipoDocumento eq 'DNI' ? 'selected' : ''}>DNI</option>
                                        <option value="CE" ${cliente.tipoDocumento eq 'CE' ? 'selected' : ''}>Carnet Extranjería</option>
                                        <option value="PASAPORTE" ${cliente.tipoDocumento eq 'PASAPORTE' ? 'selected' : ''}>Pasaporte</option>
                                    </select>
                                </div>

                                <div class="col-md-2 mt-3">
                                    <label class="form-label fw-bold">Número de Documento</label>
                                    <input class="form-control" name="txtNumeroDocumentoCliente" value="${cliente.numeroDocumento}" autocomplete="off"/>
                                </div>

                                <div class="col-md-2 mt-3">
                                    <label class="form-label fw-bold">Dirección</label>
                                    <input class="form-control" name="txtDireccionCliente" value="${cliente.direccion}" autocomplete="off"/>
                                </div>

                                <div class="col-md-2 mt-3">
                                    <label class="form-label fw-bold">Teléfono</label>
                                    <input class="form-control" name="txtTelefonoCliente" value="${cliente.telefono}" autocomplete="off"/>
                                </div>

                                <div class="col-md-2 mt-3">
                                    <label class="form-label fw-bold">Móvil</label>
                                    <input class="form-control" name="txtCelularCliente" value="${cliente.movil}" autocomplete="off"/>
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
                                    <a role="button" href="../SistemasDistribuidos/Clientes"" class="btn btn-danger" style="display: flex; align-items: center;" name="validad" value="Aceptar">
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
