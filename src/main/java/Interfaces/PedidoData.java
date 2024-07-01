/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Entidades.Pedido;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fabri
 */
public interface PedidoData {
    
    List<Pedido> findAllPedidos();
    List<Pedido> findAllDetallePedidos(int idPedido);
    void agregarPedido(Pedido pedido, List<Pedido> productosPedido, HttpServletRequest request);
    String generarCodigo();

    //Consultas SQL
    public final String BUSCAR_PEDIDOS = "SELECT Codigo_Pedido, concat(Cliente.Nombres, ' ' ,Cliente.Apellidos) as 'Cliente' , Cliente.numeroDocumento, Fecha, SubTotal, IGV, Total FROM Pedido "
            + "INNER JOIN Cliente ON Pedido.Id_Cliente = Cliente.Id_Cliente;";

    public final String BUSCAR_DETALLE_PEDIDO = " SELECT codigoProducto, nombreProducto, Cantidad, Precio_Unit, Total FROM Detalle_Pedido "
            + "WHERE IdPedido=?;";

    public final String AGREGAR_NUEVO_PEDIDO = "INSERT INTO Pedido (Codigo_Pedido, Id_Cliente, Fecha, SubTotal, IGV, Total, Id_Usuario) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?);";

    public final String AGREGAR_DETALLE_PEDIDO = "INSERT INTO Detalle_Pedido (IdPedido, codigoProducto, nombreProducto, Cantidad, Precio_Unit, Total) "
            + "VALUES (?,?,?,?,?,?);";
    
}
