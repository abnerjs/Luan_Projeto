package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.ItemVenda;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-18T08:57:33")
@StaticMetamodel(Venda.class)
public class Venda_ { 

    public static volatile SingularAttribute<Venda, Double> desconto;
    public static volatile SingularAttribute<Venda, Double> valor;
    public static volatile ListAttribute<Venda, ItemVenda> itemVendaList;
    public static volatile SingularAttribute<Venda, Integer> codVenda;

}