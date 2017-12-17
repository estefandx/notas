
package com.venta.bean;

import com.venta.dao.VentaDAO;
import com.venta.model.DetalleVenta;
import com.venta.model.Producto;
import com.venta.model.Venta;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class VentaBean {
    
    private Venta venta  = new Venta();
    private Producto producto = new Producto();
    private int cantidad;
    private List<DetalleVenta> lista  = new ArrayList();

    public VentaBean() {
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public List<DetalleVenta> getLista() {
        return lista;
    }

    public void setLista(List<DetalleVenta> lista) {
        this.lista = lista;
    }
    
    public void agregar(){
        DetalleVenta detalle = new DetalleVenta();
        detalle.setCantidad(cantidad);
        detalle.setProducto(producto);
        this.lista.add(detalle);
        
    }
    
    
    public void registrar(){
        VentaDAO dao;
        double monto = 0;
        try {
            for (DetalleVenta detalle : lista) {
                monto += detalle.getProducto().getPrecio()*detalle.getCantidad();
            }
  
          dao = new VentaDAO();
            venta.setMonto(monto);
            
            dao.registrar(venta, lista);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("aviso de exito"));
                
          
        } catch (Exception e) {
        }finally{
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            
        }
        
        
    }
    
    
    
    
    
}
