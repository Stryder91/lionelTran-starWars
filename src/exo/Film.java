package exo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Repr�sente un film
 * @author Lionel Tran
*/
public class Film {
	String titre;
	int anneeSortie;
	int numeroEpisode;
	long cout;
	long recette;
	List<Acteur> listeActeurs;
	
	/**
	 * M�thode de cr�ation d'un film
	 * @param titre : String repr�sentant le titre du film
	 * @param anneeSortie : int repr�sentant l'annee de sortie du film
	 * @param numeroEpisode : int repr�sentant le num�ro d'�pisode du film
	 * @param cout : long repr�sentant le co�t du film
	 * @param recette : long repr�sentant la recette du film
	 */ 
	public Film(String titre, int anneeSortie, int numeroEpisode, long cout, long recette) {
		this.titre = titre;
		this.anneeSortie = anneeSortie;
		this.numeroEpisode = numeroEpisode;
		this.cout = cout;
		this.recette = recette;
		this.listeActeurs = new ArrayList<Acteur>();
	}
	
	/**
	 * M�thode d'informations sur la classe et ses attributs
	 * @return String indiquant le nom de la classe de l'instance, ses attributs et les valeurs de ses attributs
	 */ 
	public String toString() {
		// Creation d'une classe utils dans laquelle j'ai mis la m�thode toString car elle est reutilisable dans toutes les classes
		Utils utils = new Utils();
		return utils.toString(this);
	}
	
	// Getters
	
	/** Methode getter titre
	 * @return String repr�sentant le titre du film
	*/
	public String getTitre() {
		return titre;
	}
	
	/** Methode getter anneeSortie
	 * @return int repr�sentant l'ann�e de sortie du film
	*/
	public int getAnneeSortie() {
		return anneeSortie;
	}
	
	/** Methode getter numeroEpisode
	 * @return String repr�sentant le num�ro d'�pisode du film
	*/
	public int getNumeroEpisode() {
		return numeroEpisode;
	}
	
	/** Methode getter cout
	 * @return long repr�sentant le co�t du film
	*/
	public double getCout() {
		return cout;
	}
	
	/** Methode getter recette
	 * @return long repr�sentant la recette du film
	*/
	public double getRecette() {
		return recette;
	}
	
	/** Methode pour obtenir la liste d'acteurs par nom complet
	 * @return List<String> repr�sentant la liste des acteurs par leur nom
	*/
	public List<String> getListActeursByName() {
		List<String> listActeursByName = new ArrayList<String>();
		listeActeurs.forEach((acteur) -> {
			listActeursByName.add(acteur.prenom + " " + acteur.nom);
		});
		return listActeursByName;
	}
	
	// Setters
	
	/** Methode setter titre
	 * @return void
	*/
	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	/** Methode setter anneeSortie
	 * @return void
	*/
	public void setAnneeSortie(int anneeSortie) {
		this.anneeSortie = anneeSortie;
	}
	
	/** Methode setter numeroEpisode
	 * @return void
	*/
	public void setNumeroEpisode(int numeroEpisode) {
		this.numeroEpisode = numeroEpisode;
	}
	
	/** Methode setter cout
	 * @return void
	*/
	public void setCout(long cout) {
		this.cout = cout;
	}
	
	/** Methode setter recette
	 * @return void
	*/
	public void setRecette(long recette) {
		this.recette = recette;
	}
	
	/*  
	 * nbActeurs() qui vous retourne le nombre d�acteurs du film
	 * @return int
	 */
	public int nbActeurs() {
		return this.listeActeurs.size();
	}
	
	/*
	 * nbPersonnages() le nombre de personnages du film
	 * @return int
	 */
	public int nbPersonnages() {
		int nbPersonnages = 0;
		for (Acteur acteur : this.listeActeurs) {
			nbPersonnages = nbPersonnages + acteur.duetPersonnage.size();
		}
		return nbPersonnages;
	}
	
	/*
	 * M�thode pour ajouter une liste d'acteurs
	 */	public void addActor (List<Acteur> listeActeurs) {
		this.listeActeurs.addAll(listeActeurs);
	}
	
	/* 
	 * M�thode pour ajouter un acteur 
	 */
	public void addActor (Acteur acteur) {
		this.listeActeurs.add(acteur);
	}
	
	/*
	 * calculB�n�fice() qui retourne le montant du b�n�fice et un bool�en dans un
	 * duet pour savoir si le film est b�n�ficiaire et si oui, de combien. M�me
	 * raisonnement pour le d�ficit.
	 * @return Map<String, Object>
	 */
	public Map<String, Object> calculBenefice() {
		Map<String, Object> duetBenefice = new HashMap<String, Object>();
		
		long benefice = (long) (this.getRecette() - this.getCout());
		if (benefice > 0) {
			duetBenefice.put("isBeneficiary", true);
			duetBenefice.put("Benefice", benefice);
		} else {
			duetBenefice.put("isBeneficiary", false);
			duetBenefice.put("D�ficit", benefice);
		}
		return duetBenefice;
	}
	
	/*
	 * isBefore(annee) qui retourne si True ou False le film est sortie avant une
	 * ann�e pass�e en param�tre.
	 */
	public boolean isBefore(int annee) {
		return this.anneeSortie < annee;
	} 
	
	/* 
	 * M�thode pour trier par ordre alphab�tique la liste des acteurs 
	 */
	public void tri() {
		Comparator<Acteur> alphabeticalComparator = new Comparator<Acteur>() {
		    public int compare(Acteur o1, Acteur o2) {
		    	String fullnameActor1 = o1.prenom + " " + o1.nom; 
		    	String fullnameActor2 = o2.prenom + " " + o2.nom; 
		        return fullnameActor1.compareTo(fullnameActor2);
		    }
		};
		this.listeActeurs.sort(alphabeticalComparator);
	}
}
