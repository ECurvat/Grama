/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modele;

import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import metier.Arete;

/**
 *
 * @author frsgr
 */
public class ModeleListAutoroute extends AbstractListModel<String> {

	private List<Arete> dataAutouroute = new ArrayList<>();
	
	@Override
	public int getSize() {
		return dataAutouroute.size();
	}

	@Override
	public String getElementAt(int index) {
		String val = dataAutouroute.get(index).getType()+dataAutouroute.get(index).getLongueur();
		return val;
	}
	
	public void ajouterAutoroute(List<Arete> listeAutoroute){
		for(Arete elem:listeAutoroute){
			dataAutouroute.add(elem);
		}
		fireIntervalAdded(this, 0, dataAutouroute.size());
		
	}
	public void viderModele(){
		dataAutouroute.clear();
	}
}
