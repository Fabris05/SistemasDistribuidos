<%-- 
    Document   : Usuario_Agregar
    Created on : 19 may. 2024, 00:56:19
    Author     : fabri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Usuario</title>
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
                    <h4>Añadir nuevo Usuario</h4>
                    <div><!-- Formulario -->
                        <form action="Agregar_Usuario" method="post">
                            <div class="d-flex row gap-3 justify-content-center">
                                <div class="col-md-2 mt-3">
                                    <label class="form-label fw-bold">ID Cliente</label>
                                    <input class="form-control" name="txtIdCliente" placeholder="ID del empleado" disabled >
                                </div>

                                <div class="col-md-2 mt-3">
                                    <label class="form-label fw-bold">Nombre</label>
                                    <input class="form-control" name="txtNombreUsuario" placeholder="Nombre del empleado" autocomplete="off">
                                </div>

                                <div class="col-md-2 mt-3">
                                    <label class="form-label fw-bold">Apellidos</label>
                                    <input class="form-control" name="txtApellidoUsuario" placeholder="Apellidos del empleado" autocomplete="off">
                                </div>
                                
                                <div class="col-md-2 mt-3">
                                    <label class="form-label fw-bold">Cargo</label>
                                    <select class="form-select" name="cbxCargoUsuario">
                                        <option value="A">Administrador</option>
                                        <option value="U">Usuario</option>
                                    </select>
                                </div>
                                
                                <div class="col-md-2 mt-3">
                                    <label class="form-label fw-bold">Estado</label>
                                    <select class="form-select" name="cbxEstadoUsuario">
                                        <option value="activo">Activo</option>
                                        <option value="inactivo">Inactivo</option>
                                    </select>
                                </div>
                                
                                <div class="col-md-2 mt-3">
                                    <label class="form-label fw-bold">Usuario</label>
                                    <input class="form-control" name="txtUsuario" placeholder="Usuario del empleado" autocomplete="off">
                                </div>
                                
                                <div class="col-md-2 mt-3">
                                    <label class="form-label fw-bold">Contraseña</label>
                                    <input class="form-control" name="txtpassUsuario" placeholder="" autocomplete="off"/>
                                </div>

                            </div>

                            <div class="d-flex row-2 justify-content-center mt-5"> <!-- Boton registrar cliente -->
                                <Button type="submit" class="btn btn-success" style="display: flex; align-items: center;" name="validad" value="Aceptar">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-plus-fill" viewBox="0 0 16 16">
                                    <path d="M1 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6"/>
                                    <path fill-rule="evenodd" d="M13.5 5a.5.5 0 0 1 .5.5V7h1.5a.5.5 0 0 1 0 1H14v1.5a.5.5 0 0 1-1 0V8h-1.5a.5.5 0 0 1 0-1H13V5.5a.5.5 0 0 1 .5-.5"/>
                                    </svg>
                                    &nbsp;Registrar Empleado
                                </Button>
                            </div> 
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
