package metier;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author François
 */
public class Sommet {
	private String type;
	private String nom;
	private List<Arete> voisins = new ArrayList<>();

	public Sommet(String type, String nom) {
		this.type = type;
		this.nom = nom;
	}
	
	public List<Arete> getVoisins() {
		return voisins;
	}
	
	@Override
	public String toString() {
		return "Sommet : " + "Type = " + type + ", Nom = " + nom;
	}

	@Override
	public boolean equals(Object o ){
		if (!(o instanceof Sommet))
			return false;
		Sommet p = (Sommet)o;
		return type.equals(p.getType()) && nom.equals(p.getNom());
	} 

	public String getType() {
		return type;
	}

	public String getNom() {
		return nom;
	}
	
	
	
}
