package application;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import metier.Sommet;
import static outils.Deserialisation.trouverTousLesSommets;

/**
 *
 * @author elliot
 */
public class Test {
	public static void main(String[] args) throws FileNotFoundException {
		List<Sommet> listeSommet = new ArrayList<>();
		listeSommet = trouverTousLesSommets("graphe.csv");
    }
}
