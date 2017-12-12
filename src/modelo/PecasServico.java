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
@Table(name = "pecas_servico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PecasServico.findAll", query = "SELECT p FROM PecasServico p")
    , @NamedQuery(name = "PecasServico.findByCodOrdem", query = "SELECT p FROM PecasServico p WHERE p.pecasServicoPK.codOrdem = :codOrdem")
    , @NamedQuery(name = "PecasServico.findByCodPeca", query = "SELECT p FROM PecasServico p WHERE p.pecasServicoPK.codPeca = :codPeca")
    , @NamedQuery(name = "PecasServico.findByValor", query = "SELECT p FROM PecasServico p WHERE p.valor = :valor")})
public class PecasServico implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PecasServicoPK pecasServicoPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private Double valor;
    @JoinColumn(name = "cod_ordem", referencedColumnName = "cod_ordem")
    @ManyToOne(optional = false)
    private OrdemServico ordemServico;
    @JoinColumn(name = "cod_peca", referencedColumnName = "cod_peca")
    @ManyToOne(optional = false)
    private Pecas pecas;

    public PecasServico() {
    }

    public PecasServico(PecasServicoPK pecasServicoPK) {
        this.pecasServicoPK = pecasServicoPK;
    }

    public PecasServico(int codOrdem, int codPeca) {
        this.pecasServicoPK = new PecasServicoPK(codOrdem, codPeca);
    }

    public PecasServicoPK getPecasServicoPK() {
        return pecasServicoPK;
    }

    public void setPecasServicoPK(PecasServicoPK pecasServicoPK) {
        this.pecasServicoPK = pecasServicoPK;
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

    public Pecas getPecas() {
        return pecas;
    }

    public void setPecas(Pecas pecas) {
        this.pecas = pecas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pecasServicoPK != null ? pecasServicoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PecasServico)) {
            return false;
        }
        PecasServico other = (PecasServico) object;
        if ((this.pecasServicoPK == null && other.pecasServicoPK != null) || (this.pecasServicoPK != null && !this.pecasServicoPK.equals(other.pecasServicoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.PecasServico[ pecasServicoPK=" + pecasServicoPK + " ]";
    }
    
}
