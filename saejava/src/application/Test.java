package application;

import java.io.FileNotFoundException;
import metier.*;

/**
 *
 * @author elliot
 */
public class Test {
	public static void main(String[] args) throws FileNotFoundException {
		Graphe graphePrincipal = new Graphe("graphe.csv");
		System.out.println("Exemple d'affichage des successeurs du 3e sommet :");
		graphePrincipal.getListeSommet().get(2).afficherSuccesseurs();
		
		for (Sommet item : graphePrincipal.getListeSommetParType("V")) {
			System.out.println(item);
		}
		
		for (Arete item : graphePrincipal.getListeAreteParType("A")) {
			System.out.println(item);
		}
		System.out.println(graphePrincipal.getListeAreteParType("A").size());
		
		graphePrincipal.afficherListeAreteParType("R");
    }
}