<%-- 
    Document   : Cliente_Agregar
    Created on : 11 may. 2024, 13:24:55
    Author     : fabri
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
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
                    <h4>Añadir nuevo Cliente</h4>
                    <div><!-- Formulario -->
                        <form action="Agregar_Cliente" method="post">
                            <div class="d-flex row gap-3 justify-content-center">
                                <div class="col-md-2 mt-3">
                                    <label class="form-label fw-bold">ID Cliente</label>
                                    <input class="form-control" name="txtIdCliente" placeholder="ID del cliente" disabled >
                                </div>

                                <div class="col-md-2 mt-3">
                                    <label class="form-label fw-bold">Nombre</label>
                                    <input class="form-control" name="txtNombreCliente" placeholder="Nombre del cliente" autocomplete="off">
                                </div>

                                <div class="col-md-2 mt-3">
                                    <label class="form-label fw-bold">Apellidos</label>
                                    <input class="form-control" name="txtApellidoCliente" placeholder="Apellidos del cliente" autocomplete="off">
                                </div>

                                <div class="col-md-2 mt-3">
                                    <label class="form-label fw-bold">Tipo de Documento</label>
                                    <select class="form-select" name="cbxTipoDocumentoCliente">
                                        <option value="DNI">DNI</option>
                                        <option value="CE">Carnet Extranjería</option>
                                        <option value="PASAPORTE">Pasaporte</option>
                                    </select>
                                </div>

                                <div class="col-md-2 mt-3">
                                    <label class="form-label fw-bold">Número de Documento</label>
                                    <input class="form-control" name="txtNumeroDocumentoCliente" placeholder="" autocomplete="off">
                                </div>

                                <div class="col-md-2 mt-3">
                                    <label class="form-label fw-bold">Dirección</label>
                                    <input class="form-control" name="txtDireccionCliente" placeholder="Dirección del cliente" autocomplete="off">
                                </div>

                                <div class="col-md-2 mt-3">
                                    <label class="form-label fw-bold">Teléfono</label>
                                    <input class="form-control" name="txtTelefonoCliente" placeholder="Teléfono del cliente" autocomplete="off">
                                </div>

                                <div class="col-md-2 mt-3">
                                    <label class="form-label fw-bold">Celular</label>
                                    <input class="form-control" name="txtCelularCliente" placeholder="Celular del cliente" autocomplete="off">
                                </div>
                            </div>

                            <div class="d-flex row-2 justify-content-center mt-5"> <!-- Boton registrar cliente -->
                                <Button type="submit" class="btn btn-primary" style="display: flex; align-items: center;" name="validad" value="Aceptar">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-plus-fill" viewBox="0 0 16 16">
                                    <path d="M1 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6"/>
                                    <path fill-rule="evenodd" d="M13.5 5a.5.5 0 0 1 .5.5V7h1.5a.5.5 0 0 1 0 1H14v1.5a.5.5 0 0 1-1 0V8h-1.5a.5.5 0 0 1 0-1H13V5.5a.5.5 0 0 1 .5-.5"/>
                                    </svg>
                                    &nbsp;Registrar Cliente
                                </Button>
                            </div> 
                        </form>
                    </div>
                    <c:if test="${not empty message}">
                        <div class="alert alert-${alertType} alert-dismissible fade show" role="alert">
                            <i class="${alertIcon}"></i>
                            ${message}
                            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                        </div>
                    </c:if>
                </div>
            </div>
        </div>
    </body>
</html>
