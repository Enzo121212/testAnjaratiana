package com.kimiko.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kimiko.beans.Article;
import com.kimiko.dao.ArticleDAO;



/**
 * Servlet implementation class ArticleServlet
 */
@WebServlet(name = "articles", urlPatterns = { "/articles" })
public class ArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	   private ArticleDAO articleDAO;

	    public void init() {
	        articleDAO = new ArticleDAO();
	    }

	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        String action = request.getParameter("action");
	        if (action == null) {
	            action = "list";
	        }

	        switch (action) {
	            case "list":
	                listArticles(request, response);
	                break;
	            case "edit":
	                showEditForm(request, response);
	                break;
	            case "delete":
	                deleteArticle(request, response);
	                break;
	            default:
	                listArticles(request, response);
	                break;
	        }
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        String action = request.getParameter("action");
	        if (action == null) {
	            action = "list";
	        }

	        switch (action) {
	            case "create":
	                createArticle(request, response);
	                break;
	            case "update":
	                updateArticle(request, response);
	                break;
	            default:
	                listArticles(request, response);
	                break;
	        }
	    }

	    private void listArticles(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        List<Article> articles = articleDAO.getAllArticles();
	       
	        	
	        for (Article T : articles) {
                System.out.println( T.getArticle() );
            }
	        
	        request.setAttribute("articles", articles);
	        request.getRequestDispatcher("article-list.jsp").forward(request, response);
	    }

	    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        Long id = Long.parseLong(request.getParameter("id"));
	        Article existingArticle = articleDAO.getArticleById(id);
	        request.setAttribute("article", existingArticle);
	        request.getRequestDispatcher("article-list.jsp").forward(request, response);
	    }

	    private void createArticle(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        String articleName = request.getParameter("articleName");
	        Article newArticle = new Article(articleName);
	        articleDAO.saveArticle(newArticle);
	        response.sendRedirect("articles?action=list");
	    }

	    private void updateArticle(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        Long id = Long.parseLong(request.getParameter("id"));
	        String articleName = request.getParameter("articleName");
	        Article existingArticle = articleDAO.getArticleById(id);
	        existingArticle.setArticle(articleName);
	        articleDAO.updateArticle(existingArticle);
	        response.sendRedirect("articles?action=list");
	    }

	    private void deleteArticle(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        Long id = Long.parseLong(request.getParameter("id"));
	        Article articleToDelete = articleDAO.getArticleById(id);
	        articleDAO.deleteArticle(articleToDelete);
	        response.sendRedirect("articles?action=list");
	    }

	    public void destroy() {
	        articleDAO.close();
	    }

}
