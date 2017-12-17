/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.venta.bean;

import com.venta.dao.PersonaDAO;
import com.venta.model.Persona;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author STEFAN
 */
@Named(value = "personaBean")
@ManagedBean
@ViewScoped
public class PersonaBean {

    private Persona persona = new Persona();
    private List<Persona> listPersonas;
    private String accion;

    public PersonaBean() {
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<Persona> getListPersonas() {
        return listPersonas;
    }

    public void setListPersonas(List<Persona> listPersonas) {
        this.listPersonas = listPersonas;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.limpiar();
        this.accion = accion;

    }

    private boolean isPostBack() {

        boolean respuesta;
        respuesta = FacesContext.getCurrentInstance().isPostback();
        return respuesta;
    }

    public void operar() throws Exception {

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

    private void limpiar() {
        this.persona.setIdPersona(0);
        this.persona.setNombre("");
        this.persona.setSexo("");

    }

    private void registar() throws Exception {
        PersonaDAO dao;
        try {
            dao = new PersonaDAO();
            dao.registrar(persona);
            this.listar("V");

        } catch (Exception e) {
            throw e;
        }
    }

    private void modificar() throws Exception {
        PersonaDAO dao;
        try {
            dao = new PersonaDAO();
            dao.modificar(persona);
            this.listar("V");

        } catch (Exception e) {
            throw e;
        }
    }

    public void listar(String valor) throws Exception {
        PersonaDAO dao;
        try {
            if (valor.equals("F")) {
                if (isPostBack() == false) {

                    dao = new PersonaDAO();
                    listPersonas = dao.listar();
                }
            } else {
                dao = new PersonaDAO();
                listPersonas = dao.listar();
            }

        } catch (Exception e) {
            throw e;
        }
    }

    public void leerID(Persona per) throws Exception {
        PersonaDAO dao;
        Persona temp;
        try {
            dao = new PersonaDAO();
            temp = dao.leerID(per);

            if (temp != null) {
                this.persona = temp;
                this.accion = "modificar";
            }

        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminar(Persona per) throws Exception {
        PersonaDAO dao;
        try {
            dao = new PersonaDAO();
            dao.eliminar(per);
            this.listar("V");

        } catch (Exception e) {
            throw e;
        }
    }

}
