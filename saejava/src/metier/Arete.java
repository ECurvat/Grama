package metier;

/**
 *
 * @author François, Elliot
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
		return type + ", " + longueur;
	}

	public String getType() {
		return type;
	}

	public int getLongueur() {
		return longueur;
	}
	
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Arete)) {
			return false;
		}
		Arete p = (Arete) o;
		return this.type.equals(p.type) && this.longueur == p.longueur;
	}
}
