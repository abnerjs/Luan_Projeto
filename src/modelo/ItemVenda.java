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
@Table(name = "item_venda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemVenda.findAll", query = "SELECT i FROM ItemVenda i")
    , @NamedQuery(name = "ItemVenda.findByCodVenda", query = "SELECT i FROM ItemVenda i WHERE i.itemVendaPK.codVenda = :codVenda")
    , @NamedQuery(name = "ItemVenda.findByCodProduto", query = "SELECT i FROM ItemVenda i WHERE i.itemVendaPK.codProduto = :codProduto")
    , @NamedQuery(name = "ItemVenda.findByValor", query = "SELECT i FROM ItemVenda i WHERE i.valor = :valor")
    , @NamedQuery(name = "ItemVenda.findByQuant", query = "SELECT i FROM ItemVenda i WHERE i.quant = :quant")})
public class ItemVenda implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ItemVendaPK itemVendaPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private Double valor;
    @Column(name = "quant")
    private Integer quant;
    @JoinColumn(name = "cod_venda", referencedColumnName = "cod_venda")
    @ManyToOne(optional = false)
    private Venda venda;
    @JoinColumn(name = "cod_produto", referencedColumnName = "cod_produto")
    @ManyToOne(optional = false)
    private Produto produto;

    public ItemVenda() {
    }

    public ItemVenda(ItemVendaPK itemVendaPK) {
        this.itemVendaPK = itemVendaPK;
    }

    public ItemVenda(int codVenda, int codProduto) {
        this.itemVendaPK = new ItemVendaPK(codVenda, codProduto);
    }

    public ItemVendaPK getItemVendaPK() {
        return itemVendaPK;
    }

    public void setItemVendaPK(ItemVendaPK itemVendaPK) {
        this.itemVendaPK = itemVendaPK;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getQuant() {
        return quant;
    }

    public void setQuant(Integer quant) {
        this.quant = quant;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemVendaPK != null ? itemVendaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemVenda)) {
            return false;
        }
        ItemVenda other = (ItemVenda) object;
        if ((this.itemVendaPK == null && other.itemVendaPK != null) || (this.itemVendaPK != null && !this.itemVendaPK.equals(other.itemVendaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.ItemVenda[ itemVendaPK=" + itemVendaPK + " ]";
    }
    
}
