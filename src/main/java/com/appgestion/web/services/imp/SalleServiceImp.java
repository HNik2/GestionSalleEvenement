package com.appgestion.web.services.imp;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.appgestion.web.dao.ISalle;
import com.appgestion.web.entites.Salle;
import com.appgestion.web.services.ISalleService;

@Transactional

public class SalleServiceImp implements ISalleService{

	private ISalle dao;
	
	public void setDao(ISalle dao) {
		this.dao = dao;
	}
	
	@Override
	public Salle save(Salle entity) {
		
		return dao.save(entity);
	}

	@Override
	public Salle update(Salle entity) {
		
		return dao.update(entity);
	}

	@Override
	public List<Salle> selectAll() {
		
		return dao.selectAll();
	}

	@Override
	public Salle getById(long id) {
		
		return dao.getById(id);
	}

	@Override
	public void remove(long id) {
		dao.remove(id);
		
	}

	@Override
	public List<Salle> selectAll(String sortFiled, String sort) {
		
		return dao.selectAll(sortFiled, sort);
	}

	@Override
	public Salle findOneBy(String nomParam, Object valeurParam) {
		
		return dao.findOneBy(nomParam, valeurParam);
	}

	@Override
	public Salle findOneBy(String[] listParam, Object[] valeurParam) {
		
		return dao.findOneBy(listParam, valeurParam);
	}

	@Override
	public int findCountBy(String nomParam, String valeurParam) {
		
		return dao.findCountBy(nomParam, valeurParam);
	}

	@Override
	public List<Salle> selectAllSalleBy(BigDecimal prix, String ville, String cat, long place) {
		
		return dao.selectAllSalleBy(prix, ville, cat, place);
	}
	
	@Override
	public List<Salle> selectAllSalleByEtat(long idSalle){
		
		return dao.selectAllSalleByEtat(idSalle);
	}

	@Override
	public List<Salle> selectAllNonReserver() {
		
		return dao.selectAllNonReserver();
	}
	

}
