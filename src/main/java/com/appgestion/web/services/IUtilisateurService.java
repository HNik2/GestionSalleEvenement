package com.appgestion.web.services;

import java.util.List;

import com.appgestion.web.entites.Utilisateur;

public interface IUtilisateurService {

	
	public Utilisateur save(Utilisateur entity);
	public Utilisateur update(Utilisateur entity);
	public List<Utilisateur>selectAll();
	public Utilisateur getById(long id);
	public void remove(long id);
	public List<Utilisateur>selectAll(String sortFiled, String sort);
	public Utilisateur findOneBy(String nomParam, Object valeurParam);
	public Utilisateur findOneBy(String[]listParam, Object[] valeurParam);
	public int findCountBy(String nomParam, String valeurParam);
}
