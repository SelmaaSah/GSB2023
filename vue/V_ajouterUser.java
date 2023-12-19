import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

public class V_ajouterUser {
    private JPanel ajoutUserPanel;
    private JLabel ajoutUserlbl;
    
    private JLabel nomlbl;
    private JTextField nomtf;

    private JLabel prenomlbl;
    private JTextField prenomtf;

    private JLabel loginlbl;
    private JTextField logintf;

    private JLabel mdplbl;
    private JTextField mdptf;
    
    private JComboBox<String> votreComboBox;
    private JButton addUserBtn;

    public V_ajouterUser() {
    	
    	ajoutUserPanel = new JPanel();
    	ajoutUserPanel.setPreferredSize(new Dimension(500, 500));
    	
        ajoutUserlbl = new JLabel("Ajouter un utilisateur");

    	nomlbl = new JLabel("Nom : ");
    	nomtf = new JTextField();
    	nomtf.setPreferredSize(new Dimension(150, 20));

    	prenomlbl = new JLabel("Prenom :");
    	prenomtf = new JTextField();
    	prenomtf.setPreferredSize(new Dimension(150, 20));

    	loginlbl = new JLabel("Identifiant :");
    	logintf = new JTextField();
    	logintf.setPreferredSize(new Dimension(150, 20));
    	
    	mdplbl = new JLabel("Mdp :");
    	mdptf = new JTextField("123");
    	mdptf.setPreferredSize(new Dimension(150, 20)); 
    	
    	addUserBtn = new JButton("Valider");

    	
    	
        votreComboBox = new JComboBox<>(); // Vous pouvez ajouter des éléments à votre JComboBox ici

        
        votreComboBox.addItem("Animateur");
        votreComboBox.addItem("Intervenant");

        ajoutUserPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 0, 0, 0);
        ajoutUserPanel.add(ajoutUserlbl, gbc);
        
        
        gbc.gridy++;
        ajoutUserPanel.add(nomlbl, gbc);
        gbc.gridy++;
        ajoutUserPanel.add(nomtf, gbc);
        
        
        gbc.gridy++;
        ajoutUserPanel.add(prenomlbl, gbc);
        gbc.gridy++;
        ajoutUserPanel.add(prenomtf, gbc);
        
        
        gbc.gridy++;    
        ajoutUserPanel.add(loginlbl, gbc);  
        gbc.gridy++;
        ajoutUserPanel.add(logintf, gbc);
        
        gbc.gridy++;    
        ajoutUserPanel.add(mdplbl, gbc);  
        gbc.gridy++;
        ajoutUserPanel.add(mdptf, gbc);
        
        gbc.gridy++;    
        ajoutUserPanel.add(votreComboBox, gbc);  

        
        gbc.gridy++;    
        ajoutUserPanel.add(addUserBtn, gbc);  
    }

	public JPanel getAjoutUserPanel() {
		return ajoutUserPanel;
	}

	public JTextField getNomtf() {
		return nomtf;
	}

	public JTextField getPrenomtf() {
		return prenomtf;
	}

	public JTextField getLogintf() {
		return logintf;
	}

	public JTextField getMdptf() {
		return mdptf;
	}

	public JComboBox<String> getVotreComboBox() {
		return votreComboBox;
	}

	public JButton getAddUserBtn() {
		return addUserBtn;
	}


    
    
    
}

