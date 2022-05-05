package outils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import metier.Sommet;

/**
 *
 * @author elliot
 */
public class Deserialisation {
	public static List<Sommet> trouverTousLesSommets(String nomFichier) throws FileNotFoundException {
		
		File getCSVFiles = new File(nomFichier);
        Scanner sc = new Scanner(getCSVFiles);
		sc.useDelimiter(";;");
		

		
		
		List<Sommet> listeSommet = new ArrayList<>();
		
		while(sc.hasNext()) {
			String ligneActuelle = sc.next();
			String[] lignesplit = ligneActuelle.split(":");
			String[] infopremier = lignesplit[0].split(",");
			infopremier[0] = infopremier[0].replace("\n", "");
			listeSommet.add(new Sommet(infopremier[0], infopremier[1]));
		}
		for(Sommet item: listeSommet) {
			System.out.println(item);
		}
		
        sc.close();  
		return listeSommet;
	}
}
