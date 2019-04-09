package com.appgestion.web.entites;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity

public class Ville implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private long idVille;
	private String nomVille; 
	
	
	@OneToMany(mappedBy="villeSal")
	private List<Salle> salle;
	
	@OneToMany(mappedBy="villeClt")
	private List<Client> client;
	
	public Ville() {
		super();
	}
	
	
	@JsonIgnore
	public List<Salle> getSalle() {
		return salle;
	}
	public void setSalle(List<Salle> salle) {
		this.salle = salle;
	}
	
	@JsonIgnore
	public List<Client> getClient() {
		return client;
	}
	public void setClient(List<Client> client) {
		this.client = client;
	}
	
	public long getIdVille() {
		return idVille;
	}
	public void setIdVille(long idVille) {
		this.idVille = idVille;
	}
	public String getNomVille() {
		return nomVille;
	}
	public void setNomVille(String nomVille) {
		this.nomVille = nomVille;
	}
	
	public String  longToString(long valeur) {
		String rep="";
		try {
			rep = Long.toString(valeur);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rep;
	}
	
}
