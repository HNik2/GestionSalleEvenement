package com.appgestion.web.services;

import java.util.Date;
import java.util.List;

import com.appgestion.web.entites.Reservation;

public interface IReservationService {

	public Reservation save(Reservation entity);
	public Reservation update(Reservation entity);
	public List<Reservation>selectAll();
	public Reservation getById(long id);
	public void remove(long id);
	public List<Reservation>selectAll(String sortFiled, String sort);
	public Reservation findOneBy(String nomParam, Object valeurParam);
	public Reservation findOneBy(String[]listParam, Object[] valeurParam);
	public int findCountBy(String nomParam, String valeurParam);
	public List<Reservation> selectAllSalleNonReserver(Date dateDebut);
}
