package modele;

import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import metier.Sommet;

/**
 * La classe pour créer un modèle de liste de sommets
 * @author François Graux
 * @author Elliot Curvat
 * @version JDK 11.0.13
 */
public class ModeleListSommets extends AbstractListModel<String>{
	
	private final List<Sommet> data = new ArrayList<>();
	
	/**
	 * Getter de la taille
	 * @return revoie la taille du modèle
	 */
	@Override
	public int getSize() {
		return data.size();
	}
	
	/**
	 * Getter pour un élément par son indice
	 * @param index indice de l'élément
	 * @return la valeur trouvée ou null si pas de valeur
	 */
	@Override
	public String getElementAt(int index) {
		return data.get(index).getNom();
	}
	
	/**
	 * Ajoute les sommets au modèle
	 * @param liste liste de sommets
	 */
	public void ajouterSommets(List<Sommet> liste){
		for(Sommet elem:liste){
			data.add(elem);
		}
		fireIntervalAdded(this, 0, data.size());	
	}
	
	/**
	 * Vide le modèle
	 */
	public void viderModele(){
		data.clear();
	}
	
}
