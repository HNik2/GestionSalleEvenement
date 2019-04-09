package com.appgestion.web.dao;

import java.util.List;

import com.appgestion.web.entites.Categorie;
import com.appgestion.web.entites.Salle;

public interface ICategorie extends IGenericDao<Categorie>{
	public List<Salle> selectAllSalleByCategory(long idCategorie);
}
