<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
     <script type="text/javascript">
        function modalCategoria(idCategoria, action){
            document.getElementById("idCategoria").value=idCategoria;
            document.getElementById("actionCategoria").value=action;
            document.getElementById("frmCategoria").submit();
        }
    </script>
    <body>
        <!-- Modal -->
        <div class="modal fade" id="editModal" tabindex="-1" aria-labelledby="editModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-scrollable">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Mis Categorías</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>

                    <div class="modal-body">
                        <!-- Formulario -->
                        <form id="frmCategoria" name="frm" action="Categoria" method="post">
                            <input type="hidden" class="form-control" id="idCategoria" name="idCategoria"/>
                            <input type="hidden" class="form-control" id="actionCategoria" name="actionCategoria"/>
                            <div class="mb-3">
                                <label class="form-label fw-bold">Categoría</label>
                                <input class="form-control" placeholder="Ingrese la categoría" name="txtCategoria" autocomplete="off"/>
                            </div>
                            <div class="mb-3">   
                                <label class="form-label fw-bold">Descripción</label>
                                <textarea class="form-control" name="txaDescripcionCategoria" placeholder="Ingrese una descripción (opcional)" rows="1"></textarea>
                            </div>

                            <button class="btn btn-success justify-content-end" onclick="modalCategoria('1', 'agregar');" style="display: flex; align-items: center;">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-plus-circle-fill" viewBox="0 0 16 16">
                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0M8.5 4.5a.5.5 0 0 0-1 0v3h-3a.5.5 0 0 0 0 1h3v3a.5.5 0 0 0 1 0v-3h3a.5.5 0 0 0 0-1h-3z"/>
                                </svg>
                                &nbsp; Añadir
                            </button>
                            <table class="table table-striped text-center mt-3">
                                <td class="fw-bold">id</td>
                                <td class="fw-bold">Categoría</td>
                                <td class="fw-bold">Descripción</td>
                                <td class="fw-bold">Acciones</td>
                                <c:forEach var="c" items="${requestScope.listadoCategoria}">
                                    <tr>
                                        <td class="">${c.idCategoria}</td>
                                        <td>${c.categoria}</td>
                                        <td>${c.descripcionCategoria}</td>
                                        <td> 
                                            <button class="btn btn-danger btn-sm" onclick="if (confirm('¿Está seguro de eliminar este registro')) { modalCategoria('${c.idCategoria}', 'eliminar'); } else { return false; }">Eliminar</button>
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
