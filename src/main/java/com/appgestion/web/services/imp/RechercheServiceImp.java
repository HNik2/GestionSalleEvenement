package com.appgestion.web.services.imp;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.appgestion.web.dao.IRechercheDao;
import com.appgestion.web.entites.Salle;
import com.appgestion.web.services.IRechercheService;

@Transactional
public class RechercheServiceImp implements IRechercheService{
	
	 private IRechercheDao dao;
	 public void setDao(IRechercheDao dao) { this.dao = dao; }
	 
	 @Override
	 public List<Salle> selectAllSalleByNom(long prix, String ville, String cat, long place) {
			
		return dao.selectAllSalleByNom(prix, ville, cat, place);
	 }
	
	
	//@Override
	/*public List<Salle> selectAllSalleBy(long prix, String ville, String cat, long place) {
		
		return dao.selectAllSalleBy(prix, ville, cat, place);
	}*/

}
