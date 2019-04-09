package com.appgestion.web.model;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Component;

import com.appgestion.web.entites.Client;
import com.appgestion.web.entites.LigneReservation;
import com.appgestion.web.entites.Reservation;
import com.appgestion.web.entites.Salle;

@Component
public class ModelCommandeClientImp implements ModelCommandeClient {

	private Reservation commande;
	private Map<Long, LigneReservation> ligneCde = new HashMap<Long, LigneReservation>();
	
	@Override
	public void creerCommande() {
		commande = new Reservation();
		commande.setDateReservation(new Date());
		commande.setCode(generateCodeCommande());
		
	}

	@Override
	public void modifierCommande(Client client) {
		if (client == null) {
			return;
		}
		if (commande != null) {
			commande.setClient2(client);
		}
		
	}

	@Override
	public LigneReservation ajouterLigneCommande(Salle article) {
		if (article == null) {
			return null;
		}
		LigneReservation lc = ligneCde.get(article.getIdSalle());
		if (lc != null) {
			BigDecimal qte = lc.getQuantite().add(BigDecimal.ONE);
			lc.setQuantite(qte);
			ligneCde.put(article.getIdSalle(), lc);
			return lc;
		} else {
			LigneReservation ligne = new LigneReservation();
			ligne.setCommandeClient(commande);
			ligne.setQuantite(BigDecimal.ONE);
			ligne.setPrixUnitaire(article.getPrix());
			ligne.setSalle(article);
			ligneCde.put(article.getIdSalle(), ligne);
			return ligne;
		}	
	}

	@Override
	public LigneReservation supprimerLigneCommande(Salle article) {
		if (article == null) {
			return null;
		}
		return ligneCde.remove(article.getIdSalle());
		
	}

	@Override
	public LigneReservation modifierQuantite(Salle article, double qte) {
		if (article == null) {
			return null;
		}
		LigneReservation lc = ligneCde.get(article.getIdSalle());
		if (lc == null) {
			return null;
		}
		lc.setQuantite(BigDecimal.valueOf(qte));
		return lc;
	}

	@Override
	public String generateCodeCommande() {
		return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase() ;
	}

	@Override
	public Reservation getCommande() {
		return commande;
	}

	public void setCommande(Reservation commande) {
		this.commande = commande;
	}
	
	@Override
	public Map<Long, LigneReservation> getLigneCde() {
		return ligneCde;
	}

	@Override
	public Collection<LigneReservation> getLignesCommandeClient(Reservation commande) {
		for (LigneReservation ligneCdeClt : ligneCde.values()) {
			ligneCdeClt.setCommandeClient(commande);
		}
		return ligneCde.values();
	}

	public void setLigneCde(Map<Long, LigneReservation> ligneCde) {
		this.ligneCde = ligneCde;
	}
	
	@Override
	public void init() {
		commande = null;
		ligneCde.clear();
		
	}
	
    @Override
    public void sendEmail(Reservation reservation) {
        final String emailFrom = "bsolibia@gmail.com";

        final String password = " basile2019";
        String emailTo = reservation.getClient2().getEmail();
        String sujet = "Votre reservation de salle " + String.valueOf(reservation.getCode());
       // sujet = "Votre confirmation NBTrans No " + String.valueOf(reservation.getIdReservation()) : sujet;
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("DÉTAIL DE LA RÉSERVATION :");

        String pattern = "dd-MM-yyyy";
        String pattern2 = "HH:mm";
        String pattern3 = "HH:mm";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(pattern2);
        SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat(pattern3);
        String date = simpleDateFormat.format(reservation.getDateEvenement());
        String heure = simpleDateFormat2.format(reservation.getHeureEvenement());
        String heure2 = simpleDateFormat3.format(reservation.getHeureFinEvenement());
        stringBuilder.append("\nNom de la Salle : " +reservation.getLibelleReservation());
        stringBuilder.append("\nDate: " + date+" de "+ heure+ " à " +heure2);
        stringBuilder.append("\nCoût de la Salle : " +reservation.getSalle2().getPrix());
        stringBuilder.append("\nRéservation en attente de confirmation ! ");
        

		/*
		 * stringBuilder.append("\nArrivée: " +
		 * reservation.getVoyage().getvAriv().getLibelle());
		 * 
		 * stringBuilder.append("\nPrix: " + reservation.getVoyage().getPrix());
		 * 
		 * stringBuilder.append("\nRENSEIGNEMENTS SUR LE PASSAGER:");
		 * 
		 * stringBuilder.append("\nNom: " + reservation.getClient().getNom());
		 * stringBuilder.append("\nPrénom " + reservation.getClient().getPrenom());
		 * stringBuilder.append("\nTéléphone: " + reservation.getClient().getTel());
		 */

        String message = stringBuilder.toString();
        //System.out.println("Message == " + message);

        Properties props = new Properties();

        props.put("mail.transport.protocol", "smtp");
        props.put("mail.debug", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.timeout", "10000");
        props.put("mail.smtp.ssl.checkserveridentity", "false");
        props.put("mail.smtp.ssl.trust", "*");
        props.put("mail.smtp.connectiontimeout", "10000");
        props.put("mail.smtp.debug", "true");
        props.put("mail.smtp.socketFactory.fallback", "false");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(emailFrom, password);
            }
        });

        try {
            Message mailMessage = new MimeMessage(session);
            mailMessage.setFrom(new InternetAddress(emailFrom));
            mailMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailTo));

            mailMessage.setSubject(sujet);
            mailMessage.setText(message);
            Transport.send(mailMessage);
            System.out.println("Email envoye avec succes");
        } catch (MessagingException e) {
            System.out.println("Unable to send mail" + e.getMessage());
            throw new RuntimeException(e);
        }
    }




}
