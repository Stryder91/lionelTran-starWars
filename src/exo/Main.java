package exo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Film episodeIV = new Film("Un nouvel espoir", 1977, 4, 11500000, 65000000);
		Film episodeV = new Film("L'Empire contre-attaque", 1980, 5, 33000000, 76000000);
		Film episodeVI = new Film("Le Retour du Jedi", 1983, 6, 32500000, 89500000);
		
		
		// Création nouveau film par l'utilisateur
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez donner les informations d'un film de Star Wars."); 
		System.out.println("Titre du film :"); 
		String titre = sc.nextLine();
		System.out.println("Année de sortie du film :"); 
		String anneeSortie = sc.nextLine(); 
		System.out.println("Numéro d'épisode du film :"); 
		String numeroEpisode = sc.nextLine(); System.out.println("Coût du film :"); 
		String cout = sc.nextLine(); System.out.println("Recette du film :"); 
		String recette = sc.nextLine(); Film nouvelEpisode = new Film(titre, Integer.parseInt(anneeSortie), Integer.parseInt(numeroEpisode), Long.parseLong(cout), Long.parseLong(recette));
		
		Personnage padmeAmidala = new Personnage("Padmé", "Amidala");
		
		List<Film> trilogie = new ArrayList<Film>(Arrays.asList(episodeIV, episodeV, nouvelEpisode));
		
		afficherInformationsTrilogie(trilogie);
		Acteur nataliePortman = new Acteur("Natalie", "Portman", new ArrayList<Personnage>(Arrays.asList(padmeAmidala)));
		
		Personnage hanSolo = new Personnage("Han", "Solo");
		Personnage indianaJones = new Personnage("Indiana", "Jones");
		List<Personnage> personnagesHarrisonFord = new ArrayList<Personnage>();
		personnagesHarrisonFord.add(hanSolo);
		personnagesHarrisonFord.add(indianaJones);
		Acteur harrisonFord = new Acteur("Harrison", "Ford", personnagesHarrisonFord);
		System.out.println("Le nombre de personnage incarnés par " + harrisonFord.prenom + " " + harrisonFord.nom + " est de : " + harrisonFord.nbPersonnages());

		// Test tri
		episodeIV.addActor(harrisonFord);
		episodeIV.addActor(nataliePortman);
		episodeIV.tri();
		System.out.println("Liste des acteurs après tri" + episodeIV.getListActeursByName());
		
		// Test 
//		System.out.println(episodeIV.isBefore(2010));
//		System.out.println(episodeIV.isBefore(1940));
		
		// Question 13
		Map<Integer, Film> dicoFilms = new HashMap<Integer, Film>();
		for (Film film : trilogie) {
			dicoFilms.put(film.anneeSortie, film);
		}
		makeBackUp(dicoFilms);
	}
	
	public static void afficherInformationsTrilogie(List<Film> trilogie) {
		for (Film film : trilogie) {
			System.out.println(film.toString());
		}
	}

	/*
	 * Fonction backup
	 * @param Map<Integer, Film> dictionnaireFilms
	 * @return void
	 */

	public static void makeBackUp (Map<Integer, Film> dictionnaireFilms) {	
		for (Entry<Integer, Film> entry : dictionnaireFilms.entrySet()) {
			if (entry.getValue().calculBenefice().get("isBeneficiary").equals(true)) {
				System.out.println(entry.getKey() + " - " + entry.getValue().titre + " - " + entry.getValue().calculBenefice().get("Benefice"));
			} else {
				System.out.println(entry.getKey() + " - " + entry.getValue().titre + " - " + entry.getValue().calculBenefice().get("Déficit"));
			}
		}
	}
}
