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
		
		
		toCSVPanel.add(animateurLabel);
		toCSVPanel.add(editorPaneAnimateur);
		
	}
	
	public JPanel getToCSVPanel() {
		return this.toCSVPanel;
	}
}
