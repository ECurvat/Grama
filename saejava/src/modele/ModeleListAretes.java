package modele;

import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import metier.Arete;

/**
 * La classe pour crée un model de liste d'arête
 * @author François Graux
 * @author Elliot Curvat
 * @version JDK 11.0.13
 */
public class ModeleListAretes extends AbstractListModel<String> {

	private final List<Arete> dataAutouroute = new ArrayList<>();
	
	/**
	 * Getteur de la taille
	 * @return revoie la taille du modele
	 */
	@Override
	public int getSize() {
		return dataAutouroute.size();
	}
	
	/**
	 * Getteur pour un element par sont indice
	 * @param index indice de l'element
	 * @return la valeur trouver ou null si pas de valeur
	 */
	@Override
	public String getElementAt(int index) {
		String val = dataAutouroute.get(index).getType()+dataAutouroute.get(index).getLongueur();
		return val;
	}
	
	/**
	 * Ajoute les arêtes au modéle
	 * @param listeAutoroute une liste d'arête
	 */
	public void ajouterAretes(List<Arete> listeAutoroute){
		for(Arete elem:listeAutoroute){
			dataAutouroute.add(elem);
		}
		fireIntervalAdded(this, 0, dataAutouroute.size());
		
	}
	
	/**
	 * vide le modéle
	 */
	public void viderModele(){
		dataAutouroute.clear();
	}
	
}
