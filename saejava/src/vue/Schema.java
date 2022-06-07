package vue;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
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
	private static Point centre;
	private static double rayon;
	private Graphe graphePrincipal;
					
	@Override
	public void paint(Graphics g) {
	
		rayon = 0.48 * this.getSize().height;
		if(this.getSize().width < this.getSize().height) {
			rayon = 0.48 * this.getSize().width;
			System.out.println("width > height");
		}
		
		centre = new Point(this.getSize().width / 2, this.getSize().height / 2);
		g.setFont(new Font("Helvetica Neue", Font.PLAIN, 10));
		this.getSize();
		if(!(graphePrincipal == null)) {
			List<Sommet> graphe = graphePrincipal.getListeSommet();
			for(int i = 0; i < graphe.size(); i++) {
				double angle = (Math.PI * 2 / graphe.size() * i);
				int posX = (int) (rayon * Math.cos(angle));
				int posY = (int) (rayon * Math.sin(angle));
				graphe.get(i).setPositionX(centre.x + posX);
				graphe.get(i).setPositionY(centre.y + posY);
				g.drawString(graphe.get(i).getNom(), centre.x + posX - 25, centre.y + posY);
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
