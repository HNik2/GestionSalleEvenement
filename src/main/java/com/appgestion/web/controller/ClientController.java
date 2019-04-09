package com.appgestion.web.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.appgestion.web.entites.Client;
import com.appgestion.web.entites.TypeClient;
import com.appgestion.web.entites.Ville;
import com.appgestion.web.services.IClientService;
import com.appgestion.web.services.IFlickrService;
import com.appgestion.web.services.ITypeClientService;
import com.appgestion.web.services.IVilleService;



@Controller
@RequestMapping(value = "/client")
public class ClientController {
	@Autowired
	private IClientService clientService;
	
	@Autowired
	private IVilleService villeService;
	
	@Autowired
	private ITypeClientService typeService;
	
	@Autowired
	private IFlickrService flickrService;
	
	@RequestMapping(value = "/")
	public String client(Model model) {
		List<Client> clients = clientService.selectAll();
		List<Ville> villes = villeService.selectAll();
		List<TypeClient> types = typeService.selectAll();
		if (clients == null) {
			clients = new ArrayList<Client>();
			villes = new ArrayList<Ville>();
			types = new ArrayList<TypeClient>();
		}
		model.addAttribute("clients", clients);
		model.addAttribute("villes", villes);
		model.addAttribute("types", types);
		return "client/client";
	}
	
	@RequestMapping(value = "/nouveau", method = RequestMethod.GET)
	public String ajouterClient(Model model) {
		Client client = new Client();
		List<Ville> villes = villeService.selectAll();
		List<TypeClient> types = typeService.selectAll();
		if (villes == null) {
			villes = new ArrayList<Ville>();
		}
		
		if (types == null) {
			types = new ArrayList<TypeClient>();
		}
		
		model.addAttribute("client", client);
		model.addAttribute("villes", villes);
		model.addAttribute("types", types);
		return "client/ajouterClient";
	}
	
	@RequestMapping(value = "/enregistrer")
	public String enregistrerClient(Model model, Client client, MultipartFile file) {
		String photoUrl = null;
		if (client != null) {
			if (file != null && !file.isEmpty()) {
				InputStream stream = null;
				try {
					stream = file.getInputStream();
					photoUrl = flickrService.savePhoto(stream, client.getNom());
					client.setPhoto(photoUrl);
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
			if (client.getIdClient() != 0) {
				clientService.update(client);
			} else {
				clientService.save(client);
			}
		}
		return "redirect:/client/";
	}
	
	@RequestMapping(value = "/modifier/{idClient}")
	public String modifierClient(Model model, @PathVariable long idClient) {
		if (idClient != 0) {
			Client client = clientService.getById(idClient);
			List<TypeClient> types = typeService.selectAll();
			List<Ville> villes = villeService.selectAll();
			if (villes == null) {
				villes = new ArrayList<Ville>();
			}
			model.addAttribute("villes", villes);
			if (types == null) {
				types = new ArrayList<TypeClient>();
			}
			model.addAttribute("types", types);
			if (client != null) {
				model.addAttribute("client", client);
			}
			
		}
		return "client/ajouterClient";
	}
	
	@RequestMapping(value = "/supprimer/{idClient}")
	public String supprimerClient(Model model, @PathVariable Long idClient) {
		if (idClient != null) {
			Client client = clientService.getById(idClient);
			if (client != null) {
				//TODO Verification avant suppression
				clientService.remove(idClient);
			}
		}
		return "redirect:/client/";
	}
	
	

}
