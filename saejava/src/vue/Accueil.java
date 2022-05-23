/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vue;

import modele.ModeleListSommets;
import java.io.File;
import java.io.IOException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import metier.*;
import modele.ModeleListAretes;

/**
 *
 * @author François, Elliot
 */
public class Accueil extends javax.swing.JFrame{
	
	public Graphe graphePrincipal;
	private ModeleListSommets modeleVille = new ModeleListSommets();
	private ModeleListSommets modeleRestaurant = new ModeleListSommets();
	private ModeleListSommets modeleLoisir = new ModeleListSommets();
	private ModeleListAretes modeleAutoroutes = new ModeleListAretes();
	private ModeleListAretes modeleNationales = new ModeleListAretes();
	private ModeleListAretes modeleDepartementales = new ModeleListAretes();
	
	
	// Selection pour combo box avec tous les sommets OU toutes les arêtes (quelque soit le type)
	private DefaultComboBoxModel modeleEcran1SommetsCombo = new DefaultComboBoxModel();
	private DefaultComboBoxModel modeleEcran2SommetsChoix1Combo = new DefaultComboBoxModel();
	private DefaultComboBoxModel modeleEcran2SommetsChoix2Combo = new DefaultComboBoxModel();
	private DefaultComboBoxModel modeleAretesCombo = new DefaultComboBoxModel();
	
	// Resultat dans l'écran 1 de la recherche de voisins
	private DefaultListModel  modeleSommet = new DefaultListModel();
	private DefaultListModel modelArete = new DefaultListModel();
	

	/**
	 * Creates new form Accueil
	 */
	public Accueil() {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPaneSelectionMenus = new javax.swing.JTabbedPane();
        jPanelAccueil = new javax.swing.JPanel();
        jButtonImporter = new javax.swing.JButton();
        jLabelMessageGraphe = new javax.swing.JLabel();
        jPanelEcran0 = new javax.swing.JPanel();
        jPanelresultat = new javax.swing.JPanel();
        jScrollPaneEcran0Villes = new javax.swing.JScrollPane();
        jListEcran0Villes = new javax.swing.JList<>();
        jScrollPaneEcran0Loisir = new javax.swing.JScrollPane();
        jListEcran0Loisirs = new javax.swing.JList<>();
        jScrollPaneEcran0Restaurants = new javax.swing.JScrollPane();
        jListEcran0Restaurants = new javax.swing.JList<>();
        jLabelEcran0Villes = new javax.swing.JLabel();
        jLabelEcran0Restaurant = new javax.swing.JLabel();
        jLabeEcran0lLoisir = new javax.swing.JLabel();
        jScrollPaneEcran0Autoutes = new javax.swing.JScrollPane();
        jListEcran0Autoroutes = new javax.swing.JList<>();
        jScrollPaneEcran0Nationales = new javax.swing.JScrollPane();
        jListEcran0Nationales = new javax.swing.JList<>();
        jScrollPaneEcran0Departementales = new javax.swing.JScrollPane();
        jListEcran0Departementales = new javax.swing.JList<>();
        jLabelEcran0Autoroutes = new javax.swing.JLabel();
        jLabelEcran0Nationales = new javax.swing.JLabel();
        jLabelEcran0Departementales = new javax.swing.JLabel();
        jLabelEcran0Recap = new javax.swing.JLabel();
        jPanelEcran1 = new javax.swing.JPanel();
        jTabbedPaneEcran1 = new javax.swing.JTabbedPane();
        jPanelSommets = new javax.swing.JPanel();
        jComboBoxEcran1Ville = new javax.swing.JComboBox<>();
        jLabelEcran1Voisin = new javax.swing.JLabel();
        jScrollPaneEcran1ResultatSommets = new javax.swing.JScrollPane();
        jListEcran1ResultatSommets = new javax.swing.JList<>();
        jPanelAretes = new javax.swing.JPanel();
        jComboBoxEcran1Arete = new javax.swing.JComboBox<>();
        jLabelEcran1SommetsRelies = new javax.swing.JLabel();
        jScrollPaneEcran1ResultatAretes = new javax.swing.JScrollPane();
        jListEcran1ResultatAretes = new javax.swing.JList<>();
        jPanelEcran2 = new javax.swing.JPanel();
        jLabelEcran2ChoixSommet1 = new javax.swing.JLabel();
        jLabelEcran2ChoixSommet2 = new javax.swing.JLabel();
        jComboBoxEcran2Sommets1 = new javax.swing.JComboBox<>();
        jComboBoxEcran2Sommets2 = new javax.swing.JComboBox<>();
        jButtonEcran2Valider = new javax.swing.JButton();
        jLabelEcran2Resultat = new javax.swing.JLabel();
        jPanelEcran3 = new javax.swing.JPanel();
        jPanelEcran4 = new javax.swing.JPanel();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuFichier = new javax.swing.JMenu();
        jMenuItemImporter = new javax.swing.JMenuItem();
        jMenuItemInformations = new javax.swing.JMenuItem();
        jMenuItemQuitter = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Accueil");

        jTabbedPaneSelectionMenus.setEnabled(false);

        jButtonImporter.setText("Importer un graphe");
        jButtonImporter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImporterActionPerformed(evt);
            }
        });

        jLabelMessageGraphe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMessageGraphe.setText("En attente d'importation d'un graphe ...");

        javax.swing.GroupLayout jPanelAccueilLayout = new javax.swing.GroupLayout(jPanelAccueil);
        jPanelAccueil.setLayout(jPanelAccueilLayout);
        jPanelAccueilLayout.setHorizontalGroup(
            jPanelAccueilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelMessageGraphe, javax.swing.GroupLayout.DEFAULT_SIZE, 794, Short.MAX_VALUE)
            .addGroup(jPanelAccueilLayout.createSequentialGroup()
                .addGap(285, 285, 285)
                .addComponent(jButtonImporter, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelAccueilLayout.setVerticalGroup(
            jPanelAccueilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAccueilLayout.createSequentialGroup()
                .addContainerGap(295, Short.MAX_VALUE)
                .addComponent(jLabelMessageGraphe)
                .addGap(127, 127, 127)
                .addComponent(jButtonImporter)
                .addGap(44, 44, 44))
        );

        jTabbedPaneSelectionMenus.addTab("Accueil", jPanelAccueil);

        jPanelEcran0.setEnabled(false);

        jListEcran0Villes.setModel(modeleVille);
        jScrollPaneEcran0Villes.setViewportView(jListEcran0Villes);

        jListEcran0Loisirs.setModel(modeleLoisir);
        jScrollPaneEcran0Loisir.setViewportView(jListEcran0Loisirs);

        jListEcran0Restaurants.setModel(modeleRestaurant);
        jScrollPaneEcran0Restaurants.setViewportView(jListEcran0Restaurants);

        jLabelEcran0Villes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabelEcran0Restaurant.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabeEcran0lLoisir.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jListEcran0Autoroutes.setModel(modeleAutoroutes);
        jScrollPaneEcran0Autoutes.setViewportView(jListEcran0Autoroutes);

        jListEcran0Nationales.setModel(modeleNationales);
        jScrollPaneEcran0Nationales.setViewportView(jListEcran0Nationales);

        jListEcran0Departementales.setModel(modeleDepartementales);
        jScrollPaneEcran0Departementales.setViewportView(jListEcran0Departementales);

        jLabelEcran0Autoroutes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabelEcran0Nationales.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabelEcran0Departementales.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanelresultatLayout = new javax.swing.GroupLayout(jPanelresultat);
        jPanelresultat.setLayout(jPanelresultatLayout);
        jPanelresultatLayout.setHorizontalGroup(
            jPanelresultatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelresultatLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanelresultatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelresultatLayout.createSequentialGroup()
                        .addGroup(jPanelresultatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabelEcran0Autoroutes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPaneEcran0Autoutes, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelresultatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPaneEcran0Nationales, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabelEcran0Nationales, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelresultatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPaneEcran0Departementales, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelEcran0Departementales, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelresultatLayout.createSequentialGroup()
                        .addComponent(jScrollPaneEcran0Villes, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPaneEcran0Restaurants, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPaneEcran0Loisir, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelresultatLayout.createSequentialGroup()
                        .addComponent(jLabelEcran0Villes, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelEcran0Restaurant, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabeEcran0lLoisir, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanelresultatLayout.setVerticalGroup(
            jPanelresultatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelresultatLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanelresultatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPaneEcran0Restaurants, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                    .addComponent(jScrollPaneEcran0Villes)
                    .addComponent(jScrollPaneEcran0Loisir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelresultatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEcran0Villes)
                    .addComponent(jLabelEcran0Restaurant)
                    .addComponent(jLabeEcran0lLoisir))
                .addGroup(jPanelresultatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelresultatLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanelresultatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPaneEcran0Nationales, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                            .addComponent(jScrollPaneEcran0Departementales))
                        .addGap(84, 84, 84))
                    .addGroup(jPanelresultatLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPaneEcran0Autoutes, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelresultatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelEcran0Autoroutes, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelEcran0Nationales, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelEcran0Departementales, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(56, 56, 56))))
        );

        jLabelEcran0Recap.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanelEcran0Layout = new javax.swing.GroupLayout(jPanelEcran0);
        jPanelEcran0.setLayout(jPanelEcran0Layout);
        jPanelEcran0Layout.setHorizontalGroup(
            jPanelEcran0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelresultat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabelEcran0Recap, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelEcran0Layout.setVerticalGroup(
            jPanelEcran0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEcran0Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelEcran0Recap, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelresultat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPaneSelectionMenus.addTab("0-distance", jPanelEcran0);

        jComboBoxEcran1Ville.setModel(modeleSommetsCombo);
        jComboBoxEcran1Ville.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEcran1VilleActionPerformed(evt);
            }
        });

        jLabelEcran1Voisin.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelEcran1Voisin.setText("Voisins direct :");

        jListEcran1ResultatSommets.setModel(modeleSommet);
        jScrollPaneEcran1ResultatSommets.setViewportView(jListEcran1ResultatSommets);

        javax.swing.GroupLayout jPanelSommetsLayout = new javax.swing.GroupLayout(jPanelSommets);
        jPanelSommets.setLayout(jPanelSommetsLayout);
        jPanelSommetsLayout.setHorizontalGroup(
            jPanelSommetsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSommetsLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanelSommetsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelEcran1Voisin)
                    .addComponent(jScrollPaneEcran1ResultatSommets, javax.swing.GroupLayout.DEFAULT_SIZE, 756, Short.MAX_VALUE)
                    .addComponent(jComboBoxEcran1Ville, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanelSommetsLayout.setVerticalGroup(
            jPanelSommetsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSommetsLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jComboBoxEcran1Ville, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelEcran1Voisin)
                .addGap(18, 18, 18)
                .addComponent(jScrollPaneEcran1ResultatSommets, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(120, Short.MAX_VALUE))
        );

        jTabbedPaneEcran1.addTab("Sommets", jPanelSommets);

        jComboBoxEcran1Arete.setModel(modeleAretesCombo);
        jComboBoxEcran1Arete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEcran1AreteActionPerformed(evt);
            }
        });

        jLabelEcran1SommetsRelies.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelEcran1SommetsRelies.setText("Sommets reliés :");

        jListEcran1ResultatAretes.setModel(modelArete);
        jScrollPaneEcran1ResultatAretes.setViewportView(jListEcran1ResultatAretes);

        javax.swing.GroupLayout jPanelAretesLayout = new javax.swing.GroupLayout(jPanelAretes);
        jPanelAretes.setLayout(jPanelAretesLayout);
        jPanelAretesLayout.setHorizontalGroup(
            jPanelAretesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAretesLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanelAretesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBoxEcran1Arete, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPaneEcran1ResultatAretes, javax.swing.GroupLayout.DEFAULT_SIZE, 756, Short.MAX_VALUE)
                    .addComponent(jLabelEcran1SommetsRelies))
                .addGap(14, 14, 14))
        );
        jPanelAretesLayout.setVerticalGroup(
            jPanelAretesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAretesLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jComboBoxEcran1Arete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelEcran1SommetsRelies)
                .addGap(18, 18, 18)
                .addComponent(jScrollPaneEcran1ResultatAretes, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(121, Short.MAX_VALUE))
        );

        jTabbedPaneEcran1.addTab("Aretes", jPanelAretes);

        javax.swing.GroupLayout jPanelEcran1Layout = new javax.swing.GroupLayout(jPanelEcran1);
        jPanelEcran1.setLayout(jPanelEcran1Layout);
        jPanelEcran1Layout.setHorizontalGroup(
            jPanelEcran1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneEcran1)
        );
        jPanelEcran1Layout.setVerticalGroup(
            jPanelEcran1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneEcran1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jTabbedPaneSelectionMenus.addTab("1-distance", jPanelEcran1);

        jLabelEcran2ChoixSommet1.setText("Choisir un premier sommet");

        jLabelEcran2ChoixSommet2.setText("Choisir un second sommet");

        jComboBoxEcran2Sommets1.setModel(modeleEcran2SommetsChoix1Combo);
        jComboBoxEcran2Sommets1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEcran2Sommets1ActionPerformed(evt);
            }
        });

        jComboBoxEcran2Sommets2.setModel(modeleEcran2SommetsChoix2Combo);
        jComboBoxEcran2Sommets2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEcran2Sommets2ActionPerformed(evt);
            }
        });

        jButtonEcran2Valider.setText("Tester la 2-distance des sommets");
        jButtonEcran2Valider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEcran2ValiderActionPerformed(evt);
            }
        });

        jLabelEcran2Resultat.setText("Les sommets X et X sont situés à une 2-distance exactement l'un de l'autre");

        javax.swing.GroupLayout jPanelEcran2Layout = new javax.swing.GroupLayout(jPanelEcran2);
        jPanelEcran2.setLayout(jPanelEcran2Layout);
        jPanelEcran2Layout.setHorizontalGroup(
            jPanelEcran2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEcran2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanelEcran2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEcran2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanelEcran2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelEcran2ChoixSommet1)
                            .addComponent(jLabelEcran2ChoixSommet2))
                        .addGap(615, 615, 615))
                    .addGroup(jPanelEcran2Layout.createSequentialGroup()
                        .addGroup(jPanelEcran2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jComboBoxEcran2Sommets1, javax.swing.GroupLayout.Alignment.LEADING, 0, 754, Short.MAX_VALUE)
                            .addComponent(jComboBoxEcran2Sommets2, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelEcran2Layout.createSequentialGroup()
                        .addGroup(jPanelEcran2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelEcran2Resultat, javax.swing.GroupLayout.PREFERRED_SIZE, 754, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonEcran2Valider))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanelEcran2Layout.setVerticalGroup(
            jPanelEcran2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEcran2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelEcran2ChoixSommet1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBoxEcran2Sommets1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelEcran2ChoixSommet2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxEcran2Sommets2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jButtonEcran2Valider)
                .addGap(29, 29, 29)
                .addComponent(jLabelEcran2Resultat, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(242, Short.MAX_VALUE))
        );

        jTabbedPaneSelectionMenus.addTab("2-distance", jPanelEcran2);

        javax.swing.GroupLayout jPanelEcran3Layout = new javax.swing.GroupLayout(jPanelEcran3);
        jPanelEcran3.setLayout(jPanelEcran3Layout);
        jPanelEcran3Layout.setHorizontalGroup(
            jPanelEcran3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 794, Short.MAX_VALUE)
        );
        jPanelEcran3Layout.setVerticalGroup(
            jPanelEcran3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 504, Short.MAX_VALUE)
        );

        jTabbedPaneSelectionMenus.addTab(">= 2-distance", jPanelEcran3);

        javax.swing.GroupLayout jPanelEcran4Layout = new javax.swing.GroupLayout(jPanelEcran4);
        jPanelEcran4.setLayout(jPanelEcran4Layout);
        jPanelEcran4Layout.setHorizontalGroup(
            jPanelEcran4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 794, Short.MAX_VALUE)
        );
        jPanelEcran4Layout.setVerticalGroup(
            jPanelEcran4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 504, Short.MAX_VALUE)
        );

        jTabbedPaneSelectionMenus.addTab("p-distance", jPanelEcran4);

        jMenuFichier.setText("Fichier");

        jMenuItemImporter.setText("Importer");
        jMenuFichier.add(jMenuItemImporter);

        jMenuItemInformations.setText("Informations");
        jMenuFichier.add(jMenuItemInformations);

        jMenuItemQuitter.setText("Quitter");
        jMenuFichier.add(jMenuItemQuitter);

        jMenuBar.add(jMenuFichier);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneSelectionMenus)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneSelectionMenus, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonImporterActionPerformed(java.awt.event.ActionEvent evt) {                                                
		if (jButtonImporter.getText().equals("Importer un graphe")) {
			JFileChooser choixFichier = new JFileChooser();
			int option = choixFichier.showOpenDialog(null);
			if(option == JFileChooser.APPROVE_OPTION){
				try {
					File file = choixFichier.getSelectedFile();
					jLabelMessageGraphe.setText("Graphe correctement importé : " + file.getName());
					graphePrincipal = new Graphe(file.getName());
					jTabbedPaneSelectionMenus.setEnabled(true);

					if(jLabelEcran0Nationales.getText().equals("")){
						int nbSommets = graphePrincipal.comptageSommets().get(0);
						int nbVilles = graphePrincipal.comptageSommets().get(1);
						int nbRestaurants = graphePrincipal.comptageSommets().get(2);
						int nbLoisir = graphePrincipal.comptageSommets().get(3);

						jLabelEcran0Villes.setText(nbVilles+" Villes");
						jLabelEcran0Restaurant.setText(nbRestaurants+" Restaurant");
						jLabeEcran0lLoisir.setText(nbLoisir+" lieux de loisir");

						int nbAretes = graphePrincipal.comptageAretes().get(0);
						int nbAutoroutes = graphePrincipal.comptageAretes().get(1);
						int nbNationales = graphePrincipal.comptageAretes().get(2);
						int nbDepartmentales = graphePrincipal.comptageAretes().get(3);

						jLabelEcran0Autoroutes.setText(nbAutoroutes+" Autoroutes");
						jLabelEcran0Nationales.setText(nbNationales+" Nationales");
						jLabelEcran0Departementales.setText(nbDepartmentales+" Departementales");

						jLabelEcran0Recap.setText("votre graphe posséde : "+nbSommets+" noeuds"+" et "+nbAretes+" arete");

						modeleVille.ajouterSommets(graphePrincipal.trouverSommetsParType("V"));
						modeleRestaurant.ajouterSommets(graphePrincipal.trouverSommetsParType("R"));
						modeleLoisir.ajouterSommets(graphePrincipal.trouverSommetsParType("L"));

						modeleAutoroutes.ajouterAretes(graphePrincipal.trouverAretesParType("A"));
						modeleNationales.ajouterAretes(graphePrincipal.trouverAretesParType("N"));
						modeleDepartementales.ajouterAretes(graphePrincipal.trouverAretesParType("D"));
					}
					for(Sommet elem :graphePrincipal.getListeSommet()){
						modeleEcran1SommetsCombo.addElement(elem);
					}
					for(Sommet elem:graphePrincipal.getListeSommet()){
						for(Arete arete:elem.getSuccesseurs()){
							modeleAretesCombo.addElement(arete);
						}	
					}

					jButtonImporter.setText("Supprimer le graphe");
				} catch (IOException e) {
					System.out.println("Erreur dans l'importation : " + e.getMessage());
				}
			}
		} else {
			jTabbedPaneSelectionMenus.setEnabled(false);

			modeleVille.viderModele();
			modeleLoisir.viderModele();
			modeleRestaurant.viderModele();
			modeleAutoroutes.viderModele();
			modeleDepartementales.viderModele();
			modeleNationales.viderModele();
			jLabelMessageGraphe.setText("En attente d'importation d'un graphe ...");
			jButtonImporter.setText("Importer un graphe");
		}
		
	}
    private void jComboBoxEcran1VilleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEcran1VilleActionPerformed
       modeleSommet.clear();
	   for(Sommet s:graphePrincipal.getListeSommet()){
		   if(jComboBoxEcran1Ville.getSelectedItem()==s){
			   for(Arete elem:s.getSuccesseurs()){
					modeleSommet.addElement(elem.getDestination());
				}
		   }
	   }
    }//GEN-LAST:event_jComboBoxEcran1VilleActionPerformed

    private void jComboBoxEcran1AreteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEcran1AreteActionPerformed
        Object val = jComboBoxEcran1Arete.getSelectedItem();
		modelArete.clear();
		for(Sommet elem:graphePrincipal.trouverSommetsRelies((Arete) val)){
			modelArete.addElement(elem);
		}
    }//GEN-LAST:event_jComboBoxEcran1AreteActionPerformed

    private void jComboBoxEcran2Sommets1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEcran2Sommets1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxEcran2Sommets1ActionPerformed

    private void jComboBoxEcran2Sommets2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEcran2Sommets2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxEcran2Sommets2ActionPerformed

    private void jButtonEcran2ValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEcran2ValiderActionPerformed
        Sommet s1 = (Sommet) jComboBoxEcran2Sommets1.getSelectedItem();
		Sommet s2 = (Sommet) jComboBoxEcran2Sommets2.getSelectedItem();
		boolean resultat = graphePrincipal.rechercher2Distance(s1, s2);
		if (resultat) jLabelEcran2Resultat.setText("Les sommets" + s1.getNom() + " et " + s2.getNom() + " sont situés à une 2-distance exactement l'un de l'autre");
		else jLabelEcran2Resultat.setText("Les sommets" + s1.getNom() + " et " + s2.getNom() + " ne sont pas situés à une 2-distance exactement l'un de l'autre");
		
    }//GEN-LAST:event_jButtonEcran2ValiderActionPerformed

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Accueil().setVisible(true);
			}
		});
		
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEcran2Valider;
    private javax.swing.JButton jButtonImporter;
    private javax.swing.JComboBox<String> jComboBoxEcran1Arete;
    private javax.swing.JComboBox<String> jComboBoxEcran1Ville;
    private javax.swing.JLabel jLabeEcran0lLoisir;
    private javax.swing.JLabel jLabelEcran0Autoroutes;
    private javax.swing.JLabel jLabelEcran0Departementales;
    private javax.swing.JLabel jLabelEcran0Nationales;
    private javax.swing.JLabel jLabelEcran0Recap;
    private javax.swing.JLabel jLabelEcran0Restaurant;
    private javax.swing.JLabel jLabelEcran0Villes;
    private javax.swing.JLabel jLabelEcran1SommetsRelies;
    private javax.swing.JLabel jLabelEcran1Voisin;
    private javax.swing.JLabel jLabelEcran2ChoixSommet1;
    private javax.swing.JLabel jLabelEcran2ChoixSommet2;
    private javax.swing.JLabel jLabelMessageGraphe;
    private javax.swing.JList<String> jListEcran0Autoroutes;
    private javax.swing.JList<String> jListEcran0Departementales;
    private javax.swing.JList<String> jListEcran0Loisirs;
    private javax.swing.JList<String> jListEcran0Nationales;
    private javax.swing.JList<String> jListEcran0Restaurants;
    private javax.swing.JList<String> jListEcran0Villes;
    private javax.swing.JList<String> jListEcran1ResultatAretes;
    private javax.swing.JList<String> jListEcran1ResultatSommets;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenu jMenuFichier;
    private javax.swing.JMenuItem jMenuItemImporter;
    private javax.swing.JMenuItem jMenuItemInformations;
    private javax.swing.JMenuItem jMenuItemQuitter;
    private javax.swing.JPanel jPanelAccueil;
    private javax.swing.JPanel jPanelAretes;
    private javax.swing.JPanel jPanelEcran0;
    private javax.swing.JPanel jPanelEcran1;
    private javax.swing.JPanel jPanelEcran2;
    private javax.swing.JPanel jPanelEcran3;
    private javax.swing.JPanel jPanelEcran4;
    private javax.swing.JPanel jPanelSommets;
    private javax.swing.JPanel jPanelresultat;
    private javax.swing.JScrollPane jScrollPaneEcran0Autoutes;
    private javax.swing.JScrollPane jScrollPaneEcran0Departementales;
    private javax.swing.JScrollPane jScrollPaneEcran0Loisir;
    private javax.swing.JScrollPane jScrollPaneEcran0Nationales;
    private javax.swing.JScrollPane jScrollPaneEcran0Restaurants;
    private javax.swing.JScrollPane jScrollPaneEcran0Villes;
    private javax.swing.JScrollPane jScrollPaneEcran1ResultatAretes;
    private javax.swing.JScrollPane jScrollPaneEcran1ResultatSommets;
    private javax.swing.JTabbedPane jTabbedPaneEcran1;
    private javax.swing.JTabbedPane jTabbedPaneSelectionMenus;
    // End of variables declaration//GEN-END:variables
}
