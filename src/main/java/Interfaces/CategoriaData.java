/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Entidades.Categoria;
import java.util.List;

/**
 *
 * @author fabri
 */
public interface CategoriaData {
    List<Categoria> findCategorias();
    void agregarCategoria(Categoria categoria);
    void eliminarCategoria(int id);
    
    public final String BUSCAR_ID_NOMBRE_CATEGORIA="SELECT idCategoria, categoria, descripcionCategoria FROM Categoria";
    public final String AGREGAR_CATEGORIA="INSERT INTO Categoria (categoria, descripcionCategoria) VALUES (?, ?);";
    public final String ELIMINAR_CATEGORIA="DELETE FROM Categoria WHERE idCategoria=?";
}
