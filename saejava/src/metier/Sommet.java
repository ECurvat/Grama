package metier;

import java.util.ArrayList;
import java.util.List;

/**
 *La classe représentant une sommet
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
	 * @param type type de sommet(V : ville, R : restaurant, L : lieux de loisir)
	 * @param nom nom du sommet
	 */
	public Sommet(String type, String nom) {
		this.type = type;
		this.nom = nom;
	}
	
	/**
	 * Getteur de sucesseur 
	 * @return le sommet successeurs
	 */
	public List<Arete> getSuccesseurs() {
		return successeurs;
	}
	
	/**
	 * Description de sommet
	 * @return une chaîne descriptive du sommet
	 */
	@Override
	public String toString() {
		return type + ", " + nom;
	}
	
	/**
	 * Comparateur d'égalité entre deux sommet
	 * @param o un objet avec lequel comparer le sommet
	 * @return true si les objets sont identiques, false sinon
	 */
	@Override
	public boolean equals(Object o ){
		if (!(o instanceof Sommet))
			return false;
		Sommet p = (Sommet)o;
		return type.equals(p.getType()) && nom.equals(p.getNom());
	} 
	
	/**
	 * Getteur du type
	 * @return le type du sommet
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * Getteur du nom 
	 * @return le nom du sommet
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * Setteur positionX
	 * @param positionX 
	 */
	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}
	
	/**
	 * Setteur positionY
	 * @param positionY 
	 */
	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}
	
	/**
	 * Getteur positionX
	 * @return renvoie la position X
	 */
	public int getPositionX() {
		return positionX;
	}
	
	/**
	 * Getteur positionY
	 * @return renvoie la position Y
	 */
	public int getPositionY() {
		return positionY;
	}
	
}
