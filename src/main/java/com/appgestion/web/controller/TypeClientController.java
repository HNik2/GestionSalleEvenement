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

import com.appgestion.web.dao.ITypeClient;
import com.appgestion.web.entites.Categorie;
import com.appgestion.web.entites.Client;

import com.appgestion.web.entites.TypeClient;


@Controller
@RequestMapping(value = "/type")
public class TypeClientController {
	@Autowired
	private ITypeClient catService;
	
	@RequestMapping(value = "/")
	public String categorie(Model model, HttpServletRequest request, HttpServletResponse response) {
		List<TypeClient> categorie = catService.selectAll();
		if (categorie == null) {
			categorie = new ArrayList<TypeClient>();
		}
		model.addAttribute("categories", categorie);
		return "typeclient/typeclient";
	}
	
	@RequestMapping(value = "/nouveau", method = RequestMethod.GET)
	public String ajouterClient(Model model) {
		Categorie categorie = new Categorie();
		model.addAttribute("categorie", categorie);
		return "typeclient/typeclient";
	}
	
	@RequestMapping(value = "/enregistrer")
	public String enregistrerClient(Model model, TypeClient categorie) {
		if (categorie != null) {
			if (categorie.getIdTypeClient() != 0) {
				catService.update(categorie);
			} else {
				catService.save(categorie);
			}
		}
		return "redirect:/typeclient/";
	}
	
	@RequestMapping(value = "/modifier/{idTypeClient}")
	public String modifierClient(Model model, @PathVariable long idCategorie) {
		if (idCategorie != 0) {
			TypeClient categorie = catService.getById(idCategorie);
			if (categorie != null) {
				model.addAttribute("categorie", categorie);
			}
		}
		return "categorie/ajouterCategorie";
	}
	
	@RequestMapping(value = "/supprimer/{idTypeClient}")
	@ResponseBody
	public String supprimerClient(Model model, @PathVariable long idCategorie) {
		if (idCategorie != 0) {
			TypeClient categorie = catService.getById(idCategorie);
			if (categorie != null) {
				List<Client> salleCat = catService.selectAllClientByType(idCategorie);
				if (salleCat.isEmpty() ) {
					catService.remove(idCategorie);
				} else {
					return "Impossible de supprimer cette catégprie, car elle est affecté à des articles";
				}
			}
		}
		return "redirect:/typeclient/";
	}
	
}
