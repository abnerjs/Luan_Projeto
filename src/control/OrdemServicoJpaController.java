/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import control.exceptions.IllegalOrphanException;
import control.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.ItensServico;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import modelo.OrdemServico;
import modelo.PecasServico;

/**
 *
 * @author abner
 */
public class OrdemServicoJpaController implements Serializable {

    public OrdemServicoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(OrdemServico ordemServico) {
        if (ordemServico.getItensServicoCollection() == null) {
            ordemServico.setItensServicoCollection(new ArrayList<ItensServico>());
        }
        if (ordemServico.getPecasServicoCollection() == null) {
            ordemServico.setPecasServicoCollection(new ArrayList<PecasServico>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<ItensServico> attachedItensServicoCollection = new ArrayList<ItensServico>();
            for (ItensServico itensServicoCollectionItensServicoToAttach : ordemServico.getItensServicoCollection()) {
                itensServicoCollectionItensServicoToAttach = em.getReference(itensServicoCollectionItensServicoToAttach.getClass(), itensServicoCollectionItensServicoToAttach.getItensServicoPK());
                attachedItensServicoCollection.add(itensServicoCollectionItensServicoToAttach);
            }
            ordemServico.setItensServicoCollection(attachedItensServicoCollection);
            Collection<PecasServico> attachedPecasServicoCollection = new ArrayList<PecasServico>();
            for (PecasServico pecasServicoCollectionPecasServicoToAttach : ordemServico.getPecasServicoCollection()) {
                pecasServicoCollectionPecasServicoToAttach = em.getReference(pecasServicoCollectionPecasServicoToAttach.getClass(), pecasServicoCollectionPecasServicoToAttach.getPecasServicoPK());
                attachedPecasServicoCollection.add(pecasServicoCollectionPecasServicoToAttach);
            }
            ordemServico.setPecasServicoCollection(attachedPecasServicoCollection);
            em.persist(ordemServico);
            for (ItensServico itensServicoCollectionItensServico : ordemServico.getItensServicoCollection()) {
                OrdemServico oldOrdemServicoOfItensServicoCollectionItensServico = itensServicoCollectionItensServico.getOrdemServico();
                itensServicoCollectionItensServico.setOrdemServico(ordemServico);
                itensServicoCollectionItensServico = em.merge(itensServicoCollectionItensServico);
                if (oldOrdemServicoOfItensServicoCollectionItensServico != null) {
                    oldOrdemServicoOfItensServicoCollectionItensServico.getItensServicoCollection().remove(itensServicoCollectionItensServico);
                    oldOrdemServicoOfItensServicoCollectionItensServico = em.merge(oldOrdemServicoOfItensServicoCollectionItensServico);
                }
            }
            for (PecasServico pecasServicoCollectionPecasServico : ordemServico.getPecasServicoCollection()) {
                OrdemServico oldOrdemServicoOfPecasServicoCollectionPecasServico = pecasServicoCollectionPecasServico.getOrdemServico();
                pecasServicoCollectionPecasServico.setOrdemServico(ordemServico);
                pecasServicoCollectionPecasServico = em.merge(pecasServicoCollectionPecasServico);
                if (oldOrdemServicoOfPecasServicoCollectionPecasServico != null) {
                    oldOrdemServicoOfPecasServicoCollectionPecasServico.getPecasServicoCollection().remove(pecasServicoCollectionPecasServico);
                    oldOrdemServicoOfPecasServicoCollectionPecasServico = em.merge(oldOrdemServicoOfPecasServicoCollectionPecasServico);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(OrdemServico ordemServico) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            OrdemServico persistentOrdemServico = em.find(OrdemServico.class, ordemServico.getCodOrdem());
            Collection<ItensServico> itensServicoCollectionOld = persistentOrdemServico.getItensServicoCollection();
            Collection<ItensServico> itensServicoCollectionNew = ordemServico.getItensServicoCollection();
            Collection<PecasServico> pecasServicoCollectionOld = persistentOrdemServico.getPecasServicoCollection();
            Collection<PecasServico> pecasServicoCollectionNew = ordemServico.getPecasServicoCollection();
            List<String> illegalOrphanMessages = null;
            for (ItensServico itensServicoCollectionOldItensServico : itensServicoCollectionOld) {
                if (!itensServicoCollectionNew.contains(itensServicoCollectionOldItensServico)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain ItensServico " + itensServicoCollectionOldItensServico + " since its ordemServico field is not nullable.");
                }
            }
            for (PecasServico pecasServicoCollectionOldPecasServico : pecasServicoCollectionOld) {
                if (!pecasServicoCollectionNew.contains(pecasServicoCollectionOldPecasServico)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain PecasServico " + pecasServicoCollectionOldPecasServico + " since its ordemServico field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<ItensServico> attachedItensServicoCollectionNew = new ArrayList<ItensServico>();
            for (ItensServico itensServicoCollectionNewItensServicoToAttach : itensServicoCollectionNew) {
                itensServicoCollectionNewItensServicoToAttach = em.getReference(itensServicoCollectionNewItensServicoToAttach.getClass(), itensServicoCollectionNewItensServicoToAttach.getItensServicoPK());
                attachedItensServicoCollectionNew.add(itensServicoCollectionNewItensServicoToAttach);
            }
            itensServicoCollectionNew = attachedItensServicoCollectionNew;
            ordemServico.setItensServicoCollection(itensServicoCollectionNew);
            Collection<PecasServico> attachedPecasServicoCollectionNew = new ArrayList<PecasServico>();
            for (PecasServico pecasServicoCollectionNewPecasServicoToAttach : pecasServicoCollectionNew) {
                pecasServicoCollectionNewPecasServicoToAttach = em.getReference(pecasServicoCollectionNewPecasServicoToAttach.getClass(), pecasServicoCollectionNewPecasServicoToAttach.getPecasServicoPK());
                attachedPecasServicoCollectionNew.add(pecasServicoCollectionNewPecasServicoToAttach);
            }
            pecasServicoCollectionNew = attachedPecasServicoCollectionNew;
            ordemServico.setPecasServicoCollection(pecasServicoCollectionNew);
            ordemServico = em.merge(ordemServico);
            for (ItensServico itensServicoCollectionNewItensServico : itensServicoCollectionNew) {
                if (!itensServicoCollectionOld.contains(itensServicoCollectionNewItensServico)) {
                    OrdemServico oldOrdemServicoOfItensServicoCollectionNewItensServico = itensServicoCollectionNewItensServico.getOrdemServico();
                    itensServicoCollectionNewItensServico.setOrdemServico(ordemServico);
                    itensServicoCollectionNewItensServico = em.merge(itensServicoCollectionNewItensServico);
                    if (oldOrdemServicoOfItensServicoCollectionNewItensServico != null && !oldOrdemServicoOfItensServicoCollectionNewItensServico.equals(ordemServico)) {
                        oldOrdemServicoOfItensServicoCollectionNewItensServico.getItensServicoCollection().remove(itensServicoCollectionNewItensServico);
                        oldOrdemServicoOfItensServicoCollectionNewItensServico = em.merge(oldOrdemServicoOfItensServicoCollectionNewItensServico);
                    }
                }
            }
            for (PecasServico pecasServicoCollectionNewPecasServico : pecasServicoCollectionNew) {
                if (!pecasServicoCollectionOld.contains(pecasServicoCollectionNewPecasServico)) {
                    OrdemServico oldOrdemServicoOfPecasServicoCollectionNewPecasServico = pecasServicoCollectionNewPecasServico.getOrdemServico();
                    pecasServicoCollectionNewPecasServico.setOrdemServico(ordemServico);
                    pecasServicoCollectionNewPecasServico = em.merge(pecasServicoCollectionNewPecasServico);
                    if (oldOrdemServicoOfPecasServicoCollectionNewPecasServico != null && !oldOrdemServicoOfPecasServicoCollectionNewPecasServico.equals(ordemServico)) {
                        oldOrdemServicoOfPecasServicoCollectionNewPecasServico.getPecasServicoCollection().remove(pecasServicoCollectionNewPecasServico);
                        oldOrdemServicoOfPecasServicoCollectionNewPecasServico = em.merge(oldOrdemServicoOfPecasServicoCollectionNewPecasServico);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = ordemServico.getCodOrdem();
                if (findOrdemServico(id) == null) {
                    throw new NonexistentEntityException("The ordemServico with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            OrdemServico ordemServico;
            try {
                ordemServico = em.getReference(OrdemServico.class, id);
                ordemServico.getCodOrdem();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ordemServico with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<ItensServico> itensServicoCollectionOrphanCheck = ordemServico.getItensServicoCollection();
            for (ItensServico itensServicoCollectionOrphanCheckItensServico : itensServicoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This OrdemServico (" + ordemServico + ") cannot be destroyed since the ItensServico " + itensServicoCollectionOrphanCheckItensServico + " in its itensServicoCollection field has a non-nullable ordemServico field.");
            }
            Collection<PecasServico> pecasServicoCollectionOrphanCheck = ordemServico.getPecasServicoCollection();
            for (PecasServico pecasServicoCollectionOrphanCheckPecasServico : pecasServicoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This OrdemServico (" + ordemServico + ") cannot be destroyed since the PecasServico " + pecasServicoCollectionOrphanCheckPecasServico + " in its pecasServicoCollection field has a non-nullable ordemServico field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(ordemServico);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<OrdemServico> findOrdemServicoEntities() {
        return findOrdemServicoEntities(true, -1, -1);
    }

    public List<OrdemServico> findOrdemServicoEntities(int maxResults, int firstResult) {
        return findOrdemServicoEntities(false, maxResults, firstResult);
    }

    private List<OrdemServico> findOrdemServicoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(OrdemServico.class));
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

    public OrdemServico findOrdemServico(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(OrdemServico.class, id);
        } finally {
            em.close();
        }
    }

    public int getOrdemServicoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<OrdemServico> rt = cq.from(OrdemServico.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
