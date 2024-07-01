
function finalizarPedido() {
    var cliente = document.getElementById("nombreCliente").value;
    var emailCliente = document.getElementById("emailCliente").value;
    var rowsProduct = document.getElementById("rowProduct").rows;
    var productos = [];
    
    
    for (var i = 0; i < rowsProduct.length; i++) {
        var row = rowsProduct[i];
        var producto = {
            codigo: row.cells[0].textContent.trim(),
            nombre: row.cells[1].textContent.trim(),
            cantidad: row.cells[2].querySelector('input').value.trim() || '0',
            precioU: row.cells[3].textContent.trim(),
            precioF: row.cells[4].textContent.trim()
        };
        productos.push(producto);
    }
    
    if(!cliente| !emailCliente || productos.length === 0){
        Swal.fire({
            icon: 'error',
            title: 'Error de pedido',
            text: 'Datos imcompletos'
        });
        return;
    }
    
    var pedido = {
        action: "finalizarPedido",
        productos: productos,
        txtPrecioParcialVenta: document.querySelector('input[name="txtPrecioParcialVenta"]').value.trim() || '0',
        txtIGV_Venta: document.querySelector('input[name="txtIGV_Venta"]').value.trim() || '0',
        txtPrecioFinalVenta: document.querySelector('input[name="txtPrecioFinalVenta"]').value.trim() || '0'
    };

    fetch('PedidosA', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'X-Requested-With': 'XMLHttpRequest'
        },
        body: JSON.stringify(pedido)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return response.json();
    })
    .then(data => {
        console.log('Success:', data);
        Swal.fire({
                icon: 'success',
                title: 'Pedido finalizado!',
                text: 'El pedido ha sido generado exitosamente.',
                showConfirmButton: false,
                timer: 1500
            });
    })
    .catch((error) => {
        console.error('Error:', error);
        alert('Ocurrió un error al finalizar la venta');
    });

    document.querySelector('button.btn-success').addEventListener('click', finalizarPedido);
}
