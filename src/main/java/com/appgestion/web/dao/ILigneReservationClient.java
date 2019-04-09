package com.appgestion.web.dao;

import java.util.List;

import com.appgestion.web.entites.LigneReservation;

public interface ILigneReservationClient  extends IGenericDao<LigneReservation>{

	public List<LigneReservation> getByIdCommande(Long idReservation);
}
