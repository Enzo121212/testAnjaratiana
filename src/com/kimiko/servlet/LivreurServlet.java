package com.kimiko.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kimiko.beans.Livreur;
import com.kimiko.dao.LivreurDAO;

/**
 * Servlet implementation class LivreurServlet
 */
@WebServlet(name = "Livreur", urlPatterns = { "/Livreur" })
public class LivreurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LivreurDAO livreurDAO;

    public void init() {
    	livreurDAO = new LivreurDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "list":
                listLivreur(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                deleteLivreur(request, response);
                break;
            default:
                listLivreur(request, response);
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        System.out.println("action"+action);
        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "create":
                createLivreur(request, response);
                break;
            case "update":
                updateLivreur(request, response);
                break;
            default:
                listLivreur(request, response);
                break;
        }
    }

    private void listLivreur(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Livreur> livreur = livreurDAO.getAllLivreurs();
        request.setAttribute("livreurs", livreur);
        request.getRequestDispatcher("livreur.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Livreur existingClient = livreurDAO.getLivreurById(id);
        request.setAttribute("livreur", existingClient);
        request.getRequestDispatcher("livreur.jsp").forward(request, response);
    }

    private void createLivreur(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String contacte = request.getParameter("contacte");
        String adresse = request.getParameter("adresse");
        Livreur newLivreur = new Livreur(nom, prenom, contacte, adresse);
        System.out.println("---------------------CREATE---------------");
        System.out.println("newClient"+newLivreur);
        livreurDAO.saveLivreur(newLivreur);
        response.sendRedirect("Livreur?action=list");
    }

    private void updateLivreur(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String contacte = request.getParameter("contacte");
        String adresse = request.getParameter("adresse");
        Livreur existingLivreur = livreurDAO.getLivreurById(id);
        existingLivreur.setNom(nom);
        existingLivreur.setPrenom(prenom);
        existingLivreur.setContacte(contacte);
        existingLivreur.setAdresse(adresse);
        livreurDAO.updateLivreur(existingLivreur);
        response.sendRedirect("Livreur?action=list");
    }

    private void deleteLivreur(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Livreur livreurToDelete = livreurDAO.getLivreurById(id);
        livreurDAO.deleteLivreur(livreurToDelete);
        response.sendRedirect("Livreur?action=list");
    }

    public void destroy() {
    	livreurDAO.close();
    }

}
