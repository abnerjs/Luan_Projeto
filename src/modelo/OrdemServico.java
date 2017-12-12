/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author abner
 */
@Entity
@Table(name = "ordem_servico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdemServico.findAll", query = "SELECT o FROM OrdemServico o")
    , @NamedQuery(name = "OrdemServico.findByCodOrdem", query = "SELECT o FROM OrdemServico o WHERE o.codOrdem = :codOrdem")
    , @NamedQuery(name = "OrdemServico.findByDataChegada", query = "SELECT o FROM OrdemServico o WHERE o.dataChegada = :dataChegada")
    , @NamedQuery(name = "OrdemServico.findByDateTermino", query = "SELECT o FROM OrdemServico o WHERE o.dateTermino = :dateTermino")
    , @NamedQuery(name = "OrdemServico.findByTotalNota", query = "SELECT o FROM OrdemServico o WHERE o.totalNota = :totalNota")
    , @NamedQuery(name = "OrdemServico.findByDesconto", query = "SELECT o FROM OrdemServico o WHERE o.desconto = :desconto")
    , @NamedQuery(name = "OrdemServico.findByValorPago", query = "SELECT o FROM OrdemServico o WHERE o.valorPago = :valorPago")})
public class OrdemServico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_ordem")
    private Integer codOrdem;
    @Column(name = "data_chegada")
    @Temporal(TemporalType.DATE)
    private Date dataChegada;
    @Column(name = "date_termino")
    @Temporal(TemporalType.DATE)
    private Date dateTermino;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total_nota")
    private Double totalNota;
    @Column(name = "desconto")
    private Double desconto;
    @Column(name = "valor_pago")
    private Double valorPago;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ordemServico")
    private Collection<ItensServico> itensServicoCollection;
    @JoinColumn(name = "cod_celular", referencedColumnName = "cod_celular")
    @ManyToOne
    private Celular codCelular;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ordemServico")
    private Collection<PecasServico> pecasServicoCollection;

    public OrdemServico() {
    }

    public OrdemServico(Integer codOrdem) {
        this.codOrdem = codOrdem;
    }

    public Integer getCodOrdem() {
        return codOrdem;
    }

    public void setCodOrdem(Integer codOrdem) {
        this.codOrdem = codOrdem;
    }

    public Date getDataChegada() {
        return dataChegada;
    }

    public void setDataChegada(Date dataChegada) {
        this.dataChegada = dataChegada;
    }

    public Date getDateTermino() {
        return dateTermino;
    }

    public void setDateTermino(Date dateTermino) {
        this.dateTermino = dateTermino;
    }

    public Double getTotalNota() {
        return totalNota;
    }

    public void setTotalNota(Double totalNota) {
        this.totalNota = totalNota;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public Double getValorPago() {
        return valorPago;
    }

    public void setValorPago(Double valorPago) {
        this.valorPago = valorPago;
    }

    @XmlTransient
    public Collection<ItensServico> getItensServicoCollection() {
        return itensServicoCollection;
    }

    public void setItensServicoCollection(Collection<ItensServico> itensServicoCollection) {
        this.itensServicoCollection = itensServicoCollection;
    }

    public Celular getCodCelular() {
        return codCelular;
    }

    public void setCodCelular(Celular codCelular) {
        this.codCelular = codCelular;
    }

    @XmlTransient
    public Collection<PecasServico> getPecasServicoCollection() {
        return pecasServicoCollection;
    }

    public void setPecasServicoCollection(Collection<PecasServico> pecasServicoCollection) {
        this.pecasServicoCollection = pecasServicoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codOrdem != null ? codOrdem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdemServico)) {
            return false;
        }
        OrdemServico other = (OrdemServico) object;
        if ((this.codOrdem == null && other.codOrdem != null) || (this.codOrdem != null && !this.codOrdem.equals(other.codOrdem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.OrdemServico[ codOrdem=" + codOrdem + " ]";
    }
    
}
