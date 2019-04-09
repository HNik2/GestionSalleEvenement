package com.appgestion.web.services.imp;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.appgestion.web.dao.IAdministrateur;
import com.appgestion.web.entites.Administrateur;
import com.appgestion.web.services.IAdministrateurService;
@Transactional

public class AdminServiceImp implements IAdministrateurService{

	private IAdministrateur dao;
	
	public void setDao(IAdministrateur dao) {
		this.dao = dao;
	}
	@Override
	public Administrateur save(Administrateur entity) {
		
		return dao.save(entity);
	}

	@Override
	public Administrateur update(Administrateur entity) {
		
		return dao.update(entity);
	}

	@Override
	public List<Administrateur> selectAll() {
		
		return dao.selectAll();
	}

	@Override
	public Administrateur getById(long id) {
		
		return dao.getById(id);
	}

	@Override
	public void remove(long id) {
		dao.remove(id);
		
	}

	@Override
	public List<Administrateur> selectAll(String sortFiled, String sort) {
		
		return dao.selectAll(sortFiled, sort);
	}

	@Override
	public Administrateur findOneBy(String nomParam, Object valeurParam) {
		
		return dao.findOneBy(nomParam, valeurParam);
	}

	@Override
	public Administrateur findOneBy(String[] listParam, Object[] valeurParam) {
		
		return dao.findOneBy(listParam, valeurParam);
	}

	@Override
	public int findCountBy(String nomParam, String valeurParam) {
		
		return dao.findCountBy(nomParam, valeurParam);
	}

}
