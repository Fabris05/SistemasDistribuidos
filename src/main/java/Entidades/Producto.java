/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.sql.Date;

/**
 *
 * @author fabri
 */
public class Producto {
    private String idProducto;
    private String codigoProducto;
    private String nombreProducto;
    private int cantidadProducto;
    private double precioProducto;
    private Date caducidadProducto;
    private String proveedorProducto;
    private String categoriaProducto;
    private String almacenProducto;
    private int idProveedorProducto;
    private int idAlmacenProducto;
    private int idCategoriaProducto;
    
    private String descripcionProducto;

    public Producto() {
    }

    public Producto(String codigoProducto, String nombreProducto, int cantidadProducto, double precioProducto, Date caducidadProducto, int idProveedorProducto, int idAlmacenProducto, int idCategoriaProducto, String descripcionProducto) {
        this.codigoProducto = codigoProducto;
        this.nombreProducto = nombreProducto;
        this.cantidadProducto = cantidadProducto;
        this.precioProducto = precioProducto;
        this.caducidadProducto = caducidadProducto;
        this.idProveedorProducto = idProveedorProducto;
        this.idAlmacenProducto = idAlmacenProducto;
        this.idCategoriaProducto = idCategoriaProducto;
        this.descripcionProducto = descripcionProducto;
    }
    
    
    
    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public Date getCaducidadProducto() {
        return caducidadProducto;
    }

    public void setCaducidadProducto(Date caducidadProducto) {
        this.caducidadProducto = caducidadProducto;
    }

    public String getProveedorProducto() {
        return proveedorProducto;
    }

    public void setProveedorProducto(String proveedorProducto) {
        this.proveedorProducto = proveedorProducto;
    }

    
    
    public String getCategoriaProducto() {
        return categoriaProducto;
    }

    public void setCategoriaProducto(String categoriaProducto) {
        this.categoriaProducto = categoriaProducto;
    }

    public String getAlmacenProducto() {
        return almacenProducto;
    }

    public void setAlmacenProducto(String almacenProducto) {
        this.almacenProducto = almacenProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public int getIdProveedorProducto() {
        return idProveedorProducto;
    }

    public void setIdProveedorProducto(int idProveedorProducto) {
        this.idProveedorProducto = idProveedorProducto;
    }

    public int getIdAlmacenProducto() {
        return idAlmacenProducto;
    }

    public void setIdAlmacenProducto(int idAlmacenProducto) {
        this.idAlmacenProducto = idAlmacenProducto;
    }

    public int getIdCategoriaProducto() {
        return idCategoriaProducto;
    }

    public void setIdCategoriaProducto(int idCategoriaProducto) {
        this.idCategoriaProducto = idCategoriaProducto;
    }
    
    
    
}
