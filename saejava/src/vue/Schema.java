package vue;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
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
	public void paint(Graphics f) {	
		Graphics2D g = (Graphics2D) f;
		rayon = 0.48 * this.getSize().height;
		if(this.getSize().width < this.getSize().height) {
			rayon = 0.48 * this.getSize().width;
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
				switch(graphe.get(i).getType()) {
					case "V":
						g.setColor(new Color(252, 92, 101));
						break;
					case "R":
						g.setColor(new Color(253, 150, 68));
						break;
					case "L":
						g.setColor(new Color(38, 222, 129));
						break;
				}
				if(!(graphe.get(i) == graphePrincipal.getSurvol())) {
					g.drawString(graphe.get(i).getNom(), centre.x + posX - 25, centre.y + posY);
				} else {
					g.setFont(new Font("Helvetica Neue", Font.PLAIN, 15));
					g.drawString(graphe.get(i).getNom(), centre.x + posX - 25, centre.y + posY);
					g.setFont(new Font("Helvetica Neue", Font.PLAIN, 10));
				}
			}
			g.setStroke(new BasicStroke(2));
			g.setFont(new Font("Helvetica Neue", Font.PLAIN, 15));
			for(Arete item : graphePrincipal.trouverAretesParType("A")) {
				g.setColor(new Color(165, 94, 234));
				Sommet debut = graphePrincipal.trouverSommetsRelies(item).get(0);
				Sommet fin = graphePrincipal.trouverSommetsRelies(item).get(1);
				if(graphePrincipal.trouverSommetsRelies(item).contains(graphePrincipal.getSurvol())) {
					g.drawLine(debut.getPositionX(), debut.getPositionY(), fin.getPositionX(), fin.getPositionY());
					g.setColor(Color.BLACK);
					g.drawString(Integer.toString(item.getLongueur()), (debut.getPositionX()+ fin.getPositionX()) / 2, (debut.getPositionY() + fin.getPositionY()) / 2 + 20);
				}	
			}
			for(Arete item : graphePrincipal.trouverAretesParType("N")) {
				g.setColor(new Color(75, 123, 236));
				Sommet debut = graphePrincipal.trouverSommetsRelies(item).get(0);
				Sommet fin = graphePrincipal.trouverSommetsRelies(item).get(1);
				if(graphePrincipal.trouverSommetsRelies(item).contains(graphePrincipal.getSurvol())) {
					g.drawLine(debut.getPositionX(), debut.getPositionY(), fin.getPositionX(), fin.getPositionY());
					g.setColor(Color.BLACK);
					g.drawString(Integer.toString(item.getLongueur()), (debut.getPositionX()+ fin.getPositionX()) / 2, (debut.getPositionY() + fin.getPositionY()) / 2 + 20);
				}
			}
			for(Arete item : graphePrincipal.trouverAretesParType("D")) {
				g.setColor(new Color(69, 170, 242));
				Sommet debut = graphePrincipal.trouverSommetsRelies(item).get(0);
				Sommet fin = graphePrincipal.trouverSommetsRelies(item).get(1);
				if(graphePrincipal.trouverSommetsRelies(item).contains(graphePrincipal.getSurvol())) {
					g.drawLine(debut.getPositionX(), debut.getPositionY(), fin.getPositionX(), fin.getPositionY());
					g.setColor(Color.BLACK);
					g.drawString(Integer.toString(item.getLongueur()), (debut.getPositionX()+ fin.getPositionX()) / 2, (debut.getPositionY() + fin.getPositionY()) / 2 + 20);
				}
			}
		}
	}

	public void setGraphePrincipal(Graphe g) {
		this.graphePrincipal = g;
	}
}
