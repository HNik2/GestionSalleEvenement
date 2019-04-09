package com.appgestion.web.entites;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Recherche implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private long id;
	private String nomVille;
	private long prix;
	private String catego;
	private long nombre;
	private Date date;
	
	
	
	public Recherche() {
		super();
	}
	
	public Recherche(String nomVille, long prix, String catego, long nombre, Date date) {
		super();
		this.nomVille = nomVille;
		this.prix = prix;
		this.catego = catego;
		this.nombre = nombre;
		this.date = date;
	}
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getNomVille() {
		return nomVille;
	}
	public void setNomVille(String nomVille) {
		this.nomVille = nomVille;
	}
	public long getPrix() {
		return prix;
	}
	public void setPrix(long prix) {
		this.prix = prix;
	}
	public String getCatego() {
		return catego;
	}
	public void setCatego(String catego) {
		this.catego = catego;
	}
	public long getNombre() {
		return nombre;
	}
	public void setNombre(long nombre) {
		this.nombre = nombre;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	

}
