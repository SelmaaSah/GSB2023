import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
	private V_ajouterConferences v_ajouterConferences;
	private V_afficherConference v_afficherConference;
	private V_annulerConference v_annulerConference;
	private V_afficherCatalogue v_afficherCatalogue;

	

	
	
//	On l'utilise pour nos case
	private String action_connexion = "CONNEXION";

	
//	Pour notre Menu 
	private String consulterStat = "ResponsableStat";
	private String creerCatalogue = "SecretaireCreerCatalogue";
	private String gererConferences = "SecretaireGererConference";
	private String gererIntervenant = "SecretaireGererIntervenant";
	private String gererAnimateur = "SecretaireGererAnimateur";
	private String ajouterConferences = "AjouterConferences";
	private String afficherConference = "AfficherConferences";
	private String annulerConferences = "AnnulerConferences";
	private String afficherCatalogue = "AfficherCatalogue";

	
	
//	Pour notre Button
	private String action_valider = "AjouterUneConference";
	private String action_annulerConferences = "AnnulerUneConference";
	
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
		    this.v_principal.getMainPanel().setLayout(new BorderLayout());
		    if (Modele.existeUser(identifiant, mdp) != null) {
//		    	On ajoute la fonction dans un attributs pour ensuite recupere le nom, typeVisiteur etc..action 
		        this.utilisateur = Modele.existeUser(identifiant, mdp);
		        this.v_accueil = new V_accueil(this.utilisateur.getNom());

//		        	Si le Visiteur est un resposable 
		            if ("Responsable".equals(this.utilisateur.getTypeVisiteur())) {
		            	
		            	this.v_menuResp = new V_menuResp();

		            	// Ajout du menu au nord de v_principal.getMainPanel() avec BorderLayout
		            	this.v_principal.getMainPanel().removeAll();
		            	
		            	this.v_principal.getMainPanel().add(this.v_menuResp.getMenu(), BorderLayout.NORTH);
		            	this.v_principal.getMainPanel().add(this.v_principal.getSecondPanel(),BorderLayout.CENTER);
		            	this.v_principal.getSecondPanel().add(this.v_accueil.getAccueilPanel());

		            	this.v_menuResp.getConsulterStats().setActionCommand(consulterStat);
		            	this.v_menuResp.getConsulterStats().addActionListener(this);

		            	// Ajout de la vue d'accueil au centre de v_principal.getMainPanel() avec GridBagLayout
//		            	this.v_principal.getMainPanel().add(this.v_accueil.getAccueilPanel(), BorderLayout.SOUTH);

		            	// Forcez la mise en page
		            	this.v_principal.getMainPanel().revalidate();
		            	this.v_principal.getMainPanel().repaint();

		                
		            } 
		            else if ("Secretaire".equals(this.utilisateur.getTypeVisiteur())) {
		            	
		            	this.v_menuSecretaire = new  V_menuSecretaire();
		                
		                
		                // Ajoutez le menu à v_principal.getMainPanel()
		                this.v_principal.getMainPanel().removeAll();

		                this.v_principal.getMainPanel().add(this.v_menuSecretaire.getMenuSecretaire(), BorderLayout.NORTH);
		                this.v_principal.getMainPanel().add(this.v_principal.getSecondPanel(),BorderLayout.CENTER);
		                this.v_principal.getSecondPanel().add(this.v_accueil.getAccueilPanel());
		                
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
		                
		                this.v_menuSecretaire.getAfficher().setActionCommand(afficherConference);
		                this.v_menuSecretaire.getAfficher().addActionListener(this);
		                
		                this.v_menuSecretaire.getAnnuler().setActionCommand(annulerConferences);
		                this.v_menuSecretaire.getAnnuler().addActionListener(this);
		                	                		                
		                
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
			this.v_creercatalogue = new V_creercatalogue();
			//this.v_afficherCatalogue = new V_afficherCatalogue();

			
			String dateP = this.v_creercatalogue.getDate().getText();
            int dureePrevue = Integer.parseInt( this.v_creercatalogue.getDuree().getText());
            int sallenum = Integer.parseInt( this.v_creercatalogue.getSalle().getText());
            int heure = Integer.parseInt( this.v_creercatalogue.getHorraire().getText());
            int animateurid = Integer.parseInt( this.v_creercatalogue.getAnimateur().getText());
            

            Modele.insertnvCatalogue(dateP, dureePrevue, sallenum, heure, animateurid);

			
            this.v_principal.getSecondPanel().removeAll();
            this.v_principal.getSecondPanel().add(this.v_creercatalogue.getPanelCatalogue());
            
            this.v_principal.getSecondPanel().removeAll();
            
            //this.v_afficherCatalogue = new V_afficherCatalogue(Modele.getLesConferences());
			
            this.v_principal.getSecondPanel().removeAll();
            this.v_principal.getSecondPanel().add(this.v_afficherCatalogue.getPanelconference());
            
            
			
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
			
			this.v_ajouterConferences = new V_ajouterConferences(Modele.getLesAnimateur());
			

            this.v_principal.getSecondPanel().removeAll();
            this.v_principal.getSecondPanel().add(this.v_ajouterConferences.getAjouterConferencePanel());
            
            this.v_ajouterConferences.getButtonVld().setActionCommand(action_valider);
            this.v_ajouterConferences.getButtonVld().addActionListener(this);
			
            this.v_principal.getMainPanel().revalidate();
            this.v_principal.getMainPanel().repaint();		
			break;
			
		case "AjouterUneConference":
			
                int idAnimateur = Integer.parseInt(((String) v_ajouterConferences.getComboBox().getSelectedItem()).split(" - ")[0]);
                
                String theme = this.v_ajouterConferences.getThemeTextField().getText();
                String dateDeroulement = this.v_ajouterConferences.getDateDeroulementTextField().getText();
                
                
                Modele.insererNvConference(theme, dateDeroulement, idAnimateur);
                
                this.v_principal.getSecondPanel().removeAll();
                
                this.v_afficherConference = new V_afficherConference(Modele.getLesConferences());
    			
                this.v_principal.getSecondPanel().removeAll();
                this.v_principal.getSecondPanel().add(this.v_afficherConference.getPanelconference());
                
    			
                this.v_principal.getMainPanel().revalidate();
                this.v_principal.getMainPanel().repaint();		
            break;
			
		case "AfficherConferences":
			this.v_afficherConference = new V_afficherConference(Modele.getLesConferences());
			
            this.v_principal.getSecondPanel().removeAll();
            this.v_principal.getSecondPanel().add(this.v_afficherConference.getPanelconference());
            
            this.v_principal.getMainPanel().revalidate();
            this.v_principal.getMainPanel().repaint();		
			break;
			
		case "AnnulerConferences":
			this.v_afficherConference = new V_afficherConference(Modele.getLesConferences());
			this.v_annulerConference = new V_annulerConference();
		
			this.v_principal.getSecondPanel().removeAll();
			this.v_principal.getSecondPanel().add(this.v_annulerConference.getAnnulerConferencePanel());
			this.v_principal.getSecondPanel().add(this.v_afficherConference.getPanelconference());
			
			this.v_annulerConference.getAnnulerButton().setActionCommand(action_annulerConferences);
			this.v_annulerConference.getAnnulerButton().addActionListener(this);
			
			this.v_principal.getMainPanel().revalidate();
	        this.v_principal.getMainPanel().repaint();	
	        
			break;
			
		case "AnnulerUneConference":
			this.v_afficherConference = new V_afficherConference(Modele.getLesConferences());
			
			String idString = this.v_annulerConference.getAnnulerTextField().getText();
			int id = Integer.parseInt(idString);
			Modele.getSupprimerUneConference(id);
				        
			this.v_principal.getSecondPanel().removeAll();
			this.v_principal.getSecondPanel().add(this.v_afficherConference.getPanelconference());
			
			this.v_principal.getMainPanel().revalidate();
	        this.v_principal.getMainPanel().repaint();	
	        
		}
		
		
	}
}