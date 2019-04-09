package com.appgestion.web.dao.imp;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import com.appgestion.web.dao.IReservation;
import com.appgestion.web.entites.Reservation;
import com.appgestion.web.entites.Salle;

public class ReservationDaoImp extends GenericDaoImp<Reservation> implements IReservation{

	@SuppressWarnings("unchecked")
	@Override
	public List<Reservation> selectAllSalleNonReserver(Date dateDebut) {
		Query query = em.createQuery("select a from " + Reservation.class.getSimpleName() + " a where a.dateEvenement = :x");
		query.setParameter("x", dateDebut);
		System.out.println(query);
		return query.getResultList();
		
		/*
		 * @Transactional(readOnly = true)
		 * 
		 * @Query("select v from Voyage v where v.vDep.id = :idvdep AND v.vAriv.id = :idvariv AND v.datDep = :dat_dep"
		 * ) Iterable <Voyage> findVoyageByParam(@Param("idvdep") Integer
		 * idvdep, @Param("idvariv") Integer idvariv, @Param("dat_dep") Date dat_dep);
		 */
	}

}
