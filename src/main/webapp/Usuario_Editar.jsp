<%-- 
    Document   : Usuario_Editar
    Created on : 19 may. 2024, 16:46:47
    Author     : fabri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <body>
        <%@include file="../Templates/header.jsp"%>
        <div class="container-fluid">
            <div class="col p-4 mt-2">
                <div class="col-12">
                    <h4>Editar datos del usuario</h4>
                    <div><!-- Formulario -->
                        <form action="Editar_Usuario" method="POST">
                            <div class="d-flex row gap-3 justify-content-center">
                                <input type="hidden" name="txtId" value="${usuario.idUsuario}"/>
                                <div class="col-md-2 mt-3">
                                    <label class="form-label fw-bold">ID Cliente</label>
                                    <input class="form-control" value="${usuario.idUsuario}" disabled/>
                                </div>

                                <div class="col-md-2 mt-3">
                                    <label class="form-label fw-bold">Nombre</label>
                                    <input class="form-control" name="txtNombreUsuario" value="${usuario.nombreUsuario}"/>
                                </div>

                                <div class="col-md-2 mt-3">
                                    <label class="form-label fw-bold">Apellidos</label>
                                    <input class="form-control" name="txtApellidoUsuario" value="${usuario.apellidoUsuario}" autocomplete="off"/>
                                </div>

                                <div class="col-md-2 mt-3">
                                    <label class="form-label fw-bold">Cargo</label>
                                    <select class="form-select" name="cbxCargoUsuario">
                                        <option value="A" ${usuario.nivel eq 'A' ? 'selected' : ''}>Adminsitrador</option>
                                        <option value="U" ${usuario.nivel eq 'U' ? 'selected' : ''}>Usuario</option>
                                    </select>
                                </div>

                                <div class="col-md-2 mt-3">
                                    <label class="form-label fw-bold">Estado</label>
                                    <select class="form-select" name="cbxEstadoUsuario">
                                        <option value="activo" ${usuario.estado eq 'activo' ? 'selected' : ''}>Activo</option>
                                        <option value="inactivo" ${usuario.estado eq 'inactivo' ? 'selected' : ''}>Inactivo</option>
                                    </select>
                                </div>

                                <div class="col-md-2 mt-3">
                                    <label class="form-label fw-bold">Usuario</label>
                                    <input class="form-control" name="txtUsuario" value="${usuario.user}" autocomplete="off"/>
                                </div>

                                <div class="col-md-2 mt-3">
                                    <label class="form-label fw-bold">Contraseña</label>
                                    <input class="form-control" name="txtPassUsuario" value="${usuario.pass}" autocomplete="off"/>
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
                                    <a role="button" href="../SistemasDistribuidos/Usuarios"" class="btn btn-danger" style="display: flex; align-items: center;" name="validad" value="Aceptar">
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
    </div>
    </body>
</html>
