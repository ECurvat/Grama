package metier;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author elliot
 */
public class Sommet {
	private final String type;
	private final String nom;
	private Map<Arete,Sommet> successeurs = new HashMap<>();
	

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
		int hash = 3;
		hash = 89 * hash + Objects.hashCode(this.type);
		hash = 89 * hash + Objects.hashCode(this.nom);
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
	

	public Map<Arete, Sommet> getSuccesseurs() {
		return successeurs;
	}
	
	public void afficherSuccesseurs() {
		Set<Map.Entry<Arete,Sommet>> parcours= successeurs.entrySet();
		for (Map.Entry<Arete,Sommet> entree : parcours){
			System.out.println("Sommet de destination : " + entree.getValue() + "via la route : " + entree.getKey());
		}
	}
}
