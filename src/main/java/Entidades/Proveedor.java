/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author fabri
 */
public class Proveedor {
    private int idProveedor;
    private String codigoProveedor;
    private String RUCProveedor;
    private String razonSocialProveedor;
    private String nombreProveedor;
    private String telefonoProveedor;
    private String emailProveedor;
    private String ubicacionProveedor;
    private String descripcionProveedor;

    public Proveedor() {
    }

    public Proveedor(String RUCProveedor, String razonSocialProveedor, String nombreProveedor, String telefonoProveedor, String emailProveedor, String ubicacionProveedor, String descripcionProveedor) {
        this.RUCProveedor = RUCProveedor;
        this.razonSocialProveedor = razonSocialProveedor;
        this.nombreProveedor = nombreProveedor;
        this.telefonoProveedor = telefonoProveedor;
        this.emailProveedor = emailProveedor;
        this.ubicacionProveedor = ubicacionProveedor;
        this.descripcionProveedor = descripcionProveedor;
    }
    
    
    
    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getCodigoProveedor() {
        return codigoProveedor;
    }

    public void setCodigoProveedor(String codigoProveedor) {
        this.codigoProveedor = codigoProveedor;
    }
    
    
    public String getRUCProveedor() {
        return RUCProveedor;
    }

    public void setRUCProveedor(String RUCProveedor) {
        this.RUCProveedor = RUCProveedor;
    }

    public String getRazonSocialProveedor() {
        return razonSocialProveedor;
    }

    public void setRazonSocialProveedor(String razonSocialProveedor) {
        this.razonSocialProveedor = razonSocialProveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getTelefonoProveedor() {
        return telefonoProveedor;
    }

    public void setTelefonoProveedor(String telefonoProveedor) {
        this.telefonoProveedor = telefonoProveedor;
    }

    public String getEmailProveedor() {
        return emailProveedor;
    }

    public void setEmailProveedor(String emailProveedor) {
        this.emailProveedor = emailProveedor;
    }

    public String getUbicacionProveedor() {
        return ubicacionProveedor;
    }

    public void setUbicacionProveedor(String ubicacionProveedor) {
        this.ubicacionProveedor = ubicacionProveedor;
    }

    public String getDescripcionProveedor() {
        return descripcionProveedor;
    }

    public void setDescripcionProveedor(String descripcionProveedor) {
        this.descripcionProveedor = descripcionProveedor;
    }
    
    

}
