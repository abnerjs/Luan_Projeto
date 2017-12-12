package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.OrdemServico;
import modelo.Pecas;
import modelo.PecasServicoPK;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-18T08:57:33")
@StaticMetamodel(PecasServico.class)
public class PecasServico_ { 

    public static volatile SingularAttribute<PecasServico, Double> valor;
    public static volatile SingularAttribute<PecasServico, Pecas> pecas;
    public static volatile SingularAttribute<PecasServico, PecasServicoPK> pecasServicoPK;
    public static volatile SingularAttribute<PecasServico, Integer> quant;
    public static volatile SingularAttribute<PecasServico, OrdemServico> ordemServico;

}