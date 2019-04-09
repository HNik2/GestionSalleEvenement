package com.appgestion.web.dao;

import java.util.Date;
import java.util.List;

import com.appgestion.web.entites.Reservation;


public interface IReservation extends IGenericDao<Reservation>{

	public List<Reservation> selectAllSalleNonReserver(Date dateDebut);
	
}
