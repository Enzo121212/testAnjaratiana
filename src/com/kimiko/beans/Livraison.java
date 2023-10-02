package com.kimiko.beans;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "livraison")
public class Livraison {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "idClient")
    private int idClient;

    @Column(name = "idCommande")
    private int idCommande;

    @Column(name = "dateLivraison")
    @Temporal(TemporalType.DATE)
    private Date dateLivraison;

    @Column(name = "heureLivraison")
    @Temporal(TemporalType.TIME)
    private Date heureLivraison;

    @Column(name = "idLivreur")
    private int idLivreur;

    @Column(name = "idTransport")
    private int idTransport;

    @Column(name = "prix", precision = 10, scale = 2)
    private BigDecimal prix;

 

    public Livraison() {
    }

    public Livraison(int idClient, int idCommande, Date dateLivraison, Date heureLivraison, int idLivreur, int idTransport, BigDecimal prix) {
        this.idClient = idClient;
        this.idCommande = idCommande;
        this.dateLivraison = dateLivraison;
        this.heureLivraison = heureLivraison;
        this.idLivreur = idLivreur;
        this.idTransport = idTransport;
        this.prix = prix;
    }

   

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public int getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}

	public Date getDateLivraison() {
		return dateLivraison;
	}

	public void setDateLivraison(Date dateLivraison) {
		this.dateLivraison = dateLivraison;
	}

	public Date getHeureLivraison() {
		return heureLivraison;
	}

	public void setHeureLivraison(Date heureLivraison) {
		this.heureLivraison = heureLivraison;
	}

	public int getIdLivreur() {
		return idLivreur;
	}

	public void setIdLivreur(int idLivreur) {
		this.idLivreur = idLivreur;
	}

	public int getIdTransport() {
		return idTransport;
	}

	public void setIdTransport(int idTransport) {
		this.idTransport = idTransport;
	}

	public BigDecimal getPrix() {
		return prix;
	}

	public void setPrix(BigDecimal prix) {
		this.prix = prix;
	}

	@Override
    public String toString() {
        return "Livraison [id=" + id + ", idClient=" + idClient + ", idCommande=" + idCommande + ", dateLivraison=" + dateLivraison
                + ", heureLivraison=" + heureLivraison + ", idLivreur=" + idLivreur + ", idTransport=" + idTransport + ", prix=" + prix + "]";
    }
}
