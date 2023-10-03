package com.kimiko.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;

import com.kimiko.beans.Article;
import com.kimiko.beans.Clients;
import com.kimiko.beans.Livraison;
import com.kimiko.beans.Livreur;
import com.kimiko.beans.Transport;
import com.kimiko.util.EntityManagerUtil;


public class LivraisonDAO {

    private EntityManager entityManager;

    public LivraisonDAO() {
        this.entityManager = EntityManagerUtil.getEntityManager();
    }

    public void saveLivraison(Livraison livraison) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(livraison);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public List<Livraison> getAllLivraisons() {
        return entityManager.createQuery("FROM Livraison", Livraison.class).getResultList();
    }

    public List<Article> getAllArticles() {
        return entityManager.createQuery("FROM Article", Article.class).getResultList();
    }
    
    public Article getArticleById(Long id) {
        return entityManager.find(Article.class, id);
    }

    public List<Clients> getAllClients() {
        return entityManager.createQuery("FROM Clients", Clients.class).getResultList();
    }
    
    public Clients getClientById(int id) {
        return entityManager.find(Clients.class, id);
    }

     public List<Livreur> getAllLivreurs() {
        return entityManager.createQuery("FROM Livreur", Livreur.class).getResultList();
    }

     public Livreur getLivreurById(int id) {
         return entityManager.find(Livreur.class, id);
     }
     public Transport getTransportById(int id) {
    	 return entityManager.find(Transport.class, id);
     }
     
     public long getCountLivraisons() {
    	    Long count = (Long) entityManager.createQuery("SELECT COUNT(l) FROM Livraison l")
    	                                    .getSingleResult();
    	    return count != null ? count : 0;
    	}
     
     public long getCountLivraisonsWithCriteria() {
    	    Session session = entityManager.unwrap(Session.class);
    	    Criteria criteria = session.createCriteria(Livraison.class);
    	    criteria.setProjection(Projections.rowCount());
    	    Long count = (Long) criteria.uniqueResult();
    	    return count != null ? count : 0;
   }
     
 public long getCountLivraisonsNow() {
	    Date now = new Date(); 
	    Long count = (Long) entityManager.createQuery(
	            "SELECT COUNT(l) FROM Livraison l WHERE l.dateLivraison = :now")
	            .setParameter("now", now)
	            .getSingleResult();
	    return count != null ? count : 0;
	}
 
 public BigDecimal getTotalPrixLivraison() {
	    BigDecimal totalPrix = (BigDecimal) entityManager.createQuery(
	            "SELECT SUM(prix) FROM Livraison ")
	            .getSingleResult();
	    return totalPrix != null ? totalPrix : BigDecimal.ZERO;
	}


    public void close() {
        EntityManagerUtil.closeEntityManager();
    }
}