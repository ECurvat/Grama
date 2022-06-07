package vue;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import metier.Arete;
import metier.Graphe;
import metier.Sommet;

/**
 *
 * @author Elliot, François
 */
public class Schema extends JPanel {
	private static final int CENTERX = 400;    
	private static final int CENTERY = 225; 
	private static final int RAYON = 200;
	private Graphe graphePrincipal;
					
	public void paint(Graphics g) {
		g.setFont(new Font("Helvetica Neue", Font.PLAIN, 10));
		if(!(graphePrincipal == null)) {
			List<Sommet> graphe = graphePrincipal.getListeSommet();
			for(int i = 0; i < graphe.size(); i++) {
				double angle = (Math.PI * 2 / graphe.size() * i);
				int posX = (int) (RAYON * Math.cos(angle));
				int posY = (int) (RAYON * Math.sin(angle));
				graphe.get(i).setPositionX(CENTERX + posX);
				graphe.get(i).setPositionY(CENTERY + posY);
				g.drawString(graphe.get(i).getNom(), CENTERX + posX - 25, CENTERY + posY);
			}
			for(Arete item : graphePrincipal.trouverAretesParType("A")) {
				Sommet debut = graphePrincipal.trouverSommetsRelies(item).get(0);
				Sommet fin = graphePrincipal.trouverSommetsRelies(item).get(1);
				g.setColor(Color.RED);
				g.drawLine(debut.getPositionX(), debut.getPositionY(), fin.getPositionX(), fin.getPositionY());
			}
			for(Arete item : graphePrincipal.trouverAretesParType("N")) {
				Sommet debut = graphePrincipal.trouverSommetsRelies(item).get(0);
				Sommet fin = graphePrincipal.trouverSommetsRelies(item).get(1);
				g.setColor(Color.BLUE);
				g.drawLine(debut.getPositionX(), debut.getPositionY(), fin.getPositionX(), fin.getPositionY());
			}
			for(Arete item : graphePrincipal.trouverAretesParType("D")) {
				Sommet debut = graphePrincipal.trouverSommetsRelies(item).get(0);
				Sommet fin = graphePrincipal.trouverSommetsRelies(item).get(1);
				g.setColor(Color.GREEN);
				g.drawLine(debut.getPositionX(), debut.getPositionY(), fin.getPositionX(), fin.getPositionY());
			}
		}
	}

	public void setGraphePrincipal(Graphe g) {
		this.graphePrincipal = g;
	}
	
	
}
