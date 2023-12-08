import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controleur implements  ActionListener{

//	Les Attributs 
	private V_principale v_principal;
	private V_connexion v_connexion;

	private V_accueil v_accueil;
	private Utilisateur utilisateur;
	private V_erreurConnexion v_erreurConnexion;
	private V_menuResp v_menuResp;
	private V_menuSecretaire v_menuSecretaire;
	private V_creercatalogue v_creercatalogue;
	
	
//	On l'utilise pour nos case
	private String action_connexion = "CONNEXION";
	private String consulterStat = "ResponsableStat";
	
	private String creerCatalogue = "SecretaireCreerCatalogue";
	private String gererConferences = "SecretaireGererConference";
	private String gererIntervenant = "SecretaireGererIntervenant";
	private String gererAnimateur = "SecretaireGererAnimateur";
	private String ajouterConferences = "AjouterConferences";
	private String afficherConferences = "AfficherConferences";
	private String annulerConferences = "AnnulerConferences";
	private String modifierConferences = "ModifierConferences";
	
	public Controleur() {
		
		this.v_principal = new V_principale();
		this.v_connexion = new V_connexion();
		
		
		// D�finir la commande d'action pour le bouton
        v_connexion.getButtonConnexion().setActionCommand(action_connexion);
        v_connexion.getButtonConnexion().addActionListener(this);

		
		this.v_principal.getMainPanel().add(this.v_connexion.getConnexionPanel());
		
		this.v_principal.getMainPanel().revalidate();
		this.v_principal.getMainPanel().repaint();
	}

	@Override
	public void actionPerformed(ActionEvent action) {
		
		String actionCommand = action.getActionCommand();
		
		switch (actionCommand) {
		
//		Notre Vue de connexion
		case "CONNEXION" :
		    String identifiant = this.v_connexion.getIdentifiantTextField().getText();
		    String mdp = this.v_connexion.getMdpTextField().getText();

		    if (Modele.existeUser(identifiant, mdp) != null) {
//		    	On ajoute la fonction dans un attributs pour ensuite recupere le nom, typeVisiteur etc..action 
		        this.utilisateur = Modele.existeUser(identifiant, mdp);
		        this.v_accueil = new V_accueil(this.utilisateur.getNom());

//		        	Si le Visiteur est un resposable 
		            if ("Responsable".equals(this.utilisateur.getTypeVisiteur())) {
		            	
		                this.v_menuResp = new V_menuResp();

		                // Ajoutez le menu à v_principal.getMainPanel()
		                this.v_principal.getMainPanel().removeAll();
		                
		                this.v_principal.getMainPanel().add(this.v_menuResp.getMenu());
		                
		                this.v_menuResp.getConsulterStats().setActionCommand(consulterStat);
		                this.v_menuResp.getConsulterStats().addActionListener(this);
		                
		                this.v_principal.getMainPanel().add(this.v_accueil.getAccueilPanel());
		                
		                this.v_principal.getMainPanel().revalidate();
		                this.v_principal.getMainPanel().repaint();
		                
		            } 
		            else if ("Secretaire".equals(this.utilisateur.getTypeVisiteur())) {
		            	
		            	this.v_menuSecretaire = new  V_menuSecretaire();
		                
		                
		                // Ajoutez le menu à v_principal.getMainPanel()
		                this.v_principal.getMainPanel().removeAll();

		                this.v_principal.getMainPanel().add(this.v_menuSecretaire.getMenuSecretaire());
		                
//		                Lire notre ActionListenner
		                this.v_menuSecretaire.getCreerCatalogue().setActionCommand(creerCatalogue);
		                this.v_menuSecretaire.getCreerCatalogue().addActionListener(this);
		                
		                this.v_menuSecretaire.getGererConferences().setActionCommand(gererConferences);
		                this.v_menuSecretaire.getGererConferences().addActionListener(this);
		                
		                this.v_menuSecretaire.getGererintervenant().setActionCommand(gererIntervenant);
		                this.v_menuSecretaire.getGererintervenant().addActionListener(this);
		                
		                this.v_menuSecretaire.getGererAnimateur().setActionCommand(gererAnimateur);
		                this.v_menuSecretaire.getGererAnimateur().addActionListener(this);
		                
		                this.v_menuSecretaire.getAjouter().setActionCommand(ajouterConferences);
		                this.v_menuSecretaire.getAjouter().addActionListener(this);
		                
		                this.v_menuSecretaire.getAfficher().setActionCommand(afficherConferences);
		                this.v_menuSecretaire.getAfficher().addActionListener(this);
		                
		                this.v_menuSecretaire.getAnnuler().setActionCommand(annulerConferences);
		                this.v_menuSecretaire.getAnnuler().addActionListener(this);
		                
		                this.v_menuSecretaire.getModifier().setActionCommand(modifierConferences);
		                this.v_menuSecretaire.getModifier().addActionListener(this);
		                
		                
		                this.v_principal.getMainPanel().add(this.v_accueil.getAccueilPanel());
		                
		                this.v_principal.getMainPanel().revalidate();
		                this.v_principal.getMainPanel().repaint();
		            }
		        
		    } else {
		        this.v_erreurConnexion = new V_erreurConnexion();

		        // Vérifiez si v_principal et MainPanel sont correctement initialisés
		        if (this.v_principal != null && this.v_principal.getMainPanel() != null) {
		            this.v_principal.getMainPanel().removeAll();
		            
		            this.v_principal.getMainPanel().add(this.v_connexion.getConnexionPanel());
		            this.v_principal.getMainPanel().add(this.v_erreurConnexion.getErreurConnexionPanel());
		            
		            this.v_principal.getMainPanel().revalidate();
		            this.v_principal.getMainPanel().repaint();
		        }
		    }
		    
		    break;
		
		case "ResponsableStat":
			System.out.println("Consulter les Stat");
			break;
			
		case "SecretaireCreerCatalogue":
			System.out.println("Creer un catalogue");
			this.v_creercatalogue = new V_creercatalogue();
            this.v_principal.getMainPanel().add(this.v_creercatalogue.getPanelCatalogue());
            this.v_principal.getMainPanel().revalidate();
            this.v_principal.getMainPanel().repaint();		
			break;
		
		case "SecretaireGererConference":
			System.out.println("Gerer La congérences");
			break;
			
		case "SecretaireGererIntervenant":
			System.out.println("Gerer les interventant");
			break;
			
		case "SecretaireGererAnimateur":
			System.out.println("Gerer les Animateur");
			break;
		
		case "AjouterConferences":
			System.out.println("Ajouter une Conferences");
			break;
			
		case "AfficherConferences":
			System.out.println("Afficher les Conferences");
			break;
			
		case "AnnulerConferences":
			System.out.println("Annuler une Conferences");
			break;
			
		case "ModifierConferences":
			System.out.println("Modifier une Conferences");
			break;
			
		}
		
	}
}