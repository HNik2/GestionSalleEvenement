package com.appgestion.web.services.imp;

import java.util.List;

import com.appgestion.web.dao.IVenteDao;
import com.appgestion.web.entites.Vente;
import com.appgestion.web.services.IVenteService;

public class VenteServiceImp implements IVenteService{

	private IVenteDao dao;
	
	public void setDao(IVenteDao dao) {
		this.dao = dao;
	}
	
	@Override
	public Vente save(Vente entity) {
		return dao.save(entity);
	}

	@Override
	public Vente update(Vente entity) {
		
		return dao.update(entity);
	}

	@Override
	public List<Vente> selectAll() {
	
		return dao.selectAll();
	}

	@Override
	public List<Vente> selectAll(String sortField, String sort) {
		
		return dao.selectAll(sortField, sort);
	}

	@Override
	public Vente getById(Long id) {
		
		return dao.getById(id);
	}

	@Override
	public void remove(Long id) {
		dao.remove(id);
	}

	@Override
	public Vente findOneBy(String paramName, Object paramValue) {
		
		return dao.findOneBy(paramName, paramValue);
	}

	@Override
	public Vente findOneBy(String[] paramNames, Object[] paramValues) {
		
		return dao.findOneBy(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		
		return dao.findCountBy(paramName, paramValue);
	}

}
