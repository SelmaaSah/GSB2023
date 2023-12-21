import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class V_toJSON {

	private JPanel toJSONPanel;
	
	private JLabel animateurLabel;
	private JLabel catalogueLabel;
	private JLabel conferenceLabel;
	
	private JEditorPane editorPaneAnimateur;
	private JEditorPane editorPaneCatalogue;
	private JEditorPane editorPaneConference;

	public V_toJSON(ArrayList<Animateur> lesAnimateurs, ArrayList<Catalogue> lesCatalogues, ArrayList<Conference> lesConferences) {
		
		// Initialisation du panel principal
        toJSONPanel = new JPanel();

        // Initialisation du label pour la section "Animateur"
        animateurLabel = new JLabel("Animateur :");
        // Initialisation de l'éditeur de texte pour "Animateur"
        editorPaneAnimateur = new JEditorPane("text/html", "");

        // Construction de la chaîne HTML représentant les animateurs
        StringBuilder animateurStringBuilder = new StringBuilder();
        for (Animateur animateur : lesAnimateurs) {
            animateurStringBuilder.append(animateur.toJSONString());
        }
        // Définition du texte de l'éditeur de texte "Animateur"
        editorPaneAnimateur.setText("<html>" + animateurStringBuilder.toString() + "</html>");

        // Même procédure pour les sections "Catalogue" et "Conference"
        catalogueLabel = new JLabel("Catalogue :");
        editorPaneCatalogue = new JEditorPane("text/html", "");
        StringBuilder catalogueStringBuilder = new StringBuilder();
        for (Catalogue catalogue : lesCatalogues) {
            catalogueStringBuilder.append(catalogue.toJSONString());
        }
        editorPaneCatalogue.setText("<html>" + catalogueStringBuilder.toString() + "</html>");

        conferenceLabel = new JLabel("Conference :");
        editorPaneConference = new JEditorPane("text/html", "");
        StringBuilder conferenceStringBuilder = new StringBuilder();
        for (Conference conference : lesConferences) {
            conferenceStringBuilder.append(conference.toJSONString());
        }
        editorPaneConference.setText("<html>" + conferenceStringBuilder.toString() + "</html>");

        // Configuration du layout du panel principal avec GridBagLayout
        toJSONPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 10, 10);

        // Ajout des composants au panel principal avec GridBagConstraints
        toJSONPanel.add(animateurLabel, gbc);
        gbc.gridy++;
        toJSONPanel.add(editorPaneAnimateur, gbc);
        gbc.gridy++;
        toJSONPanel.add(catalogueLabel, gbc);
        gbc.gridy++;
        toJSONPanel.add(editorPaneCatalogue, gbc);
        gbc.gridy++;
        toJSONPanel.add(conferenceLabel, gbc);
        gbc.gridy++;
        toJSONPanel.add(editorPaneConference, gbc);
		
	}
	
	public JPanel getToJSONPanel() {
		return this.toJSONPanel;
	}
	
}
