/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metier;

import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;

/**
 *
 * @author frsgr
 */
public class ModeleListLigne extends AbstractListModel<String>{
	
	private List<String>dataLigne=new ArrayList<>();
	
	public void initData(List<String> tab){
		dataLigne=tab;
	}

	@Override
	public int getSize() {
		return dataLigne.size();
	}

	@Override
	public String getElementAt(int index) {
		return dataLigne.get(index);
	}
}
