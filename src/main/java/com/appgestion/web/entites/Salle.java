package com.appgestion.web.entites;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="salle")
public class Salle implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private long idSalle;
	private String codeSalle;
	
	private String nom;
	private String adresse;
	private BigDecimal prix;
	private String photo;
	private boolean etat;

	private long nbrePlace;

	

	@ManyToOne
	@JoinColumn(name="idVille")
	private Ville villeSal;

	@ManyToOne
	@JoinColumn(name="idCategorie")
	private Categorie catgori;
	
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="idClient") private Client clientPub;
	 */
	
	
	@ManyToOne
	@JoinColumn(name="idPub")
	private Publication publie;
	
	@OneToMany(mappedBy="salle2")
	private List<Reservation> sallesReserver;
	
	public List<Reservation> getSallesReserver() {
		return sallesReserver;
	}


	public void setSallesReserver(List<Reservation> sallesReserver) {
		this.sallesReserver = sallesReserver;
	}


	public Salle() {
		super();
	}
	
	
	public long getNbrePlace() {
		return nbrePlace;
	}

	public void setNbrePlace(long nbrePlace) {
		this.nbrePlace = nbrePlace;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public boolean isEtat() {
		return etat;
	}
	
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	public Publication getPublie() {
		return publie;
	}
	public void setPublie(Publication publie) {
		this.publie = publie;
	}
	
	public Categorie getCatgori() {
		return catgori;
	}
	public void setCatgori(Categorie catgori) {
		this.catgori = catgori;
	}
	
	
	public String getCodeSalle() {
		return codeSalle;
	}

	public void setCodeSalle(String codeSalle) {
		this.codeSalle = codeSalle;
	}
	public long getIdSalle() {
		return idSalle;
	}
	public void setIdSalle(long idSalle) {
		this.idSalle = idSalle;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public BigDecimal getPrix() {
		return prix;
	}

	public void setPrix(BigDecimal prix) {
		this.prix = prix;
	}

	
	
	public Ville getVilleSal() {
		return villeSal;
	}

	public void setVilleSal(Ville villeSal) {
		this.villeSal = villeSal;
	}
	
}
