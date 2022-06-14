package metier;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * La classe représentant un sommet
 * @author François Graux
 * @author Elliot Curvat
 * @version JDK 11.0.13
 */
public class Sommet {
	
	private final String type;
	private final String nom;
	private final List<Arete> successeurs = new ArrayList<>();
	private int positionX;
	private int positionY;
	
	/**
	 * Constructeur de sommet
	 * @param type type de sommet (V : ville, R : restaurant, L : lieu de loisir)
	 * @param nom nom du sommet
	 */
	public Sommet(String type, String nom) {
		this.type = type;
		this.nom = nom;
	}
	
	/**
	 * Getter des successeurs
	 * @return une liste d'arêtes qui partent du sommet
	 */
	public List<Arete> getSuccesseurs() {
		return successeurs;
	}
	
	/**
	 * Getter du type
	 * @return le type du sommet
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * Getter du nom 
	 * @return le nom du sommet
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * Getteur positionX
	 * @return renvoie la position X du sommet dans l'affichage du graphe
	 */
	public int getPositionX() {
		return positionX;
	}
	
	/**
	 * Getteur positionY
	 * @return renvoie la position Y du sommet dans l'affichage du graphe
	 */
	public int getPositionY() {
		return positionY;
	}
	
	/**
	 * Setteur positionX
	 * @param positionX position X du sommet dans l'accueil (affichage du graphe)
	 */
	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}
	
	/**
	 * Setteur positionY
	 * @param positionY position Y du sommet dans l'accueil (affichage du graphe)
	 */
	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}
	
	/**
	 * Comparateur d'égalité entre deux sommets
	 * @param o un objet avec lequel comparer le sommet
	 * @return true si les objets sont identiques (même type et nom), false sinon
	 */
	@Override
	public boolean equals(Object o ){
		if (!(o instanceof Sommet))
			return false;
		Sommet p = (Sommet)o;
		return type.equals(p.getType()) && nom.equals(p.getNom());
	} 

	/**
	 * Hashcode de sommet
	 * @return hashcode
	 */
	@Override
	public int hashCode() {
		int hash = 7;
		hash = 89 * hash + Objects.hashCode(this.type);
		hash = 89 * hash + Objects.hashCode(this.nom);
		return hash;
	}
	
	/**
	 * Description de sommet
	 * @return une chaîne descriptive du sommet
	 */
	@Override
	public String toString() {
		return type + ", " + nom;
	}
	
}
