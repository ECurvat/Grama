package metier;

/**
 *
 * @author elliot
 */
public class Sommet {
	private String type;
	private String nom;

	public Sommet(String type, String nom) {
		this.type = type;
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Sommet : " + "Type = " + type + ", Nom = " + nom;
	}

	public String getType() {
		return type;
	}

	public String getNom() {
		return nom;
	}
	
	
}
