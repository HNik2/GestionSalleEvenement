package com.appgestion.web.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Qualifier;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.appgestion.web.entites.Categorie;
import com.appgestion.web.entites.Salle;
import com.appgestion.web.entites.Ville;
import com.appgestion.web.export.FileExporter;
import com.appgestion.web.services.ICategorieService;
import com.appgestion.web.services.IFlickrService;
import com.appgestion.web.services.ISalleService;
import com.appgestion.web.services.IVilleService;

@Controller
@RequestMapping(value = "/salle")
public class SalleController {

	@Autowired
	private ISalleService salleService;
	

	@Autowired
	private IVilleService villeService;
	
	@Autowired
	private ICategorieService catService;
	
	@Autowired
	private IFlickrService flickrService;

	@Autowired
	
	private FileExporter exporter;

	@RequestMapping(value = "/")
	public String salle(Model model) {
		List<Salle> salle = salleService.selectAll();
		if (salle == null) {
			salle = new ArrayList<Salle>();
		}
	
		model.addAttribute("salles", salle);
		return "salle/salle";
	}
	
	@RequestMapping(value = "/nouveau", method = RequestMethod.GET)
	public String ajouterSalle(Model model) {
		Salle salle = new Salle();
		List<Ville> listVille = villeService.selectAll();
		List<Categorie> categorie = catService.selectAll();
		if (categorie == null) {
			categorie = new ArrayList<Categorie>();
			
		}
		
		if (listVille == null) {
			listVille = new ArrayList<Ville>();
		}
		
		model.addAttribute("salle", salle);
		model.addAttribute("categories", categorie);
		model.addAttribute("villes", listVille);
		return "salle/ajouterSalle";
	}
	
	@RequestMapping(value = "/enregistrer")
	public String enregistrerArticle(Model model, Salle salle, MultipartFile file) {
		String photoUrl = null;
		if (salle != null) {
			if (file != null && !file.isEmpty()) {
				InputStream stream = null;
				try {
					stream = file.getInputStream();
					photoUrl = flickrService.savePhoto(stream, salle.getNom());
					salle.setPhoto(photoUrl);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						stream.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			if (salle.getIdSalle() != 0) {
				salleService.update(salle);
			} else {
				salleService.save(salle);
			}
		}
		return "redirect:/salle/";
	}
	
	@RequestMapping(value = "/modifier/{idSalle}")
	public String modifierSalle(Model model, @PathVariable long idSalle) {
		if (idSalle != 0) {
			Salle salle = salleService.getById(idSalle);
			List<Categorie> categorie = catService.selectAll();
			List<Ville> listVille = villeService.selectAll();
			if (listVille == null) {
				listVille = new ArrayList<Ville>();
			}
			model.addAttribute("villes", listVille);
			if (categorie == null) {
				categorie = new ArrayList<Categorie>();
			}
			model.addAttribute("categories", categorie);
			if (salle != null) {
				model.addAttribute("salle", salle);
			}
		}
		return "salle/ajouterSalle";
	}
	
	
	
	
	
	
	@RequestMapping(value = "/supprimer/{idSalle}")
	public String supprimerSalle(Model model, @PathVariable Long idSalle) {
		if (idSalle != null) {
			Salle Salle = salleService.getById(idSalle);
			if (Salle != null) {
				//TODO Verification avant suppression
				salleService.remove(idSalle);
			}
		}
		return "redirect:/salle/";
	}
	
	@RequestMapping(value = "/export/") 
	public String exportSalle(HttpServletResponse response) {
		exporter.exportDataToExcel(response, null, null);
		return "salle/salle";
	}
	
}
