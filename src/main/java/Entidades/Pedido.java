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
public class Pedido extends Producto{
    private String id;
    private String codigo;
    private String idCliente;
    private String cliente;
    private String numDocumento;
    private Date fecha;
    private double subTotal;
    private double igv;
    private double total;
    private int idUser;
    private double precioU;
    private double precioF;
    

    public Pedido() {
    }

    public Pedido(String idCliente, double subTotal, double igv, double total, int idUser) {
        this.idCliente = idCliente;
        this.subTotal = subTotal;
        this.igv = igv;
        this.total = total;
        this.idUser = idUser;
    }

    public Pedido(double precioU, double precioF, String codigoProducto, String nombreProducto, int cantidadProducto) {
        super(codigoProducto, nombreProducto, cantidadProducto);
        this.precioU = precioU;
        this.precioF = precioF;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }  

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }
    
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getIgv() {
        return igv;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public double getPrecioU() {
        return precioU;
    }

    public void setPrecioU(double precioU) {
        this.precioU = precioU;
    }

    public double getPrecioF() {
        return precioF;
    }

    public void setPrecioF(double precioF) {
        this.precioF = precioF;
    }
    
}
