/*
 * To change this license header, choose License Headers in Project Proproties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.venta.dao;

import com.venta.model.Producto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author STEFAN
 */
public class ProductoDAO extends DAO{
    
    public void registrar(Producto pro) throws Exception {

        try {
            this.conectar();
            PreparedStatement st = this.getCn().prepareStatement("INSERT INTO Producto (nombre, precio) values(?,?)");
            st.setString(1, pro.getNombre());
            st.setDouble(2, pro.getPrecio());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally {
        this.cerrar();
        }
    }
    
    public List<Producto> listar() throws Exception{
        List<Producto> lista;
        ResultSet rs;
    try {
            this.conectar();
            PreparedStatement st = this.getCn().prepareStatement("SELECT producto_id, nombre, precio FROM Producto");
           rs =  st.executeQuery();
           lista = new ArrayList();
           
           while (rs.next()) {  
               Producto pro = new Producto();
               pro.setProductoId(rs.getInt("producto_id"));
               pro.setNombre(rs.getString("nombre"));
               pro.setPrecio(rs.getDouble("precio"));
               
               lista.add(pro);
            
        }
          
        } catch (Exception e) {
            throw e;
        }finally {
        this.cerrar();
        }
     return lista;
    }
    
    public Producto leerID(Producto pro) throws Exception {
            Producto prod = null;
            ResultSet rs;
        try {
            this.conectar();
            PreparedStatement st = this.getCn().prepareStatement("SELECT producto_id, nombre, precio FROM Producto where producto_id= ?");
            st.setInt(1, pro.getProductoId());
             rs = st.executeQuery();
                while (rs.next()) {  
               prod = new Producto();
               prod.setProductoId(rs.getInt("producto_id"));
               prod.setNombre(rs.getString("nombre"));
               prod.setPrecio(rs.getDouble("precio"));
               
              
            
        }
        } catch (Exception e) {
            throw e;
        }finally {
        this.cerrar();
        }
        return prod;
    }
   
    public void modificar(Producto pro) throws Exception {

        try {
            this.conectar();
            PreparedStatement st = this.getCn().prepareStatement("UPDATE Producto SET nombre = ?, precio = ? WHERE producto_id = ? ");
            st.setString(1, pro.getNombre());
            st.setDouble(2, pro.getPrecio());
            st.setInt(3, pro.getProductoId());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally {
        this.cerrar();
        }
    }
    
    public void eliminar(Producto pro) throws Exception {

        try {
            this.conectar();
            PreparedStatement st = this.getCn().prepareStatement("DELETE FROM  Producto  WHERE producto_id = ? ");
            st.setInt(1, pro.getProductoId());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally {
        this.cerrar();
        }
    }
}
