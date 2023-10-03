package com.kimiko.dao;

import com.kimiko.beans.Livreur;
import com.kimiko.beans.Transport;
import com.kimiko.util.EntityManagerUtil;
import javax.persistence.EntityManager;
import java.util.List;

public class LivreurDAO {

    private EntityManager entityManager;

    public LivreurDAO() {
        this.entityManager = EntityManagerUtil.getEntityManager();
    }

    public void saveLivreur(Livreur livreur) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(livreur);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public Livreur getLivreurById(int id) {
        return entityManager.find(Livreur.class, id);
    }

    public List<Livreur> getAllLivreurs() {
        return entityManager.createQuery("FROM Livreur", Livreur.class).getResultList();
    }
    
    public Transport getTransportById(int id) {
    	return entityManager.find(Transport.class, id);
    }

    public void updateLivreur(Livreur livreur) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(livreur);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void deleteLivreur(Livreur livreur) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(livreur);
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