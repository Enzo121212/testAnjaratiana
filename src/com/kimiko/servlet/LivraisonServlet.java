package com.kimiko.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import com.kimiko.beans.Transport;
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
		try {
			
			int idClient = Integer.parseInt(request.getParameter("idClient"));
			Long idCommande = Long.parseLong(request.getParameter("idCommande"));
		    Date dateLivraison = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dateLivraison"));
		    String heureLivraison = request.getParameter("heureLivraison");
		    int idLivreur = Integer.parseInt(request.getParameter("idLivreur"));
		    int idTransport = Integer.parseInt(request.getParameter("idTransport"));
		    BigDecimal prix = new BigDecimal(request.getParameter("prix"));

		   
		    Clients client = livraisonDAO.getClientById(idClient); 
		    Article article = livraisonDAO.getArticleById(idCommande);
		    Livreur livreur = livraisonDAO.getLivreurById(idLivreur); 
		    Transport transport = livraisonDAO.getTransportById(idTransport); 

	
		    Livraison newLivraison = new Livraison(client, article, dateLivraison, heureLivraison, livreur, transport, prix);		   
		    
		    livraisonDAO.saveLivraison(newLivraison);
		    
		    
		    response.sendRedirect("Livraison");
		} catch (NumberFormatException | ParseException e) {

		    e.printStackTrace(); 
		}
	}

}
