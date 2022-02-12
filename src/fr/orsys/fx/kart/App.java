package fr.orsys.fx.kart;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fr.orsys.fx.kart.builders.ParticipationBuilder;
import fr.orsys.fx.kart.business.Banane;
import fr.orsys.fx.kart.business.CarapaceDeTortue;
import fr.orsys.fx.kart.business.Client;
import fr.orsys.fx.kart.business.Kart;
import fr.orsys.fx.kart.business.LanceRoquette;
import fr.orsys.fx.kart.business.Participation;
import fr.orsys.fx.kart.iterators.CollectionDeParticipants;

public class App {

	private static CollectionDeParticipants collectionDeParticipants = new CollectionDeParticipants();
	private static Scanner scanner = new Scanner(System.in);
	private static List<Participation> participations = new ArrayList<>();
	
	public static void main(String[] args) {
		
		int choix = 0;

		while (choix != 5) {
			afficherMenuPrincipal();
			choix = demanderChoix("Veuillez saisir votre choix : ", 1, 5);

			switch (choix) {
			case 1:
				ajouterClient();
				break;
			case 2:
				afficherClients();
				break;
			case 3:
				ajouterParticipation();
				break;
			case 4:
				afficherParticipations();
				break;
			default:
				break;
			}

		}
		scanner.close();

	}
	
	private static void ajouterParticipation() {
		ParticipationBuilder participationBuilder = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			participationBuilder = new ParticipationBuilder(sdf.parse("20/01/2021"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		List<Kart> karts = participationBuilder.getKarts();

		System.out.println("Ajout d'une participation");
		if (collectionDeParticipants.size() == 0) {
			System.out.println("Il n'y a pas de clients !");
		} else {
			Client participant = null;
			afficherClients();
			int choix = demanderChoix("Veuillez choisir un client : ", 1, collectionDeParticipants.size());
			participant = collectionDeParticipants.get(choix-1);

			int compteur = 1;
			for (Kart kart : karts) {
				System.out.println(compteur++ + ": " + kart.getImmatriculation());
			}
			Kart kart = null;
			choix = demanderChoix("Veuillez choisir un kart : ", 1, karts.size());
			kart = karts.get(choix-1);

			boolean continuer = true;

			do {
				afficherOptions();
				choix = demanderChoix("Choisissez le numéro de l'option : ", 1, 3);

				switch (choix) {
				case 1:
					// On décore le kart avec un lance roquette
					kart = new LanceRoquette(kart);
					break;
				case 2:
					// On décore le kart avec une banane
					kart = new Banane(kart);
					break;
				case 3:
					// On décore le kart avec une carapace de tortue
					kart = new CarapaceDeTortue(kart);
					break;
				default:
					System.out.println("Saisie incorrecte, merci de saisir un nombre compris entre 1 et 3");
					break;
				}
				System.out.println("Voici les options de votre kart : " + kart.getNom() + ". Prix total: "
						+ kart.getPrix() + "\n");

				System.out.println("Souhaitez-vous ajouter une nouvelle option (O/N) ?");
				String reponse = "";
				boolean erreur = false;
				do {
					reponse = scanner.nextLine();
					reponse = reponse.toUpperCase();
					if (!reponse.equals("O") && !(reponse.equals("N"))) {
						erreur = true;
					} else {
						erreur = false;
					}
				} while (erreur);
				switch (reponse) {
				case "O":
					continuer = true;
					break;
				case "N":
					continuer = false;
					break;
				default:
					break;
				}
			} while (continuer);

			String nomRepas = null;
			System.out.println("Veuillez préciser le repas souhaité (Burger ou Linguine aux fruits de mer)");
			nomRepas = scanner.nextLine();
			Participation participation = participationBuilder.definirParticipant(participant).definirKart(kart).definirRepas(nomRepas).build();
			participations.add(participation);
			System.out.println(participation);
		}
		
	}

	private static void afficherParticipations() {
		for (Participation participation : participations) {
			System.out.println(participation);
		}
	}

	public static void afficherMenuPrincipal() {
		System.out.println("Menu Principal");
		System.out.println("1) Ajouter un client");
		System.out.println("2) Voir les clients");
		System.out.println("3) Ajouter une participation");
		System.out.println("4) Voir les participations");
		System.out.println("5) Quitter");
	}

	private static void ajouterClient() {
		System.out.println("Ajout d'un client");
		System.out.print("Entrez le nom du client : ");
		String nom = scanner.nextLine();
		System.out.print("Entrez le prénom du client : ");
		String prenom = scanner.nextLine();
		Client client = new Client(prenom, nom);
		collectionDeParticipants.add(client);
	}

	public static void afficherClients() {
		if (collectionDeParticipants.size() == 0) {
			System.out.println("Il n'y pas encore de clients");
		} else {
			// Ceci est possible par l'implémentation de l'interface Interable dans la classe CollectionDeParticipants
			int compteur = 1;
			for (Client client : collectionDeParticipants) {
				System.out.println(compteur++ + ". " + client);
			}
		}
	}

	public static void afficherOptions() {
		System.out.println("1) Ajouter un lance-roquette");
		System.out.println("2) Ajouter une banane");
		System.out.println("3) Ajouter une carapace de tortue");
	}
	
	private static int demanderChoix(String message, int borneMin, int borneMax) {
		int valeur = borneMin - 1;
		do {
			System.out.print(message);
			try {
				String saisie = scanner.nextLine();
				valeur = Integer.parseInt(saisie);
				if (valeur < borneMin || valeur > borneMax) {
					System.out.println("Merci de saisir un nombre compris entre " + borneMin + " et " + borneMax);
				}
			} catch (Exception e) {
				System.out.println("Merci de saisir un nombre");
			}

		} while (!(valeur >= borneMin && valeur <= borneMax));
		return valeur;
	}

}
