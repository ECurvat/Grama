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
public class ModeleListDepartementales extends AbstractListModel<String> {

	private List<Arete>dataDeparte=new ArrayList<>();
	
	@Override
	public int getSize() {
		return dataDeparte.size();
	}

	@Override
	public String getElementAt(int index) {
		String val = dataDeparte.get(index).getType()+dataDeparte.get(index).getLongueur();
		return val ;
	}
	
	public void ajouterDepartmentales(List<Arete> tableauDeparte){
		for(Arete elem:tableauDeparte){
			dataDeparte.add(elem);
		}
		fireIntervalAdded(this, 0, dataDeparte.size());
		
	}
	
	public void SupprimerD(){
		dataDeparte.clear();
	}
}
