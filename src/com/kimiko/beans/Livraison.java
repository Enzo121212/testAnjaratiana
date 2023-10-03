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

    @ManyToOne
    @JoinColumn(name="idClient", nullable=false)
    private Clients client;

    @ManyToOne
    @JoinColumn(name="idCommande", nullable=false)
    private Article article;

    @Column(name = "dateLivraison")
    @Temporal(TemporalType.DATE)
    private Date dateLivraison;

    @Column(name = "heureLivraison")
    private String heureLivraison;

    
    @ManyToOne
    @JoinColumn(name="idLivreur", nullable=false)
    private Livreur livreur;


    @ManyToOne
    @JoinColumn(name="idTransport", nullable=false)
    private Transport transport;

    @Column(name = "prix", precision = 10, scale = 2)
    private BigDecimal prix;

    public Livraison(Clients client, Article article, Date dateLivraison, String heureLivraison, Livreur livreur, Transport transport, BigDecimal prix) {
        this.client = client;
        this.article = article;
        this.dateLivraison = dateLivraison;
        this.heureLivraison = heureLivraison;
        this.livreur = livreur;
        this.transport = transport;
        this.prix = prix;
    }
    
    public Livraison() {
  
    }



    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Clients getClient() {
		return client;
	}

	public void setClient(Clients client) {
		this.client = client;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Date getDateLivraison() {
		return dateLivraison;
	}

	public void setDateLivraison(Date dateLivraison) {
		this.dateLivraison = dateLivraison;
	}

	public String getHeureLivraison() {
		return heureLivraison;
	}

	public void setHeureLivraison(String heureLivraison) {
		this.heureLivraison = heureLivraison;
	}

	public Livreur getLivreur() {
		return livreur;
	}

	public void setLivreur(Livreur livreur) {
		this.livreur = livreur;
	}

	public Transport getTransport() {
		return transport;
	}

	public void setTransport(Transport transport) {
		this.transport = transport;
	}

	public BigDecimal getPrix() {
		return prix;
	}

	public void setPrix(BigDecimal prix) {
		this.prix = prix;
	}

	@Override
    public String toString() {
        return "Livraison [id=" + id + ", client=" + client + ", article=" + article + ", dateLivraison=" + dateLivraison
                + ", heureLivraison=" + heureLivraison + ", livreur=" + livreur + ", transport=" + transport + ", prix=" + prix + "]";
    }


}
