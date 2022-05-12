package outils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import metier.Sommet;
import metier.Arete;

/**
 *
 * @author elliot
 */
public class Deserialisation {
	public static List<Sommet> trouverLesSommets(String nomFichier) throws FileNotFoundException {
		// Ouverture du CSV et séparation par lignes
		File getCSVFiles = new File(nomFichier);
        Scanner sc = new Scanner(getCSVFiles);
		sc.useDelimiter(";;");

		List<Sommet> listeSommet = new ArrayList<>();
		
		// Traitement du CSV pour n'avoir que les sommets d'origine
		while(sc.hasNext()) {
			String ligneActuelle = sc.next();
			String[] ligneSplit = ligneActuelle.split(":");
			String[] infopremier = ligneSplit[0].split(",");
			infopremier[0] = infopremier[0].replace("\n", "");
			
			// Ajout des sommets d'origine à la liste de sommets
			listeSommet.add(new Sommet(infopremier[0], infopremier[1]));
		}
        sc.close();  
		return listeSommet;
	}
	
	public static List<Arete> trouverLesAretes(String nomFichier, List<Sommet> listeSommet) throws FileNotFoundException {
		// Ouverture du CSV et séparation par lignes
		File getCSVFiles = new File(nomFichier);
        Scanner scanAretes = new Scanner(getCSVFiles);
		scanAretes.useDelimiter(";;");
		
		List<Arete> listeTemporaire = new ArrayList<>();
		
		// Traitement du CSV jusqu'à avoir la liste des successeurs de chaque sommet seulement
		while(scanAretes.hasNext()) {
			String lignePropre = scanAretes.next().replace("\n", "");
			lignePropre = lignePropre.replace(" ", "");
			String[] séparationSommetArete = lignePropre.split(":");
			String listeDestination = séparationSommetArete[1];
			String[] destIndiv = listeDestination.split(";");
			for(String item:destIndiv) {
				String[] séparationRouteDestination = item.split("\\|");
				String[] routeIndividuelle = séparationRouteDestination[0].split(",");
				
				// Ajout de toutes les arêtes trouvées dans une liste temporaire
				listeTemporaire.add(new Arete(routeIndividuelle[0], Integer.valueOf(routeIndividuelle[1])));
			}
		}
		
		// On crée une nouvelle liste sans les doublons
		List<Arete> listeArete = new ArrayList<>();
		for(Arete item:listeTemporaire) {
			if(!listeArete.contains(item)) {
				listeArete.add(item);
			}
		}
		scanAretes.close();
		return listeArete;
	}
	
	public static void trouverLesCorrespondance(String nomFichier, List<Sommet> listeSommet, List<Arete> listeArete) throws FileNotFoundException {
		// Ouverture du CSV et séparation par lignes
		File getCSVFiles = new File(nomFichier);
		Scanner scanSucc = new Scanner(getCSVFiles);
		scanSucc.useDelimiter(";;");
		
		while(scanSucc.hasNext()) {
			// Expulsion les caractères parasites
			String lignePropre = scanSucc.next().replace("\n", "");
			lignePropre = lignePropre.replace(" ", "");
			
			// Séparation de la ligne entre Sommet d'origine --- Liste de ses successeurs
			String[] ligneEntiere = lignePropre.split(":");
			
			String sommetOriginal = ligneEntiere[0];
			String[] infoPremier = sommetOriginal.split(",");
			int positionOrigine = listeSommet.indexOf(new Sommet(infoPremier[0], infoPremier[1]));
			
			// Traitement de la liste des successeurs
			String[] destinationIndividuelle = ligneEntiere[1].split(";");
			for(String item : destinationIndividuelle) {
				String[] separationAreteSommet = item.split("\\|");
				int positionDestination = listeSommet.indexOf(new Sommet(separationAreteSommet[1].split(",")[0], separationAreteSommet[1].split(",")[1]));
				int positionRoute = listeArete.indexOf(new Arete(separationAreteSommet[0].split(",")[0], Integer.valueOf(separationAreteSommet[0].split(",")[1])));
				Sommet sommetOrigine = listeSommet.get(positionOrigine);
				Sommet sommetDestination = listeSommet.get(positionDestination);
				Arete route = listeArete.get(positionRoute);
				
				// Ajout du successeur traité dans la HashMap du sommet d'origine
				sommetOrigine.getSuccesseurs().put(route, sommetDestination);
			}
		}
		scanSucc.close();
	}
}
