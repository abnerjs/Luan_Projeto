package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Cliente;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-18T08:57:33")
@StaticMetamodel(Celular.class)
public class Celular_ { 

    public static volatile SingularAttribute<Celular, String> marca;
    public static volatile SingularAttribute<Celular, Integer> codCelular;
    public static volatile SingularAttribute<Celular, String> cor;
    public static volatile SingularAttribute<Celular, Integer> imei;
    public static volatile SingularAttribute<Celular, String> modelo;
    public static volatile SingularAttribute<Celular, Cliente> codCliente;

}