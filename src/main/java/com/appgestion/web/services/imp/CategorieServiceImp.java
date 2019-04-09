package com.appgestion.web.services.imp;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.appgestion.web.dao.ICategorie;
import com.appgestion.web.entites.Categorie;
import com.appgestion.web.entites.Salle;
import com.appgestion.web.services.ICategorieService;

@Transactional
public class CategorieServiceImp implements ICategorieService{

	private ICategorie dao;
	
	public void setDao(ICategorie dao) {
		this.dao = dao;
	}
	
	@Override
	public Categorie save(Categorie entity) {
		return dao.save(entity);
	}

	@Override
	public Categorie update(Categorie entity) {
		return dao.update(entity);
	}

	@Override
	public List<Categorie> selectAll() {
		return dao.selectAll();
	}

	@Override
	public Categorie getById(long id) {
		return dao.getById(id);
	}

	@Override
	public void remove(long id) {
		dao.remove(id);
		
	}

	@Override
	public List<Categorie> selectAll(String sortFiled, String sort) {
		return dao.selectAll(sortFiled, sort);
	}

	@Override
	public Categorie findOneBy(String nomParam, Object valeurParam) {
		return dao.findOneBy(nomParam, valeurParam);
	}

	@Override
	public Categorie findOneBy(String[] listParam, Object[] valeurParam) {
		return dao.findOneBy(listParam, valeurParam);
	}

	@Override
	public int findCountBy(String nomParam, String valeurParam) {
		return dao.findCountBy(nomParam, valeurParam);
	}

	@Override
	public List<Salle> selectAllSalleByCategory(long idCategorie) {
		
		return dao.selectAllSalleByCategory(idCategorie);
	}

	

}
