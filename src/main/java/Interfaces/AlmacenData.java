/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Entidades.Almacen;
import java.util.List;

/**
 *
 * @author fabri
 */
public interface AlmacenData {
    List<Almacen> findAlmacenes();
    
    public final String BUSCAR_ID_NOMBRE_ALMACEN="Select idAlmacen, almacen FROM Almacen";
}
