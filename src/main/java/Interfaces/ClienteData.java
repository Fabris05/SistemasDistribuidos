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
    void Guardar(Cliente cliente);
    void Eliminar(String Id);
    String generarID();
}
