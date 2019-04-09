package com.appgestion.web.services.imp;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.appgestion.web.dao.IPublication;
import com.appgestion.web.entites.Publication;
import com.appgestion.web.services.IPublicationService;
@Transactional

public class PublicationServiceImp implements IPublicationService{

	private IPublication dao;
	
	public void setDao(IPublication dao) {
		this.dao = dao;
	}
	@Override
	public Publication save(Publication entity) {
		return dao.save(entity);
	}

	@Override
	public Publication update(Publication entity) {
		
		return dao.update(entity);
	}

	@Override
	public List<Publication> selectAll() {
		
		return dao.selectAll();
	}

	@Override
	public Publication getById(long id) {
		
		return dao.getById(id);
	}

	@Override
	public void remove(long id) {
		
		dao.remove(id);
	}

	@Override
	public List<Publication> selectAll(String sortFiled, String sort) {
		
		return dao.selectAll(sortFiled, sort);
	}

	@Override
	public Publication findOneBy(String nomParam, Object valeurParam) {
		
		return dao.findOneBy(nomParam, valeurParam);
	}

	@Override
	public Publication findOneBy(String[] listParam, Object[] valeurParam) {
		
		return dao.findOneBy(listParam, valeurParam);
	}

	@Override
	public int findCountBy(String nomParam, String valeurParam) {
		
		return dao.findCountBy(nomParam, valeurParam);
	}

}
