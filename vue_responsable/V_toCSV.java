import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.*;

/**
 * Classe représentant une vue pour afficher des informations formatées en CSV.
 */
public class V_toCSV extends JPanel {

    // Panel principal qui contiendra tous les composants
    private JPanel toCSVPanel;

    // Labels pour chaque section
    private JLabel animateurLabel;
    private JLabel catalogueLabel;
    private JLabel conferenceLabel;

    // Éditeurs de texte pour afficher les informations
    private JEditorPane editorPaneAnimateur;
    private JEditorPane editorPaneCatalogue;
    private JEditorPane editorPaneConference;

    /**
     * Constructeur pour la vue CSV.
     *
     * @param lesAnimateurs   Liste d'objets Animateur à afficher.
     * @param lesCatalogues   Liste d'objets Catalogue à afficher.
     * @param lesConferences  Liste d'objets Conference à afficher.
     */
    public V_toCSV(ArrayList<Animateur> lesAnimateurs, ArrayList<Catalogue> lesCatalogues, ArrayList<Conference> lesConferences) {

        // Initialisation du panel principal
        toCSVPanel = new JPanel();

        // Initialisation du label pour la section "Animateur"
        animateurLabel = new JLabel("Animateur :");
        // Initialisation de l'éditeur de texte pour "Animateur"
        editorPaneAnimateur = new JEditorPane("text/html", "");

        // Construction de la chaîne HTML représentant les animateurs
        StringBuilder animateurStringBuilder = new StringBuilder();
        for (Animateur animateur : lesAnimateurs) {
            animateurStringBuilder.append(animateur.toCSVString());
        }
        // Définition du texte de l'éditeur de texte "Animateur"
        editorPaneAnimateur.setText("<html>" + animateurStringBuilder.toString() + "</html>");

        // Même procédure pour les sections "Catalogue" et "Conference"
        catalogueLabel = new JLabel("Catalogue :");
        editorPaneCatalogue = new JEditorPane("text/html", "");
        StringBuilder catalogueStringBuilder = new StringBuilder();
        for (Catalogue catalogue : lesCatalogues) {
            catalogueStringBuilder.append(catalogue.toCSVString());
        }
        editorPaneCatalogue.setText("<html>" + catalogueStringBuilder.toString() + "</html>");

        conferenceLabel = new JLabel("Conference :");
        editorPaneConference = new JEditorPane("text/html", "");
        StringBuilder conferenceStringBuilder = new StringBuilder();
        for (Conference conference : lesConferences) {
            conferenceStringBuilder.append(conference.toCSVString());
        }
        editorPaneConference.setText("<html>" + conferenceStringBuilder.toString() + "</html>");

        // Configuration du layout du panel principal avec GridBagLayout
        toCSVPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 10, 10);

        // Ajout des composants au panel principal avec GridBagConstraints
        toCSVPanel.add(animateurLabel, gbc);
        gbc.gridy++;
        toCSVPanel.add(editorPaneAnimateur, gbc);
        gbc.gridy++;
        toCSVPanel.add(catalogueLabel, gbc);
        gbc.gridy++;
        toCSVPanel.add(editorPaneCatalogue, gbc);
        gbc.gridy++;
        toCSVPanel.add(conferenceLabel, gbc);
        gbc.gridy++;
        toCSVPanel.add(editorPaneConference, gbc);
    }

    /**
     * Méthode pour récupérer le panel principal.
     *
     * @return Le panel principal de la vue.
     */
    public JPanel getToCSVPanel() {
        return this.toCSVPanel;
    }
}
