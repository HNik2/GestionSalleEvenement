package com.appgestion.web.services;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.appgestion.web.entites.Reservation;
import com.appgestion.web.entites.Salle;

public interface ISalleService {

	public Salle save(Salle entity);
	public Salle update(Salle entity);
	public List<Salle>selectAll();
	public Salle getById(long id);
	public void remove(long id);
	public List<Salle>selectAll(String sortFiled, String sort);
	public Salle findOneBy(String nomParam, Object valeurParam);
	public Salle findOneBy(String[]listParam, Object[] valeurParam);
	public int findCountBy(String nomParam, String valeurParam);
	public List<Salle> selectAllSalleBy(BigDecimal prix, String ville, String cat, long place);
	public List<Salle> selectAllSalleByEtat(long idSalle);
	public List<Salle> selectAllNonReserver();

	
}
