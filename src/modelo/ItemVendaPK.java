/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author abner
 */
@Embeddable
public class ItemVendaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "cod_venda", insertable = false, updatable = false)
    private int codVenda;
    @Basic(optional = false)
    @Column(name = "cod_produto", insertable = false, updatable = false)
    private int codProduto;

    public ItemVendaPK() {
    }

    public ItemVendaPK(int codVenda, int codProduto) {
        this.codVenda = codVenda;
        this.codProduto = codProduto;
    }

    public int getCodVenda() {
        return codVenda;
    }

    public void setCodVenda(int codVenda) {
        this.codVenda = codVenda;
    }

    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codVenda;
        hash += (int) codProduto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemVendaPK)) {
            return false;
        }
        ItemVendaPK other = (ItemVendaPK) object;
        if (this.codVenda != other.codVenda) {
            return false;
        }
        if (this.codProduto != other.codProduto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.ItemVendaPK[ codVenda=" + codVenda + ", codProduto=" + codProduto + " ]";
    }
    
}
