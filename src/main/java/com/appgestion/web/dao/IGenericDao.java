package com.appgestion.web.dao;

import java.util.List;

public interface IGenericDao<E> {

	public E save(E entity);
	public E update(E entity);
	public List<E>selectAll();
	public E getById(long id);
	public void remove(long id);
	public List<E>selectAll(String sortFiled, String sort);
	public E findOneBy(String nomParam, Object valeurParam);
	public E findOneBy(String[]listParam, Object[] valeurParam);
	public int findCountBy(String nomParam, String valeurParam);
	
	
}
