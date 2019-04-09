package com.appgestion.web.model;

import java.util.Collection;
import java.util.Map;


import com.appgestion.web.entites.Client;
import com.appgestion.web.entites.LigneReservation;
import com.appgestion.web.entites.Reservation;
import com.appgestion.web.entites.Salle;

public interface ModelCommandeClient {


	void creerCommande();
	
	void modifierCommande(Client client);
	
	LigneReservation ajouterLigneCommande(Salle article);
	
	LigneReservation supprimerLigneCommande(Salle article);
	
	LigneReservation modifierQuantite(Salle article, double qte);
	
	String generateCodeCommande();
	
	Reservation getCommande();
	
	Map<Long, LigneReservation> getLigneCde();
	
	Collection<LigneReservation> getLignesCommandeClient(Reservation commande);
	
	void init();
	public void sendEmail(Reservation reservation);
}
