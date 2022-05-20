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
public class ModeleListRestaurant extends AbstractListModel<String>{
	
	private List<Sommet> dataRestaurant=new ArrayList<>();
	
	@Override
	public int getSize() {
		return dataRestaurant.size();
	}

	@Override
	public String getElementAt(int index) {
		return dataRestaurant.get(index).getNom();
	}
	
	public void ajouterRestaurant(List<Sommet> tableauResto){
		for(Sommet elem:tableauResto){
			dataRestaurant.add(elem);
		}
		fireIntervalAdded(this, 0, dataRestaurant.size());
	}
	
}
