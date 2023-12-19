import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class V_menuSecretaire extends JMenuBar {
	
    private JMenu catalogue;
    private JMenuItem creercatalogue;
    private JMenuItem afficherCatalogue;

    
    private JMenu gerer2;
    private JMenuItem annuler;
    private JMenuItem ajouter;
    private JMenuItem afficher;
    
    private JMenu gererInterventant;
    private JMenuItem ajouterUtilisateur;
    private JMenuItem afficherUtilisateur;
    private JMenuItem supprimerUtilisateur;  
    private JMenuItem deconnexion; 


    public V_menuSecretaire() {
        // Instanciation des menus et sous-menus
        catalogue = new JMenu("Catalogue");
        creercatalogue = new JMenuItem("Créer un catalogue");
        afficherCatalogue = new JMenuItem("Afficher un catalogue");

        

        
        gerer2 = new JMenu("Conferences");
        ajouter = new JMenuItem("Ajouter une conference");
        afficher = new JMenuItem("Afficher les conferences");
        annuler = new JMenuItem("Annuler une conference");
        
        gererInterventant = new JMenu("Utilisateur");
        ajouterUtilisateur = new JMenuItem("Inscrire un utilisateur");
        afficherUtilisateur = new JMenuItem("Afficher un utilisateur");
        supprimerUtilisateur = new JMenuItem("Supprimer un utilisateur");
        
        deconnexion = new JMenuItem("Deconnexion");
        

        // Ajout des menus à la barre de menus
        add(catalogue);
        add(gerer2);
        add(gererInterventant);
        add(deconnexion);

        // Ajout des sous-menus aux menus
        catalogue.add(creercatalogue);
        catalogue.add(afficherCatalogue);

        
        gerer2.add(ajouter);
        gerer2.add(afficher);
        gerer2.add(annuler);
        
        gererInterventant.add(ajouterUtilisateur);
        gererInterventant.add(afficherUtilisateur);
        gererInterventant.add(supprimerUtilisateur);
        
    }

    public JMenuBar getMenuSecretaire() {
        return this;  
    }
    
    public JMenuItem getMenuDeconnexion() {
    	return this.deconnexion;
    }
    
    public JMenuItem getAfficherCatalogue() {
    	return this.afficherCatalogue;
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
    
    public JMenuItem getAfficherUtilisateur() {
    	return this.afficherUtilisateur;
    }
    
    public JMenuItem getAjouterUtilisateur() {
    	return this.ajouterUtilisateur;
    }
    
    public JMenuItem getSupprimerUtilisateur() {
    	return this.supprimerUtilisateur;
    }
}