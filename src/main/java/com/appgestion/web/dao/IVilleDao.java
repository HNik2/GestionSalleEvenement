package com.appgestion.web.dao;

import java.util.List;

import com.appgestion.web.entites.Client;
import com.appgestion.web.entites.Salle;
import com.appgestion.web.entites.Ville;

public interface IVilleDao extends IGenericDao<Ville>{

	public List<Salle> selectAllSalleByVille(long idVille);
	public List<Client> selectAllClientByVille(long idVille);
}
