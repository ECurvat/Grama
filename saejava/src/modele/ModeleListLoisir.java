/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modele;

import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import metier.Sommet;

/**
 *
 * @author frsgr
 */
public class ModeleListLoisir extends AbstractListModel<String>{
	
	private List<Sommet>dataLoisir=new ArrayList<>();

	@Override
	public int getSize() {
		return dataLoisir.size();
	}

	@Override
	public String getElementAt(int index) {
		return dataLoisir.get(index).getNom();
	}
	
	public void ajouterLoisir(List<Sommet> tableauLoisir){
		for(Sommet elem:tableauLoisir){
			dataLoisir.add(elem);
		}
		fireIntervalAdded(this, 0, dataLoisir.size());
	}
	
}
