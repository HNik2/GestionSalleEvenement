package com.appgestion.web.services.imp;

import java.util.List;

import com.appgestion.web.dao.ILigneReservationClient;
import com.appgestion.web.entites.LigneReservation;
import com.appgestion.web.services.ILigneReservationService;

public class LigneReservationServiceImp implements ILigneReservationService{

	private ILigneReservationClient dao;
	
	public void setDao(ILigneReservationClient dao) {
		this.dao = dao;
	}
	
	@Override
	public LigneReservation save(LigneReservation entity) {
		
		return dao.save(entity);
	}

	public LigneReservation update(LigneReservation entity) {
		
		return dao.update(entity);
	}

	public List<LigneReservation> selectAll() {
		
		return dao.selectAll();
	}

	
	public List<LigneReservation> selectAll(String sortField, String sort) {
		
		return dao.selectAll(sortField, sort);
	}

	
	public LigneReservation getById(Long id) {
		
		return dao.getById(id);
	}

	
	public void remove(Long id) {
		dao.remove(id);
		
	}

	public LigneReservation findOneBy(String paramName, Object paramValue) {
		
		return dao.findOneBy(paramName, paramValue);
	}

	
	public LigneReservation findOneBy(String[] paramNames, Object[] paramValues) {
		
		return dao.findOneBy(paramNames, paramValues);
	}

	
	public int findCountBy(String paramName, String paramValue) {
		
		return dao.findCountBy(paramName, paramValue);
	}

	
	public List<LigneReservation> getByIdCommande(Long idCommandeClient) {
		
		return dao.getByIdCommande(idCommandeClient);
	}

	

}
