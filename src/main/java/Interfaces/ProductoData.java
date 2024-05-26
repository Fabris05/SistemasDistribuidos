/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Entidades.Producto;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author fabri
 */
public interface ProductoData {
    List<Producto> findAll();
    Producto findById(String id);
    void agregarProducto(Producto producto);
    void Editar(String id, Producto producto);
    void Eliminar(String Id);
    String generarID();
    Date parseDate(String date);
    public final String BUSCAR_PRODUCTOS_TABLA="SELECT CodigoProducto, nombreProducto, precioProducto, cantidadProducto, caducidadProducto "
            + "FROM Producto;";
    public final String BUSCAR_PRODUCTOS_ID = "SELECT CodigoProducto, nombreProducto, cantidadProducto, precioProducto, caducidadProducto, Proveedor.proveedor as 'Proveedor', Categoria.categoria as 'Categoria', Almacen.almacen as 'Almacen', descripcionProducto FROM Producto "
            + "INNER JOIN Proveedor ON  Producto.idProveedorProducto=Proveedor.Id_Proveedor "
            + "INNER JOIN Categoria ON Producto.idCategoriaProducto = Categoria.idCategoria "
            + "INNER JOIN Almacen ON Producto.idAlmacenProducto = Almacen.idAlmacen "
            + "WHERE CodigoProducto=? ;";
    public final String AGREGAR_PRODUCTO = "INSERT INTO Producto (CodigoProducto, nombreProducto, cantidadProducto, precioProducto, caducidadProducto, idProveedorProducto, idCategoriaProducto, idAlmacenProducto, descripcionProducto) "
            + "VALUES (?, ?, ?, ?, ?, ?,?,?,?);";
    public final String ELIMINAR_PRODUCTO="DELETE FROM Producto WHERE CodigoProducto=?";
    public final String BUSCAR_MAXIMO_CODIGO = "SELECT MAX(CAST(SUBSTRING(CodigoProducto, 2) AS UNSIGNED)) AS MaxCode FROM Producto;";
}
