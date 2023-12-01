

import javax.swing.JLabel;
import javax.swing.JPanel;

public class V_accueil {
	private JPanel accueilPanel;
	private JLabel accueilLabel;
	
	public V_accueil() {
		accueilPanel = new JPanel();
		accueilLabel = new JLabel("Acccueil");
		
		accueilPanel.add(accueilLabel);
	}
	
	public JPanel getAccueilPanel() {
		return this.accueilPanel;
	}
}
