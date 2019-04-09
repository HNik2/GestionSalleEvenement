package com.appgestion.web.entites;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="publication")

public class Publication implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	
	private long idPub;
	private String libellePub;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date datePublication;
	
	
	@ManyToOne
	@JoinColumn(name="idClient")
	private Client clientPublie;
	
	@OneToMany(mappedBy="publie")
	private List<Salle> salleProprietaire;
	
	public Publication() {
		super();
	}
	
	public Client getClientPublie() {
		return clientPublie;
	}
	public void setClientPublie(Client clientPublie) {
		this.clientPublie = clientPublie;
	}
	
	public List<Salle> getSalleProprietaire() {
		return salleProprietaire;
	}
	public void setSalleProprietaire(List<Salle> salleProprietaire) {
		this.salleProprietaire = salleProprietaire;
	}
	public long getIdPub() {
		return idPub;
	}
	public void setIdPub(long idPub) {
		this.idPub = idPub;
	}
	public String getLibellePub() {
		return libellePub;
	}
	public void setLibellePub(String libellePub) {
		this.libellePub = libellePub;
	}

	public Date getDatePublication() {
		return datePublication;
	}

	public void setDatePublication(Date datePublication) {
		this.datePublication = datePublication;
	}
	
	
}
