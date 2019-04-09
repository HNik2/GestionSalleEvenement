package com.appgestion.web.dao.imp;

import java.util.List;

import javax.persistence.Query;

import com.appgestion.web.dao.ILigneReservationClient;
import com.appgestion.web.entites.LigneReservation;

public class LigneReservationClientImp  extends GenericDaoImp<LigneReservation> implements ILigneReservationClient {

	@SuppressWarnings("unchecked")
	@Override
	public List<LigneReservation> getByIdCommande(Long idLigneReserv) {
		String queryString = "select lc from " + LigneReservation.class.getSimpleName() + " lc where lc.commandeClient.idReservation = :x";
		Query query = em.createQuery(queryString);
		query.setParameter("x", idLigneReserv);
		return query.getResultList();
	}

}
