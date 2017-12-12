/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author abner
 */
@Entity
@Table(name = "celular")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Celular.findAll", query = "SELECT c FROM Celular c")
    , @NamedQuery(name = "Celular.findByCodCelular", query = "SELECT c FROM Celular c WHERE c.codCelular = :codCelular")
    , @NamedQuery(name = "Celular.findByCor", query = "SELECT c FROM Celular c WHERE c.cor = :cor")
    , @NamedQuery(name = "Celular.findByModelo", query = "SELECT c FROM Celular c WHERE c.modelo = :modelo")
    , @NamedQuery(name = "Celular.findByMarca", query = "SELECT c FROM Celular c WHERE c.marca = :marca")
    , @NamedQuery(name = "Celular.findByImei", query = "SELECT c FROM Celular c WHERE c.imei = :imei")})
public class Celular implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_celular")
    private Integer codCelular;
    @Column(name = "cor")
    private String cor;
    @Column(name = "modelo")
    private String modelo;
    @Column(name = "marca")
    private String marca;
    @Column(name = "imei")
    private Integer imei;
    @ManyToOne
    private Cliente codCliente;

    public Celular() {
    }

    public Celular(Integer codCelular) {
        this.codCelular = codCelular;
    }

    public Integer getCodCelular() {
        return codCelular;
    }

    public void setCodCelular(Integer codCelular) {
        this.codCelular = codCelular;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getImei() {
        return imei;
    }

    public void setImei(Integer imei) {
        this.imei = imei;
    }

    public Cliente getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Cliente codCliente) {
        this.codCliente = codCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCelular != null ? codCelular.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Celular)) {
            return false;
        }
        Celular other = (Celular) object;
        if ((this.codCelular == null && other.codCelular != null) || (this.codCelular != null && !this.codCelular.equals(other.codCelular))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Celular[ codCelular=" + codCelular + " ]";
    }
    
}
