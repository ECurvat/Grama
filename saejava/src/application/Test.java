package application;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import metier.Arete;
import metier.Correspondance;
import metier.Sommet;
import static outils.Deserialisation.trouverLesSommets;
import static outils.Deserialisation.trouverLesAretes;
import static outils.Deserialisation.trouverLesCorrespondances;

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
		List<Correspondance> listeCorrespondance = new ArrayList<>();
		listeCorrespondance = trouverLesCorrespondances("graphe.csv", listeSommet, listeArete);
		for (int i = 0; i < listeCorrespondance.size(); i++) {
			System.out.println(i + " " + listeCorrespondance.get(i));
		}
    }
}
