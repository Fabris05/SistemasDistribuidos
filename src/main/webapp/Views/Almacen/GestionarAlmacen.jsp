<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <body>
        <!-- Modal -->
        <div class="modal fade" id="editModalAlmacen" tabindex="-1" aria-labelledby="editModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Mis Almacenes</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>

                    <div class="modal-body">
                        <!-- Formulario -->
                        <form id="frm" name="frm" action="Almacen" method="post">
                            <input type="hidden" class="form-control" id="codigoCategoria" name="codigoCategoria"/>
                            <input type="hidden" class="form-control" id="accionButton" name="accionButton"/>
                            <div class="mb-3">
                                <label class="form-label fw-bold">Almacén</label>
                                <input class="form-control" placeholder="Ingrese el almacén" name="txtAlmacen" autocomplete="off"/>
                            </div>
                            <div class="mb-3">
                                <label class="form-label fw-bold">Ubicación</label>
                                <input class="form-control" placeholder="Ingrese la ubicación" name="txtUbicacion" autocomplete="off"/>
                            </div>
                            <div class="mb-3">   
                                <label class="form-label fw-bold">Descripción</label>
                                <textarea class="form-control" name="txaDescripcionAlmacen" placeholder="Ingrese una descripción (opcional)" rows="1"></textarea>
                            </div>

                            <button type="submit" class="btn btn-success justify-content-end" style="display: flex; align-items: center;">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-plus-circle-fill" viewBox="0 0 16 16">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0M8.5 4.5a.5.5 0 0 0-1 0v3h-3a.5.5 0 0 0 0 1h3v3a.5.5 0 0 0 1 0v-3h3a.5.5 0 0 0 0-1h-3z"/>
                                </svg>
                                &nbsp; Añadir
                            </button>
                            <table class="table table-striped text-center mt-3">
                                <td class="fw-bold d-none">id</td>
                                <td class="fw-bold">Almacén</td>
                                <td class="fw-bold">Ubicación</td>
                                <td class="fw-bold">Descripción</td>
                                <td class="fw-bold">Acciones</td>
                                <c:forEach var="c" items="${requestScope.listadoAlmacen}">
                                    <tr>
                                        <td class="d-none">${c.idAlmacen}</td>
                                        <td>${c.almacen}</td>
                                        <td>${c.ubicacion}</td>
                                        <td>${c.descripcion}</td>
                                        <td> 
                                            <button class="btn btn-danger btn-sm" onclick="if (confirm('¿Está seguro de eliminar este registro')) { ejecutarAccionConParams('${c.idAlmacen}', 'eliminar'); } else { return false; }">Eliminar</button>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Cancelar</button>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
