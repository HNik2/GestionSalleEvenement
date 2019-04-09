package com.appgestion.web.services;

import java.util.List;

import com.appgestion.web.entites.Client;
import com.appgestion.web.entites.Salle;
import com.appgestion.web.entites.Ville;

public interface IVilleService {

	public Ville save(Ville entity);
	public Ville update(Ville entity);
	public List<Ville>selectAll();
	public Ville getById(long id);
	public void remove(long id);
	public List<Ville>selectAll(String sortFiled, String sort);
	public Ville findOneBy(String nomParam, Object valeurParam);
	public Ville findOneBy(String[]listParam, Object[] valeurParam);
	public int findCountBy(String nomParam, String valeurParam);
	public List<Salle> selectAllSalleByVille(long idVille);
	public List<Client> selectAllClientByVille(long idVille);
}
