<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <!-- Modal -->
        <div class="modal fade" id="editModal" tabindex="-1" aria-labelledby="editModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="editModalLabel">Editar Producto</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <form id="ProductoEditar" action="Productos" method="POST">
                            <input type="hidden" class="form-control" name="codigoProducto"/>
                            <div class="mb-3">
                                <label for="modalCodigoProducto" class="form-label">Código Producto</label>
                                <input type="text" class="form-control" id="modalCodigoProducto" name="codigoProducto" disabled>
                            </div>
                            <div class="mb-3">
                                <label for="modalNombreProducto" class="form-label">Nombre Producto</label>
                                <input type="text" class="form-control" id="modalNombreProducto" name="nombreProducto">
                            </div>
                            <div class="mb-3">
                                <label for="modalPrecioProducto" class="form-label">Precio</label>
                                <input type="number" step="0.01" class="form-control" id="modalPrecioProducto" name="precioProducto">
                            </div>
                            <div class="mb-3">
                                <label for="modalCantidadProducto" class="form-label">Cantidad</label>
                                <input type="number" class="form-control" id="modalCantidadProducto" name="cantidadProducto">
                            </div>
                            <div class="mb-3">
                                <label for="modalCaducidadProducto" class="form-label">Caducidad</label>
                                <input type="date" class="form-control" id="modalCaducidadProducto" name="caducidadProducto">
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                                <button type="submit" class="btn btn-primary">Guardar cambios</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
