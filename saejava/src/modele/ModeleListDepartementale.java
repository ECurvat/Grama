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
public class ModeleListDepartementale extends AbstractListModel<String> {

	private List<Arete> dataDepartementale =new ArrayList<>();
	
	@Override
	public int getSize() {
		return dataDepartementale.size();
	}

	@Override
	public String getElementAt(int index) {
		String val = dataDepartementale.get(index).getType()+dataDepartementale.get(index).getLongueur();
		return val ;
	}
	
	public void ajouterDepartmentales(List<Arete> listeDepartementale){
		for(Arete elem:listeDepartementale){
			dataDepartementale.add(elem);
		}
		fireIntervalAdded(this, 0, dataDepartementale.size());
		
	}
	
	public void viderModele(){
		dataDepartementale.clear();
	}
}
