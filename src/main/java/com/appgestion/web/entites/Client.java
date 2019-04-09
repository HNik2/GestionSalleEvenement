package com.appgestion.web.entites;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="client")

public class Client implements Serializable{
	@Id
	@GeneratedValue
	
	private long idClient;
	private String nom;
	private String prenom;
	private String adresse;
	private String email;
	private String telephone;
	private String password;
	private String photo;
	
	

	private String sexe;
	
	@ManyToOne
	@JoinColumn(name="idTypeClient")
	private TypeClient type;
	
	@OneToMany(mappedBy="client2")
	private List<Reservation> reserve;
	
	@OneToMany(mappedBy="clientPublie")
	private List<Publication> pub;
	
	
	@ManyToOne
	@JoinColumn(name="idVille")
	private Ville villeClt;
	
	private boolean actived;
	
	@OneToMany(mappedBy = "clientRole")
	List<Roles> roles;
	
	public Client() {
		super();
	}
	
	public List<Reservation> getReserve() {
		return reserve;
	}
	
	

	public boolean isActived() {
		return actived;
	}

	public void setActived(boolean actived) {
		this.actived = actived;
	}

	public List<Roles> getRoles() {
		return roles;
	}

	public void setRoles(List<Roles> roles) {
		this.roles = roles;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public void setReserve(List<Reservation> reserve) {
		this.reserve = reserve;
	}
	
	
	public long getIdClient() {
		return idClient;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public TypeClient getType() {
		return type;
	}
	public void setType(TypeClient type) {
		this.type = type;
	}
	
	
	
	public List<Publication> getPub() {
		return pub;
	}
	public void setPub(List<Publication> pub) {
		this.pub = pub;
	}
	public void setIdClient(long idClient) {
		this.idClient = idClient;
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
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Ville getVilleClt() {
		return villeClt;
	}

	public void setVilleClt(Ville villeClt) {
		this.villeClt = villeClt;
	}
	
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
}
