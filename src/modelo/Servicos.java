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
@Table(name = "servicos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servicos.findAll", query = "SELECT s FROM Servicos s")
    , @NamedQuery(name = "Servicos.findByCodServico", query = "SELECT s FROM Servicos s WHERE s.codServico = :codServico")
    , @NamedQuery(name = "Servicos.findByDescricao", query = "SELECT s FROM Servicos s WHERE s.descricao = :descricao")
    , @NamedQuery(name = "Servicos.findByValor", query = "SELECT s FROM Servicos s WHERE s.valor = :valor")})
public class Servicos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_servico")
    private Integer codServico;
    @Column(name = "descricao")
    private String descricao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private Double valor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "servicos")
    private Collection<ItensServico> itensServicoCollection;

    public Servicos() {
    }

    public Servicos(Integer codServico) {
        this.codServico = codServico;
    }

    public Integer getCodServico() {
        return codServico;
    }

    public void setCodServico(Integer codServico) {
        this.codServico = codServico;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @XmlTransient
    public Collection<ItensServico> getItensServicoCollection() {
        return itensServicoCollection;
    }

    public void setItensServicoCollection(Collection<ItensServico> itensServicoCollection) {
        this.itensServicoCollection = itensServicoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codServico != null ? codServico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servicos)) {
            return false;
        }
        Servicos other = (Servicos) object;
        if ((this.codServico == null && other.codServico != null) || (this.codServico != null && !this.codServico.equals(other.codServico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Servicos[ codServico=" + codServico + " ]";
    }
    
}
