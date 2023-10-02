package com.kimiko.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.kimiko.beans.Article;
import com.kimiko.beans.Clients;
import com.kimiko.beans.Livraison;
import com.kimiko.beans.Livreur;
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

    public List<Clients> getAllClients() {
        return entityManager.createQuery("FROM Clients", Clients.class).getResultList();
    }

        public List<Livreur> getAllLivreurs() {
        return entityManager.createQuery("FROM Livreur", Livreur.class).getResultList();
    }



    public void close() {
        EntityManagerUtil.closeEntityManager();
    }
}