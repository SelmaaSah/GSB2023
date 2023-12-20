import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

public class V_ajoutSecretaire {
    private JPanel ajoutSecrPanel;
    private JLabel ajoutSecrlbl;
    
    private JLabel nomlbl;
    private JTextField nomtf;

    private JLabel prenomlbl;
    private JTextField prenomtf;

    private JLabel loginlbl;
    private JTextField logintf;

    private JLabel mdplbl;
    private JTextField mdptf;
    
    private JButton addUserBtn;

    public V_ajoutSecretaire() {
    	
    	ajoutSecrPanel = new RoundedPanel(20);
    	ajoutSecrPanel.setBackground(Color.white);
    	ajoutSecrPanel.setPreferredSize(new Dimension(500, 500));
    	
    	ajoutSecrlbl = new JLabel("Ajouter un/ une secretaire");
    	ajoutSecrlbl.setForeground(new Color(128,162,205));

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
    	
    	
		Font police = new Font("Courier New", Font.BOLD, 13);
		ajoutSecrlbl.setFont(police);
		nomlbl.setFont(police);
		prenomlbl.setFont(police);
		loginlbl.setFont(police);
		mdplbl.setFont(police);
		addUserBtn.setFont(police);
    	
    	

        ajoutSecrPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 0, 0, 0);
        ajoutSecrPanel.add(ajoutSecrlbl, gbc);
        
        
        gbc.gridy++;
        ajoutSecrPanel.add(nomlbl, gbc);
        gbc.gridy++;
        ajoutSecrPanel.add(nomtf, gbc);
        
        
        gbc.gridy++;
        ajoutSecrPanel.add(prenomlbl, gbc);
        gbc.gridy++;
        ajoutSecrPanel.add(prenomtf, gbc);
        
        
        gbc.gridy++;    
        ajoutSecrPanel.add(loginlbl, gbc);  
        gbc.gridy++;
        ajoutSecrPanel.add(logintf, gbc);
        
        gbc.gridy++;    
        ajoutSecrPanel.add(mdplbl, gbc);  
        gbc.gridy++;
        ajoutSecrPanel.add(mdptf, gbc);
        


        
        gbc.gridy++;    
        ajoutSecrPanel.add(addUserBtn, gbc);  
    }

	public JPanel getAjoutSecrPanel() {
		return ajoutSecrPanel;
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


	public JButton getAddUserBtn() {
		return addUserBtn;
	}


    
    
    
}

