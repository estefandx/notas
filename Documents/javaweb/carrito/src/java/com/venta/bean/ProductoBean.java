/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.venta.bean;

import com.venta.dao.ProductoDAO;
import com.venta.model.Producto;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author STEFAN
 */
@Named(value = "productoBean")
@ManagedBean
@ViewScoped
public class ProductoBean {

    private Producto producto = new Producto();
    private List<Producto> listProductos;
    private String accion;
    
     public ProductoBean() {
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public List<Producto> getListProductos() {
        return listProductos;
    }

    public void setListProductos(List<Producto> listProductos) {
        this.listProductos = listProductos;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.limpiar();
        this.accion = accion;
        
    }
    
    public void operar() throws Exception{
        
        switch (accion) {
            case "registrar":
                this.registar();
                this.limpiar();
                break;
            case "modificar":
                this.modificar();
                this.limpiar();
                break;    
            
        }
    }
    
    private void limpiar(){
        this.producto.setProductoId(0);
        this.producto.setNombre("");
        this.producto.setPrecio(0);
    
    }
    
    private void registar() throws Exception {
        ProductoDAO dao;
        try {
            dao = new ProductoDAO();
            dao.registrar(producto);
            this.listar();
            

        } catch (Exception e) {
            throw e;
        }
    }
    
      private void modificar() throws Exception {
        ProductoDAO dao;
        try {
            dao = new ProductoDAO();
            dao.modificar(producto);
            this.listar();

        } catch (Exception e) {
            throw e;
        }
    }
    
    public void listar() throws Exception {
        ProductoDAO dao;
        try {
            dao = new ProductoDAO();
           listProductos =  dao.listar();

        } catch (Exception e) {
            throw e;
        }
    }
    
    public void leerID(Producto per) throws Exception {
        ProductoDAO dao;
        Producto temp;
        try {
            dao = new ProductoDAO();
            temp = dao.leerID(per);
            
            if (temp != null) {
                this.producto = temp;
                this.accion = "modificar";
            }

        } catch (Exception e) {
            throw e;
        }
    }
    
   
     
     public void eliminar(Producto per) throws Exception {
        ProductoDAO dao;
        try {
            dao = new ProductoDAO();
            dao.eliminar(per);
            this.listar();

        } catch (Exception e) {
            throw e;
        }
    }
   
    
}
