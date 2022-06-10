package modele;

import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import metier.Sommet;

/**
 *
 * @author François, Elliot
 */
public class ModeleListSommets extends AbstractListModel<String>{
	
	private final List<Sommet> dataVille =new ArrayList<>();

	@Override
	public int getSize() {
		return dataVille.size();
	}

	@Override
	public String getElementAt(int index) {
		return dataVille.get(index).getNom();
	}
	
	public void ajouterSommets(List<Sommet> listeVille){
		for(Sommet elem:listeVille){
			dataVille.add(elem);
		}
		fireIntervalAdded(this, 0, dataVille.size());	
	}
	
	public void viderModele(){
		dataVille.clear();
	}
	
}
