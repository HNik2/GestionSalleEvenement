package com.appgestion.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.appgestion.web.entites.Categorie;
import com.appgestion.web.entites.Client;
import com.appgestion.web.entites.Salle;
import com.appgestion.web.entites.Ville;
import com.appgestion.web.services.IVilleService;

@Controller
@RequestMapping(value = "/ville")
public class VilleController {

	@Autowired
	private IVilleService catService;
	
	@Autowired
	private IVilleService catService1;
	
	@RequestMapping(value = "/")
	public String categorie(Model model, HttpServletRequest request, HttpServletResponse response) {
		List<Ville> categorie = catService.selectAll();
		if (categorie == null) {
			categorie = new ArrayList<Ville>();
		}
		model.addAttribute("villes", categorie);
		return "ville/ville";
	}
	
	@RequestMapping(value = "/nouveau", method = RequestMethod.GET)
	public String ajouterClient(Model model) {
		Ville categorie = new Ville();
		model.addAttribute("ville", categorie);
		return "ville/ajouterVille";
	}
	
	@RequestMapping(value = "/enregistrer")
	public String enregistrerClient(Model model, Ville categorie) {
		if (categorie != null) {
			if (categorie.getIdVille() != 0) {
				catService.update(categorie);
			} else {
				catService.save(categorie);
			}
		}
		return "redirect:/ville/";
	}
	
	@RequestMapping(value = "/modifier/{idVille}")
	public String modifierClient(Model model, @PathVariable long idVille) {
		if (idVille != 0) {
			Ville categorie = catService.getById(idVille);
			if (categorie != null) {
				model.addAttribute("ville", categorie);
			}
		}
		return "ville/ajouterVille";
	}
	
	@RequestMapping(value = "/supprimer/{idVille}")
	public String supprimerClient(Model model, @PathVariable long idVille) {
		if (idVille != 0) {
			Ville categorie = catService.getById(idVille);
			if (categorie != null) {
				List<Salle> salleCat = catService.selectAllSalleByVille(idVille);
				List<Client> clientList = catService1.selectAllClientByVille(idVille);
				if (salleCat.isEmpty() && clientList.isEmpty()) {
					catService.remove(idVille);
					
				} else {
					return "Impossible de supprimer cette catégprie, car elle est affecté à des articles";
				}
			}
		}
		return "redirect:/ville/";
	}
	
	
}
