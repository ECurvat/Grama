package metier;

/**
 *
 * @author elliot
 */
public class Correspondance {
	private Sommet depart;
	private Sommet destination;
	private Arete route;

	public Correspondance(Sommet depart, Sommet destination, Arete route) {
		this.depart = depart;
		this.destination = destination;
		this.route = route;
	}

	@Override
	public String toString() {
		return "Correspondance : " + "Départ = " + depart + ", Route = " + route + ", Destination = " + destination;
	}
}
