package com.appgestion.web.entites;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
public class LigneReservation implements Serializable{

	@Id
	@GeneratedValue
	private Long idLigneReserv;
	
	@ManyToOne
	@JoinColumn(name = "idSalle")
	private Salle salle;
	
	@ManyToOne
	@JoinColumn(name = "idReservation")
	private Reservation commandeClient;
	
	private BigDecimal quantite;
	
	private BigDecimal prixUnitaire;
	
	public Long getIdLigneReserv() {
		return idLigneReserv;
	}

	public void setIdLigneReserv(Long idLigneReserv) {
		this.idLigneReserv = idLigneReserv;
	}

	
	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	@JsonIgnore
	public Reservation getCommandeClient() {
		return commandeClient;
	}

	public void setCommandeClient(Reservation commandeClient) {
		this.commandeClient = commandeClient;
	}

	public BigDecimal getQuantite() {
		return quantite;
	}

	public void setQuantite(BigDecimal quantite) {
		this.quantite = quantite;
	}

	public BigDecimal getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(BigDecimal prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	

}
