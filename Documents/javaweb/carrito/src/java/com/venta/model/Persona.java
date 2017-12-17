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
public class Persona {

    private int idPersona;
    private String nombre;
    private String sexo;

    @Override
    public String toString() {
       return String.format("%s[idPersona=%d]", getClass().getSimpleName(), getIdPersona());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.idPersona;
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
        final Persona other = (Persona) obj;
        if (this.idPersona != other.idPersona) {
            return false;
        }
        return true;
    }
    
    

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    

}
