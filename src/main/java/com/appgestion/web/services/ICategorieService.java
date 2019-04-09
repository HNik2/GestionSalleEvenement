package com.appgestion.web.services;

import java.util.List;

import com.appgestion.web.entites.Categorie;
import com.appgestion.web.entites.Salle;

public interface ICategorieService {

	public Categorie save(Categorie entity);
	public Categorie update(Categorie entity);
	public List<Categorie>selectAll();
	public Categorie getById(long id);
	public void remove(long id);
	public List<Categorie>selectAll(String sortFiled, String sort);
	public Categorie findOneBy(String nomParam, Object valeurParam);
	public Categorie findOneBy(String[]listParam, Object[] valeurParam);
	public int findCountBy(String nomParam, String valeurParam);
	public List<Salle> selectAllSalleByCategory(long idCategorie);
	
}
