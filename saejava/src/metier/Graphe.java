package metier;

import java.io.BufferedReader;
import java.io.File;
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
	private List<Sommet> listSommet=new ArrayList<>();
	private String nomFichier;

	public Graphe(String nomFichier) throws IOException {
		this.nomFichier = nomFichier;
		ouvrir();
	}

	public Graphe(File file) {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	public List<Sommet> getListSommet() {
		return listSommet;
	}
	
	
	public void ouvrir() throws FileNotFoundException, IOException{
		
		BufferedReader scanSommets = new BufferedReader(new FileReader(nomFichier));
        
        String ligneActuelle;
        while ((ligneActuelle = scanSommets.readLine()) != null) {
			//System.out.println(ligneActuelle);
            String sommet = ligneActuelle.split(":")[0];
            String[] sommetSplit = sommet.split(",");
            listSommet.add(new Sommet(sommetSplit[0], sommetSplit[1]));
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
			
			Sommet origine=listSommet.get(listSommet.indexOf(new Sommet(infoSommetOrigine[0], infoSommetOrigine[1])));
			//System.out.println(origine);
			
            for(String item:listeDestination) {
				
                String[] séparationRouteDestination = item.split("\\|");
                String[] routeIndividuelle = séparationRouteDestination[0].split(",");
				String[] routeDestination = séparationRouteDestination[1].split(",");
				Sommet destination = listSommet.get(listSommet.indexOf(new Sommet(routeDestination[0], routeDestination[1])));
				origine.getVoisins().add(new Arete(routeIndividuelle[0], Integer.parseInt(routeIndividuelle[1]),destination));
            }
        }
	}
}
