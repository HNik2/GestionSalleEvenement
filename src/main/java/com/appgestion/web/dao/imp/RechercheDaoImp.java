package com.appgestion.web.dao.imp;

import java.util.List;

import javax.persistence.Query;

import com.appgestion.web.dao.IRechercheDao;
import com.appgestion.web.entites.Recherche;
import com.appgestion.web.entites.Salle;

public class RechercheDaoImp extends GenericDaoImp<Recherche> implements IRechercheDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<Salle> selectAllSalleByNom(long prix, String ville, String cat, long place) {
		
		Query query = em.createQuery("select a from " + Salle.class.getSimpleName() + " a where a.salle.prix = :x and a.salle.villeSal.nomVille = :y and a.salle.nbrePlace = :z and a.salle.catgori.libelle = :t");
		query.setParameter("x", prix).setParameter("y", ville).setParameter("z", place).setParameter("t", cat);
		
		return query.getResultList();
		
	}

}
