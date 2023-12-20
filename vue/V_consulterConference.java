import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class V_consulterConference extends JPanel {

    private JPanel panelconference;
    private JTable table;


    public V_consulterConference(ArrayList<Conference> lesConferences) {

    	panelconference = new RoundedPanel(20);
        panelconference.setBackground(Color.white);

    	
        String[] nomColonnes = {"Id de la conférence", "Theme", "Date de deroulement ", "Animateur "};

        // Création d'un tableau pour stocker les données
        Object[][] data = new Object[lesConferences.size()][5];

        for (int i = 0; i < lesConferences.size(); i++) {
        	Conference conference = lesConferences.get(i);
            data[i][0] = conference.getIdC();
            data[i][1] = conference.getTheme();
            data[i][2] = conference.getDateDeroulement();
            data[i][3] = conference.getNomAnimateur();
        }

        // Création d'une instance de JTable avec les données et noms de colonnes
        table = new JTable(data, nomColonnes);

        // Création d'un JScrollPane pour gérer le défilement de la table
        JScrollPane scrollPane = new JScrollPane(table);

        panelconference.add(scrollPane);


    }

    public JPanel getPanelconference() {
        return panelconference;
    }
}