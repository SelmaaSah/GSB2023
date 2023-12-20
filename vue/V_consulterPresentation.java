import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class V_consulterPresentation extends JPanel {

    private JPanel panelPresentation;
    private JTable table;

    public V_consulterPresentation(ArrayList<Catalogue> lesCatalogues) {
    	panelPresentation = new RoundedPanel(20);
        String[] nomColonnes = {"ID", "Date ", "Duree prevue", "Numéro de la salle ", "Heure ", "Animateur"};

        panelPresentation.setBackground(Color.white);

        
        // Correction de la taille du tableau data
        Object[][] data = new Object[lesCatalogues.size()][6];

        for (int i = 0; i < lesCatalogues.size(); i++) {
            Catalogue catalogue = lesCatalogues.get(i);
            data[i][0] = catalogue.getIdCatalogue();
            data[i][1] = catalogue.getDateP();
            data[i][2] = catalogue.getDureePrevue();
            data[i][3] = catalogue.getSallenum();
            data[i][4] = catalogue.getHeure();
            data[i][5] = catalogue.getAnimateurNom();
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