<%-- 
    Document   : PedidoAñadir
    Created on : 22 jun. 2024, 13:22:16
    Author     : fabri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@11/dist/sweetalert2.min.css">
        <title>Añadir Pedido</title>
    </head>
    <body>
        <%@include file="/Templates/header.jsp"%>
        <div class="container-fluid">
            <div class="col p-4 mt-1">
                <div class="col-12">
                    <div class="row gap-1 justify-content-between">
                        <h5 class="fw-bold">Añadir nuevo pedido<span class="badge badge-secondary"></span></h5>
                        <div class="col-3">
                            <h5>Datos del Cliente<span class="badge badge-secondary"></span></h5>
                            <div class="row mt-3"> <!-- Cliente -->
                                <form id="formFindClient" action="PedidosA" method="post">
                                    <input type="hidden" name="action" value="buscarCliente"/>
                                    <div class="d-flex gap-2 mb-1"> <!-- div de input y button -->
                                        <select class="form-select form-select-sm" name="cbxTipoDocumento">
                                            <option value="DNI">DNI</option>
                                            <option value="CE">Carnet Extranjería</option>
                                            <option value="PASAPORTE">Pasaporte</option>
                                        </select>
                                        <input type="text" name="txtNumDocumentoCliente" placeholder="N° Documento" class="form-control form-control-sm" value="${cliente.numeroDocumento}" autocomplete="off"/>
                                        <div>
                                            <button type="button" class="btn btn-primary btn-sm" onclick="buscarCliente();">
                                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
                                                <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001q.044.06.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1 1 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0"/>
                                                </svg>
                                            </button>
                                        </div>
                                    </div>
                                    <div id="cliente-info">
                                        <label for="labelCliente" class="form-label fw-bold mt-1">Cliente</label>
                                        <input type="text" id="nombreCliente" name="txtNombreCliente" class="form-control form-control-sm" readonly>
                                        <label for="labelEmail" class="form-label fw-bold mt-1">Email</label>
                                        <input type="text" id="emailCliente" name="txtEmailCliente" class="form-control form-control-sm" readonly>
                                    </div>
                                </form>
                            </div>
                        </div>

                        <!-- Formulario de Productos -->

                        <div class="col-5 p-2"> <!-- DIV producto -->
                            <h5>Datos del Producto<span class="badge badge-secondary"></span></h5>
                            <form id="formFindProduct" action="PedidosA" method="post">
                                <input type="hidden" name="action" value="buscarProducto">
                                <div class="d-flex col align-items-center gap-2 mt-3">
                                    <label for="labelCodigo" class="form-label fw-bold">Código Producto</label>
                                    <div class="col-7">
                                        <input type="text" name="txtCodigoProductoVenta" id="codigoProducto" class="form-control" value="P-">
                                    </div>
                                    <div class="col-1">
                                        <button type="button" class="btn btn-primary" onclick="buscarProducto();">
                                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
                                            <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001q.044.06.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1 1 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0"/>
                                            </svg>
                                        </button>
                                    </div>
                                </div>
                            </form>
                            <div id="producto-info">
                                <div class="d-flex col align-items-center gap-2 mt-3" id="producto-info">
                                    <label for="labelCodigo" class="form-label fw-bold">Producto</label>
                                    <div class="col-10">
                                        <input type="text" name="txtCodigoProductoVenta" id="nombreProducto" class="form-control" value="${producto.nombreProducto}" disabled>
                                    </div>

                                </div>
                                <div class="d-flex row-12 gap-2 mt-3">
                                    <div class="d-flex col-4 gap-2 align-items-center">
                                        <label for="labelCantidad" class="form-label fw-bold">Cantidad</label>
                                        <input type="number" class="form-control" name="txtCantidadProductoVenta" id="cantidadProducto" min="1">
                                    </div>
                                    <div class="d-flex col-3 gap-2 align-items-center">
                                        <label for="labelStock" class="form-label fw-bold">Stock</label>
                                        <input type="text" name="txtStockVenta" id="stockProducto" class="form-control" disabled>
                                    </div>
                                    <div class="d-flex col-4 gap-2 align-items-center">
                                        <label for="labelPrecio" class="form-label fw-bold">Precio</label> 
                                        <input type="text"  class="form-control" name="txtPrecioProductoVenta" id="precioUProducto" disabled>
                                    </div>
                                </div>
                            </div>

                            <div class="d-flex mt-4 justify-content-center ">
                                <button type="button" class="btn btn-primary" onclick="addProduct()">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-plus-circle-fill" viewBox="0 0 16 16">
                                    <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0m-7.5-3.5a.5.5 0 0 0-1 0v3h-3a.5.5 0 0 0 0 1h3v3a.5.5 0 0 0 1 0v-3h3a.5.5 0 0 0 0-1h-3z"/>
                                    </svg>
                                    &nbsp;Añadir Producto
                                </button>
                            </div>
                        </div>

                        <!-- FORMULARIO Metodo de Pago -->

                        <div class="col-3 p-3">
                            
                            <form action="PedidosA" method="post">
                                <h5>Resumen de Venta<span class="badge badge-secondary"></span></h5>
                                <input type="hidden" name="action" value="finalizarVenta"/>
                                <input type="hidden" name="txtNumDocumentoVenta" value="${cliente.numeroDocumento}"/>
                                <div class="d-flex col justify-content-between gap-3 mt-3 align-items-center">
                                    <label for="labelCodigo" class="form-label fw-bold">Precio parcial S/.</label>
                                    <div class="col-6">
                                        <input type="text" name="txtPrecioParcialVenta" id="precioParcial" class="form-control form-control-sm" readonly>
                                    </div>
                                </div>
                                <div class="d-flex col justify-content-between gap-3 mt-2 align-items-center">
                                    <label for="labelCodigo" class="form-label fw-bold">IGV S/.</label>
                                    <div class="col-6">
                                        <input type="text" name="txtIGV_Venta" class="form-control form-control-sm" readonly>
                                    </div>
                                </div>
                                <div class="d-flex col justify-content-between gap-3 mt-2 align-items-center">
                                    <label for="labelCodigo" class="form-label fw-bold ">Precio final S/.</label>
                                    <div class="col-6">
                                        <input type="text" name="txtPrecioFinalVenta" class="form-control form-control-sm" readonly>
                                    </div>
                                </div>

                                <div class="d-flex mt-4 justify-content-center ">
                                    <button type="button" class="btn btn-success" style="display: flex; align-items: center;" onclick="finalizarPedido()">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-check-circle-fill" viewBox="0 0 16 16">
                                        <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0m-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
                                        </svg>
                                        &nbsp;Finalizar Venta
                                    </button>
                                </div>
                            </form>
                        </div>
                    </div>


                    <div class="mt-4"> <!-- DIV Tabla -->
                        <table class="table table-sm table-hover text-center">
                            <thead class="thead-light">
                                <tr>
                                    
                                    <th>Código</th>
                                    <th>Producto</th>
                                    <th>Cantidad</th>
                                    <th>Precio Unitario S/.</th>
                                    <th>Precio Total S/.</th>
                                    <th>Acciones</th>
                                </tr>
                            </thead>
                            <tbody id="rowProduct">
                           
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>

        <!-- Scripts -->
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <script src="/SistemasDistribuidos/Resources/JS/PedidoA.js"></script>
        <script src="/SistemasDistribuidos/Resources/JS/PedidoCarrito.js"></script>
        <script src="/SistemasDistribuidos/Resources/JS/PedidoFinalizar.js"></script>
    </body>
</html>