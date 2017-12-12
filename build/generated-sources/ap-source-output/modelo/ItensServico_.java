package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.ItensServicoPK;
import modelo.OrdemServico;
import modelo.Servicos;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-18T08:57:33")
@StaticMetamodel(ItensServico.class)
public class ItensServico_ { 

    public static volatile SingularAttribute<ItensServico, Servicos> servicos;
    public static volatile SingularAttribute<ItensServico, ItensServicoPK> itensServicoPK;
    public static volatile SingularAttribute<ItensServico, Double> valor;
    public static volatile SingularAttribute<ItensServico, OrdemServico> ordemServico;

}