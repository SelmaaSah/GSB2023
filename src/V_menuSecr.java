import java.awt.*;
import javax.swing.*;

/**
 * La classe V_menu représente la barre de menus de l'application.
 */
public class V_menuSecr extends JMenuBar {

    // Les éléments de la barre de menus
    private JMenuBar menu;

    private JMenu catalogue;
    private JMenuItem creercatalogue;
    
    private JMenu gerer;
    private JMenuItem gererconferences;
    private JMenuItem gererintervenant;
    private JMenuItem gereranimateur;

    private JMenu gerer2;
    private JMenuItem annuler;
    private JMenuItem modifier;
    private JMenuItem ajouter;
    private JMenuItem afficher;


    private JMenu menuActeur;
    private JMenuItem menuVoirActeur;

    /**
     * Constructeur de la classe V_menu.
     * Initialise la barre de menus avec ses éléments.
     */
    public V_menuSecr() {
        // Instanciation de la barre de menus
        menu = new JMenuBar();

        // Instanciation des menus et sous-menus
        catalogue = new JMenu("Catalogue");
        creercatalogue = new JMenuItem("Créer un catalogue");


        gerer = new JMenu("Gérer");
        gererconferences = new JMenuItem("Gérer les conférences");
        gererintervenant = new JMenuItem("Gérer les intervenants");
        gereranimateur = new JMenuItem("Gérer les animateurs");


        ajouter = new JMenu("Ajouter une conférence");
        afficher = new JMenuItem("Afficher une conférence");
        annuler = new JMenuItem("Annuler une conférence");
        modifier = new JMenuItem("Modifier une conférence");

        // Ajout des menus à la barre de menus
        setLayout(new BorderLayout());
        add(menu);
        menu.add(catalogue);
        menu.add(gerer);
        menu.add(gerer2);

        // Ajout des sous-menus aux menus
        catalogue.add(creercatalogue);
        
        gerer.add(gererconferences);
        gerer.add(gererintervenant);
        gerer.add(gereranimateur);


        gerer2.add(ajouter);
        gerer2.add(afficher);
        gerer2.add(modifier);
        gerer2.add(annuler);
        
        menu.setVisible(true);

    }

    
    
    // Méthodes pour obtenir les éléments de la barre de menus
   
	public JMenuBar getMenu() {
		return menu;
	}

	public JMenu getCatalogue() {
		return catalogue;
	}



	public JMenuItem getCreercatalogue() {
		return creercatalogue;
	}



	public JMenu getGerer() {
		return gerer;
	}



	public JMenuItem getGererconferences() {
		return gererconferences;
	}



	public JMenuItem getGererintervenant() {
		return gererintervenant;
	}



	public JMenuItem getGereranimateur() {
		return gereranimateur;
	}


	public JMenu getGerer2() {
		return gerer2;
	}



	public JMenuItem getAnnuler() {
		return annuler;
	}



	public JMenuItem getModifier() {
		return modifier;
	}



	public JMenuItem getAjouter() {
		return ajouter;
	}



	public JMenuItem getAfficher() {
		return afficher;
	}



	public JMenu getMenuActeur() {
		return menuActeur;
	}



	public JMenuItem getMenuVoirActeur() {
		return menuVoirActeur;
	}



   


}