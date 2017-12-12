package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.ItensServico;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-18T08:57:33")
@StaticMetamodel(Servicos.class)
public class Servicos_ { 

    public static volatile ListAttribute<Servicos, ItensServico> itensServicoList;
    public static volatile SingularAttribute<Servicos, Integer> codServico;
    public static volatile SingularAttribute<Servicos, Double> valor;
    public static volatile SingularAttribute<Servicos, String> descricao;

}