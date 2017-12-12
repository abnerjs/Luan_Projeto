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
public class ItensServicoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "cod_ordem", insertable = false, updatable = false)
    private int codOrdem;
    @Basic(optional = false)
    @Column(name = "cod_serv", insertable = false, updatable = false)
    private int codServ;

    public ItensServicoPK() {
    }

    public ItensServicoPK(int codOrdem, int codServ) {
        this.codOrdem = codOrdem;
        this.codServ = codServ;
    }

    public int getCodOrdem() {
        return codOrdem;
    }

    public void setCodOrdem(int codOrdem) {
        this.codOrdem = codOrdem;
    }

    public int getCodServ() {
        return codServ;
    }

    public void setCodServ(int codServ) {
        this.codServ = codServ;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codOrdem;
        hash += (int) codServ;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItensServicoPK)) {
            return false;
        }
        ItensServicoPK other = (ItensServicoPK) object;
        if (this.codOrdem != other.codOrdem) {
            return false;
        }
        if (this.codServ != other.codServ) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.ItensServicoPK[ codOrdem=" + codOrdem + ", codServ=" + codServ + " ]";
    }
    
}
