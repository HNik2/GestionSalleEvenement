package com.appgestion.web.dao.imp;

import java.util.List;

import javax.persistence.Query;

import com.appgestion.web.dao.ICategorie;
import com.appgestion.web.entites.Categorie;
import com.appgestion.web.entites.Salle;

public class CategorieDaoImp extends GenericDaoImp<Categorie> implements ICategorie{

	@SuppressWarnings("unchecked")
	@Override
	public List<Salle> selectAllSalleByCategory(long idCategorie) {
		Query query = em.createQuery("select a from " + Salle.class.getSimpleName() + " a where a.categorie.idCategorie = :x");
		query.setParameter("x", idCategorie);
		return query.getResultList();
	}

}
