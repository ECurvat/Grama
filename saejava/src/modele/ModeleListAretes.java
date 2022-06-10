package modele;

import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import metier.Arete;

/**
 *
 * @author François, Elliot
 */
public class ModeleListAretes extends AbstractListModel<String> {

	private final List<Arete> dataAutouroute = new ArrayList<>();
	
	@Override
	public int getSize() {
		return dataAutouroute.size();
	}

	@Override
	public String getElementAt(int index) {
		String val = dataAutouroute.get(index).getType()+dataAutouroute.get(index).getLongueur();
		return val;
	}
	
	public void ajouterAretes(List<Arete> listeAutoroute){
		for(Arete elem:listeAutoroute){
			dataAutouroute.add(elem);
		}
		fireIntervalAdded(this, 0, dataAutouroute.size());
		
	}
	public void viderModele(){
		dataAutouroute.clear();
	}
	
}
