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
	private V_ajouterUser v_ajouterUser;
	private V_afficherUser v_afficherUser;
	private V_supprimerUser v_supprimerUser;

	
//	On l'utilise pour nos case
	private String action_connexion = "CONNEXION";

	
//	Pour notre Menu 
	private String consulterStat = "ResponsableStat";
	private String creerCatalogue = "SecretaireCreerCatalogue";
	private String afficherCatalogue = "AfficherCatalogue";

	private String ajouterConferences = "AjouterConferences";
	private String afficherConference = "AfficherConferences";
	private String annulerConferences = "AnnulerConferences";
	
	private String inscrireUser = "InscrireUser";
	private String afficherUser = "AfficherLesUtilisateurs";
	private String supprimerUtilisateur = "SupprimerUser";


//	Pour notre Button
	private String action_valider = "AjouterUneConference";
	private String action_annulerConferences = "AnnulerUneConference";
	private String action_ajouterCatalogue = "AjouterUnCatalogue";
	private String action_inscrire = "InscrireUnUser";
	private String action_supprimer_utilisateur = "SupprimerUnUtilisateur";

	
	
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
		                
		                this.v_menuSecretaire.getAfficherCatalogue().setActionCommand(afficherCatalogue);
		                this.v_menuSecretaire.getAfficherCatalogue().addActionListener(this);

		                
		                this.v_menuSecretaire.getAjouter().setActionCommand(ajouterConferences);
		                this.v_menuSecretaire.getAjouter().addActionListener(this);
		                
		                this.v_menuSecretaire.getAfficher().setActionCommand(afficherConference);
		                this.v_menuSecretaire.getAfficher().addActionListener(this);
		                
		                this.v_menuSecretaire.getAnnuler().setActionCommand(annulerConferences);
		                this.v_menuSecretaire.getAnnuler().addActionListener(this);
		                
		                this.v_menuSecretaire.getAjouterUtilisateur().setActionCommand(inscrireUser);
		                this.v_menuSecretaire.getAjouterUtilisateur().addActionListener(this);
		                
		                this.v_menuSecretaire.getAfficherUtilisateur().setActionCommand(afficherUser);
		                this.v_menuSecretaire.getAfficherUtilisateur().addActionListener(this);
		                
		                this.v_menuSecretaire.getSupprimerUtilisateur().setActionCommand(supprimerUtilisateur);
		                this.v_menuSecretaire.getSupprimerUtilisateur().addActionListener(this);
		                
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
			this.v_creercatalogue = new V_creercatalogue(Modele.getLesAnimateur(),Modele.getLesSalles());

            this.v_principal.getSecondPanel().removeAll();
            this.v_principal.getSecondPanel().add(this.v_creercatalogue.getPanelCatalogue());
            this.v_creercatalogue.getBtnVld().setActionCommand(action_ajouterCatalogue);
            this.v_creercatalogue.getBtnVld().addActionListener(this);
       
			
            this.v_principal.getMainPanel().revalidate();
            this.v_principal.getMainPanel().repaint();		
			break;
			
		case "AjouterUnCatalogue":
			
			String dateC = this.v_creercatalogue.getDateF().getText();
			int horraire = Integer.parseInt(this.v_creercatalogue.getHorraire().getText());
			int duree = Integer.parseInt(this.v_creercatalogue.getDuree().getText());
			int salle = Integer.parseInt(((String) v_creercatalogue.getComboBoxLesSalles().getSelectedItem()).split(" - ")[0]);
			int animateur = Integer.parseInt(((String) v_creercatalogue.getComboBoxCatalogue().getSelectedItem()).split(" - ")[0]);
			
			Modele.insererNvPresentation(dateC, duree, salle, horraire, animateur);
			
            this.v_principal.getMainPanel().revalidate();
            this.v_principal.getMainPanel().repaint();	
			break;
				

			
		case "AfficherCatalogue":
			this.v_afficherCatalogue = new V_afficherCatalogue(Modele.getLesCatalogues());
			
            this.v_principal.getSecondPanel().removeAll();
            this.v_principal.getSecondPanel().add(this.v_afficherCatalogue.getPanelconference());
            
            this.v_principal.getMainPanel().revalidate();
            this.v_principal.getMainPanel().repaint();		
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
	        
	        
	    	break;
	        
			
		case "InscrireUser":
			this.v_ajouterUser = new V_ajouterUser();
			

	        this.v_principal.getSecondPanel().removeAll();
	        this.v_principal.getSecondPanel().add(this.v_ajouterUser.getAjoutUserPanel());
	        
	        this.v_ajouterUser.getAddUserBtn().setActionCommand(action_inscrire);
	        this.v_ajouterUser.getAddUserBtn().addActionListener(this);
	        
	       			
	        this.v_principal.getMainPanel().revalidate();
	        this.v_principal.getMainPanel().repaint();		
	        
			break;
			
		case "InscrireUnUser":
			String nom, prenom, login, mdpUtilisateur, typeUtilisateur;
				
			nom = this.v_ajouterUser.getNomtf().getText();
			prenom = this.v_ajouterUser.getPrenomtf().getText();
			login = this.v_ajouterUser.getLogintf().getText();
			mdpUtilisateur = this.v_ajouterUser.getMdptf().getText();
			typeUtilisateur = (String) this.v_ajouterUser.getVotreComboBox().getSelectedItem();
			
			Modele.insertNvUtilisateur(nom, prenom, login, mdpUtilisateur, typeUtilisateur);
			
			this.v_afficherUser = new V_afficherUser(Modele.getLesUsers());
			
			this.v_principal.getSecondPanel().removeAll();
			this.v_principal.getSecondPanel().add(this.v_afficherUser.getAfficherUserPanel());
		
			this.v_principal.getMainPanel().revalidate();
	        this.v_principal.getMainPanel().repaint();		
			
			
			break;
			
		case "AfficherLesUtilisateurs":
		
			this.v_afficherUser = new V_afficherUser(Modele.getLesUsers());
			
			this.v_principal.getSecondPanel().removeAll();
			this.v_principal.getSecondPanel().add(this.v_afficherUser.getAfficherUserPanel());
		
			this.v_principal.getMainPanel().revalidate();
	        this.v_principal.getMainPanel().repaint();		
			
			break;
			
		case "SupprimerUser":
			
			this.v_supprimerUser = new V_supprimerUser();
			this.v_afficherUser = new V_afficherUser(Modele.getLesUsers());
			
			this.v_principal.getSecondPanel().removeAll();
			this.v_principal.getSecondPanel().add(this.v_supprimerUser.getSupprimerUserPanel());
			this.v_principal.getSecondPanel().add(this.v_afficherUser.getAfficherUserPanel());
			
			this.v_supprimerUser.getSupprimerButton().setActionCommand(action_supprimer_utilisateur);
			this.v_supprimerUser.getSupprimerButton().addActionListener(this);
			
			
			this.v_principal.getMainPanel().revalidate();
	        this.v_principal.getMainPanel().repaint();		
			break;
			
		case "SupprimerUnUtilisateur":
			
			String idUser = this.v_supprimerUser.getSupprimerTextField().getText();
			int idUsers = Integer.parseInt(idUser);
			
			Modele.getSupprimerUnUtilisateur(idUsers);
			
			break;

			
		}
	}
}