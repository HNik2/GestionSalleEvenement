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
import com.appgestion.web.entites.Salle;
import com.appgestion.web.services.ICategorieService;

@Controller
@RequestMapping(value = "/categorie")
public class CategorieController {

	@Autowired
	private ICategorieService catService;
	
	@RequestMapping(value = "/")
	public String categorie(Model model, HttpServletRequest request, HttpServletResponse response) {
		List<Categorie> categorie = catService.selectAll();
		if (categorie == null) {
			categorie = new ArrayList<Categorie>();
		}
		model.addAttribute("categories", categorie);
		return "categorie/categorie";
	}
	
	@RequestMapping(value = "/nouveau", method = RequestMethod.GET)
	public String ajouterClient(Model model) {
		Categorie categorie = new Categorie();
		model.addAttribute("categorie", categorie);
		return "categorie/ajouterCategorie";
	}
	
	@RequestMapping(value = "/enregistrer")
	public String enregistrerClient(Model model, Categorie categorie) {
		if (categorie != null) {
			if (categorie.getIdCategorie() != 0) {
				catService.update(categorie);
			} else {
				catService.save(categorie);
			}
		}
		return "redirect:/categorie/";
	}
	
	@RequestMapping(value = "/modifier/{idCategorie}")
	public String modifierClient(Model model, @PathVariable long idCategorie) {
		if (idCategorie != 0) {
			Categorie categorie = catService.getById(idCategorie);
			if (categorie != null) {
				model.addAttribute("categorie", categorie);
			}
		}
		return "categorie/ajouterCategorie";
	}
	
	@RequestMapping(value = "/supprimer/{idCategorie}")
	@ResponseBody
	public String supprimerClient(Model model, @PathVariable long idCategorie) {
		if (idCategorie != 0) {
			Categorie categorie = catService.getById(idCategorie);
			if (categorie != null) {
				List<Salle> salleCat = catService.selectAllSalleByCategory(idCategorie);
				if (salleCat.isEmpty() ) {
					catService.remove(idCategorie);
				} else {
					return "Impossible de supprimer cette catégprie, car elle est affecté à des articles";
				}
			}
		}
		return "redirect:/categorie/";
	}

}
