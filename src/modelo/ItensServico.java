/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author abner
 */
@Entity
@Table(name = "itens_servico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItensServico.findAll", query = "SELECT i FROM ItensServico i")
    , @NamedQuery(name = "ItensServico.findByCodOrdem", query = "SELECT i FROM ItensServico i WHERE i.itensServicoPK.codOrdem = :codOrdem")
    , @NamedQuery(name = "ItensServico.findByCodServ", query = "SELECT i FROM ItensServico i WHERE i.itensServicoPK.codServ = :codServ")
    , @NamedQuery(name = "ItensServico.findByValor", query = "SELECT i FROM ItensServico i WHERE i.valor = :valor")})
public class ItensServico implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ItensServicoPK itensServicoPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private Double valor;
    @JoinColumn(name = "cod_ordem", referencedColumnName = "cod_ordem")
    @ManyToOne(optional = false)
    private OrdemServico ordemServico;
    @JoinColumn(name = "cod_serv", referencedColumnName = "cod_servico")
    @ManyToOne(optional = false)
    private Servicos servicos;

    public ItensServico() {
    }

    public ItensServico(ItensServicoPK itensServicoPK) {
        this.itensServicoPK = itensServicoPK;
    }

    public ItensServico(int codOrdem, int codServ) {
        this.itensServicoPK = new ItensServicoPK(codOrdem, codServ);
    }

    public ItensServicoPK getItensServicoPK() {
        return itensServicoPK;
    }

    public void setItensServicoPK(ItensServicoPK itensServicoPK) {
        this.itensServicoPK = itensServicoPK;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public OrdemServico getOrdemServico() {
        return ordemServico;
    }

    public void setOrdemServico(OrdemServico ordemServico) {
        this.ordemServico = ordemServico;
    }

    public Servicos getServicos() {
        return servicos;
    }

    public void setServicos(Servicos servicos) {
        this.servicos = servicos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itensServicoPK != null ? itensServicoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItensServico)) {
            return false;
        }
        ItensServico other = (ItensServico) object;
        if ((this.itensServicoPK == null && other.itensServicoPK != null) || (this.itensServicoPK != null && !this.itensServicoPK.equals(other.itensServicoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.ItensServico[ itensServicoPK=" + itensServicoPK + " ]";
    }
    
}
