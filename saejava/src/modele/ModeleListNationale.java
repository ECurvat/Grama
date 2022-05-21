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
public class ModeleListNationale extends AbstractListModel<String>{

	private List<Arete> dataNationales =new ArrayList<>();
	
	@Override
	public int getSize() {
		return dataNationales.size();
	}

	@Override
	public String getElementAt(int index) {
		String val = dataNationales.get(index).getType()+dataNationales.get(index).getLongueur();
		return val;
	}
	
	public void ajouterNationales(List<Arete> listeNationale){
		for(Arete elem:listeNationale){
			dataNationales.add(elem);
		}
		fireIntervalAdded(this, 0, dataNationales.size());
	}
	
	public void viderModele(){
		dataNationales.clear();
	}
}
