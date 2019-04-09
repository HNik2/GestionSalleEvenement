package com.appgestion.web.dao.imp;



import javax.persistence.Query;

import com.appgestion.web.dao.IClient;
import com.appgestion.web.entites.Client;


public class ClientDaoImp extends GenericDaoImp<Client> implements IClient{

	@Override
	public Client selectClientByUsername(String username) {
		Query query = em.createQuery("select c from " + Client.class.getSimpleName() + " c where c.email = :x");
		query.setParameter("x", username);
		return (Client) query.getSingleResult();
	}
}
