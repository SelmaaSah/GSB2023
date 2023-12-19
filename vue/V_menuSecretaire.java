import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class V_menuSecretaire extends JMenuBar {
	
    private JMenu catalogue;
    private JMenuItem creercatalogue;
    private JMenuItem ajtcatalogue;

    

    
    private JMenu gerer2;
    private JMenuItem annuler;
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
        ajtcatalogue = new JMenuItem("Afficher un catalogue");

        

        
        gerer2 = new JMenu("Conferences");
        ajouter = new JMenuItem("Ajouter une conference");
        afficher = new JMenuItem("Afficher les conferences");
        annuler = new JMenuItem("Annuler une conference");
        
        gererInterventant = new JMenu("Intervenant");
        ajouterInterventant = new JMenuItem("Inscrire un utilisateur");
        afficherInterventant = new JMenuItem("Afficher un utilisateur");
        supprimerInterventant = new JMenuItem("Supprimer un utilisateur");
        

        // Ajout des menus à la barre de menus
        add(catalogue);
        add(gerer2);
        add(gererInterventant);

        // Ajout des sous-menus aux menus
        catalogue.add(creercatalogue);
        catalogue.add(ajtcatalogue);

        

        
        gerer2.add(ajouter);
        gerer2.add(afficher);
        gerer2.add(annuler);
        
        gererInterventant.add(ajouterInterventant);
        gererInterventant.add(afficherInterventant);
        gererInterventant.add(supprimerInterventant);
        
    }

    public JMenuBar getMenuSecretaire() {
        return this;  
    }
    
    public JMenuItem getCreerCatalogue() {
    	return this.creercatalogue;
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
    
}