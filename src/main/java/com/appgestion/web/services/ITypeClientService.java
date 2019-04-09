package com.appgestion.web.services;

import java.util.List;

import com.appgestion.web.entites.Client;
import com.appgestion.web.entites.TypeClient;

public interface ITypeClientService {

	public TypeClient save(TypeClient entity);
	public TypeClient update(TypeClient entity);
	public List<TypeClient>selectAll();
	public TypeClient getById(long id);
	public void remove(long id);
	public List<TypeClient>selectAll(String sortFiled, String sort);
	public TypeClient findOneBy(String nomParam, Object valeurParam);
	public TypeClient findOneBy(String[]listParam, Object[] valeurParam);
	public int findCountBy(String nomParam, String valeurParam);
	public List<Client> selectAllClientByType(long idVille);
}
