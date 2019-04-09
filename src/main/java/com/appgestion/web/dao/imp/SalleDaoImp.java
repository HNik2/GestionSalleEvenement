package com.appgestion.web.dao.imp;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Query;

import com.appgestion.web.dao.ISalle;
import com.appgestion.web.entites.Reservation;
import com.appgestion.web.entites.Salle;

public class SalleDaoImp extends GenericDaoImp<Salle> implements ISalle{
	@SuppressWarnings("unchecked")
	@Override
	public List<Salle> selectAllSalleBy(BigDecimal prix, String ville, String cat, long place) {
		
		Query query = em.createQuery("select a from " + Salle.class.getSimpleName() + " a where a.prix = :x and a.villeSal.nomVille = :y and a.catgori.libelle = :t and a.nbrePlace = :z");
		query.setParameter("x", prix).setParameter("y", ville).setParameter("t", cat).setParameter("z", place);
		System.out.println(query);
		return query.getResultList();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Salle> selectAllSalleByEtat(long idSalle) {
		Query query = em.createQuery("select a from " + Reservation.class.getSimpleName() + " a where a.salle.idSalle <> :x");
		query.setParameter("x", idSalle);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Salle> selectAllNonReserver() {
		//long param = ;
		Query query = em.createQuery("select a from " + Salle.class.getSimpleName() +" a where a.etat = :x");
		query.setParameter("x", false);
		return query.getResultList();
	}

}
