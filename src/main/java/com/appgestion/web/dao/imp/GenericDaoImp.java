package com.appgestion.web.dao.imp;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.appgestion.web.dao.IGenericDao;
@SuppressWarnings("unchecked")

public class GenericDaoImp <E> implements IGenericDao<E>{

	@PersistenceContext
	EntityManager em;
	
	private Class<E>type;
	
	public GenericDaoImp() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class<E>) pt.getActualTypeArguments()[0];
		
	}
	
	
	
	public Class<E> getType() {
		return type;
	}



	public void setType(Class<E> type) {
		this.type = type;
	}



	@Override
	public E save(E entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public E update(E entity) {
		
		return em.merge(entity);
	}

	@Override
	public List<E> selectAll() {
		Query query = em.createQuery("select t from " + type.getSimpleName() +" t");
		
		return query.getResultList();
	}

	@Override
	public E getById(long id) {
		
		return em.find(type, id);
	}

	@Override
	public void remove(long id) {
		E tab = em.getReference(type, id);
		em.remove(tab);
	}

	@Override
	public List<E> selectAll(String sortFiled, String sort) {
		Query query = em.createQuery("select t from " + type.getSimpleName() +" t order by " +sortFiled+" "+sort);
		
		return query.getResultList();
	}

	@Override
	public E findOneBy(String nomParam, Object valeurParam) {
		Query query = em.createQuery("select t from " + type.getSimpleName() + " t where " +nomParam+ " = :x");
		query.setParameter(nomParam, valeurParam);
		
		return query.getResultList().size()> 0 ? (E) query.getResultList().get(0): null;
	}

	@Override
	public E findOneBy(String[] listParam, Object[] valeurParam) {
		if (listParam.length != valeurParam.length) {
			return null;
		}
		String queryString = "select e from " + type.getSimpleName() + " e where ";
		int len = listParam.length;
		for (int i = 0; i < len; i++) {
			queryString += " e." + listParam[i] + " = :x" + i;
			if ((i + 1) < len) {
				queryString += " and ";
			}
		}
		Query query = em.createQuery(queryString);
		for (int i = 0; i < valeurParam.length; i++) {
			query.setParameter("x" + i, valeurParam[i]);
		}
		return query.getResultList().size() > 0 ? (E) query.getResultList().get(0) : null;
	}

	@Override
	public int findCountBy(String nomParam, String valeurParam) {
		Query query = em.createQuery("select t from " + type.getSimpleName() + " t where " + nomParam + " = :x");
		query.setParameter(nomParam, valeurParam);
		return query.getResultList().size() > 0 ? ((Long) query.getSingleResult()).intValue() : 0;
	}
	
	

}
