package com.appgestion.web.services;

import java.util.List;


import com.appgestion.web.entites.Salle;

public interface IRechercheService {
	//public List<Salle>selectAll();
	//public List<Salle> selectAllSalleBy(long prix, String ville, String cat, long place);
	public List<Salle> selectAllSalleByNom(long prix, String ville, String cat, long place);

}
