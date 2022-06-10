package metier;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author François, Elliot
 */
public class Sommet {
	
	private final String type;
	private final String nom;
	private final List<Arete> successeurs = new ArrayList<>();
	private int positionX;
	private int positionY;

	public Sommet(String type, String nom) {
		this.type = type;
		this.nom = nom;
	}
	
	public List<Arete> getSuccesseurs() {
		return successeurs;
	}
	
	@Override
	public String toString() {
		return type + ", " + nom;
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
	
	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	public int getPositionX() {
		return positionX;
	}

	public int getPositionY() {
		return positionY;
	}
	
}
