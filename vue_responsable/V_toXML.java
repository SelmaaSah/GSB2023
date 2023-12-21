import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class V_toXML {

    private JPanel toXMLPanel;

    private JLabel animateurLabel;
    private JLabel catalogueLabel;
    private JLabel conferenceLabel;

    private JEditorPane editorPaneAnimateur;
    private JEditorPane editorPaneCatalogue;
    private JEditorPane editorPaneConference;

    public V_toXML(ArrayList<Animateur> lesAnimateurs, ArrayList<Catalogue> lesCatalogues, ArrayList<Conference> lesConferences) {

        toXMLPanel = new JPanel();

        animateurLabel = new JLabel("Animateur :");
        editorPaneAnimateur = new JEditorPane("text/html", "");
        JScrollPane scrollPaneAnimateur = new JScrollPane(editorPaneAnimateur); // Encapsulation dans JScrollPane

        StringBuilder animateurStringBuilder = new StringBuilder();
        for (Animateur animateur : lesAnimateurs) {
            animateurStringBuilder.append(animateur.toXMLString());
        }
        editorPaneAnimateur.setText("<html>" + animateurStringBuilder.toString() + "</html>");

        catalogueLabel = new JLabel("Catalogue :");
        editorPaneCatalogue = new JEditorPane("text/html", "");
        JScrollPane scrollPaneCatalogue = new JScrollPane(editorPaneCatalogue);

        StringBuilder catalogueStringBuilder = new StringBuilder();
        for (Catalogue catalogue : lesCatalogues) {
            catalogueStringBuilder.append(catalogue.toXMlString());
        }
        editorPaneCatalogue.setText("<html>" + catalogueStringBuilder.toString() + "</html>");

        conferenceLabel = new JLabel("Conference :");
        editorPaneConference = new JEditorPane("text/html", "");
        JScrollPane scrollPaneConference = new JScrollPane(editorPaneConference);

        StringBuilder conferenceStringBuilder = new StringBuilder();
        for (Conference conference : lesConferences) {
            conferenceStringBuilder.append(conference.toXMlString());
        }
        editorPaneConference.setText("<html>" + conferenceStringBuilder.toString() + "</html>");

        toXMLPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 10, 10);

        toXMLPanel.add(animateurLabel, gbc);
        gbc.gridy++;
        toXMLPanel.add(scrollPaneAnimateur, gbc); // Ajout du JScrollPane
        gbc.gridy++;
        toXMLPanel.add(catalogueLabel, gbc);
        gbc.gridy++;
        toXMLPanel.add(scrollPaneCatalogue, gbc);
        gbc.gridy++;
        toXMLPanel.add(conferenceLabel, gbc);
        gbc.gridy++;
        toXMLPanel.add(scrollPaneConference, gbc);
    }

    public JPanel getToXMLPanel() {
        return this.toXMLPanel;
    }
}
