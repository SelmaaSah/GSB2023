import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controleur implements  ActionListener{

//	Les Attributs 
	private V_principale v_principal;
	private V_connexion v_connexion;
	private V_accueil v_accueil;
	
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
		
        case Action_connexion:
        	this.v_accueil = new V_accueil();
        	this.v_principal.getMainPanel().removeAll();
    		this.v_principal.getMainPanel().add(this.v_accueil.getAccueilPanel());
    		this.v_principal.getMainPanel().revalidate();
    		this.v_principal.getMainPanel().repaint();
            break;
		}
		
	}
}
