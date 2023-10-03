package com.kimiko.servlet;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kimiko.dao.LivraisonDAO;
import com.kimiko.dao.LivreurDAO;

/**
 * Servlet implementation class DashboardServlet
 */
@WebServlet(name = "Dashboard", urlPatterns = { "/Dashboard" })
public class DashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LivraisonDAO livraisonDAO;
	private LivreurDAO livreurDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DashboardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	public void init() {
        livraisonDAO = new LivraisonDAO();
      	livreurDAO = new LivreurDAO();
    }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Long numberLivraison = livraisonDAO.getCountLivraisonsWithCriteria();
		
		Long numberLivraisonNow = livraisonDAO.getCountLivraisonsNow();
		
		Long numberLivreur = livreurDAO.getCountLivreur();
		
		BigDecimal  totalPrixLivraison = livraisonDAO.getTotalPrixLivraison();
		
		request.setAttribute("numberLivraison", numberLivraison);
		
		request.setAttribute("numberLivraisonNow", numberLivraisonNow);
		
		request.setAttribute("numberLivreur", numberLivreur);
		
		request.setAttribute("totalPrixLivraison", totalPrixLivraison);

		 
		 request.getRequestDispatcher("dashboard.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
