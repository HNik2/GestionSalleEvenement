package com.appgestion.web.services;

import java.util.List;

import com.appgestion.web.entites.LigneVente;

public interface ILigneVenteService {


	public LigneVente save(LigneVente entity);
	public LigneVente update(LigneVente entity);
	public List<LigneVente>selectAll();
	public LigneVente getById(long id);
	public void remove(long id);
	public List<LigneVente>selectAll(String sortFiled, String sort);
	public LigneVente findOneBy(String nomParam, Object valeurParam);
	public LigneVente findOneBy(String[]listParam, Object[] valeurParam);
	public int findCountBy(String nomParam, String valeurParam);
}
