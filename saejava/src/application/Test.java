package application;

import java.io.File;
import java.io.FileNotFoundException;
import metier.*;

/**
 *
 * @author elliot
 */
public class Test {
	public static void main(String[] args) throws FileNotFoundException {
		Graphe graphePrincipal = new Graphe(new File("graphe.csv"));
		System.out.println("Exemple d'affichage des successeurs du 3e sommet :");
		graphePrincipal.getListeSommet().get(2).afficherSuccesseurs();
		
		for (Sommet item : graphePrincipal.getListeSommetParType("V")) {
			System.out.println(item);
		}
		
		for (Arete item : graphePrincipal.getListeAreteParType("A")) {
			System.out.println(item);
		}
		System.out.println(graphePrincipal.getListeAreteParType("A").size());
		
		graphePrincipal.afficherListeAreteParType("");
		System.out.println(graphePrincipal.getListeArete().get(29));
		for(Sommet item : graphePrincipal.rechercherSommetsRelies(29)) {
			System.out.println(item);
		}
		for(int i = 0; i < graphePrincipal.getListeSommet().size(); i++) {
			System.out.println(i + " " + graphePrincipal.getListeSommet().get(i));
		}
		System.out.println(graphePrincipal.rechercher1Distance(graphePrincipal.getListeSommet().get(17), graphePrincipal.getListeSommet().get(18)));
		System.out.println(graphePrincipal.rechercher2Distance(graphePrincipal.getListeSommet().get(4), graphePrincipal.getListeSommet().get(22)));
    }
}