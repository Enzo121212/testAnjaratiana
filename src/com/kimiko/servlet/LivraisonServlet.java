package com.kimiko.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kimiko.beans.Article;
import com.kimiko.beans.Clients;
import com.kimiko.beans.Livraison;
import com.kimiko.beans.Livreur;
import com.kimiko.dao.LivraisonDAO;

/**
 * Servlet implementation class LivraisonServlet
 */
@WebServlet(name = "Livraison", urlPatterns = { "/Livraison" })
public class LivraisonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LivraisonDAO livraisonDAO;
  
    public LivraisonServlet() {
        super();
    }
	public void init() {
        livraisonDAO = new LivraisonDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Livraison> livraison = livraisonDAO.getAllLivraisons();
        request.setAttribute("livraisons", livraison);
        
        List<Livreur> livreur = livraisonDAO.getAllLivreurs();
        request.setAttribute("livreurs", livreur);
        
        List<Clients> clients = livraisonDAO.getAllClients();
        request.setAttribute("clients", clients);
        
        List<Article> articles = livraisonDAO.getAllArticles();
        request.setAttribute("articles", articles);
        
        request.getRequestDispatcher("livraison.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*int idClient = request.getParameter("idClient");
        int idCommande = request.getParameter("idCommande");
        Date dateLivraison = request.getParameter("dateLivraison");
        Date heureLivraison = request.getParameter("heureLivraison");
		int idLivreur = request.getParameter("idLivreur");
        int idTransport = request.getParameter("idTransport");
        BigDecimal prix = request.getParameter("prix");
        Livraison newlivraison = new Livraison(( idClient,  idCommande,  dateLivraison,  heureLivraison,  idLivreur,  idTransport, BigDecimal prix))
      	livraisonDAO.saveLivraison(newlivraison);
        response.sendRedirect("Livraison");*/
	}

}
