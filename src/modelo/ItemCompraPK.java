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
public class ItemCompraPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "cod_produto", insertable = false, updatable = false)
    private int codProduto;
    @Basic(optional = false)
    @Column(name = "cod_compra", insertable = false, updatable = false)
    private int codCompra;

    public ItemCompraPK() {
    }

    public ItemCompraPK(int codProduto, int codCompra) {
        this.codProduto = codProduto;
        this.codCompra = codCompra;
    }

    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

    public int getCodCompra() {
        return codCompra;
    }

    public void setCodCompra(int codCompra) {
        this.codCompra = codCompra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codProduto;
        hash += (int) codCompra;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemCompraPK)) {
            return false;
        }
        ItemCompraPK other = (ItemCompraPK) object;
        if (this.codProduto != other.codProduto) {
            return false;
        }
        if (this.codCompra != other.codCompra) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.ItemCompraPK[ codProduto=" + codProduto + ", codCompra=" + codCompra + " ]";
    }
    
}
