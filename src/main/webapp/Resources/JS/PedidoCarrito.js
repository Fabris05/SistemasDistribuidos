class Producto {
    constructor(codigo, producto, cantidad, precioU, precioF) {
        this.codigo = codigo;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioU = precioU;
        this.precioF = precioF;
    }
}

function addProduct() {
    console.log("addProduct function called"); 
    var codigo = document.getElementById("codigoProducto").value;
    var producto = document.getElementById("nombreProducto").value;
    var cantidad = parseInt(document.getElementById("cantidadProducto").value);
    var stock = parseInt(document.getElementById("stockProducto").value);
    var precioU = document.getElementById("precioUProducto").value;
    var precioF = cantidad * precioU;
    
    // Asegúrate de que todos los campos estén llenos
    if (!codigo || !producto || !cantidad || !precioU) {
        Swal.fire({
                icon: 'error',
                title: 'Datos no incompletos',
                text: 'Ingresa todos los datos' 
            });
        return;
    }
    
    if(cantidad > stock) {
        Swal.fire({
            icon: 'error',
            title: 'Error de stock',
            text: 'Excediste el stock disponible'
        });
        return;
    }
    
    var rowsProduct = document.getElementById("rowProduct");
    for (var i = 0; i < rowsProduct.rows.length; i++) {
        var rowCodigo = rowsProduct.rows[i].cells[0].textContent;
        if (rowCodigo === codigo) {
            Swal.fire({
                icon: 'error',
                title: 'Producto duplicado',
                text: 'El producto ya está en el carrito'
            });
            document.getElementById("codigoProducto").disabled= false;
            return;
        }
    }
    var productoNew = new Producto(codigo, producto, cantidad, precioU, precioF);

    addProductTable(productoNew);
    limpiarCamposProducto();
    document.getElementById("codigoProducto").disabled= false;
    document.getElementById("codigoProducto").value="";
}

function addProductTable(productoNew) {
    var rowsProduct = document.getElementById("rowProduct");

    var newRow = rowsProduct.insertRow();
    
    var CodeCell = newRow.insertCell(0);
    var ProductCell = newRow.insertCell(1);
    var QuantyCell = newRow.insertCell(2);
    var UnitPriceCell = newRow.insertCell(3);
    var FinalPriceCell = newRow.insertCell(4);
    var deleteCell= newRow.insertCell(5);

    CodeCell.textContent = productoNew.codigo;
    ProductCell.textContent = productoNew.producto;
    QuantyCell.innerHTML = `<input type="number" value="${productoNew.cantidad}" class="col-3 form-control form-control-sm justify-content-center" min="1" onchange="actualizarCantidad(this)">`;
    UnitPriceCell.textContent = productoNew.precioU;
    FinalPriceCell.textContent = productoNew.precioF;
    
    deleteCell.innerHTML = '<button class="btn btn-danger btn-sm" onclick="deleteProduct(this)">Eliminar</button>';
    
    console.log(CodeCell);
    sumarPreciosFinales();
}

function deleteProduct(button) {
    var row = button.parentNode.parentNode;
    row.parentNode.removeChild(row);
    sumarPreciosFinales();
}

function actualizarCantidad(input){
    var cantidad = parseInt(input.value);
    var row = input.parentNode.parentNode;
    var precioU = parseFloat(row.cells[3].textContent);
    var precioF = cantidad * precioU;
    row.cells[4].textContent = precioF.toFixed(2);

    // Actualiza los totales después de cambiar la cantidad
    sumarPreciosFinales();
}

function sumarPreciosFinales() {
    var rowsProduct = document.getElementById("rowProduct");

    if (!rowsProduct) {
        console.error("El elemento con id 'rowProduct' no se encontró.");
        return;
    }

    var total = 0;
    var rows = rowsProduct.rows;

    for (var i = 0; i < rows.length; i++) {
        var FinalPriceCell = rows[i].cells[4];
        if (!FinalPriceCell) {
            console.error(`La celda finalPriceCell en la fila ${i} no existe.`);
            continue;
        }
        var precioF = parseFloat(FinalPriceCell.textContent);
        if (isNaN(precioF)) {
            console.error(`El contenido de la celda finalPriceCell en la fila ${i} no es un número válido: ${FinalPriceCell.textContent}`);
            continue;
        }
        total += precioF;
    }

    // Actualiza el campo de total en el resumen de venta
    document.querySelector('input[name="txtPrecioParcialVenta"]').value = total.toFixed(2);
    // Si tienes otros cálculos como IGV y Neto, actualízalos aquí
    var igv = total * 0.18; // Suponiendo un IGV del 18%
    var neto = total + igv;
    document.querySelector('input[name="txtIGV_Venta"]').value = igv.toFixed(2);
    document.querySelector('input[name="txtPrecioFinalVenta"]').value = neto.toFixed(2);
}

function limpiarCamposProducto(){
    document.getElementById("nombreProducto").value ="";
    document.getElementById("cantidadProducto").value ="";
    document.getElementById("stockProducto").value ="";
    document.getElementById("precioUProducto").value ="";
}