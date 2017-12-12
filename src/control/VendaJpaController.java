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
import modelo.ItemVenda;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import modelo.Venda;

/**
 *
 * @author abner
 */
public class VendaJpaController implements Serializable {

    public VendaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Venda venda) {
        if (venda.getItemVendaCollection() == null) {
            venda.setItemVendaCollection(new ArrayList<ItemVenda>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<ItemVenda> attachedItemVendaCollection = new ArrayList<ItemVenda>();
            for (ItemVenda itemVendaCollectionItemVendaToAttach : venda.getItemVendaCollection()) {
                itemVendaCollectionItemVendaToAttach = em.getReference(itemVendaCollectionItemVendaToAttach.getClass(), itemVendaCollectionItemVendaToAttach.getItemVendaPK());
                attachedItemVendaCollection.add(itemVendaCollectionItemVendaToAttach);
            }
            venda.setItemVendaCollection(attachedItemVendaCollection);
            em.persist(venda);
            for (ItemVenda itemVendaCollectionItemVenda : venda.getItemVendaCollection()) {
                Venda oldVendaOfItemVendaCollectionItemVenda = itemVendaCollectionItemVenda.getVenda();
                itemVendaCollectionItemVenda.setVenda(venda);
                itemVendaCollectionItemVenda = em.merge(itemVendaCollectionItemVenda);
                if (oldVendaOfItemVendaCollectionItemVenda != null) {
                    oldVendaOfItemVendaCollectionItemVenda.getItemVendaCollection().remove(itemVendaCollectionItemVenda);
                    oldVendaOfItemVendaCollectionItemVenda = em.merge(oldVendaOfItemVendaCollectionItemVenda);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Venda venda) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Venda persistentVenda = em.find(Venda.class, venda.getCodVenda());
            Collection<ItemVenda> itemVendaCollectionOld = persistentVenda.getItemVendaCollection();
            Collection<ItemVenda> itemVendaCollectionNew = venda.getItemVendaCollection();
            List<String> illegalOrphanMessages = null;
            for (ItemVenda itemVendaCollectionOldItemVenda : itemVendaCollectionOld) {
                if (!itemVendaCollectionNew.contains(itemVendaCollectionOldItemVenda)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain ItemVenda " + itemVendaCollectionOldItemVenda + " since its venda field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<ItemVenda> attachedItemVendaCollectionNew = new ArrayList<ItemVenda>();
            for (ItemVenda itemVendaCollectionNewItemVendaToAttach : itemVendaCollectionNew) {
                itemVendaCollectionNewItemVendaToAttach = em.getReference(itemVendaCollectionNewItemVendaToAttach.getClass(), itemVendaCollectionNewItemVendaToAttach.getItemVendaPK());
                attachedItemVendaCollectionNew.add(itemVendaCollectionNewItemVendaToAttach);
            }
            itemVendaCollectionNew = attachedItemVendaCollectionNew;
            venda.setItemVendaCollection(itemVendaCollectionNew);
            venda = em.merge(venda);
            for (ItemVenda itemVendaCollectionNewItemVenda : itemVendaCollectionNew) {
                if (!itemVendaCollectionOld.contains(itemVendaCollectionNewItemVenda)) {
                    Venda oldVendaOfItemVendaCollectionNewItemVenda = itemVendaCollectionNewItemVenda.getVenda();
                    itemVendaCollectionNewItemVenda.setVenda(venda);
                    itemVendaCollectionNewItemVenda = em.merge(itemVendaCollectionNewItemVenda);
                    if (oldVendaOfItemVendaCollectionNewItemVenda != null && !oldVendaOfItemVendaCollectionNewItemVenda.equals(venda)) {
                        oldVendaOfItemVendaCollectionNewItemVenda.getItemVendaCollection().remove(itemVendaCollectionNewItemVenda);
                        oldVendaOfItemVendaCollectionNewItemVenda = em.merge(oldVendaOfItemVendaCollectionNewItemVenda);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = venda.getCodVenda();
                if (findVenda(id) == null) {
                    throw new NonexistentEntityException("The venda with id " + id + " no longer exists.");
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
            Venda venda;
            try {
                venda = em.getReference(Venda.class, id);
                venda.getCodVenda();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The venda with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<ItemVenda> itemVendaCollectionOrphanCheck = venda.getItemVendaCollection();
            for (ItemVenda itemVendaCollectionOrphanCheckItemVenda : itemVendaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Venda (" + venda + ") cannot be destroyed since the ItemVenda " + itemVendaCollectionOrphanCheckItemVenda + " in its itemVendaCollection field has a non-nullable venda field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(venda);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Venda> findVendaEntities() {
        return findVendaEntities(true, -1, -1);
    }

    public List<Venda> findVendaEntities(int maxResults, int firstResult) {
        return findVendaEntities(false, maxResults, firstResult);
    }

    private List<Venda> findVendaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Venda.class));
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

    public Venda findVenda(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Venda.class, id);
        } finally {
            em.close();
        }
    }

    public int getVendaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Venda> rt = cq.from(Venda.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
