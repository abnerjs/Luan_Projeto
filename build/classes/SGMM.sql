 drop database if exists SGMM;
create database SGMM;
use SGMM;

create table Cliente (

	cod_cliente 	int primary key auto_increment,
    nome 			varchar (60),
    cpf 			varchar (14),
    endereco 		varchar (60),
    cidade 			varchar (40),
    estado			char (2),
    cep				char (10),
    telefone 		char 	(14)
    
);

create table Celular (

	cod_celular  	int primary key auto_increment,
    cor 			varchar (10),
    modelo 			varchar (20),
    marca			varchar (20),
    cod_cliente 	int,
    imei			int,
    
    foreign key (cod_cliente) references Cliente (cod_cliente)
    
);

create table Servicos (
 
	cod_servico 	int primary key auto_increment,
	descricao 		varchar	(20),
    valor 			double
    
);

create table Pecas (
	
    cod_peca	  int primary key auto_increment,
    Descricao 	  varchar  (100),
    valor		  double
    
);

create table Ordem_Servico (

	cod_ordem 		 int primary key auto_increment,
    data_chegada	 date,
    date_termino	 date,
    cod_celular		 int,
    total_nota		 double,	
    desconto		 double,
    valor_pago		 double,
    
    foreign key (cod_celular) references Celular (cod_celular)
    
    
);

create table Itens_Servico (

     cod_ordem		int,
     cod_serv		int,
     valor			double,
     
     primary key (cod_ordem,cod_serv),
     foreign key (cod_ordem) references Ordem_Servico (cod_ordem),
     foreign key (cod_serv)  references Servicos      (cod_servico)
 
);

create table Pecas_Servico(

     cod_ordem		int,
     cod_peca		int,
     quant 			int,
     valor			double,
     
     primary key (cod_ordem,cod_peca),
     foreign key (cod_ordem) references Ordem_Servico (cod_ordem),
     foreign key (cod_peca)  references Pecas      	  (cod_peca)
 
);

#   Vendas

create table Produto (
	
    cod_produto 	int primary key auto_increment,
    quant			int,
    valor			double,
    descricao		varchar	(100)
    
);

create table Venda  (
	
    cod_venda		int primary key auto_increment,
    valor 			double,
    desconto		double
    
);

create table Item_Venda (
	
	cod_venda		int,
	cod_produto		int,
	valor			double,
    
    primary key (cod_venda,cod_produto),
    foreign key (cod_venda)   references  Venda    (cod_venda),
    foreign key (cod_produto) references  Produto  (cod_produto)
	
);

create table Entrada_estoque  (

	cod_pedido 		int primary key,
    data_pedido 	date,
    quant			int,
    cod_prduto		int,
    
    foreign key (cod_prduto) references Produto (cod_produto)
);

