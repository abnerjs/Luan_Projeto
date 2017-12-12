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
import modelo.ItemCompra;
import modelo.ItemCompraPK;

/**
 *
 * @author abner
 */
public class ItemCompraJpaController implements Serializable {

    public ItemCompraJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ItemCompra itemCompra) throws PreexistingEntityException, Exception {
        if (itemCompra.getItemCompraPK() == null) {
            itemCompra.setItemCompraPK(new ItemCompraPK());
        }
        itemCompra.getItemCompraPK().setCodProduto(itemCompra.getProduto().getCodProduto());
        itemCompra.getItemCompraPK().setCodCompra(itemCompra.getCompra().getCodCompra());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(itemCompra);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findItemCompra(itemCompra.getItemCompraPK()) != null) {
                throw new PreexistingEntityException("ItemCompra " + itemCompra + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ItemCompra itemCompra) throws NonexistentEntityException, Exception {
        itemCompra.getItemCompraPK().setCodProduto(itemCompra.getProduto().getCodProduto());
        itemCompra.getItemCompraPK().setCodCompra(itemCompra.getCompra().getCodCompra());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            itemCompra = em.merge(itemCompra);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                ItemCompraPK id = itemCompra.getItemCompraPK();
                if (findItemCompra(id) == null) {
                    throw new NonexistentEntityException("The itemCompra with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(ItemCompraPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ItemCompra itemCompra;
            try {
                itemCompra = em.getReference(ItemCompra.class, id);
                itemCompra.getItemCompraPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The itemCompra with id " + id + " no longer exists.", enfe);
            }
            em.remove(itemCompra);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ItemCompra> findItemCompraEntities() {
        return findItemCompraEntities(true, -1, -1);
    }

    public List<ItemCompra> findItemCompraEntities(int maxResults, int firstResult) {
        return findItemCompraEntities(false, maxResults, firstResult);
    }

    private List<ItemCompra> findItemCompraEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ItemCompra.class));
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

    public ItemCompra findItemCompra(ItemCompraPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ItemCompra.class, id);
        } finally {
            em.close();
        }
    }

    public int getItemCompraCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ItemCompra> rt = cq.from(ItemCompra.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
