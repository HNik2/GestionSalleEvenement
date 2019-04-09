package com.appgestion.web.services;

import java.util.List;

import com.appgestion.web.entites.Administrateur;

public interface IAdministrateurService {

	public Administrateur save(Administrateur entity);
	public Administrateur update(Administrateur entity);
	public List<Administrateur>selectAll();
	public Administrateur getById(long id);
	public void remove(long id);
	public List<Administrateur>selectAll(String sortFiled, String sort);
	public Administrateur findOneBy(String nomParam, Object valeurParam);
	public Administrateur findOneBy(String[]listParam, Object[] valeurParam);
	public int findCountBy(String nomParam, String valeurParam);
}
