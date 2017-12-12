package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Celular;
import modelo.ItensServico;
import modelo.PecasServico;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-18T08:57:33")
@StaticMetamodel(OrdemServico.class)
public class OrdemServico_ { 

    public static volatile SingularAttribute<OrdemServico, Date> dateTermino;
    public static volatile ListAttribute<OrdemServico, ItensServico> itensServicoList;
    public static volatile SingularAttribute<OrdemServico, Double> desconto;
    public static volatile SingularAttribute<OrdemServico, Double> totalNota;
    public static volatile SingularAttribute<OrdemServico, Celular> codCelular;
    public static volatile ListAttribute<OrdemServico, PecasServico> pecasServicoList;
    public static volatile SingularAttribute<OrdemServico, Double> valorPago;
    public static volatile SingularAttribute<OrdemServico, Integer> codOrdem;
    public static volatile SingularAttribute<OrdemServico, Date> dataChegada;

}