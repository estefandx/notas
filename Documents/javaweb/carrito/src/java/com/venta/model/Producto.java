/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.venta.model;

/**
 *
 * @author STEFAN
 */
public class Producto {
    
    private int productoId;
    private String nombre;
    private double precio;

    @Override
    public String toString() {
         return String.format("%s[productoId=%d]", getClass().getSimpleName(), getProductoId());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.productoId;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producto other = (Producto) obj;
        if (this.productoId != other.productoId) {
            return false;
        }
        return true;
    }
    
    

    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
    
}
