/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.venta.dao;

import com.venta.model.Persona;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author STEFAN
 */
public class PersonaDAO extends DAO {

    public void registrar(Persona per) throws Exception {

        try {
            this.conectar();
            PreparedStatement st = this.getCn().prepareStatement("INSERT INTO persona (nombre, sexo) values(?,?)");
            st.setString(1, per.getNombre());
            st.setString(2, per.getSexo());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally {
        this.cerrar();
        }
    }
    
    public List<Persona> listar() throws Exception{
        List<Persona> lista;
        ResultSet rs;
    try {
            this.conectar();
            PreparedStatement st = this.getCn().prepareStatement("SELECT id_persona, nombre, sexo FROM Persona");
           rs =  st.executeQuery();
           lista = new ArrayList();
           
           while (rs.next()) {  
               Persona per = new Persona();
               per.setIdPersona(rs.getInt("id_persona"));
               per.setNombre(rs.getString("nombre"));
               per.setSexo(rs.getString("sexo"));
               
               lista.add(per);
            
        }
          
        } catch (Exception e) {
            throw e;
        }finally {
        this.cerrar();
        }
     return lista;
    }
    
    public Persona leerID(Persona per) throws Exception {
            Persona pers = null;
            ResultSet rs;
        try {
            this.conectar();
            PreparedStatement st = this.getCn().prepareStatement("SELECT id_persona, nombre, sexo FROM Persona where id_persona= ?");
            st.setInt(1, per.getIdPersona());
             rs = st.executeQuery();
                while (rs.next()) {  
               pers = new Persona();
               pers.setIdPersona(rs.getInt("id_persona"));
               pers.setNombre(rs.getString("nombre"));
               pers.setSexo(rs.getString("sexo"));
               
              
            
        }
        } catch (Exception e) {
            throw e;
        }finally {
        this.cerrar();
        }
        return pers;
    }
   
    public void modificar(Persona per) throws Exception {

        try {
            this.conectar();
            PreparedStatement st = this.getCn().prepareStatement("UPDATE Persona SET nombre = ?, sexo = ? WHERE id_persona = ? ");
            st.setString(1, per.getNombre());
            st.setString(2, per.getSexo());
            st.setInt(3, per.getIdPersona());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally {
        this.cerrar();
        }
    }
    
    public void eliminar(Persona per) throws Exception {

        try {
            this.conectar();
            PreparedStatement st = this.getCn().prepareStatement("DELETE FROM  Persona  WHERE id_persona = ? ");
            st.setInt(1, per.getIdPersona());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally {
        this.cerrar();
        }
    }
}
