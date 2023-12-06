import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controleur implements  ActionListener{

//	Les Attributs 
	private V_principale v_principal;
	private V_connexion v_connexion;
	private V_accueil v_accueil;
	private Utilisateur utilisateur;
	private V_erreurConnexion v_erreurConnexion;
	
	
//	Création d'un attribut static 
	private static final String Action_connexion = "CONNEXION";
	
	public Controleur() {
		
		this.v_principal = new V_principale();
		this.v_connexion = new V_connexion();
		
		// Définir la commande d'action pour le bouton
        v_connexion.getButtonConnexion().setActionCommand(Action_connexion);
        v_connexion.getButtonConnexion().addActionListener(this);

		
		this.v_principal.getMainPanel().add(this.v_connexion.getConnexionPanel());
	}

	@Override
	public void actionPerformed(ActionEvent action) {
		
		String actionCommand = action.getActionCommand();
		
		switch (actionCommand) {
		
//		Notre Vue de connexion
        case Action_connexion:
        	
        	String identifiant = this.v_connexion.getIdentifiantTextField().getText();
        	String mdp = this.v_connexion.getMdpTextField().getText();
        	
        	
        	if(Modele.existeUser(identifiant, mdp) != null) {
        		this.utilisateur = Modele.existeUser(identifiant, mdp);
        		this.v_accueil = new V_accueil(this.utilisateur.getNom());

        		if ("Responsable".equals(this.utilisateur.getTypeVisiteur())) {
        		    System.out.println("Resp");
        		} else if ("Secretaire".equals(this.utilisateur.getTypeVisiteur())) {
        		    System.out.println("Sec");
        		}
        		
            	this.v_principal.getMainPanel().removeAll();
        		this.v_principal.getMainPanel().add(this.v_accueil.getAccueilPanel());
        		
        	}
        	else {
        		
        		this.v_erreurConnexion = new V_erreurConnexion();
        		
        		this.v_principal.getMainPanel().removeAll();
        		
        		this.v_principal.getMainPanel().add(this.v_connexion.getConnexionPanel());
        		this.v_principal.getMainPanel().add(this.v_erreurConnexion.getErreurConnexionPanel());
        		
        	}
        	
    		this.v_principal.getMainPanel().revalidate();
    		this.v_principal.getMainPanel().repaint();
            break;
		}
		
	}
}
