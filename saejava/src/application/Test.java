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
		Graphe test = new Graphe("graphe.csv");
		
		
		for (Sommet e : test.getListeSommet()){
			System.out.printf("%-50s",e);
			for (Arete v : e.getSuccesseurs()){
				System.out.printf("%-20s",v.getDestination().getNom());
			}
			System.out.println();
		}
		
		// TESTS TROUVER SOMMETS
		System.out.println("Tests recherche sommet par type inconnu : ");
		for(Sommet item : test.trouverSommetsParType("U")) {
			System.out.println("\t" + item);
		}
		System.out.println("Tests recherche sommet par type connu : ");
		for(Sommet item : test.trouverSommetsParType("L")) {
			System.out.println("\t" + item);
		}
		
		// TESTS TROUVER ARETES
		System.out.println("Tests recherche arête par type inconnu : ");
		for(Arete item : test.trouverAretesParType("P")) {
			System.out.println("\t" + item);
		}
		System.out.println("Tests recherche arête par type connu : ");
		for(Arete item : test.trouverAretesParType("A")) {
			System.out.println("\t" + item);
		}
		
		// TEST TROUVER SOMMETS RELIÉS
		System.out.println("Test trouver sommets reliés par une arête : ");
		for(Sommet item : test.trouverSommetsRelies(new Arete("A", 71, test.getListeSommet().get(2)))) {
			System.out.println("\t" + item);
		}
		System.out.println("Test trouver sommets reliés par une arête qui n'existe pas : ");
		if(test.trouverSommetsRelies(new Arete("A", 72, test.getListeSommet().get(2))).isEmpty()) {
			System.out.println("Rien à trouver");
		}
    }
}