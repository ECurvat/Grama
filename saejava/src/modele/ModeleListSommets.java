package modele;

import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import metier.Sommet;

/**
 * La classe pour crée un model de liste d'arête
 * @author François Graux
 * @author Elliot Curvat
 * @version JDK 11.0.13
 */
public class ModeleListSommets extends AbstractListModel<String>{
	
	private final List<Sommet> dataVille =new ArrayList<>();
	
	/**
	 * Getteur de la taille
	 * @return revoie la taille du modele
	 */
	@Override
	public int getSize() {
		return dataVille.size();
	}
	
	/**
	 * Getteur pour un element par sont indice
	 * @param index indice de l'element
	 * @return la valeur trouver ou null si pas de valeur
	 */
	@Override
	public String getElementAt(int index) {
		return dataVille.get(index).getNom();
	}
	
	/**
	 * Ajoute les sommets au modéle
	 * @param listeVille une liste de sommet
	 */
	public void ajouterSommets(List<Sommet> listeVille){
		for(Sommet elem:listeVille){
			dataVille.add(elem);
		}
		fireIntervalAdded(this, 0, dataVille.size());	
	}
	
	/**
	 * vide le modéle
	 */
	public void viderModele(){
		dataVille.clear();
	}
	
}
