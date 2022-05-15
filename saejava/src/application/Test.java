package application;

import java.io.FileNotFoundException;
import java.io.IOException;
import metier.*;

/**
 *
 * @author François
 */
public class Test {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Graphe test=new Graphe("graphe.csv");
		
		
		for (Sommet e : test.getListSommet()){
			System.out.printf("%-50s",e);
			for (Arete v : e.getVoisins()){
				System.out.printf("%-20s",v.getDestination().getNom());
			}
			System.out.println();
		}
		
		
    }
}