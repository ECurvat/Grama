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
public class ModeleListNationales extends AbstractListModel<String>{

	private List<Arete>dataNatio=new ArrayList<>();
	
	@Override
	public int getSize() {
		return dataNatio.size();
	}

	@Override
	public String getElementAt(int index) {
		String val = dataNatio.get(index).getType()+dataNatio.get(index).getLongueur();
		return val;
	}
	
	public void ajouterNationales(List<Arete> tableauNatio){
		for(Arete elem:tableauNatio){
			dataNatio.add(elem);
		}
		fireIntervalAdded(this, 0, dataNatio.size());
	}
	
}
