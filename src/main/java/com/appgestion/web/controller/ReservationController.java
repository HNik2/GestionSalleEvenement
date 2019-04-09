package com.appgestion.web.controller;


import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.appgestion.web.entites.Client;
import com.appgestion.web.entites.LigneReservation;
import com.appgestion.web.entites.Reservation;
import com.appgestion.web.entites.Salle;
import com.appgestion.web.entites.TypeClient;
import com.appgestion.web.entites.Ville;
import com.appgestion.web.model.ModelCommandeClient;
import com.appgestion.web.model.StringResponse;
import com.appgestion.web.services.IClientService;
import com.appgestion.web.services.ILigneReservationService;
import com.appgestion.web.services.IReservationService;
import com.appgestion.web.services.ISalleService;

@Controller
@RequestMapping(value = "/commandeclient")
public class ReservationController {

	@Autowired
	private IReservationService commandeService;
	
	@Autowired
	private ILigneReservationService ligneCdeService;
	
	@Autowired
	private IClientService clientService;
	
	@Autowired
	private ISalleService articleService;
	
	@Autowired
	private ModelCommandeClient modelCommande;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateReservation;
	
	@RequestMapping(value = "/")
	public String index(Model model) {
		List<Reservation> commandesClient = commandeService.selectAll();
		if (commandesClient.isEmpty()) {
			commandesClient = new ArrayList<Reservation>();
		} 

		model.addAttribute("commandesClient", commandesClient);
		return " ";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public String currentUserName(Principal principal) {
	   return principal.getName();
	}
	
	@RequestMapping(value = "/nouveau")
	public String nouvelleCommande(Model model) {
		
		List<Client> clients = clientService.selectAll();
		if (clients.isEmpty()) {
			clients = new ArrayList<Client>();
		}
		modelCommande.creerCommande();
		model.addAttribute("code", modelCommande.getCommande().getCode());
		model.addAttribute("dateCde", modelCommande.getCommande().getDateReservation());
		model.addAttribute("clients", clients);
		return "commandeclient/nouvellecommande";
	}
	
	@RequestMapping(value = "/creerCommande")
	@ResponseBody
	public String creerCommande(final long idClient) {
		if (idClient == 0) {
			return null;
		}
		Client client = clientService.getById(idClient);
		if (client == null) {
			return null;
		}
		
		return "OK";
	}
	
	@RequestMapping(value = "/ajouterLigne")
	@ResponseBody
	public LigneReservation getArticleByCode(final Long codeArticle) {
		if (codeArticle == null) {
			return null;
		}
		Salle article = articleService.findOneBy("codeSalle", ""+codeArticle);
		if (article == null) {
			return null;
		}
		return modelCommande.ajouterLigneCommande(article); 
	}
	
	
	@RequestMapping(value = "/reserver/{idSalle}")
	public String reserver(Model model, @PathVariable long idSalle) {
		
		if (idSalle != 0) {
			dateReservation = new Date();
			Salle salle = articleService.getById(idSalle);
			salle.setEtat(true);
			System.out.println("***********test*********** : "+salle.isEtat());
			Reservation reserver = new Reservation();
			reserver.setSalle2(salle);
			
			reserver.setCode(modelCommande.generateCodeCommande());
			reserver.setDateReservation(new Date());
			
			model.addAttribute("reservation", reserver);
		}
		
		
		return "commandeclient/reservation";
	}
	
	
	@RequestMapping(value = "/enregistrerReservation")
	public String enregistrerArticle(Principal userDetail, Model model, Reservation reserver) {
		
		if(commandeService.selectAllSalleNonReserver(reserver.getDateEvenement()).isEmpty()) {
				
				String username = currentUserName(userDetail);
				
				//((Client)).getNom();
				
				if (reserver.getIdReservation() !=0) {
					commandeService.update(reserver);
				} else {
					reserver.setLibelleReservation(reserver.getSalle2().getNom());
					
					reserver.setClient2(clientService.selectClientByUsername(username));
					modelCommande.sendEmail(reserver);
					reserver = commandeService.save(reserver);
					
				}
				return "redirect:/home/";
				
			}
		else {
			System.out.println("Salle déja réserver");
			return "salleReserver/salleReserver";
		}	
		
	}
	
	@RequestMapping(value = "/supprimer")
	public String supprimerClient(Model model, @PathVariable Long idReservation) {
		if (idReservation != null) {
			Reservation reserver = commandeService.getById(idReservation);
			if (reserver != null) {
				
				commandeService.remove(idReservation);
			}
		}
		return "redirect:/commandeclient/";
	}
	
	
	@RequestMapping(value = "/modifier/{idReservation}")
	public String modifierClient(Model model, @PathVariable long idReservation) {
		if (idReservation != 0) {
			Reservation reserver = commandeService.getById(idReservation);
			
			
			if (reserver != null) {
				model.addAttribute("reservation", reserver);
			}
			
		}
		return "commandeclient/reservation";
	}
	
	/*
	 * @RequestMapping(value = "/enrigstrerCommande", produces = "application/json")
	 * 
	 * @ResponseBody public StringResponse enrgistrerCommande(HttpServletRequest
	 * request) { Reservation nouvelleCommande = null; if
	 * (modelCommande.getCommande() != null) { nouvelleCommande =
	 * commandeService.save(modelCommande.getCommande()); } if (nouvelleCommande !=
	 * null) { Collection<LigneReservation> ligneCommandes =
	 * modelCommande.getLignesCommandeClient(nouvelleCommande); if (ligneCommandes
	 * != null && !ligneCommandes.isEmpty()) { for (LigneReservation
	 * ligneCommandeClient : ligneCommandes) {
	 * ligneCdeService.save(ligneCommandeClient); } modelCommande.init(); } }
	 * 
	 * return new StringResponse(request.getContextPath() + "/commandeclient"); }
	 */
	
	
}
