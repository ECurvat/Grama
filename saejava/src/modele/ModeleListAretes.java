package modele;

import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import metier.Arete;

/**
 * La classe pour créer un modèle de liste d'arêtes
 * @author François Graux
 * @author Elliot Curvat
 * @version JDK 11.0.13
 */
public class ModeleListAretes extends AbstractListModel<String> {

	private final List<Arete> dataAutouroute = new ArrayList<>();
	
	/**
	 * Getter de la taille
	 * @return la taille du modele
	 */
	@Override
	public int getSize() {
		return dataAutouroute.size();
	}
	
	/**
	 * Getter pour un élément par son indice
	 * @param index indice de l'élément
	 * @return la valeur trouvée ou null si pas de valeur
	 */
	@Override
	public String getElementAt(int index) {
		String val = dataAutouroute.get(index).getType()+dataAutouroute.get(index).getLongueur();
		return val;
	}
	
	/**
	 * Ajoute les arêtes au modèle
	 * @param liste liste d'arête
	 */
	public void ajouterAretes(List<Arete> liste){
		for(Arete elem:liste){
			dataAutouroute.add(elem);
		}
		fireIntervalAdded(this, 0, dataAutouroute.size());
		
	}
	
	/**
	 * Vide le modèle
	 */
	public void viderModele(){
		dataAutouroute.clear();
	}
	
}
