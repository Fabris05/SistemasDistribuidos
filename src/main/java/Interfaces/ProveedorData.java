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
    List<Proveedor> findProveedores();
    
    public final String BUSCAR_ID_NOMBRE_PROVEEDOR="SELECT Id_Proveedor, proveedor FROM Proveedor";
}
