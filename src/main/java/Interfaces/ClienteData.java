/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Entidades.Cliente;
import java.util.List;

/**
 *
 * @author fabri
 */
public interface ClienteData {
    List<Cliente> findAll();
    Cliente findById(String id);
    Cliente findByDocumento(String tipoDocumento, String numDocumento);
    void Editar(String id, Cliente cliente);
    void Guardar(Cliente cliente);
    void Eliminar(String Id);
    String generarID();
    
    //Consultas
    
    public final String BUSCAR_CLIENTE_DOCUMENTO="SELECT * FROM Cliente WHERE TipoDocumento=? and numeroDocumento=?;";
}
