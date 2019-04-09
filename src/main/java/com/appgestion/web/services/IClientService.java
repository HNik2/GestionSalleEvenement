package com.appgestion.web.services;

import java.util.List;

import com.appgestion.web.entites.Client;

public interface IClientService {

	public Client save(Client entity);
	public Client update(Client entity);
	public List<Client>selectAll();
	public Client getById(long id);
	public void remove(long id);
	public List<Client>selectAll(String sortFiled, String sort);
	public Client findOneBy(String nomParam, Object valeurParam);
	public Client findOneBy(String[]listParam, Object[] valeurParam);
	public int findCountBy(String nomParam, String valeurParam);
	public Client selectClientByUsername(String username);
	
}
