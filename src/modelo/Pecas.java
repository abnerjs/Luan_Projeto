/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "pecas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pecas.findAll", query = "SELECT p FROM Pecas p")
    , @NamedQuery(name = "Pecas.findByCodPeca", query = "SELECT p FROM Pecas p WHERE p.codPeca = :codPeca")
    , @NamedQuery(name = "Pecas.findByDescricao", query = "SELECT p FROM Pecas p WHERE p.descricao = :descricao")
    , @NamedQuery(name = "Pecas.findByQuant", query = "SELECT p FROM Pecas p WHERE p.quant = :quant")
    , @NamedQuery(name = "Pecas.findByValor", query = "SELECT p FROM Pecas p WHERE p.valor = :valor")})
public class Pecas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_peca")
    private Integer codPeca;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "quant")
    private Integer quant;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private Double valor;

    public Pecas() {
    }

    public Pecas(Integer codPeca) {
        this.codPeca = codPeca;
    }

    public Integer getCodPeca() {
        return codPeca;
    }

    public void setCodPeca(Integer codPeca) {
        this.codPeca = codPeca;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getQuant() {
        return quant;
    }

    public void setQuant(Integer quant) {
        this.quant = quant;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPeca != null ? codPeca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pecas)) {
            return false;
        }
        Pecas other = (Pecas) object;
        if ((this.codPeca == null && other.codPeca != null) || (this.codPeca != null && !this.codPeca.equals(other.codPeca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Pecas[ codPeca=" + codPeca + " ]";
    }
    
}
