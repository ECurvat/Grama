package metier;

import java.util.Objects;

/**
 * La classe représentant une arête
 * @author François Graux
 * @author Elliot Curvat
 * @version JDK 11.0.13
 */
public class Arete {
	
	private final String type;
	private final int longueur;
	private final Sommet destination;
	
	/**
	 * Constructeur d'arête
	 * @param type type de l'arête (A : autoroute, N : nationale, D : départementale)
	 * @param kilometrage longueur de l'arête en kilomètres
	 * @param destination objet Sommet qui est la destination de l'arête
	 */
	public Arete(String type, int kilometrage,Sommet destination) {
		this.type = type;
		this.longueur = kilometrage;
		this.destination=destination;
	}
	
	/**
	 * Getter de la destination
	 * @return destination de l'arête
	 */
	public Sommet getDestination() {
		return destination;
	}
	
	/**
	 * Getter du type
	 * @return le type de l'arête
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * Getter de la longueur
	 * @return la longueur en kilomètres de l'arête
	 */
	public int getLongueur() {
		return longueur;
	}
	
	/**
	 * Comparateur d'égalité entre deux arêtes
	 * @param o un objet avec lequel comparer l'arête
	 * @return true si les objets sont identiques (même type et longueur), false sinon
	 */
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Arete)) {
			return false;
		}
		Arete p = (Arete) o;
		return this.type.equals(p.type) && this.longueur == p.longueur;
	}

	/**
	 * Hashcode d'arête
	 * @return hashcode
	 */
	@Override
	public int hashCode() {
		int hash = 7;
		hash = 53 * hash + Objects.hashCode(this.type);
		hash = 53 * hash + this.longueur;
		hash = 53 * hash + Objects.hashCode(this.destination);
		return hash;
	}
	
	/**
	 * Description d'arête
	 * @return une chaîne descriptive de l'arête
	 */
	@Override
	public String toString() {
		return type + ", " + longueur;
	}
	
}
