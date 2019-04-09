package com.appgestion.web.services.imp;

import java.util.List;

import com.appgestion.web.dao.ILigneVenteDao;
import com.appgestion.web.entites.LigneVente;
import com.appgestion.web.services.ILigneVenteService;

public class LigneVenteServiceImp implements ILigneVenteService{

	private ILigneVenteDao dao;
	
	public void setDao(ILigneVenteDao dao) {
		this.dao = dao;
	}

	
	public LigneVente save(LigneVente entity) {
		
		return dao.save(entity);
	}

	
	public LigneVente update(LigneVente entity) {
		
		return dao.update(entity);
	}

	
	public List<LigneVente> selectAll() {
		
		return dao.selectAll();
	}

	
	public LigneVente getById(long id) {
		
		return dao.getById(id);
	}

	
	public void remove(long id) {
		dao.remove(id);
		
	}

	
	public List<LigneVente> selectAll(String sortFiled, String sort) {
		
		return dao.selectAll(sortFiled, sort);
	}

	
	public LigneVente findOneBy(String nomParam, Object valeurParam) {
		
		return dao.findOneBy(nomParam, valeurParam);
	}

	
	public LigneVente findOneBy(String[] listParam, Object[] valeurParam) {
		
		return dao.findOneBy(listParam, valeurParam);
	}

	
	public int findCountBy(String nomParam, String valeurParam) {
		
		return dao.findCountBy(nomParam, valeurParam);
	}

	
	
	
}
