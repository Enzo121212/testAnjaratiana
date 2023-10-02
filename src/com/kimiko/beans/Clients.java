package com.kimiko.beans;

import javax.persistence.*;

@Entity
@Table(name = "clients")
public class Clients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "contacte")
    private String contacte;

    @Column(name = "adresse")
    private String adresse;

   

    public Clients() {
    }

    public Clients(String nom, String prenom, String contacte, String adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.contacte = contacte;
        this.adresse = adresse;
    }



    public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getContacte() {
		return contacte;
	}

	public void setContacte(String contacte) {
		this.contacte = contacte;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getId() {
		return id;
	}

	@Override
    public String toString() {
        return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", contacte=" + contacte + ", adresse="
                + adresse + "]";
    }
}
