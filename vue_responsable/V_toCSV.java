import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;

public class V_toCSV extends JPanel {

	private JPanel toCSVPanel;
	
	private JLabel animateurLabel;
	private JLabel catalogueLabel;
	private JLabel conferenceLabel;
	
	private JEditorPane editorPaneAnimateur;
	private JEditorPane editorPaneCatalogue;
	private JEditorPane editorPaneConference;
	
	public V_toCSV(String csvStringAnimateur, String csvStringCatalogue, String csvStringConference) {
		
		toCSVPanel = new JPanel();
		
		animateurLabel  = new JLabel("Animateur :");
		editorPaneAnimateur = new JEditorPane("text/html",csvStringAnimateur);
		
		catalogueLabel  = new JLabel("Catalogue :");
		editorPaneCatalogue = new JEditorPane("text/html",csvStringCatalogue);
		
		conferenceLabel  = new JLabel("Conference :");
		editorPaneConference = new JEditorPane("text/html",csvStringConference);
		
		toCSVPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
	    gbc.gridy = 0;
	    gbc.anchor = GridBagConstraints.WEST;
	    gbc.insets = new Insets(10, 10, 10, 10);
	
		toCSVPanel.add(animateurLabel,gbc);
		gbc.gridy++;
		toCSVPanel.add(editorPaneAnimateur,gbc);
		gbc.gridy++;
		toCSVPanel.add(catalogueLabel,gbc);
		gbc.gridy++;
		toCSVPanel.add(editorPaneCatalogue,gbc);
		gbc.gridy++;
		toCSVPanel.add(conferenceLabel,gbc);
		gbc.gridy++;
		toCSVPanel.add(editorPaneConference,gbc);
		
	}
	
	public JPanel getToCSVPanel() {
		return this.toCSVPanel;
	}
}
