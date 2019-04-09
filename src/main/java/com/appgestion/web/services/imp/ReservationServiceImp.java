package com.appgestion.web.services.imp;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.appgestion.web.dao.IReservation;
import com.appgestion.web.entites.Reservation;
import com.appgestion.web.services.IReservationService;
@Transactional

public class ReservationServiceImp implements IReservationService{

	private IReservation dao;
	
	public void setDao(IReservation dao) {
		this.dao = dao;
	}
	
	@Override
	public Reservation save(Reservation entity) {
		
		return dao.save(entity);
	}

	@Override
	public Reservation update(Reservation entity) {
		
		return dao.update(entity);
	}

	@Override
	public List<Reservation> selectAll() {
		
		return dao.selectAll();
	}

	@Override
	public Reservation getById(long id) {
		
		return dao.getById(id);
	}

	@Override
	public void remove(long id) {
		dao.remove(id);
		
	}

	@Override
	public List<Reservation> selectAll(String sortFiled, String sort) {
		
		return dao.selectAll(sortFiled, sort);
	}

	@Override
	public Reservation findOneBy(String nomParam, Object valeurParam) {
		
		return dao.findOneBy(nomParam, valeurParam);
	}

	@Override
	public Reservation findOneBy(String[] listParam, Object[] valeurParam) {
		
		return dao.findOneBy(listParam, valeurParam);
	}

	@Override
	public int findCountBy(String nomParam, String valeurParam) {
		
		return dao.findCountBy(nomParam, valeurParam);
	}

	@Override
	public List<Reservation> selectAllSalleNonReserver(Date dateDebut) {
		
		return dao.selectAllSalleNonReserver(dateDebut);
	}


}
