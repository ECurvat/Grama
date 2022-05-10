package outils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import metier.Sommet;
import metier.Arete;
import metier.Correspondance;

/**
 *
 * @author elliot
 */
public class Deserialisation {
	public static List<Sommet> trouverLesSommets(String nomFichier) throws FileNotFoundException {
		
		File getCSVFiles = new File(nomFichier);
        Scanner sc = new Scanner(getCSVFiles);
		sc.useDelimiter(";;");
		

		
		
		List<Sommet> listeSommet = new ArrayList<>();
		
		while(sc.hasNext()) {
			String ligneActuelle = sc.next();
			String[] ligneSplit = ligneActuelle.split(":");
			String[] infopremier = ligneSplit[0].split(",");
			infopremier[0] = infopremier[0].replace("\n", "");
			listeSommet.add(new Sommet(infopremier[0], infopremier[1]));
		}
		
        sc.close();  
		return listeSommet;
	}
	
	public static List<Arete> trouverLesAretes(String nomFichier, List<Sommet> listeSommet) throws FileNotFoundException {
		
		File getCSVFiles = new File(nomFichier);
        Scanner scanAretes = new Scanner(getCSVFiles);
		scanAretes.useDelimiter(";;");
		
		List<Arete> listeTemporaire = new ArrayList<>();
		
		while(scanAretes.hasNext()) {
			String test = scanAretes.next().replace("\n", "");
			test = test.replace(" ", "");
			String[] séparationSommetArete = test.split(":");
			String listeDestination = séparationSommetArete[1];
			String[] destIndiv = listeDestination.split(";");
			for(String item:destIndiv) {
				String[] séparationRouteDestination = item.split("\\|");

				String[] routeIndividuelle = séparationRouteDestination[0].split(",");
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
	
	public static List<Correspondance> trouverLesCorrespondances(String nomFichier, List<Sommet> listeSommet, List<Arete> listeArete) throws FileNotFoundException {
		File getCSVFiles = new File(nomFichier);
		Scanner scanSucc = new Scanner(getCSVFiles);
		scanSucc.useDelimiter(";;");
		
		List<Correspondance> listeCorrespondance = new ArrayList<>();
		
		while(scanSucc.hasNext()) {
			String test = scanSucc.next().replace("\n", "");
			test = test.replace(" ", "");
			String[] ligneEntiere = test.split(":");
			String sommetOriginal = ligneEntiere[0];
			String[] infoPremier = sommetOriginal.split(",");
			int positionOriginal = listeSommet.indexOf(new Sommet(infoPremier[0], infoPremier[1]));
			String[] destinationIndividuelle = ligneEntiere[1].split(";");
			for(String item : destinationIndividuelle) {
				String[] separationAreteSommet = item.split("\\|");
				int positionFin = listeSommet.indexOf(new Sommet(separationAreteSommet[1].split(",")[0], separationAreteSommet[1].split(",")[1]));
				int positionRoute = listeArete.indexOf(new Arete(separationAreteSommet[0].split(",")[0], Integer.valueOf(separationAreteSommet[0].split(",")[1])));
				listeCorrespondance.add(new Correspondance(listeSommet.get(positionOriginal), listeSommet.get(positionFin), listeArete.get(positionRoute)));
			}
		}
		for(Correspondance item : listeCorrespondance) {
			System.out.println(item);
		}
		return listeCorrespondance;
	}
}
