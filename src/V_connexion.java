import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import javax.swing.*;

public class V_connexion extends JFrame{
    private JPanel connexionPanel;
    private JLabel connexionJLabel;

    private JLabel identifiantLabel;
    private JTextField identifiantTextField;

    private JLabel mdpLabel;
    private JTextField mdpTextField;
    
    private JLabel bienvenueLabel;
    private JLabel imageLabel;


    private JButton buttonConnexion;

    
    
    public V_connexion() {
    	connexionPanel = new RoundedPanel(20); // Ajustez le rayon des coins ici
        connexionPanel.setLayout(new GridBagLayout()); // Utilisation de GridBagLayout
        
        connexionPanel.setBackground(Color.white);

        
        // Chargement de l'image depuis le fichier
        ImageIcon logoGSB = new ImageIcon("image2/logogsb.png"); 

        // Redimensionner l'image
        Image image = logoGSB.getImage();
        Image newImage = image.getScaledInstance(150, 100, Image.SCALE_SMOOTH); 

        ImageIcon resizedIcon = new ImageIcon(newImage);
        imageLabel = new JLabel(resizedIcon);


        identifiantLabel = new JLabel("Identifiant : ");
        identifiantTextField = new JTextField("selma");
        identifiantTextField.setPreferredSize(new Dimension(120, 20));

        buttonConnexion = new JButton("Se Connecter");
        
        bienvenueLabel = new JLabel("Bienvenue, GSB est ravi de vous revoir !");
        mdpLabel = new JLabel("Mot de Passe :  ");
        mdpTextField = new JTextField("123");
        mdpTextField.setPreferredSize(new Dimension(120, 20));


		Font police = new Font("Courier New", Font.BOLD, 13);
		bienvenueLabel.setFont(police);
		identifiantLabel.setFont(police);
		mdpLabel.setFont(police);
		buttonConnexion.setFont(police);
		

		
		
        // Chargement de l'image depuis le fichier
//        ImageIcon logoSIO = new ImageIcon("image/img-sioplus.png"); 
//
//        // Redimensionner l'image
//        Image image = logoSIO.getImage();
//        Image newImage = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH); 
//
//        ImageIcon resizedIcon = new ImageIcon(newImage);
//        imageLabel = new JLabel(resizedIcon);
//        mainPanel.add(imageLabel); // Ajout du JLabel avec l'image en dessous du bouton
        
        // Configuration pour le JLabel et le JTextField de l'identifiant

        
	     // Pour bienvenueLabel
        GridBagConstraints gbclogo = new GridBagConstraints();
        gbclogo.gridx = 0;
        gbclogo.gridy = 0;
        gbclogo.anchor = GridBagConstraints.CENTER;
        gbclogo.gridwidth = 2;
        gbclogo.insets = new Insets(0, 0, 0, 0); // Ajout d'un espace en HAUT ET EN bas
        connexionPanel.add(imageLabel, gbclogo);

		
		
		
		
     // Pour bienvenueLabel
        GridBagConstraints gbcBienvenue = new GridBagConstraints();
        gbcBienvenue.gridx = 0;
        gbcBienvenue.gridy = 1;
        gbcBienvenue.anchor = GridBagConstraints.WEST;
        gbcBienvenue.gridwidth = 2;
        gbcBienvenue.insets = new Insets(0, 0, 120, 0); // Ajout d'un espace en HAUT ET EN bas

        connexionPanel.add(bienvenueLabel, gbcBienvenue);

        // Pour identifiantLabel
        GridBagConstraints gbcIdentifiantLabel = new GridBagConstraints();
        gbcIdentifiantLabel.gridx = 0;
        gbcIdentifiantLabel.gridy = 1;
        gbcIdentifiantLabel.insets = new Insets(10, 0, 10, 0); // Ajout d'un espace en HAUT ET EN bas
        connexionPanel.add(identifiantLabel, gbcIdentifiantLabel);

        // Pour identifiantTextField
        GridBagConstraints gbcIdentifiantTextField = new GridBagConstraints();
        gbcIdentifiantTextField.gridx = 1;
        gbcIdentifiantTextField.gridy = 1;
        gbcIdentifiantTextField.insets = new Insets(10, 0, 10, 0); // Ajout d'un espace en bas
        connexionPanel.add(identifiantTextField, gbcIdentifiantTextField);


        GridBagConstraints gbcMdpLabel = new GridBagConstraints();
        gbcMdpLabel.gridx = 0;
        gbcMdpLabel.gridy = 2;
        gbcMdpLabel.insets = new Insets(10, 0, 10, 0); // Ajout d'un espace en HAUT ET EN bas
        connexionPanel.add(mdpLabel, gbcMdpLabel);
        
        
        GridBagConstraints gbcMdpTextField = new GridBagConstraints();
        gbcMdpTextField.gridx = 1;
        gbcMdpTextField.gridy = 2;
        gbcMdpTextField.insets = new Insets(10, 0, 10, 0); // Ajout d'un espace en HAUT ET EN bas
        connexionPanel.add(mdpTextField, gbcMdpTextField);
        
//        // Configuration pour le JLabel de la connexion et le bouton
        GridBagConstraints gbc = new GridBagConstraints();

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
