package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.PecasServico;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-18T08:57:33")
@StaticMetamodel(Pecas.class)
public class Pecas_ { 

    public static volatile SingularAttribute<Pecas, Integer> codPeca;
    public static volatile ListAttribute<Pecas, PecasServico> pecasServicoList;
    public static volatile SingularAttribute<Pecas, Double> valor;
    public static volatile SingularAttribute<Pecas, String> descricao;

}