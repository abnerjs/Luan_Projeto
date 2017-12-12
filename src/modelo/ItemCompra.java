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
@Table(name = "item_compra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemCompra.findAll", query = "SELECT i FROM ItemCompra i")
    , @NamedQuery(name = "ItemCompra.findByCodProduto", query = "SELECT i FROM ItemCompra i WHERE i.itemCompraPK.codProduto = :codProduto")
    , @NamedQuery(name = "ItemCompra.findByCodCompra", query = "SELECT i FROM ItemCompra i WHERE i.itemCompraPK.codCompra = :codCompra")
    , @NamedQuery(name = "ItemCompra.findByQuantidade", query = "SELECT i FROM ItemCompra i WHERE i.quantidade = :quantidade")
    , @NamedQuery(name = "ItemCompra.findByValor", query = "SELECT i FROM ItemCompra i WHERE i.valor = :valor")})
public class ItemCompra implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ItemCompraPK itemCompraPK;
    @Column(name = "quantidade")
    private Integer quantidade;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private Double valor;
    @JoinColumn(name = "cod_compra", referencedColumnName = "cod_compra")
    @ManyToOne(optional = false)
    private Compra compra;
    @JoinColumn(name = "cod_produto", referencedColumnName = "cod_produto")
    @ManyToOne(optional = false)
    private Produto produto;

    public ItemCompra() {
    }

    public ItemCompra(ItemCompraPK itemCompraPK) {
        this.itemCompraPK = itemCompraPK;
    }

    public ItemCompra(int codProduto, int codCompra) {
        this.itemCompraPK = new ItemCompraPK(codProduto, codCompra);
    }

    public ItemCompraPK getItemCompraPK() {
        return itemCompraPK;
    }

    public void setItemCompraPK(ItemCompraPK itemCompraPK) {
        this.itemCompraPK = itemCompraPK;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
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
        hash += (itemCompraPK != null ? itemCompraPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemCompra)) {
            return false;
        }
        ItemCompra other = (ItemCompra) object;
        if ((this.itemCompraPK == null && other.itemCompraPK != null) || (this.itemCompraPK != null && !this.itemCompraPK.equals(other.itemCompraPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.ItemCompra[ itemCompraPK=" + itemCompraPK + " ]";
    }
    
}
