
import javax.swing.*;

public class V_connexion {
	private JPanel connexionPanel;
	private JLabel connexionJLabel;
	
	private JButton buttonConnexion;
	
	public V_connexion(){
		
		connexionPanel = new JPanel();
		connexionJLabel = new JLabel("Coonexion");
		buttonConnexion = new JButton("Se Connecter");
		
		
		connexionPanel.add(connexionJLabel);
		connexionPanel.add(buttonConnexion);
	}
	
	public JPanel getConnexionPanel() {
		return this.connexionPanel;
	}
	
	public JButton getButtonConnexion() {
		return this.buttonConnexion;
	}
}
