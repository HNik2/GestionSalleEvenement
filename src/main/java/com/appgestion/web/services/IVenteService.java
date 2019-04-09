package com.appgestion.web.services;

import java.util.List;

import com.appgestion.web.entites.Vente;

public interface IVenteService {

	public Vente save(Vente entity);
	
	public Vente update(Vente entity);

	public List<Vente> selectAll();

	public List<Vente> selectAll(String sortField, String sort);

	public Vente getById(Long id);

	public void remove(Long id);

	public Vente findOneBy(String paramName, Object paramValue);

	public Vente findOneBy(String[] paramNames, Object[] paramValues);

	public int findCountBy(String paramName, String paramValue);
}
