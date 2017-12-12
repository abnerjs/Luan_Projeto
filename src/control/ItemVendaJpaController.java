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
import modelo.ItemVenda;
import modelo.ItemVendaPK;
import modelo.Venda;

/**
 *
 * @author abner
 */
public class ItemVendaJpaController implements Serializable {

    public ItemVendaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ItemVenda itemVenda) throws PreexistingEntityException, Exception {
        if (itemVenda.getItemVendaPK() == null) {
            itemVenda.setItemVendaPK(new ItemVendaPK());
        }
        itemVenda.getItemVendaPK().setCodVenda(itemVenda.getVenda().getCodVenda());
        itemVenda.getItemVendaPK().setCodProduto(itemVenda.getProduto().getCodProduto());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Venda venda = itemVenda.getVenda();
            if (venda != null) {
                venda = em.getReference(venda.getClass(), venda.getCodVenda());
                itemVenda.setVenda(venda);
            }
            em.persist(itemVenda);
            if (venda != null) {
                venda.getItemVendaCollection().add(itemVenda);
                venda = em.merge(venda);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findItemVenda(itemVenda.getItemVendaPK()) != null) {
                throw new PreexistingEntityException("ItemVenda " + itemVenda + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ItemVenda itemVenda) throws NonexistentEntityException, Exception {
        itemVenda.getItemVendaPK().setCodVenda(itemVenda.getVenda().getCodVenda());
        itemVenda.getItemVendaPK().setCodProduto(itemVenda.getProduto().getCodProduto());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ItemVenda persistentItemVenda = em.find(ItemVenda.class, itemVenda.getItemVendaPK());
            Venda vendaOld = persistentItemVenda.getVenda();
            Venda vendaNew = itemVenda.getVenda();
            if (vendaNew != null) {
                vendaNew = em.getReference(vendaNew.getClass(), vendaNew.getCodVenda());
                itemVenda.setVenda(vendaNew);
            }
            itemVenda = em.merge(itemVenda);
            if (vendaOld != null && !vendaOld.equals(vendaNew)) {
                vendaOld.getItemVendaCollection().remove(itemVenda);
                vendaOld = em.merge(vendaOld);
            }
            if (vendaNew != null && !vendaNew.equals(vendaOld)) {
                vendaNew.getItemVendaCollection().add(itemVenda);
                vendaNew = em.merge(vendaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                ItemVendaPK id = itemVenda.getItemVendaPK();
                if (findItemVenda(id) == null) {
                    throw new NonexistentEntityException("The itemVenda with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(ItemVendaPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ItemVenda itemVenda;
            try {
                itemVenda = em.getReference(ItemVenda.class, id);
                itemVenda.getItemVendaPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The itemVenda with id " + id + " no longer exists.", enfe);
            }
            Venda venda = itemVenda.getVenda();
            if (venda != null) {
                venda.getItemVendaCollection().remove(itemVenda);
                venda = em.merge(venda);
            }
            em.remove(itemVenda);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ItemVenda> findItemVendaEntities() {
        return findItemVendaEntities(true, -1, -1);
    }

    public List<ItemVenda> findItemVendaEntities(int maxResults, int firstResult) {
        return findItemVendaEntities(false, maxResults, firstResult);
    }

    private List<ItemVenda> findItemVendaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ItemVenda.class));
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

    public ItemVenda findItemVenda(ItemVendaPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ItemVenda.class, id);
        } finally {
            em.close();
        }
    }

    public int getItemVendaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ItemVenda> rt = cq.from(ItemVenda.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
