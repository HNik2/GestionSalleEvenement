package com.appgestion.web.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.appgestion.web.entites.Reservation;
import com.appgestion.web.model.ModelCommandeClient;
import com.appgestion.web.services.IClientService;
import com.appgestion.web.services.IReservationService;

@Controller
@RequestMapping(value = "/listeReservation")
public class ListeController {
	
	@Autowired
	private IReservationService commandeService;
	
	@Autowired
	private IClientService clientService;
	
	@Autowired
	private ModelCommandeClient modelCommande;

	@RequestMapping(value = "/")
	public String index(Model model) {
		List<Reservation> commandesClient = commandeService.selectAll();
		if (commandesClient.isEmpty()) {
			commandesClient = new ArrayList<Reservation>();
		} 

		model.addAttribute("commandesClient", commandesClient);
		return "listeReservation/listeReservation";
	}

	/*
	 * @RequestMapping(value = "/", method = RequestMethod.GET)
	 * 
	 * @ResponseBody public String currentUserName(Principal principal) { return
	 * principal.getName(); }
	 */
	@RequestMapping(value = "/supprimer/{idReservation}")
	public String supprimerClient(Model model, @PathVariable Long idReservation) {
		if (idReservation != null) {
			Reservation reserver = commandeService.getById(idReservation);
			if (reserver != null) {
				
				commandeService.remove(idReservation);
			}
		}
		return "redirect:/listeReservation/";
	}
	
	/*
	 * @RequestMapping(value = "/modifier/{idReservation}") public String
	 * modifierClient(Model model, @PathVariable long idReservation) { if
	 * (idReservation != 0) { Reservation reserver =
	 * commandeService.getById(idReservation);
	 * 
	 * 
	 * if (reserver != null) { model.addAttribute("reservation", reserver); }
	 * 
	 * } return "listeReservation/reservation"; }
	 */
	
	/*
	 * @RequestMapping(value = "/enregistrerReservation") public String
	 * enregistrerArticle(Principal userDetail, Model model, Reservation reserver) {
	 * 
	 * 
	 * String username = currentUserName(userDetail);
	 * 
	 * //((Client)).getNom();
	 * 
	 * if (reserver.getIdReservation() !=0) { commandeService.update(reserver); }
	 * else { reserver.setLibelleReservation(reserver.getSalle().getNom());
	 * reserver.setClient2(clientService.selectClientByUsername(username)); reserver
	 * = commandeService.save(reserver); modelCommande.sendEmail(reserver); }
	 * System.out.println("username = " +username);
	 * 
	 * return "redirect:/listeReservation/"; }
	 */
}
