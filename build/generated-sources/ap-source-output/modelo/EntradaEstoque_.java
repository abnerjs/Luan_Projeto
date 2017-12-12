package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Produto;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-18T08:57:33")
@StaticMetamodel(EntradaEstoque.class)
public class EntradaEstoque_ { 

    public static volatile SingularAttribute<EntradaEstoque, Integer> codPedido;
    public static volatile SingularAttribute<EntradaEstoque, Produto> codPrduto;
    public static volatile SingularAttribute<EntradaEstoque, Date> dataPedido;
    public static volatile SingularAttribute<EntradaEstoque, Integer> quant;

}