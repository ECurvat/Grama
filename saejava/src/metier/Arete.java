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

	@Override
	public int hashCode() {
		int hash = 7;
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Arete)) {
			return false;
		}
		Arete p = (Arete)obj;
		return this.type.equals(p.type) && this.longueur == p.longueur;
	}
	
	
}
