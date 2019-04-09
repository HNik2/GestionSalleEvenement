package com.appgestion.web.entites;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name="sallecategorie")

public class Categorie implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	
	private long idCategorie;
	private String libelle;
	
	@OneToMany(mappedBy="catgori")
	private List<Salle> salle;
	
	
	public Categorie() {
		super();
	}
	
	@JsonIgnore
	public List<Salle> getSalle() {
		return salle;
	}
	public void setSalle(List<Salle> salle) {
		this.salle = salle;
	}
	public long getIdCategorie() {
		return idCategorie;
	}
	public void setIdCategorie(long idCategorie) {
		this.idCategorie = idCategorie;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	
}
