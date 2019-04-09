package com.appgestion.web.entites;

import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.Transient;

import org.apache.axis.types.Time;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.format.annotation.DateTimeFormat;

import com.appgestion.web.dao.imp.LigneReservationClientImp;


@SuppressWarnings("serial")
@Entity
@Table(name="reservation")


public class Reservation implements Serializable{

	@Id
	@GeneratedValue
	
	private long idReservation;
	private String libelleReservation;
	private String code;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateReservation;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")    
    private Date dateEvenement;
    
    public Date getDateEvenement() {
		return dateEvenement;
	}


	public void setDateEvenement(Date dateEvenement) {
		this.dateEvenement = dateEvenement;
	}


	
	public Date getHeureEvenement() {
		return heureEvenement;
	}

	

	public void setHeureEvenement(Date heureEvenement) {
		this.heureEvenement = heureEvenement;
	}


	@DateTimeFormat(pattern="HH:mm")
    private Date heureEvenement;
	
	@DateTimeFormat(pattern="HH:mm")
    private Date heureFinEvenement;
	
	public Date getHeureFinEvenement() {
		return heureFinEvenement;
	}


	public void setHeureFinEvenement(Date heureFinEvenement) {
		this.heureFinEvenement = heureFinEvenement;
	}


	@Transient
	private BigDecimal totalCommande;
	
	@ManyToOne
	@JoinColumn(name = "idSalle")
	private Salle salle2;

	@ManyToOne
	@JoinColumn(name="idClient")
	private Client client2;
	
	@OneToMany(mappedBy = "commandeClient")
	private List<LigneReservation> ligneCommandeClients;

	@JsonIgnore
	public List<LigneReservation> getLigneCommandeClients() {
		return ligneCommandeClients;
	}


	public void setLigneCommandeClients(List<LigneReservation> ligneCommandeClients) {
		this.ligneCommandeClients = ligneCommandeClients;
	}

	public Reservation() {
		dateEvenement = new Date();
		heureEvenement = new Date();
		heureFinEvenement = new Date();
	}
	
	


	public Salle getSalle2() {
		return salle2;
	}


	public void setSalle2(Salle salle2) {
		this.salle2 = salle2;
	}


	public Client getClient2() {
		return client2;
	}

	public void setClient2(Client client2) {
		this.client2 = client2;
	}
	
	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}

	
	public String getLibelleReservation() {
		return libelleReservation;
	}

	public void setLibelleReservation(String libelleReservation) {
		this.libelleReservation = libelleReservation;
	}


	public long getIdReservation() {
		return idReservation;
	}

	public void setIdReservation(long idReservation) {
		this.idReservation = idReservation;
	}
	
	public Date getDateReservation() {
		return dateReservation;
	}

	public void setDateReservation(Date dateReservation) {
		this.dateReservation = dateReservation;
	}
	
	public BigDecimal getTotalCommande() {
		totalCommande = BigDecimal.ZERO;
		if (!ligneCommandeClients.isEmpty()) {
			for (LigneReservation ligneCommandeClient : ligneCommandeClients) {
				if (ligneCommandeClient.getQuantite() != null && ligneCommandeClient.getPrixUnitaire() != null) {
					BigDecimal totalLigne = ligneCommandeClient.getQuantite().multiply(ligneCommandeClient.getSalle().getPrix());
					totalCommande = totalCommande.add(totalLigne);
				}
			}
		}
		return totalCommande;
	}
	
	@Transient
	public String getLigneCommandeJson() {
		/*if(!ligneCommandeClients.isEmpty()) {
			for(LigneReservation ligneReservation : ligneCommandeClients) {
				BigDecimal totalLigne = ligneReservation.getQuantite().multiply(ligneReservation.getPrixUnitaire());
				totalCommande = totalCommande.add(totalLigne);
			}
		}*/
		
		if (!ligneCommandeClients.isEmpty()) {
			try {
				ObjectMapper mapper = new ObjectMapper();
				return mapper.writeValueAsString(ligneCommandeClients);
			} catch (JsonGenerationException e) {
				e.printStackTrace();
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return " ";
	}


	public void setTotalCommande(BigDecimal totalCommande) {
		this.totalCommande = totalCommande;
	}
	
	
	
	
	/*
	 * public boolean disponible(Reservation reserver){
	 * 
	 * if(reserver.getSalle2().getSallesReserver().isEmpty()){ return true; }
	 * 
	 * //Créneaux de notre nouvelle réservation long debutCreation = date.getTime();
	 * long finCreation = date.getTime() + duree;
	 * 
	 * for(Reservation each : this.listeReservation){ //Créneau d'une réservation
	 * déjà existante long finExistante = each.debut() + each.getTemps(); long
	 * debutExistante = each.debut();
	 * 
	 * //Si la nouvelle réservation se finit après le début d'une ancienne
	 * if(finCreation >= debutExistante && debutCreation <= debutExistante){ return
	 * false; } //Si la nouvelle réservation commence avant la fin d'une ancienne
	 * if(debutCreation <= finExistante && finCreation >= finExistante){ return
	 * false; } //Si la nouvelle réservation est en plein dans une réservation
	 * existante if(debutCreation >= debutExistante && finCreation <= finExistante){
	 * return false; } } return true; }
	 */
	
}
