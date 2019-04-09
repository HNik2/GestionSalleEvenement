package com.appgestion.web.services.imp;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.appgestion.web.dao.IUtilisateur;
import com.appgestion.web.entites.Utilisateur;
import com.appgestion.web.services.IUtilisateurService;

@Transactional
public class UtilisateurServiceImp implements IUtilisateurService {
	
	private IUtilisateur dao;
	
	public void setDao(IUtilisateur dao) {
		this.dao = dao;
	}

	@Override
	public Utilisateur save(Utilisateur entity) {
		
		return dao.save(entity);
	}

	@Override
	public Utilisateur update(Utilisateur entity) {
		
		return dao.update(entity);
	}

	@Override
	public List<Utilisateur> selectAll() {
		
		return dao.selectAll();
	}

	@Override
	public Utilisateur getById(long id) {
		
		return dao.getById(id);
	}

	@Override
	public void remove(long id) {
		dao.remove(id);
		
	}

	@Override
	public List<Utilisateur> selectAll(String sortFiled, String sort) {
		
		return dao.selectAll(sortFiled, sort);
	}

	@Override
	public Utilisateur findOneBy(String nomParam, Object valeurParam) {
		
		return dao.findOneBy(nomParam, valeurParam);
	}

	@Override
	public Utilisateur findOneBy(String[] listParam, Object[] valeurParam) {
		
		return dao.findOneBy(listParam, valeurParam);
	}

	@Override
	public int findCountBy(String nomParam, String valeurParam) {
		
		return dao.findCountBy(nomParam, valeurParam);
	}

}
