package application;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import metier.Arete;
import metier.Sommet;
import static outils.Deserialisation.trouverLesSommets;
import static outils.Deserialisation.trouverLesAretes;
import static outils.Deserialisation.trouverLesCorrespondance;

/**
 *
 * @author elliot
 */
public class Test {
	public static void main(String[] args) throws FileNotFoundException {
		List<Sommet> listeSommet = new ArrayList<>();
		listeSommet = trouverLesSommets("graphe.csv");
		List<Arete> listeArete = new ArrayList<>();
		listeArete = trouverLesAretes("graphe.csv", listeSommet);
		trouverLesCorrespondance("graphe.csv", listeSommet, listeArete);
		System.out.println("Exemple d'affichage des successeurs du 3e sommet :");
		listeSommet.get(2).afficherSuccesseurs();		
    }
}
