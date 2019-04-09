package com.appgestion.web.services;

import java.util.List;

import com.appgestion.web.entites.LigneReservation;

public interface ILigneReservationService {

	public LigneReservation save(LigneReservation entity);
	
	public LigneReservation update(LigneReservation entity);
	
	public List<LigneReservation> selectAll();
	
	public List<LigneReservation> selectAll(String sortField, String sort);
	
	public LigneReservation getById(Long id);
	
	public void remove(Long id);
	
	public LigneReservation findOneBy(String paramName, Object paramValue);
	
	public LigneReservation findOneBy(String[] paramNames, Object[] paramValues);
	
	public int findCountBy(String paramName, String paramValue);
	
	public List<LigneReservation> getByIdCommande(Long idCommandeClient);
}
