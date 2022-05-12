package metier;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static outils.Deserialisation.trouverLesAretes;
import static outils.Deserialisation.trouverLesSommets;
import static outils.Deserialisation.trouverLesSuccesseurs;

/**
 *
 * @author elliot
 */
public class Graphe {
	private List<Sommet> listeSommet = new ArrayList<>();
	private List<Arete> listeArete = new ArrayList<>();
	
	public Graphe(String nomFichier) throws FileNotFoundException {
		listeSommet = trouverLesSommets(nomFichier);
		listeArete = trouverLesAretes(nomFichier, listeSommet);
		trouverLesSuccesseurs(nomFichier, listeSommet, listeArete);
	}

	public List<Sommet> getListeSommet() {
		return listeSommet;
	}

	public List<Arete> getListeArete() {
		return listeArete;
	}
	
	public List<Sommet> getListeSommetParType(String typeSommet) {
		List<Sommet> listeRecherchee = new ArrayList<>();
		for(Sommet item : listeSommet) {
			if (item.getType().equals(typeSommet)) {
				listeRecherchee.add(item);
			}
		}
		return listeRecherchee;
	}
	
	public List<Arete> getListeAreteParType(String typeArete) {
		List<Arete> listeRecherchee = new ArrayList<>();
		for(Arete item : listeArete) {
			if (item.getType().equals(typeArete)) {
				listeRecherchee.add(item);
			}
		}
		return listeRecherchee;
	}
	
	public void afficherListeSommetParType(String typeSommet) {
		try {
			if (!typeSommet.equalsIgnoreCase("V") && !typeSommet.equalsIgnoreCase("R") && !typeSommet.equalsIgnoreCase("L")) {
				throw new TypeInconnuException();
			} else {
				int nbSommet = 0;
				switch (typeSommet) {
					case "V" : System.out.println("Affichage des villes du graphe :");
								break;
					case "R" : System.out.println("Affichage des restaurants du graphe :");
								break;
					case "L" : System.out.println("Affichage des lieux de loisir du graphe :");
								break;
					default: break;
				}
				for(Sommet item : listeSommet) {
					if (item.getType().equals(typeSommet)) {
						System.out.println("\t" + item);
						nbSommet++;
					}
				}
				System.out.println("Nombre de sommet(s) trouvé(s) : " + nbSommet);
			}
		} catch (TypeInconnuException e) {
			System.out.println("Erreur levée : " + e.getMessage());
		}
	}
	
	public void afficherListeAreteParType(String typeArete) {
		try {
			if (!typeArete.equalsIgnoreCase("A") && !typeArete.equalsIgnoreCase("N") && !typeArete.equalsIgnoreCase("D")) {
				throw new TypeInconnuException();
			} else {
				int nbArete = 0;
				switch (typeArete) {
					case "A" : System.out.println("Affichage des autoroutes du graphe :");
								break;
					case "N" : System.out.println("Affichage des routes nationales du graphe :");
								break;
					case "D" : System.out.println("Affichage des routes départementales du graphe :");
								break;
					default: break;
				}
				for(Arete item : listeArete) {
					if (item.getType().equals(typeArete)) {
						System.out.println("\t" + item);
						nbArete++;
					}
				}
				System.out.println("Nombre d'arête(s) trouvée(s) : " + nbArete);
			}
		} catch (TypeInconnuException e) {
			System.out.println("Erreur levée : " + e.getMessage());
		}
	}
	
	public List<Sommet> rechercherSommetsRelies(int positionListe) {
		List<Sommet> sommetsRecherches = new ArrayList<>();
		Arete sujet = listeArete.get(positionListe);
		for(Sommet objet : listeSommet) {
			for(Map.Entry<Arete, Sommet> item : objet.getSetSuccesseurs()) {
				if (item.getKey().equals(sujet) && !sommetsRecherches.contains(objet)) {
					sommetsRecherches.add(objet);
					sommetsRecherches.add(item.getValue());
				}
			}
		}
		return sommetsRecherches;
	}
}
