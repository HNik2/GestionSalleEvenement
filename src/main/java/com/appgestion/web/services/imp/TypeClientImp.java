package com.appgestion.web.services.imp;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.appgestion.web.dao.ITypeClient;
import com.appgestion.web.entites.Client;
import com.appgestion.web.entites.TypeClient;
import com.appgestion.web.services.ITypeClientService;


@Transactional
public class TypeClientImp implements ITypeClientService {

	private ITypeClient dao;
	
	public void setDao(ITypeClient dao) {
		this.dao = dao;
	}
	@Override
	public TypeClient save(TypeClient entity) {
	
		return dao.save(entity);
	}

	@Override
	public TypeClient update(TypeClient entity) {
		
		return dao.update(entity);
	}

	@Override
	public List<TypeClient> selectAll() {
		
		return dao.selectAll();
	}

	@Override
	public TypeClient getById(long id) {
		
		return dao.getById(id);
	}

	@Override
	public void remove(long id) {
		dao.remove(id);
		
	}

	@Override
	public List<TypeClient> selectAll(String sortFiled, String sort) {
		
		return dao.selectAll(sortFiled, sort);
	}

	@Override
	public TypeClient findOneBy(String nomParam, Object valeurParam) {
		
		return dao.findOneBy(nomParam, valeurParam);
	}

	@Override
	public TypeClient findOneBy(String[] listParam, Object[] valeurParam) {
		
		return dao.findOneBy(listParam, valeurParam);
	}

	@Override
	public int findCountBy(String nomParam, String valeurParam) {
		
		return dao.findCountBy(nomParam, valeurParam);
	}
	
	@Override
	public List<Client> selectAllClientByType(long idVille) {
	
		return dao.selectAllClientByType(idVille);
	}
	
	

}
