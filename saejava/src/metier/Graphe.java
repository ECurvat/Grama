package metier;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *La classe représentant un graphe
 * @author François Graux
 * @author Elliot Curvat
 * @version JDK 11.0.13
 */
public class Graphe {
	
	private final List<Sommet> listeSommet = new ArrayList<>();
	private final String nomFichier;
	private Sommet survol;
	/**
	 * Constructeur de graphe
	 * @param nomFichier nom du fichier du graphe
	 * @throws IOException 
	 */
	public Graphe(String nomFichier) throws IOException {
		this.nomFichier = nomFichier;
		ouvrir();
	}
	/**
	 * Getteur de la liste de tout les sommets du graphe
	 * @return liste de sommet
	 */
	public List<Sommet> getListeSommet() {
		return listeSommet;
	}
	
	/**
	 * Ouverture de graphe et création des objets
	 * @throws FileNotFoundException
	 * @throws IOException 
	 */
	private void ouvrir() throws FileNotFoundException, IOException{
		
		String ligneActuelle;
		try (BufferedReader scanSommets = new BufferedReader(new FileReader(nomFichier))) {
			while ((ligneActuelle = scanSommets.readLine()) != null) {
				//System.out.println(ligneActuelle);
				String sommet = ligneActuelle.split(":")[0];
				String[] sommetSplit = sommet.split(",");
				listeSommet.add(new Sommet(sommetSplit[0], sommetSplit[1]));
			}
		} 
      
		BufferedReader scanAretes = new BufferedReader(new FileReader(nomFichier));
   
        while ((ligneActuelle = scanAretes.readLine()) != null) {            
            String[] séparationSommetArete = ligneActuelle.split(":");
            
           
            String[] infoSommetOrigine = séparationSommetArete[0].split(",");
			String[] listeDestination = séparationSommetArete[1].split(";");
			
			Sommet origine=listeSommet.get(listeSommet.indexOf(new Sommet(infoSommetOrigine[0], infoSommetOrigine[1])));
			
            for(String item:listeDestination) {
				
                String[] séparationRouteDestination = item.split("\\|");
                String[] routeIndividuelle = séparationRouteDestination[0].split(",");
				String[] routeDestination = séparationRouteDestination[1].split(",");
				Sommet destination = listeSommet.get(listeSommet.indexOf(new Sommet(routeDestination[0], routeDestination[1])));
				origine.getSuccesseurs().add(new Arete(routeIndividuelle[0], Integer.parseInt(routeIndividuelle[1]),destination));
            }
        }
	}
	
	/**
	 * Trouve les sommets par type 
	 * @param type type de sommet
	 * @return sommet du type voulu
	 */
	public List<Sommet> trouverSommetsParType(String type) {
		List<Sommet> trouvailles = new ArrayList<>();

		if (type.equalsIgnoreCase("V") || type.equalsIgnoreCase("R") || type.equalsIgnoreCase("L")) {
			for(Sommet item : listeSommet) {
				if(item.getType().equalsIgnoreCase(type)) {
					trouvailles.add(item);
				}
			}
		}
		return trouvailles;
	}
	
	/**
	 * Trouve les arêtes par type 
	 * @param type type d'arête
	 * @return arête du type voulu
	 */
	public List<Arete> trouverAretesParType(String type) {
		List<Arete> trouvailles = new ArrayList<>();
		if (type.equalsIgnoreCase("A") || type.equalsIgnoreCase("N") || type.equalsIgnoreCase("D")) {
			for(Sommet item : listeSommet) {
				for(Arete parcours : item.getSuccesseurs()) {
					if(parcours.getType().equalsIgnoreCase(type) && !trouvailles.contains(parcours)) {
						trouvailles.add(parcours);
					}
				}
			}
		}
		return trouvailles;
	}
	
	/**
	 * Trouve les extremitées d'une arête
	 * @param test une arête
	 * @return liste de sommet correspondant
	 */
	public List<Sommet> trouverSommetsRelies(Arete test) {
		List<Sommet> trouvailles = new ArrayList<>();
		for(Sommet item : listeSommet) {
			for(Arete parcours : item.getSuccesseurs()) {
				if(!trouvailles.contains(item) && parcours.equals(test)) {
					trouvailles.add(item);
					trouvailles.add(parcours.getDestination());
				}
			}
		}
		return trouvailles;
	}
	
	/**
	 * Trouve si deux sommet sont liés à 1 de distance
	 * @param premier Premier sommet
	 * @param deuxieme Deuxième sommet
	 * @return true si liés , false sinon
	 */
	public boolean rechercher1Distance(Sommet premier, Sommet deuxieme) {
		for(Arete item : premier.getSuccesseurs()) {
			if(item.getDestination().equals(deuxieme)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Trouve si deux sommet sont liés à 2 de distance
	 * @param premier Premier sommet
	 * @param deuxieme Deuxième sommet
	 * @return true si liés , false sinon
	 */
	public boolean rechercher2Distance(Sommet premier, Sommet deuxieme) {
		// 2-distance exactement donc : 
		if(rechercher1Distance(premier, deuxieme)) {
			return false;
		}
		for(Arete item : premier.getSuccesseurs()) {
			// parcourir les aretes de item.getDestination
			// si la destination n'est pas égale à premier et égale à deuxieme alors true
			for(Arete deuxiemeSaut : item.getDestination().getSuccesseurs()) {
				if(!(deuxiemeSaut.getDestination().equals(premier)) && deuxiemeSaut.getDestination().equals(deuxieme)) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Compte le total de sommet et le nombre de sommet par type
	 * @return liste de valeur numérique
	 */
	public List<Integer> comptageSommets(){
		List<Integer> compte= new ArrayList<>();
		int countSommets = 0;
		int countVilles = 0;
		int countRestaurants = 0;
		int countLoisir = 0;
		for(Sommet item:listeSommet){
			countSommets++;
			switch (item.getType()) {
				case "V":
					countVilles++;
					break;
				case "R":
					countRestaurants++;
					break;
				case "L":
					countLoisir++;
					break;
				default:
					break;
			}
		}
		compte.add(countSommets);
		compte.add(countVilles);
		compte.add(countRestaurants);
		compte.add(countLoisir);
		return compte;
	}
	
	/**
	 * Compte le total d'arête et le nombre d'arête par type
	 * @return liste de valeur numérique
	 */
	public List<Integer>comptageAretes(){
		List<Integer> compte= new ArrayList<>();
		int countAretes = 0;
		int countAutoroutes = 0;
		int countNationales = 0;
		int countDepartementales = 0;
		
		for(Sommet s:listeSommet){
			for(Arete elem:s.getSuccesseurs()){
				countAretes++;
				switch (elem.getType()) {
					case "A":
						countAutoroutes++;
						break;
					case "N":
						countNationales++;
						break;
					case "D":
						countDepartementales++;
						break;
					default:
						break;
				}
			}
		}
		compte.add(countAretes);
		compte.add(countAutoroutes);
		compte.add(countNationales);
		compte.add(countDepartementales);
		return compte;
	}
	

	//pour le sommet en question on regarde tous ses voisins puis on regarde les voisins de ces voisins
	
	/**
	 * Compare deux sommet(ouverture,culturel,gastonomique)
	 * @param premier Premier sommet
	 * @param deuxieme Deuxièmre sommet
	 * @return liste de valeur numérique
	 */
	public List<Integer> comparerOCG(Sommet premier, Sommet deuxieme) {
		List<Integer> resultat = new ArrayList<>();
		List<Sommet> eviterLesDoublons1 = new ArrayList<>();
		eviterLesDoublons1.add(premier);
		int nbVPremier = 0, nbRPremier = 0, nbLPremier = 0;
		for(Arete item : premier.getSuccesseurs()) {
			for(Arete parcours : item.getDestination().getSuccesseurs()) {
				if(!eviterLesDoublons1.contains(parcours.getDestination())) {
					switch (parcours.getDestination().getType()) {
						case "V" : nbVPremier++;
									break;
						case "R" : nbRPremier++;
									break;
						case "L" : nbLPremier++;
									break;
					}
					eviterLesDoublons1.add(parcours.getDestination());
				}
			}
		}
		for(Arete item : premier.getSuccesseurs()) {
			if(!eviterLesDoublons1.contains(item.getDestination())) {
				switch (item.getDestination().getType()) {
					case "V" : nbVPremier++;
								break;
					case "R" : nbRPremier++;
								break;
					case "L" : nbLPremier++;
								break;
				}
				System.out.println(item.getDestination());
				eviterLesDoublons1.add(item.getDestination());
			}
		}
		List<Sommet> eviterLesDoublons2 = new ArrayList<>();
		eviterLesDoublons2.add(deuxieme);
		int nbVDeuxieme = 0, nbRDeuxieme = 0, nbLDeuxieme = 0;
		for(Arete item : deuxieme.getSuccesseurs()) {
			for(Arete parcours : item.getDestination().getSuccesseurs()) {
				if(!eviterLesDoublons2.contains(parcours.getDestination())) {
					switch (parcours.getDestination().getType()) {
						case "V" : nbVDeuxieme++;
									break;
						case "R" : nbRDeuxieme++;
									break;
						case "L" : nbLDeuxieme++;
									break;
					}
					eviterLesDoublons2.add(parcours.getDestination());
				}
			}
		}
		for(Arete item : deuxieme.getSuccesseurs()) {
			if(!eviterLesDoublons2.contains(item.getDestination())) {
				switch (item.getDestination().getType()) {
					case "V" : nbVDeuxieme++;
									break;
					case "R" : nbRDeuxieme++;
								break;
					case "L" : nbLDeuxieme++;
								break;
				}
				eviterLesDoublons2.add(item.getDestination());
			}
		}
		
		// Format liste retour : [comparaison premier avec deuxieme VILLE, comparaison premier avec deuxieme RESTAURANT, comparaison premier avec deuxieme LOISIR]
		// Correspondances : [1 - premier > deuxième, 0 - premier = deuxieme, -1 - premier < deuxieme]
		int comparaison;
		if (nbVPremier>nbVDeuxieme) comparaison = 1;
		else if (nbVPremier<nbVDeuxieme) comparaison = -1;
		else comparaison = 0;
		resultat.add(comparaison);
		if (nbRPremier>nbRDeuxieme) comparaison = 1;
		else if (nbRPremier<nbRDeuxieme) comparaison = -1;
		else comparaison = 0;
		resultat.add(comparaison);
		if (nbLPremier>nbLDeuxieme) comparaison = 1;
		else if (nbLPremier<nbLDeuxieme) comparaison = -1;
		else comparaison = 0;
		resultat.add(comparaison);
		return resultat;
	}
	
	/**
	 * Getter du surval
	 * @return le survol du sommet
	 */
	public Sommet getSurvol() {
		return survol;
	}
	
	/**
	 * Setteur du survol
	 * @param survol sommet choisi
	 */
	public void setSurvol(Sommet survol) {
		this.survol = survol;
	}
	
	/**
	 * Trouve une arête entre deux sommets
	 * @param premier Premier sommet
	 * @param deuxieme Deuxième sommet
	 * @return arête si trouvée, null sinon
	 */
	public Arete trouverAreteEntreSommets(Sommet premier, Sommet deuxieme) {
		for(Arete item : premier.getSuccesseurs()) {
			for(Arete elem : deuxieme.getSuccesseurs()) {
				if(item.equals(elem)) {
					return elem;
				}
			}
		}		
		return null;
	}
	
	/**
	 * Détermine un itinéraire entre deux sommets
	 * @param depart Premier sommet
	 * @param arrivee Deuxième sommet
	 * @return l'itinéraire entre les deux sommets,sinon null
	 */
	public Map<Sommet, Arete> itineraire(Sommet depart, Sommet arrivee) {
		if(!depart.equals(arrivee)) {
			// Dijkstra :
			List<Sommet> listeSommetsNonTraites = new ArrayList<>(listeSommet);
			HashMap<Sommet, Integer> distance = new HashMap<>();
			// premier dans la hashmap = sommet qu on regarde /////////// deuxieme = predecesseur dans l'itinéraire du sommet en première position
			HashMap<Sommet, Sommet> predecesseur = new HashMap<>();

			// initialisation de toutes les distances
			for(Sommet item : listeSommetsNonTraites) {
				if(item.equals(depart)) {
					distance.put(item, 0);
				} else {
					distance.put(item, Integer.MAX_VALUE);
				}
				predecesseur.put(item, item);
			}

			while(!listeSommetsNonTraites.isEmpty()) {
				int minimumTrouve = Integer.MAX_VALUE;
				Sommet si = null;
				for(Sommet elem : listeSommetsNonTraites) {
					// si la distance dans la hashmap distance à la position du sommet elem est inférieur à minimumTrouve alors on remplace minimultrouve et pluspetitedistance
					if(distance.get(elem) < minimumTrouve) {
						minimumTrouve = distance.get(elem);
						si = elem;
					}
				}
				listeSommetsNonTraites.remove(si);
				
				
				if(!(si == null)) {
					for(Arete suivantes : si.getSuccesseurs()) {
						Sommet sj = suivantes.getDestination();
						if(distance.get(sj) > minimumTrouve + suivantes.getLongueur()) {
							distance.replace(sj, minimumTrouve + suivantes.getLongueur());
							predecesseur.replace(sj, si);
						}					
					}
				}
				
			}
			Map<Sommet, Arete> decodage = new LinkedHashMap<>();
			Set<Map.Entry<Sommet, Sommet>> parcours = predecesseur.entrySet();

			Sommet predDernier = predecesseur.get(arrivee);
			Sommet dernier = arrivee;
			
			if(!predDernier.equals(depart)) {
				do {
					decodage.put(dernier, trouverAreteEntreSommets(dernier, predecesseur.get(dernier)));
					dernier = predecesseur.get(dernier);
				} while (!dernier.equals(depart));
			}
			return decodage;
		} else {
			return null;
		}
	}
	
	/**
	 * Calcule la longeur d'itineraire
	 * @param resultat map de sommet et d'arête
	 * @return distance total
	 */
	public int longueurItineraire(Map<Sommet, Arete> resultat) {
		int total = 0;
		for(Map.Entry<Sommet, Arete> elem : resultat.entrySet()) {
			if(!(elem.getValue() == null)) {
				total += elem.getValue().getLongueur();
			}
		}
		return total;
	}
}
