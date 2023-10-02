package com.kimiko.dao;


import java.util.List;

import javax.persistence.EntityManager;

import com.kimiko.beans.Clients;
import com.kimiko.util.EntityManagerUtil;

public class ClientDAO {

    private EntityManager entityManager;

    public ClientDAO() {
        this.entityManager = EntityManagerUtil.getEntityManager();
    }

    public void saveClient(Clients client) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(client);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public Clients getClientById(int id) {
        return entityManager.find(Clients.class, id);
    }

    public List<Clients> getAllClients() {
        return entityManager.createQuery("FROM Client", Clients.class).getResultList();
    }

    public void updateClient(Clients client) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(client);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void deleteClient(Clients client) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(client);
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
