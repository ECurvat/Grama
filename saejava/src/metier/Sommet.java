package metier;

import java.util.Objects;

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

	@Override
	public int hashCode() {
		int hash = 7;
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Sommet)) {
			return false;
		}
		Sommet p = (Sommet)obj;
		return this.type.equals(p.type) && this.nom.equals(p.nom);
	}
	
}
