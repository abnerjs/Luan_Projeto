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
import modelo.OrdemServico;
import modelo.PecasServico;
import modelo.PecasServicoPK;

/**
 *
 * @author abner
 */
public class PecasServicoJpaController implements Serializable {

    public PecasServicoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PecasServico pecasServico) throws PreexistingEntityException, Exception {
        if (pecasServico.getPecasServicoPK() == null) {
            pecasServico.setPecasServicoPK(new PecasServicoPK());
        }
        pecasServico.getPecasServicoPK().setCodOrdem(pecasServico.getOrdemServico().getCodOrdem());
        pecasServico.getPecasServicoPK().setCodPeca(pecasServico.getPecas().getCodPeca());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            OrdemServico ordemServico = pecasServico.getOrdemServico();
            if (ordemServico != null) {
                ordemServico = em.getReference(ordemServico.getClass(), ordemServico.getCodOrdem());
                pecasServico.setOrdemServico(ordemServico);
            }
            em.persist(pecasServico);
            if (ordemServico != null) {
                ordemServico.getPecasServicoCollection().add(pecasServico);
                ordemServico = em.merge(ordemServico);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPecasServico(pecasServico.getPecasServicoPK()) != null) {
                throw new PreexistingEntityException("PecasServico " + pecasServico + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PecasServico pecasServico) throws NonexistentEntityException, Exception {
        pecasServico.getPecasServicoPK().setCodOrdem(pecasServico.getOrdemServico().getCodOrdem());
        pecasServico.getPecasServicoPK().setCodPeca(pecasServico.getPecas().getCodPeca());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PecasServico persistentPecasServico = em.find(PecasServico.class, pecasServico.getPecasServicoPK());
            OrdemServico ordemServicoOld = persistentPecasServico.getOrdemServico();
            OrdemServico ordemServicoNew = pecasServico.getOrdemServico();
            if (ordemServicoNew != null) {
                ordemServicoNew = em.getReference(ordemServicoNew.getClass(), ordemServicoNew.getCodOrdem());
                pecasServico.setOrdemServico(ordemServicoNew);
            }
            pecasServico = em.merge(pecasServico);
            if (ordemServicoOld != null && !ordemServicoOld.equals(ordemServicoNew)) {
                ordemServicoOld.getPecasServicoCollection().remove(pecasServico);
                ordemServicoOld = em.merge(ordemServicoOld);
            }
            if (ordemServicoNew != null && !ordemServicoNew.equals(ordemServicoOld)) {
                ordemServicoNew.getPecasServicoCollection().add(pecasServico);
                ordemServicoNew = em.merge(ordemServicoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PecasServicoPK id = pecasServico.getPecasServicoPK();
                if (findPecasServico(id) == null) {
                    throw new NonexistentEntityException("The pecasServico with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PecasServicoPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PecasServico pecasServico;
            try {
                pecasServico = em.getReference(PecasServico.class, id);
                pecasServico.getPecasServicoPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pecasServico with id " + id + " no longer exists.", enfe);
            }
            OrdemServico ordemServico = pecasServico.getOrdemServico();
            if (ordemServico != null) {
                ordemServico.getPecasServicoCollection().remove(pecasServico);
                ordemServico = em.merge(ordemServico);
            }
            em.remove(pecasServico);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PecasServico> findPecasServicoEntities() {
        return findPecasServicoEntities(true, -1, -1);
    }

    public List<PecasServico> findPecasServicoEntities(int maxResults, int firstResult) {
        return findPecasServicoEntities(false, maxResults, firstResult);
    }

    private List<PecasServico> findPecasServicoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PecasServico.class));
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

    public PecasServico findPecasServico(PecasServicoPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PecasServico.class, id);
        } finally {
            em.close();
        }
    }

    public int getPecasServicoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PecasServico> rt = cq.from(PecasServico.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
