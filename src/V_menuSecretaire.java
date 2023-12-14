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
    
    private JMenu gererInterventant;
    private JMenuItem ajouterInterventant;
    private JMenuItem modifierInterventant;
    private JMenuItem afficherInterventant;
    private JMenuItem supprimerInterventant;  


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
        afficher = new JMenuItem("Afficher les conferences");
        annuler = new JMenuItem("Annuler une conference");
        modifier = new JMenuItem("Modifier une conference");
        
        gererInterventant = new JMenu("Intervenant");
        ajouterInterventant = new JMenuItem("Ajouter un Interventant");
        modifierInterventant = new JMenuItem("Modifier un Interventant");
        afficherInterventant = new JMenuItem("Afficher un Interventant");
        supprimerInterventant = new JMenuItem("Supprimer un Interventant");
        

        // Ajout des menus à la barre de menus
        add(catalogue);
        add(gerer);
        add(gerer2);
        add(gererInterventant);

        // Ajout des sous-menus aux menus
        catalogue.add(creercatalogue);
        
        gerer.add(gererconferences);
        gerer.add(gererintervenant);
        gerer.add(gereranimateur);
        
        gerer2.add(ajouter);
        gerer2.add(afficher);
        gerer2.add(modifier);
        gerer2.add(annuler);
        
        gererInterventant.add(ajouterInterventant);
        gererInterventant.add(modifierInterventant);
        gererInterventant.add(afficherInterventant);
        gererInterventant.add(supprimerInterventant);
        
    }

    public JMenuBar getMenuSecretaire() {
        return this;  
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
    
    public JMenuItem getAfficher() {
    	return this.afficher;
    }
    
    public JMenuItem getAnnuler() {
    	return this.annuler;
    }
    
    public JMenuItem getModifier() {
    	return this.modifier;
    }
}