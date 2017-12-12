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
import modelo.Servicos;

/**
 *
 * @author abner
 */
public class ServicosJpaController implements Serializable {

    public ServicosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Servicos servicos) {
        if (servicos.getItensServicoCollection() == null) {
            servicos.setItensServicoCollection(new ArrayList<ItensServico>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<ItensServico> attachedItensServicoCollection = new ArrayList<ItensServico>();
            for (ItensServico itensServicoCollectionItensServicoToAttach : servicos.getItensServicoCollection()) {
                itensServicoCollectionItensServicoToAttach = em.getReference(itensServicoCollectionItensServicoToAttach.getClass(), itensServicoCollectionItensServicoToAttach.getItensServicoPK());
                attachedItensServicoCollection.add(itensServicoCollectionItensServicoToAttach);
            }
            servicos.setItensServicoCollection(attachedItensServicoCollection);
            em.persist(servicos);
            for (ItensServico itensServicoCollectionItensServico : servicos.getItensServicoCollection()) {
                Servicos oldServicosOfItensServicoCollectionItensServico = itensServicoCollectionItensServico.getServicos();
                itensServicoCollectionItensServico.setServicos(servicos);
                itensServicoCollectionItensServico = em.merge(itensServicoCollectionItensServico);
                if (oldServicosOfItensServicoCollectionItensServico != null) {
                    oldServicosOfItensServicoCollectionItensServico.getItensServicoCollection().remove(itensServicoCollectionItensServico);
                    oldServicosOfItensServicoCollectionItensServico = em.merge(oldServicosOfItensServicoCollectionItensServico);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Servicos servicos) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Servicos persistentServicos = em.find(Servicos.class, servicos.getCodServico());
            Collection<ItensServico> itensServicoCollectionOld = persistentServicos.getItensServicoCollection();
            Collection<ItensServico> itensServicoCollectionNew = servicos.getItensServicoCollection();
            List<String> illegalOrphanMessages = null;
            for (ItensServico itensServicoCollectionOldItensServico : itensServicoCollectionOld) {
                if (!itensServicoCollectionNew.contains(itensServicoCollectionOldItensServico)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain ItensServico " + itensServicoCollectionOldItensServico + " since its servicos field is not nullable.");
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
            servicos.setItensServicoCollection(itensServicoCollectionNew);
            servicos = em.merge(servicos);
            for (ItensServico itensServicoCollectionNewItensServico : itensServicoCollectionNew) {
                if (!itensServicoCollectionOld.contains(itensServicoCollectionNewItensServico)) {
                    Servicos oldServicosOfItensServicoCollectionNewItensServico = itensServicoCollectionNewItensServico.getServicos();
                    itensServicoCollectionNewItensServico.setServicos(servicos);
                    itensServicoCollectionNewItensServico = em.merge(itensServicoCollectionNewItensServico);
                    if (oldServicosOfItensServicoCollectionNewItensServico != null && !oldServicosOfItensServicoCollectionNewItensServico.equals(servicos)) {
                        oldServicosOfItensServicoCollectionNewItensServico.getItensServicoCollection().remove(itensServicoCollectionNewItensServico);
                        oldServicosOfItensServicoCollectionNewItensServico = em.merge(oldServicosOfItensServicoCollectionNewItensServico);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = servicos.getCodServico();
                if (findServicos(id) == null) {
                    throw new NonexistentEntityException("The servicos with id " + id + " no longer exists.");
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
            Servicos servicos;
            try {
                servicos = em.getReference(Servicos.class, id);
                servicos.getCodServico();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The servicos with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<ItensServico> itensServicoCollectionOrphanCheck = servicos.getItensServicoCollection();
            for (ItensServico itensServicoCollectionOrphanCheckItensServico : itensServicoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Servicos (" + servicos + ") cannot be destroyed since the ItensServico " + itensServicoCollectionOrphanCheckItensServico + " in its itensServicoCollection field has a non-nullable servicos field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(servicos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Servicos> findServicosEntities() {
        return findServicosEntities(true, -1, -1);
    }

    public List<Servicos> findServicosEntities(int maxResults, int firstResult) {
        return findServicosEntities(false, maxResults, firstResult);
    }

    private List<Servicos> findServicosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Servicos.class));
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

    public Servicos findServicos(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Servicos.class, id);
        } finally {
            em.close();
        }
    }

    public int getServicosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Servicos> rt = cq.from(Servicos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
