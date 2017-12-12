/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Aluno
 */
public class GerenciamentoEntidades {

    // cria um identificador para um objeto EntityManagerFactory
    private static EntityManagerFactory fabEntidades;

    public GerenciamentoEntidades() {
    }
    
    // retorna a fábrica de gerentes de entidades
    public static EntityManagerFactory getFabEntidades()
    {
        // verifica se a fábrica de entidades não foi criada
        if (fabEntidades==null)
        {
            // criando a fábrica de entidades
            fabEntidades = Persistence.createEntityManagerFactory("Luan_ProjetoPU");
        }
        return fabEntidades;
    }
    
    // retorna o gerente de entidade
    public static EntityManager criarGerenteEntidade()
    {
        if (fabEntidades==null)
        {
            // criando a fábrica de entidades
            fabEntidades = Persistence.createEntityManagerFactory("Banco");
        }        
        return fabEntidades.createEntityManager();
    }
    
}

