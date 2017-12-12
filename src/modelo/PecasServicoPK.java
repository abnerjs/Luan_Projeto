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
public class PecasServicoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "cod_ordem", insertable = false, updatable = false)
    private int codOrdem;
    @Basic(optional = false)
    @Column(name = "cod_peca", insertable = false, updatable = false)
    private int codPeca;

    public PecasServicoPK() {
    }

    public PecasServicoPK(int codOrdem, int codPeca) {
        this.codOrdem = codOrdem;
        this.codPeca = codPeca;
    }

    public int getCodOrdem() {
        return codOrdem;
    }

    public void setCodOrdem(int codOrdem) {
        this.codOrdem = codOrdem;
    }

    public int getCodPeca() {
        return codPeca;
    }

    public void setCodPeca(int codPeca) {
        this.codPeca = codPeca;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codOrdem;
        hash += (int) codPeca;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PecasServicoPK)) {
            return false;
        }
        PecasServicoPK other = (PecasServicoPK) object;
        if (this.codOrdem != other.codOrdem) {
            return false;
        }
        if (this.codPeca != other.codPeca) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.PecasServicoPK[ codOrdem=" + codOrdem + ", codPeca=" + codPeca + " ]";
    }
    
}
