package com.appgestion.web.services.imp;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.appgestion.web.dao.IClient;
import com.appgestion.web.entites.Client;
import com.appgestion.web.services.IClientService;

@Transactional

public class ClientServiceImp implements IClientService {

	private IClient dao;
	
	public void setDao(IClient dao) {
		this.dao = dao;
	}
	
	@Override
	public Client save(Client entity) {
		return dao.save(entity);
	}

	@Override
	public Client update(Client entity) {
		return dao.update(entity);
	}

	@Override
	public List<Client> selectAll() {
		return dao.selectAll();
	}

	@Override
	public Client getById(long id) {
		return dao.getById(id);
	}

	@Override
	public void remove(long id) {
		dao.remove(id);
		
	}

	@Override
	public List<Client> selectAll(String sortFiled, String sort) {
		return dao.selectAll(sortFiled, sort);
	}

	@Override
	public Client findOneBy(String nomParam, Object valeurParam) {
		return dao.findOneBy(nomParam, valeurParam);
	}

	@Override
	public Client findOneBy(String[] listParam, Object[] valeurParam) {
		return dao.findOneBy(listParam, valeurParam);
	}

	@Override
	public int findCountBy(String nomParam, String valeurParam) {
		return dao.findCountBy(nomParam, valeurParam);
	}

	@Override
	public Client selectClientByUsername(String username) {
		
		return dao.selectClientByUsername(username);
	}

}
