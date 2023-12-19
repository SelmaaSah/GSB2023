import java.awt.*;
import javax.swing.*;

public class V_annulerConference extends JFrame{

	private JPanel annulerConferencePanel;
	
	private JLabel titreLabel;
	private JLabel annulerLabel;
	
	private JTextField annulerTextField;
	
	private JButton annulerButton;
	
	public V_annulerConference() {
		
		annulerConferencePanel = new JPanel();
		
		titreLabel = new JLabel("Annuler une Conference");
		annulerLabel = new JLabel("Choissisez l'id pour annuler la conference :");
		annulerTextField = new JTextField();
		annulerTextField.setPreferredSize(new Dimension(120, 20));
		
		annulerButton = new JButton("Annuler cette Conférence");
		
		annulerConferencePanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 10, 10); // Ajout d'un espace en haut
		 
		annulerConferencePanel.add(titreLabel, gbc);
		gbc.gridy++;
		annulerConferencePanel.add(annulerLabel, gbc);
		gbc.gridy++;
		annulerConferencePanel.add(annulerTextField, gbc);
		gbc.gridy++;
		annulerConferencePanel.add(annulerButton, gbc);
	}
	
	public JPanel getAnnulerConferencePanel() {
		return this.annulerConferencePanel;
	}
	
	public JButton getAnnulerButton() {
		return this.annulerButton;
	}
	
	public JTextField getAnnulerTextField() {
		return this.annulerTextField;
	}
	
}
