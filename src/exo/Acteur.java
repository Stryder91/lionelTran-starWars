package exo;

import java.util.List;

public class Acteur {
	String nom;
	String prenom;
	List<Personnage> duetPersonnage;
	
	public Acteur(String prenom, String nom, List<Personnage> duetPersonnage) {
		this.nom = nom;
		this.prenom = prenom;
		this.duetPersonnage = duetPersonnage;
	}
	
	public String toString() {
		Utils utils = new Utils();
		return utils.toString(this);
	}
	
	// Getters
	public String getNom() {
		return nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public List<Personnage> getDuetPersonnages() {
		return duetPersonnage;
	}
	
	// Setters
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	// nombre de personnages incarnés
	public int nbPersonnages() {
		return this.duetPersonnage.size();
	}
}
