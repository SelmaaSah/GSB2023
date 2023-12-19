import java.awt.Color;
import java.util.ArrayList;

import javax.swing.*;

public class V_afficherUser extends JPanel {
	
	private JPanel afficherUserPanel;
	private JTable tableUsers;
	
	public V_afficherUser(ArrayList<User> lesUsers) {
		afficherUserPanel = new RoundedPanel(20);
		afficherUserPanel.setBackground(Color.white);
		
		String[] nomColonnes = {"ID", "Nom", "Prenom", "Login", "Type Utilisateur"};
		
		// Création d'un tableau pour stocker les données
        Object[][] data = new Object[lesUsers.size()][5];
        
        for (int i = 0; i < lesUsers.size(); i++) {
        	User user = lesUsers.get(i);
            data[i][0] = user.getIdUser();
            data[i][1] = user.getNom();
            data[i][2] = user.getPrenom();
            data[i][3] = user.getLogin();
            data[i][4] = user.getTypeVisiteur();
        }
        
     // Création d'une instance de JTable avec les données et noms de colonnes
        tableUsers = new JTable(data, nomColonnes);
        
     // Création d'un JScrollPane pour gérer le défilement de la table
        JScrollPane scrollPane = new JScrollPane(tableUsers);

        afficherUserPanel.add(scrollPane);
	}
	
	public JPanel getAfficherUserPanel() {
        return afficherUserPanel;
    }
}
