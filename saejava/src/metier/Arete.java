package metier;

/**
 *
 * @author elliot
 */
public class Arete {
	private String type;
	private int longueur;

	public Arete(String type, int kilometrage) {
		this.type = type;
		this.longueur = kilometrage;
	}	
	
	@Override
	public String toString() {
		return "Arête : " + "Type = " + type + ", Longueur = " + longueur + "km";
	}
}
