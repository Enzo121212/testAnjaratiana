package com.kimiko.dao;

import com.kimiko.beans.Livraison;
import com.kimiko.util.EntityManagerUtil;
import javax.persistence.EntityManager;
import java.util.List;


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

    public Livraison getLivraisonById(int id) {
        return entityManager.find(Livraison.class, id);
    }

    public List<Livraison> getAllLivraisons() {
        return entityManager.createQuery("FROM Livraison", Livraison.class).getResultList();
    }

    public void updateLivraison(Livraison livraison) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(livraison);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void deleteLivraison(Livraison livraison) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(livraison);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void close() {
        EntityManagerUtil.closeEntityManager();
    }
}