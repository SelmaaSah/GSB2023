import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class V_afficherSecretaire {

	
	
	
	private JPanel panelSecretaire;
    private JTable tableUsers;


    public V_afficherSecretaire(ArrayList<User> lesUsers) {

    	panelSecretaire = new RoundedPanel(20);
    	panelSecretaire.setBackground(Color.white);

    	
        String[] nomColonnes = {"ID", "Nom", " Prenom ", "Login "};

        // Création d'un tableau pour stocker les données
        Object[][] data = new Object[lesUsers.size()][4];

        for (int i = 0; i < lesUsers.size(); i++) {
        	User user = lesUsers.get(i);
            data[i][0] = user.getIdUser();
            data[i][1] = user.getNom();
            data[i][2] = user.getPrenom();
            data[i][3] = user.getLogin();
        }

        // Création d'une instance de JTable avec les données et noms de colonnes
        tableUsers = new JTable(data, nomColonnes);

        // Création d'un JScrollPane pour gérer le défilement de la table
        JScrollPane scrollPane = new JScrollPane(tableUsers);

        panelSecretaire.add(scrollPane);


    }

    public JPanel getPanelSecretaire() {
        return panelSecretaire;
    }
}


	
	

