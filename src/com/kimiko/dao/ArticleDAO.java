package com.kimiko.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.kimiko.beans.Article;
import com.kimiko.util.EntityManagerUtil;

public class ArticleDAO {

    private EntityManager entityManager;

    public ArticleDAO() {
        this.entityManager = EntityManagerUtil.getEntityManager();
    }

    public void saveArticle(Article article) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(article);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public Article getArticleById(Long id) {
        return entityManager.find(Article.class, id);
    }

    public List<Article> getAllArticles() {
        return entityManager.createQuery("FROM Article", Article.class).getResultList();
    }

    public void updateArticle(Article article) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(article);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void deleteArticle(Article article) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(article);
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