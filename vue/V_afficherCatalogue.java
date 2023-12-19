import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class V_afficherCatalogue extends JPanel {

    private JPanel panelconference;
    private JTable table;

    public V_afficherCatalogue(ArrayList<Catalogue> lesCatalogues) {
        panelconference = new RoundedPanel(20);
        String[] nomColonnes = {"Date ", "Duree prevue", "Numéro de la salle ", "Heure ", "Animateur"};

        panelconference.setBackground(Color.white);

        
        // Correction de la taille du tableau data
        Object[][] data = new Object[lesCatalogues.size()][5];

        for (int i = 0; i < lesCatalogues.size(); i++) {
            Catalogue catalogue = lesCatalogues.get(i);
            data[i][0] = catalogue.getDateP();
            data[i][1] = catalogue.getDureePrevue();
            data[i][2] = catalogue.getSallenum();
            data[i][3] = catalogue.getHeure();
            data[i][4] = catalogue.getAnimateurNom();
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
