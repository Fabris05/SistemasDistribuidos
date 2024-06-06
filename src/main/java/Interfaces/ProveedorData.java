/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Entidades.Proveedor;
import java.util.List;

/**
 *
 * @author fabri
 */
public interface ProveedorData {
    
    List<Proveedor> findAll();
    Proveedor findById(String codigo);
    void registrarProveedor(Proveedor proveedor);
    void eliminarProveedor(String codigo);
    String generarID();
    List<Proveedor> findProveedores();
    
    // Consultas proveedor
    public final String BUSCAR_PROVEEDOR_CODIGO = "SELECT CodigoProveedor,RUC, razonSocial, proveedor, telefono, email, ubicacion, descripcion FROM Proveedor "
            + "WHERE CodigoProveedor=?;";
    public final String BUSCAR_PROVEEDORES = "SELECT CodigoProveedor, RUC, proveedor, telefono, email FROM Proveedor;";
    public final String BUSCAR_ID_NOMBRE_PROVEEDOR = "SELECT Id_Proveedor, proveedor FROM Proveedor;";
    public final String AGREGAR_PROVEEDOR = "INSERT INTO Proveedor(CodigoProveedor,RUC, razonSocial, proveedor, telefono, email, ubicacion, descripcion) "
            + "VALUES (?,?,?,?,?,?,?,?);";
    public final String ELIMINAR_PROVEEDOR = "DELETE FROM Proveedor WHERE CodigoProveedor=?;";

}
