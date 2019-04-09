package com.appgestion.web.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Roles {
	@Id
	@GeneratedValue
	private Long idRole;
	private String roleName;
	@ManyToOne
	@JoinColumn(name = "idUtilisateur")
	private Utilisateur utilisateur;
	
	@ManyToOne
	@JoinColumn(name = "idClient")
	private Client clientRole;

	public Roles() {
		super();
	}

	public Long getIdRole() {
		return idRole;
	}

	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}

	public String getRoleName() {
		return roleName;
	}
	

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	

	public Client getClientRole() {
		return clientRole;
	}

	public void setClientRole(Client clientRole) {
		this.clientRole = clientRole;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	
	
}
