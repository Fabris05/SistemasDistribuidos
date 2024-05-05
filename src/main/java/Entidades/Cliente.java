/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author fabri
 */
public class Cliente {
    
    private String Id;
    private String Apellidos;
    private String Nombres;
    private String Direccion;
    private String DNI;
    private String Telefono;
    private String Movil;

    public Cliente() {
    }

    public Cliente(String Id, String Apellidos, String Nombres, String Direccion, String DNI, String Telefono, String Movil) {
        this.Id = Id;
        this.Apellidos = Apellidos;
        this.Nombres = Nombres;
        this.Direccion = Direccion;
        this.DNI = DNI;
        this.Telefono = Telefono;
        this.Movil = Movil;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getMovil() {
        return Movil;
    }

    public void setMovil(String Movil) {
        this.Movil = Movil;
    }
    
    
    
    
}
