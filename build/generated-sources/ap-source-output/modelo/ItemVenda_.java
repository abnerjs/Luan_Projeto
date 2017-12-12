package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.ItemVendaPK;
import modelo.Produto;
import modelo.Venda;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-18T08:57:33")
@StaticMetamodel(ItemVenda.class)
public class ItemVenda_ { 

    public static volatile SingularAttribute<ItemVenda, Venda> venda;
    public static volatile SingularAttribute<ItemVenda, ItemVendaPK> itemVendaPK;
    public static volatile SingularAttribute<ItemVenda, Double> valor;
    public static volatile SingularAttribute<ItemVenda, Produto> codProduto;

}