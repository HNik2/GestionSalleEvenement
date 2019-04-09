package com.appgestion.web.dao;

import java.math.BigDecimal;
import java.util.List;

import com.appgestion.web.entites.Salle;

public interface ISalle extends IGenericDao<Salle>{

	public List<Salle> selectAllSalleBy(BigDecimal prix, String ville, String cat, long place);
	public List<Salle> selectAllSalleByEtat(long idSalle);
	public List<Salle> selectAllNonReserver();

}
