import java.awt.*;

import javax.swing.*;

public class V_supprimerUser extends JFrame{

	private JPanel supprimerUserPanel;
	private JLabel titreLabel;
	private JLabel supprimerLabel;
	
	private JTextField  supprimerTextField;
	
	private JButton  supprimerButton;

	public V_supprimerUser() {
		supprimerUserPanel = new RoundedPanel(20);
		supprimerUserPanel.setBackground(Color.white);
		
		titreLabel = new JLabel("SUPPRIMER UN UTILISATEUR");
		titreLabel.setForeground(new Color(128,162,205));
		
		supprimerLabel = new JLabel("Choissisez l'ID pour suppriemr l'utilisateur :");
		supprimerLabel.setForeground(new Color(128,162,205));
		
		supprimerTextField = new JTextField();
		supprimerTextField.setPreferredSize(new Dimension(120, 20));
		
		supprimerButton = new JButton("Supprimer L'utilisateur");
		
		supprimerUserPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 10, 10); // Ajout d'un espace en haut
        
        supprimerUserPanel.add(titreLabel, gbc);
		gbc.gridy++;
		supprimerUserPanel.add(supprimerLabel, gbc);
		gbc.gridy++;
		supprimerUserPanel.add(supprimerTextField, gbc);
		gbc.gridy++;
		supprimerUserPanel.add(supprimerButton, gbc);
	}
	
	public JPanel getSupprimerUserPanel() {
		return supprimerUserPanel;
	}
	
	public JTextField getSupprimerTextField() {
		return supprimerTextField;
	}

	public JButton getSupprimerButton() {
		return supprimerButton;
	}

}
