/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Entidades.Usuario;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author fabri
 */
public interface UsuarioData {
    List<Usuario> findAll();
    Usuario findById(int id);
    void agregarUsuario(Usuario usuario);
    void Editar(int id, Usuario usuario);
    String hashPassword(String pass);
    void Eliminar(int Id);
    boolean autenticarUsuario(HttpServletRequest request, String user, String pass);
    
    
    // Apartado de consultas
    
    public final String BUSCAR_USUARIO_ID="SELECT * FROM Usuario WHERE Id_Usuario=?";
    public final String ELIMINAR_USUARIO_ID="DELETE FROM Usuario WHERE Id_Usuario=?";
    public final String EDITAR_USUARIO_ID="UPDATE Usuario SET Nombre=?, apellidos=?, usuario=?, pass=?, nivel=?, estado=? "
            + "WHERE Id_Usuario=?";
    public final String VALIDAR_USUARIO="SELECT usuario, pass, nivel, estado, nombre FROM Usuario WHERE usuario= ?;";
}
