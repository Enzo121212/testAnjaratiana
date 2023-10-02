package com.kimiko.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kimiko.beans.Clients;
import com.kimiko.dao.ClientDAO;

import java.util.List;

/**
 * Servlet implementation class ClientsServlet
 */
@WebServlet(name = "Client", urlPatterns = { "/Client" })
public class ClientsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ClientDAO clientDAO;

    public void init() {
        clientDAO = new ClientDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "list":
                listClients(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                deleteClient(request, response);
                break;
            default:
                listClients(request, response);
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
                createClient(request, response);
                break;
            case "update":
                updateClient(request, response);
                break;
            default:
                listClients(request, response);
                break;
        }
    }

    private void listClients(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Clients> clients = clientDAO.getAllClients();
        request.setAttribute("clients", clients);
        request.getRequestDispatcher("clients.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Clients existingClient = clientDAO.getClientById(id);
        request.setAttribute("client", existingClient);
        request.getRequestDispatcher("clients.jsp").forward(request, response);
    }

    private void createClient(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String contacte = request.getParameter("contacte");
        String adresse = request.getParameter("adresse");
        Clients newClient = new Clients(nom, prenom, contacte, adresse);
        System.out.println("---------------------CREATE---------------");
        System.out.println("newClient"+newClient);
        clientDAO.saveClient(newClient);
        response.sendRedirect("Client?action=list");
    }

    private void updateClient(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String contacte = request.getParameter("contacte");
        String adresse = request.getParameter("adresse");
        Clients existingClient = clientDAO.getClientById(id);
        existingClient.setNom(nom);
        existingClient.setPrenom(prenom);
        existingClient.setContacte(contacte);
        existingClient.setAdresse(adresse);
        clientDAO.updateClient(existingClient);
        response.sendRedirect("Client?action=list");
    }

    private void deleteClient(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Clients clientToDelete = clientDAO.getClientById(id);
        clientDAO.deleteClient(clientToDelete);
        response.sendRedirect("Client?action=list");
    }

    public void destroy() {
        clientDAO.close();
    }

}
