package com.appgestion.web.dao;

import com.appgestion.web.entites.Client;

public interface IClient extends IGenericDao<Client>{
	public Client selectClientByUsername(String username);

}
