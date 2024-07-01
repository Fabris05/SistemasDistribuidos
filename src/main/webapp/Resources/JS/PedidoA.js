function buscarCliente() {
    var tipoDocumento = document.querySelector('[name="cbxTipoDocumento"]').value;
    var numDocumento = document.querySelector('[name="txtNumDocumentoCliente"]').value;
    var emailCliente = document.querySelector('[name="txtEmailCliente"]').value;

    var data = {
        action: "buscarCliente",
        cbxTipoDocumento: tipoDocumento,
        txtNumDocumentoCliente: numDocumento,
        txtEmailCliente: emailCliente
    };

    fetch('/SistemasDistribuidos/PedidosA', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'X-Requested-With': 'XMLHttpRequest'
        },
        body: JSON.stringify(data)
    })
    .then(response => response.json())
    .then(data => {
        if (data.error) {
            Swal.fire({
                icon: 'error',
                title: 'Cliente no encontrado',
                text: data.error
                
            });
            limpiarCamposCliente();
        } else {
            Swal.fire({
                icon: 'success',
                title: 'Cliente encontrado',
                text: 'El cliente ha sido encontrado exitosamente.',
                showConfirmButton: false,
                timer: 1000
            });
            document.getElementById("nombreCliente").value = data.nombre;
            document.getElementById("emailCliente").value = data.correoElectronico;
        }
    })
    .catch(error => console.error('Error:', error));
}


function buscarProducto() {
    var codigoProducto = document.querySelector('[name="txtCodigoProductoVenta"]').value;
    // Aquí obtenemos el valor del campo txtCodigoProductoVenta
    
    var data = {
        action: "buscarProducto",
        txtcodigoProducto: codigoProducto
    };
    
    fetch('/SistemasDistribuidos/PedidosA', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'X-Requested-With': 'XMLHttpRequest'
        },
        body: JSON.stringify(data)
    })
    .then(response => response.json())
    .then(data => {
        if (data.error) {
            Swal.fire({
                icon: 'error',
                title: 'Producto no encontrado',
                text: data.error
                
            });
            limpiarCamposProducto();
        } else {
            Swal.fire({
                icon: 'success',
                title: 'Producto encontrado',
                text: 'El prooducto ha sido encontrado exitosamente.',
                showConfirmButton: false,
                timer: 1000
            });
            document.getElementById("codigoProducto").disabled= true;
            document.getElementById("nombreProducto").value =data.nombre;
            document.getElementById("stockProducto").value =data.stock;
            document.getElementById("precioUProducto").value =data.precio;
        }
    })
    .catch(error => console.error('Error:', error));
}

function limpiarCamposCliente() {
    document.getElementById("nombreCliente").value ="";
    document.getElementById("emailCliente").value ="";
}

function limpiarCamposProducto(){
    document.getElementById("nombreProducto").value ="";
    document.getElementById("cantidadProducto").value ="";
    document.getElementById("stockProducto").value ="";
    document.getElementById("precioUProducto").value ="";
}