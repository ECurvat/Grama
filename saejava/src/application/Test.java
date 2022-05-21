package application;

import java.io.FileNotFoundException;
import java.io.IOException;
import metier.*;

/**
 *
 * @author François, Elliot
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
		
		// TEST VERIFIER SI 1-DISTANCE
		System.out.println("Test si deux sommets sont reliés à une 1-distance (Auxerre et Paris réellement reliés) : " + test.rechercher1Distance(test.getListeSommet().get(8), test.getListeSommet().get(17)));
		System.out.println("Test si deux sommets sont reliés à une 1-distance (Lyon et Paris non reliés) : " + test.rechercher1Distance(test.getListeSommet().get(0), test.getListeSommet().get(17)));
		
		// TEST VERIFIER SI 2-DISTANCE
		System.out.println("Test si deux sommets sont reliés à une 2-distance (Lyon et Chalon réellement reliés) : " + test.rechercher2Distance(test.getListeSommet().get(0), test.getListeSommet().get(2)));
		System.out.println("Test si deux sommets sont reliés à une 2-distance (Lyon et Macon non reliés) : " + test.rechercher2Distance(test.getListeSommet().get(0), test.getListeSommet().get(1)));
		
		// TEST COMPARAISON VILLES
		System.out.println("Comparaison 0 avec 29 : " + test.comparerOCG(test.getListeSommet().get(0), test.getListeSommet().get(29)).toString());
		
		//TEST POUR NOMBRE NOEUD,VILLES,RETSTAURANT,LIEUX DE LOISIR
		System.out.println(test.comptageSommets());
		
		//TEST POUR LE NOMBRE D'ARETE
		System.out.println(test.comptageAretes());
    }
}