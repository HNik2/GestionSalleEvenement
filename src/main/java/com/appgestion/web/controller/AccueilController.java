package com.appgestion.web.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.appgestion.web.entites.Recherche;
import com.appgestion.web.entites.Salle;
import com.appgestion.web.entites.Ville;
import com.appgestion.web.services.IRechercheService;
import com.appgestion.web.services.ISalleService;
import com.appgestion.web.services.IVilleService;


@Controller
@RequestMapping(value = "/home")
public class AccueilController {

	@Autowired
	private ISalleService salleService;
	
	
	@Autowired
	private IVilleService catService;
	
	@Autowired
	private IRechercheService recherche;
	
	@RequestMapping(value = "/")
	public String home(Model model) {
		Recherche aRechercher= new Recherche();
		List<Salle> salle = salleService.selectAllNonReserver();
		if (salle == null) {
			salle = new ArrayList<Salle>();
		}
		
		List<Ville> categorie = catService.selectAll();
		if (categorie == null) {
			categorie = new ArrayList<Ville>();
		}
		model.addAttribute("aRechercher", aRechercher);	
		model.addAttribute("villes", categorie);
		model.addAttribute("salles", salle);
		return "home/home";
	}
	
	@RequestMapping(value = "/rechercher")
	public String rechercher(Model model, @RequestParam("prix") BigDecimal prix, @RequestParam("nomVille") String nomVille, @RequestParam("categorie") String catego, @RequestParam("nombre") long nombre) {
		//Recherche aRecherche= new Recherche();
		List<Salle> aRechercher = salleService.selectAllSalleBy(prix, nomVille, catego, nombre);
		
		if(aRechercher == null) {
			aRechercher = new ArrayList<Salle>();
		}
			
		//model.addAttribute("villes", categorie);
		model.addAttribute("salles", aRechercher);
		return "home/home";
	}
	
	
	

	
	@RequestMapping(value = "/blank")
	public String blankHome() {
		
		return "home/home";
	}
}
