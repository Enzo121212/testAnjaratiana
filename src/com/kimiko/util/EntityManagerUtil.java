package com.kimiko.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {
	  private static EntityManagerFactory emf;
	    private static ThreadLocal<EntityManager> threadLocal = new ThreadLocal<>();

	    public static EntityManager getEntityManager() {
	        if (emf == null) {
	            emf = Persistence.createEntityManagerFactory("persistenceRef");
	        }
	        EntityManager em = threadLocal.get();
	        if (em == null || !em.isOpen()) {
	            em = emf.createEntityManager();
	            threadLocal.set(em);
	        }
	        return em;
	    }

	    public static void closeEntityManager() {
	        EntityManager em = threadLocal.get();
	        if (em != null && em.isOpen()) {
	            em.close();
	        }
	        threadLocal.remove();
	    }
}