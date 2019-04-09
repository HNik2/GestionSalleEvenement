package com.appgestion.web.dao.imp;

import java.util.List;

import javax.persistence.Query;

import com.appgestion.web.dao.IVilleDao;
import com.appgestion.web.entites.Client;
import com.appgestion.web.entites.Salle;
import com.appgestion.web.entites.Ville;

public class VilleDaoImp  extends GenericDaoImp<Ville> implements IVilleDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<Salle> selectAllSalleByVille(long idVille) {
		Query query = em.createQuery("select a from " + Salle.class.getSimpleName() + " a where a.ville.idVille = :x");
		query.setParameter("x", idVille);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Client> selectAllClientByVille(long idVille) {
		Query query = em.createQuery("select a from " + Client.class.getSimpleName() + " a where a.ville.idVille = :x");
		query.setParameter("x", idVille);
		return query.getResultList();
	}

}
