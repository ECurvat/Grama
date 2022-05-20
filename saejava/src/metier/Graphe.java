package metier;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author François
 */
public class Graphe {
	private final List<Sommet> listeSommet = new ArrayList<>();
	private final String nomFichier;

	public Graphe(String nomFichier) throws IOException {
		this.nomFichier = nomFichier;
		ouvrir();
	}

	public List<Sommet> getListeSommet() {
		return listeSommet;
	}
	
	
	private void ouvrir() throws FileNotFoundException, IOException{
		
		BufferedReader scanSommets = new BufferedReader(new FileReader(nomFichier));
        
        String ligneActuelle;
        while ((ligneActuelle = scanSommets.readLine()) != null) {
			//System.out.println(ligneActuelle);
            String sommet = ligneActuelle.split(":")[0];
            String[] sommetSplit = sommet.split(",");
            listeSommet.add(new Sommet(sommetSplit[0], sommetSplit[1]));
        }
        scanSommets.close(); 
      
		BufferedReader scanAretes = new BufferedReader(new FileReader(nomFichier));
   
        while ((ligneActuelle = scanAretes.readLine()) != null) {
            ligneActuelle.replace(";;", "");
            
            String[] séparationSommetArete = ligneActuelle.split(":");
            
           
            String[] infoSommetOrigine = séparationSommetArete[0].split(",");
			String[] listeDestination = séparationSommetArete[1].split(";");
			
			/*
			System.out.println("__________________________________________________________________");
			
            System.out.println("Info sommet origine : " +  Arrays.toString(infoSommetOrigine));
			System.out.println("Liste destination : " + Arrays.toString(listeDestination));
			System.out.println("Nombre de routes voisines : " + listeDestination.length);
			*/
			
			Sommet origine=listeSommet.get(listeSommet.indexOf(new Sommet(infoSommetOrigine[0], infoSommetOrigine[1])));
			//System.out.println(origine);
			
            for(String item:listeDestination) {
				
                String[] séparationRouteDestination = item.split("\\|");
                String[] routeIndividuelle = séparationRouteDestination[0].split(",");
				String[] routeDestination = séparationRouteDestination[1].split(",");
				Sommet destination = listeSommet.get(listeSommet.indexOf(new Sommet(routeDestination[0], routeDestination[1])));
				origine.getSuccesseurs().add(new Arete(routeIndividuelle[0], Integer.parseInt(routeIndividuelle[1]),destination));
            }
        }
	}
	
	public List<Sommet> trouverSommetsParType(String type) {
		List<Sommet> trouvailles = new ArrayList<>();
		try {
			if (type.equalsIgnoreCase("V") || type.equalsIgnoreCase("R") || type.equalsIgnoreCase("L")) {
				for(Sommet item : listeSommet) {
					if(item.getType().equalsIgnoreCase(type)) {
						trouvailles.add(item);
					}
				}
			} else {
				throw new TypeInconnuException();
			}
		} catch (TypeInconnuException e) {
			System.out.println("Erreur de recherche : " + e.getMessage());
		}
		return trouvailles;
	}
	
	public List<Arete> trouverAretesParType(String type) {
		List<Arete> trouvailles = new ArrayList<>();
		try {
			if (type.equalsIgnoreCase("A") || type.equalsIgnoreCase("N") || type.equalsIgnoreCase("D")) {
				for(Sommet item : listeSommet) {
					for(Arete parcours : item.getSuccesseurs()) {
						if(parcours.getType().equalsIgnoreCase(type) && !trouvailles.contains(parcours)) {
							trouvailles.add(parcours);
						}
					}
				}
			} else {
				throw new TypeInconnuException();
			}
		} catch (TypeInconnuException e) {
			System.out.println("Erreur de recherche : " + e.getMessage());
		}
		return trouvailles;
	}
	
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
	
	public boolean rechercher1Distance(Sommet premier, Sommet deuxieme) {
		for(Arete item : premier.getSuccesseurs()) {
			if(item.getDestination().equals(deuxieme)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean rechercher2Distance(Sommet premier, Sommet deuxieme) {
		// 2-distance exactement donc : 
		if(rechercher1Distance(premier, deuxieme)) {
			return false;
		}
		for(Arete item : premier.getSuccesseurs()) {
			if(rechercher1Distance(item.getDestination(), deuxieme)) {
				return true;
			}
		}
		return false;
	}
	
	public List<Integer> infographe(){
		List<Integer> listVal= new ArrayList<>();
		int countNode = 0;
		int countVilles = 0;
		int countResto = 0;
		int countLoisir = 0;
		for(Sommet item:listeSommet){
			countNode++;
			if(item.getType().equals("V")){
				countVilles++;
			}
			else if (item.getType().equals("R")) {
				countResto++;
			}
			else if(item.getType().equals("L")){
				countLoisir++;
			}
		}
		listVal.add(countNode);
		listVal.add(countVilles);
		listVal.add(countResto);
		listVal.add(countLoisir);
		return listVal;
	}
	

	//pour le sommet en question on regarde tous ses voisins puis on regarde les voisins de ces voisins
	
	public List<Integer> comparerOCG(Sommet premier, Sommet deuxieme) {
		List<Integer> resultat = new ArrayList<>();
		List<Sommet> eviterLesDoublons1 = new ArrayList<>();
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
		System.out.println("NB V Premier : " + nbVPremier + " NB R Premier : " + nbRPremier + " NB L Premier : " + nbLPremier);
		
		List<Sommet> eviterLesDoublons2 = new ArrayList<>();
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
		System.out.println("NB V Deuxieme : " + nbVDeuxieme + " NB R Deuxieme : " + nbRDeuxieme + " NB L Deuxieme : " + nbLDeuxieme);
		
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
}
