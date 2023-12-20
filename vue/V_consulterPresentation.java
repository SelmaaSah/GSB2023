import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class V_consulterPresentation extends JPanel {

    private JPanel panelPresentation;
    private JTable table;

    public V_consulterPresentation(ArrayList<Presentation> lesPresentation) {
    	panelPresentation = new RoundedPanel(20);
        String[] nomColonnes = {"ID", "Date ", "Duree prevue", "Numéro de la salle ", "Heure ", "Animateur"};

        panelPresentation.setBackground(Color.white);

        
        // Correction de la taille du tableau data
        Object[][] data = new Object[lesPresentation.size()][6];

        for (int i = 0; i < lesPresentation.size(); i++) {
        	Presentation presentation = lesPresentation.get(i);
            data[i][0] = presentation.getIdPresentation();
            data[i][1] = presentation.getDatePresentation();
            data[i][2] = presentation.getDureePresentation();
            data[i][3] = presentation.getSallePresentation();
            data[i][4] = presentation.getHeurePresentation();
            data[i][5] = presentation.getAnimateur();
        }

        // Création d'une instance de JTable avec les données et noms de colonnes
        table = new JTable(data, nomColonnes);

        // Création d'un JScrollPane pour gérer le défilement de la table
        JScrollPane scrollPane = new JScrollPane(table);

        panelPresentation.add(scrollPane);
        
    }

    public JPanel getPanelPresentation() {
        return panelPresentation;
    }
}