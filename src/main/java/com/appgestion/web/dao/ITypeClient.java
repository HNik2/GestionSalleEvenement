package com.appgestion.web.dao;

import java.util.List;

import com.appgestion.web.entites.Client;
import com.appgestion.web.entites.TypeClient;

public interface ITypeClient extends IGenericDao<TypeClient>{

	public List<Client> selectAllClientByType(long idVille);
}
