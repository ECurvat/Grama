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
public class ModeleListLVille extends AbstractListModel<String>{
	
	private List<Sommet>dataVille=new ArrayList<>();

	@Override
	public int getSize() {
		return dataVille.size();
	}

	@Override
	public String getElementAt(int index) {
		return dataVille.get(index).getNom();
	}
	
	public void ajouterVille(List<Sommet> tableauVille){
		for(Sommet elem:tableauVille){
			dataVille.add(elem);
		}
		fireIntervalAdded(this, 0, dataVille.size());	
	}
}
