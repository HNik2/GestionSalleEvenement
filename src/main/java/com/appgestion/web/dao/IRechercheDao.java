package com.appgestion.web.dao;

import java.util.List;

import com.appgestion.web.entites.Recherche;
import com.appgestion.web.entites.Salle;

public interface IRechercheDao extends IGenericDao<Recherche>{

	public List<Salle> selectAllSalleByNom(long prix, String ville, String cat, long place);

	
	//public List<Salle> selectAllSalleBy(long prix, String ville, String cat, long place);
}
