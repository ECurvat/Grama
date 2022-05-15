package metier;

/**
 *
 * @author elliot
 */
public class Arete {
	private final String type;
	private final int longueur;
	private Sommet destination;

	public Sommet getDestination() {
		return destination;
	}

	public Arete(String type, int kilometrage,Sommet destination) {
		this.type = type;
		this.longueur = kilometrage;
		this.destination=destination;
	}	
	
	@Override
	public String toString() {
		return "Arête : " + "Type = " + type + ", Longueur = " + longueur + "km";
	}

	public String getType() {
		return type;
	}

	public int getLongueur() {
		return longueur;
	}
}
