package metier;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author elliot
 */
public class Conteneur {
	private List<List> conteneurPrincipal;
	private List<HashMap> conteneurSuccesseurs;
	
	Map<Integer,Sommet> correspondanceSommets = new HashMap<>();
	Map<Integer,Arete> destinationRoute = new HashMap<>();
	
	public Conteneur() {
		
	}
}
