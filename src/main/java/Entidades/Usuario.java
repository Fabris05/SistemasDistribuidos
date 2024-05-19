/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author fabri
 */
public class Usuario {
    private String idUsuario;
    private String nombreUsuario;
    private String apellidoUsuario;
    private String user;
    private String pass;
    private String nivel;
    private String estado;

    public Usuario() {
    }

    public Usuario(String nombreUsuario, String apellidoUsuario, String user, String pass, String nivel, String estado) {
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.user = user;
        this.pass = pass;
        this.nivel = nivel;
        this.estado = estado;
    }

    public Usuario(String idUsuario, String nombreUsuario, String apellidoUsuario, String user, String estado) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.user = user;
        this.estado = estado;
    }
    
    public Usuario(String user, String nivel) {
        this.user = user;
        this.nivel = nivel;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

  
}
