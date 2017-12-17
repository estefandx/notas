/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author STEFAN
 */
@Entity
@Table(name = "nota")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nota.findAll", query = "SELECT n FROM Nota n")
    , @NamedQuery(name = "Nota.findByCodigo", query = "SELECT n FROM Nota n WHERE n.codigo = :codigo")
    , @NamedQuery(name = "Nota.findByEncabezado", query = "SELECT n FROM Nota n WHERE n.encabezado = :encabezado")
    , @NamedQuery(name = "Nota.findByCuerpo", query = "SELECT n FROM Nota n WHERE n.cuerpo = :cuerpo")
    , @NamedQuery(name = "Nota.findByFecha", query = "SELECT n FROM Nota n WHERE n.fecha = :fecha")
    , @NamedQuery(name = "Nota.findByComentarioAdmin", query = "SELECT n FROM Nota n WHERE n.comentarioAdmin = :comentarioAdmin")
    , @NamedQuery(name = "Nota.findByValorizacion", query = "SELECT n FROM Nota n WHERE n.valorizacion = :valorizacion")})
public class Nota implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "encabezado")
    private String encabezado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "cuerpo")
    private String cuerpo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Size(max = 50)
    @Column(name = "comentarioAdmin")
    private String comentarioAdmin;
    @Size(max = 2)
    @Column(name = "valorizacion")
    private String valorizacion;
    @JoinColumn(name = "codigo_categoria", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Categoria codigoCategoria;
    @JoinColumn(name = "codigo_persona", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Persona codigoPersona;

    public Nota() {
    }

    public Nota(Integer codigo) {
        this.codigo = codigo;
    }

    public Nota(Integer codigo, String encabezado, String cuerpo, Date fecha) {
        this.codigo = codigo;
        this.encabezado = encabezado;
        this.cuerpo = cuerpo;
        this.fecha = fecha;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getEncabezado() {
        return encabezado;
    }

    public void setEncabezado(String encabezado) {
        this.encabezado = encabezado;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getComentarioAdmin() {
        return comentarioAdmin;
    }

    public void setComentarioAdmin(String comentarioAdmin) {
        this.comentarioAdmin = comentarioAdmin;
    }

    public String getValorizacion() {
        return valorizacion;
    }

    public void setValorizacion(String valorizacion) {
        this.valorizacion = valorizacion;
    }

    public Categoria getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(Categoria codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }

    public Persona getCodigoPersona() {
        return codigoPersona;
    }

    public void setCodigoPersona(Persona codigoPersona) {
        this.codigoPersona = codigoPersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nota)) {
            return false;
        }
        Nota other = (Nota) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.model.Nota[ codigo=" + codigo + " ]";
    }
    
}
