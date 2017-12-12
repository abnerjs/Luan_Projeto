/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import control.exceptions.NonexistentEntityException;
import control.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.ItensServico;
import modelo.ItensServicoPK;
import modelo.OrdemServico;
import modelo.Servicos;

/**
 *
 * @author abner
 */
public class ItensServicoJpaController implements Serializable {

    public ItensServicoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ItensServico itensServico) throws PreexistingEntityException, Exception {
        if (itensServico.getItensServicoPK() == null) {
            itensServico.setItensServicoPK(new ItensServicoPK());
        }
        itensServico.getItensServicoPK().setCodOrdem(itensServico.getOrdemServico().getCodOrdem());
        itensServico.getItensServicoPK().setCodServ(itensServico.getServicos().getCodServico());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            OrdemServico ordemServico = itensServico.getOrdemServico();
            if (ordemServico != null) {
                ordemServico = em.getReference(ordemServico.getClass(), ordemServico.getCodOrdem());
                itensServico.setOrdemServico(ordemServico);
            }
            Servicos servicos = itensServico.getServicos();
            if (servicos != null) {
                servicos = em.getReference(servicos.getClass(), servicos.getCodServico());
                itensServico.setServicos(servicos);
            }
            em.persist(itensServico);
            if (ordemServico != null) {
                ordemServico.getItensServicoCollection().add(itensServico);
                ordemServico = em.merge(ordemServico);
            }
            if (servicos != null) {
                servicos.getItensServicoCollection().add(itensServico);
                servicos = em.merge(servicos);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findItensServico(itensServico.getItensServicoPK()) != null) {
                throw new PreexistingEntityException("ItensServico " + itensServico + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ItensServico itensServico) throws NonexistentEntityException, Exception {
        itensServico.getItensServicoPK().setCodOrdem(itensServico.getOrdemServico().getCodOrdem());
        itensServico.getItensServicoPK().setCodServ(itensServico.getServicos().getCodServico());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ItensServico persistentItensServico = em.find(ItensServico.class, itensServico.getItensServicoPK());
            OrdemServico ordemServicoOld = persistentItensServico.getOrdemServico();
            OrdemServico ordemServicoNew = itensServico.getOrdemServico();
            Servicos servicosOld = persistentItensServico.getServicos();
            Servicos servicosNew = itensServico.getServicos();
            if (ordemServicoNew != null) {
                ordemServicoNew = em.getReference(ordemServicoNew.getClass(), ordemServicoNew.getCodOrdem());
                itensServico.setOrdemServico(ordemServicoNew);
            }
            if (servicosNew != null) {
                servicosNew = em.getReference(servicosNew.getClass(), servicosNew.getCodServico());
                itensServico.setServicos(servicosNew);
            }
            itensServico = em.merge(itensServico);
            if (ordemServicoOld != null && !ordemServicoOld.equals(ordemServicoNew)) {
                ordemServicoOld.getItensServicoCollection().remove(itensServico);
                ordemServicoOld = em.merge(ordemServicoOld);
            }
            if (ordemServicoNew != null && !ordemServicoNew.equals(ordemServicoOld)) {
                ordemServicoNew.getItensServicoCollection().add(itensServico);
                ordemServicoNew = em.merge(ordemServicoNew);
            }
            if (servicosOld != null && !servicosOld.equals(servicosNew)) {
                servicosOld.getItensServicoCollection().remove(itensServico);
                servicosOld = em.merge(servicosOld);
            }
            if (servicosNew != null && !servicosNew.equals(servicosOld)) {
                servicosNew.getItensServicoCollection().add(itensServico);
                servicosNew = em.merge(servicosNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                ItensServicoPK id = itensServico.getItensServicoPK();
                if (findItensServico(id) == null) {
                    throw new NonexistentEntityException("The itensServico with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(ItensServicoPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ItensServico itensServico;
            try {
                itensServico = em.getReference(ItensServico.class, id);
                itensServico.getItensServicoPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The itensServico with id " + id + " no longer exists.", enfe);
            }
            OrdemServico ordemServico = itensServico.getOrdemServico();
            if (ordemServico != null) {
                ordemServico.getItensServicoCollection().remove(itensServico);
                ordemServico = em.merge(ordemServico);
            }
            Servicos servicos = itensServico.getServicos();
            if (servicos != null) {
                servicos.getItensServicoCollection().remove(itensServico);
                servicos = em.merge(servicos);
            }
            em.remove(itensServico);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ItensServico> findItensServicoEntities() {
        return findItensServicoEntities(true, -1, -1);
    }

    public List<ItensServico> findItensServicoEntities(int maxResults, int firstResult) {
        return findItensServicoEntities(false, maxResults, firstResult);
    }

    private List<ItensServico> findItensServicoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ItensServico.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public ItensServico findItensServico(ItensServicoPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ItensServico.class, id);
        } finally {
            em.close();
        }
    }

    public int getItensServicoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ItensServico> rt = cq.from(ItensServico.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
