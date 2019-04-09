package com.appgestion.web;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	private IClientService clientService;
	
	@Autowired
	private IVilleService villeService;
	
	@Autowired
	private ITypeClientService typeService;
	@Autowired
	private IFlickrService flickrService;
	
private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "login/login";
	}
	
	
	@RequestMapping(value = "/failedlogin")
	public String failedLogin() {
		
		return "login/login";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String inscription(Model model) {
		
		
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
		
		return "login/register";
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
		return "redirect:/";
	}
	
}
