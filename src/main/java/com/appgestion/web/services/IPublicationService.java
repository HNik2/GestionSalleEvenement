package com.appgestion.web.services;

import java.util.List;

import com.appgestion.web.entites.Publication;

public interface IPublicationService {

	public Publication save(Publication entity);
	public Publication update(Publication entity);
	public List<Publication>selectAll();
	public Publication getById(long id);
	public void remove(long id);
	public List<Publication>selectAll(String sortFiled, String sort);
	public Publication findOneBy(String nomParam, Object valeurParam);
	public Publication findOneBy(String[]listParam, Object[] valeurParam);
	public int findCountBy(String nomParam, String valeurParam);
}
