package metier;

/**
 *Cette class permet de crée les objets de type "Arete" aisni que de definir les méthodes nécessaire pour les manipuler
 * 
 * @author François, Elliot
 */
public class Arete {
	
	private final String type;
	private final int longueur;
	private final Sommet destination;
	/**
	 * Constructeur d'Arete
	 * @param type Ce paramètre représente le type de l'arrete (Autoroute, Départementale ou Nationale)
	 * @param kilometrage Ce paramètre représente la longeur de l'arete en kilométre 
	 * @param destination Ce paramètre représente un objet "Sommet" qui est la destination de l'arete
	 */
	public Arete(String type, int kilometrage,Sommet destination) {
		this.type = type;
		this.longueur = kilometrage;
		this.destination=destination;
	}
	/**
	 * Ce getteur permet de renvoyer la destination d'un Sommet 
	 * @return La destination
	 */
	public Sommet getDestination() {
		return destination;
	}
	/**
	 * la méthode toString permet de renvoyer un apperç visuele des aretes avce leurs "Type" et leurs "Longueur" 
	 * @return la chaine de caractère correspondante
	 */
	@Override
	public String toString() {
		return type + ", " + longueur;
	}
	/**
	 * Ce getteur permet de renvoyer le type d'une arete
	 * @return Le type
	 */
	public String getType() {
		return type;
	}
	/**
	 * Ce getteur permet de renvoyer la longueur en kilométre d'une arete
	 * @return la longueur en kilométre
	 */
	public int getLongueur() {
		return longueur;
	}
	/**
	 * La méthode equals permet de comparer des objet arete pour savoir si ils sont identique
	 * @param o Ce paramètre représente une arete que nous voulons tester
	 * @return True si les objet sont identique ,False dans le cas contraire
	 */
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Arete)) {
			return false;
		}
		Arete p = (Arete) o;
		return this.type.equals(p.type) && this.longueur == p.longueur;
	}

}
