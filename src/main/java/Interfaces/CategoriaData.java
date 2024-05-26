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
    
    public final String BUSCAR_ID_NOMBRE_CATEGORIA="SELECT idCategoria, categoria FROM Categoria";
}
