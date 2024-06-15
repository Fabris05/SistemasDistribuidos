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
    void agregarAlmacen(Almacen almacen);
    
    public final String BUSCAR_ID_NOMBRE_ALMACEN="Select idAlmacen, almacen, ubicacion, descripcion FROM Almacen";
    public final String AGREGAR_ALMACEN="INSERT INTO Almacen (almacen, ubicacion,descripcion) VALUES (?, ?, ?);";
}
