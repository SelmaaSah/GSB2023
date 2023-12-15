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
    private JButton btnvld3;

    public V_ajouterUser(ArrayList<User>lesUsers) {
    	
    	ajoutUserPanel = new JPanel();
    	ajoutUserPanel.setPreferredSize(new Dimension(500, 500));
    	
        ajoutUserlbl = new JLabel("Ajouter un utilisateur");

    	nomlbl = new JLabel("Nom : ");
    	nomtf = new JTextField();
    	nomtf.setPreferredSize(new Dimension(150, 20));

    	prenomlbl = new JLabel("Prenom :");
    	prenomtf = new JTextField();
    	prenomtf.setPreferredSize(new Dimension(150, 20));

    	loginlbl = new JLabel("Prenom :");
    	logintf = new JTextField();
    	logintf.setPreferredSize(new Dimension(150, 20));
    	
    	mdplbl = new JLabel("Prenom :");
    	mdptf = new JTextField();
    	mdptf.setPreferredSize(new Dimension(150, 20)); 
    	
        btnvld3 = new JButton(" Valider ");

    	
    	
        votreComboBox = new JComboBox<>(); // Vous pouvez ajouter des éléments à votre JComboBox ici

        
        votreComboBox = new JComboBox<>();
        
        
//      Faire une For pour recuperer le nom de l'animateur Requete SQL
        for (int i = 0; i < lesUsers.size(); i++) {
            User user = lesUsers.get(i);
            String typeVisiteur = user.getTypeVisiteur();
            votreComboBox.addItem(typeVisiteur);
        }
        
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
        ajoutUserPanel.add(btnvld3, gbc);  
        gbc.gridy++;
        ajoutUserPanel.add(btnvld3, gbc);
    }

	public JPanel getAjoutUserPanel() {
		return ajoutUserPanel;
	}

	public JLabel getAjoutUserlbl() {
		return ajoutUserlbl;
	}

	public JLabel getNomlbl() {
		return nomlbl;
	}

	public JTextField getNomtf() {
		return nomtf;
	}

	public JLabel getPrenomlbl() {
		return prenomlbl;
	}

	public JTextField getPrenomtf() {
		return prenomtf;
	}

	public JLabel getLoginlbl() {
		return loginlbl;
	}

	public JTextField getLogintf() {
		return logintf;
	}

	public JLabel getMdplbl() {
		return mdplbl;
	}

	public JTextField getMdptf() {
		return mdptf;
	}

	public JComboBox<String> getVotreComboBox() {
		return votreComboBox;
	}

	public JButton getBtnvld3() {
		return btnvld3;
	}


    
    
    
}

