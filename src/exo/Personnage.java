package exo;

public class Personnage {
	String nom;
	String prenom;
	
	public Personnage(String prenom, String nom) {
		this.nom = nom;
		this.prenom = prenom;
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
	
	// Setters
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
}
