/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.EJB.CategoriaFacade;
import com.mycompany.EJB.CategoriaFacadeLocal;
import com.mycompany.model.Categoria;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author STEFAN
 */
@Named
@ViewScoped
public class CategoriaController implements Serializable {
    
    @EJB
    CategoriaFacadeLocal categoriaEJB;
    private Categoria categoria;
    
    @PostConstruct
    public void init(){
        categoria = new Categoria();
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    public void registrar(){
        
        try {
            categoriaEJB.create(categoria);
            
        } catch (Exception e) {
            //mensaje
        }
        
    }
}
