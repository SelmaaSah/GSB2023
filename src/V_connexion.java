import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.*;

public class V_connexion {
    private JPanel connexionPanel;
    private JLabel connexionJLabel;

    private JLabel identifiantLabel;
    private JTextField identifiantTextField;

    private JLabel mdpLabel;
    private JTextField mdpTextField;

    private JButton buttonConnexion;

    
    
    public V_connexion() {
        connexionPanel = new JPanel(new GridBagLayout()); // Utilisation de GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();


        
        identifiantLabel = new JLabel("Identifiant : ");
        identifiantTextField = new JTextField("");
        identifiantTextField.setPreferredSize(new Dimension(120, 20));

        buttonConnexion = new JButton("Se Connecter");

        mdpLabel = new JLabel("Mot de Passe :  ");
        mdpTextField = new JTextField("");
        mdpTextField.setPreferredSize(new Dimension(120, 20));


        
        // Configuration pour le JLabel et le JTextField de l'identifiant

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;

        gbc.insets = new Insets(0, 0, 10, 0); // Ajout d'un espace en HAUT ET EN bas
        connexionPanel.add(identifiantLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 10, 0); // Ajout d'un espace en bas
        connexionPanel.add(identifiantTextField, gbc);

        // Configuration pour le JLabel et le JTextField du mot de passe
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(10, 0, 10, 0); // Ajout d'un espace en haut
        connexionPanel.add(mdpLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(10, 0, 0, 0); // Ajout d'un espace en haut
        connexionPanel.add(mdpTextField, gbc);

        // Configuration pour le JLabel de la connexion et le bouton
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 0, 0, 0); // Ajout d'un espace en haut
        gbc.anchor = GridBagConstraints.CENTER;

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        connexionPanel.add(buttonConnexion, gbc);
    }

    public JPanel getConnexionPanel() {
        return this.connexionPanel;
    }

    public JButton getButtonConnexion() {
        return this.buttonConnexion;
    }

	public JTextField getIdentifiantTextField() {
		return identifiantTextField;
	}



	public JTextField getMdpTextField() {
		return mdpTextField;
	}


    
    
}
