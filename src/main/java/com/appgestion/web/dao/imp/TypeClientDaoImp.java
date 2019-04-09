package com.appgestion.web.dao.imp;

import java.util.List;

import javax.persistence.Query;

import com.appgestion.web.dao.ITypeClient;
import com.appgestion.web.entites.Client;
import com.appgestion.web.entites.TypeClient;

public class TypeClientDaoImp extends GenericDaoImp<TypeClient> implements ITypeClient{
	@SuppressWarnings("unchecked")
	@Override
	public List<Client> selectAllClientByType(long idVille) {
		Query query = em.createQuery("select a from " + Client.class.getSimpleName() + " a where a.typeclient.idTypeClient = :x");
		query.setParameter("x", idVille);
		return query.getResultList();
	}

}
