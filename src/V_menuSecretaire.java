import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class V_menuSecretaire extends JMenuBar {
	
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

    public V_menuSecretaire() {
        // Instanciation des menus et sous-menus
        catalogue = new JMenu("Catalogue");
        creercatalogue = new JMenuItem("Créer un catalogue");
        
        gerer = new JMenu("Gerer");
        gererconferences = new JMenuItem("Gerer les conf�rences");
        gererintervenant = new JMenuItem("Gerer les intervenants");
        gereranimateur = new JMenuItem("Gerer les animateurs");
        
        gerer2 = new JMenu("Conferences");
        ajouter = new JMenuItem("Ajouter une conference");
        afficher = new JMenuItem("Afficher une conference");
        annuler = new JMenuItem("Annuler une conference");
        modifier = new JMenuItem("Modifier une conference");

        // Ajout des menus à la barre de menus
        add(catalogue);
        add(gerer);
        add(gerer2);

        // Ajout des sous-menus aux menus
        catalogue.add(creercatalogue);
        
        gerer.add(gererconferences);
        gerer.add(gererintervenant);
        gerer.add(gereranimateur);
        
        gerer2.add(ajouter);
        gerer2.add(afficher);
        gerer2.add(modifier);
        gerer2.add(annuler);
    }

    public JMenuBar getMenuSecretaire() {
        return this;  // Retourne directement l'instance de la barre de menus
    }
    
    public JMenuItem getCreerCatalogue() {
    	return this.creercatalogue;
    }
    
    public JMenuItem getGererConferences() {
    	return this.gererconferences;
    }
    
    public JMenuItem getGererintervenant() {
    	return this.gererintervenant;
    }
    
    public JMenuItem getGererAnimateur() {
    	return this.gereranimateur;
    }
    
    public JMenuItem getAjouter() {
    	return this.ajouter;
    }
}